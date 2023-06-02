package project.hanseovill.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.hanseovill.domain.User;
import project.hanseovill.domain.authority.Authority;
import project.hanseovill.domain.authority.UserAuthority;
import project.hanseovill.dto.UserDto;
import project.hanseovill.repository.UserRepository;
import project.hanseovill.security.SecurityUtil;

import java.util.Collections;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 회원가입 로직을 수행하는 메서드
     * username이 DB에 존재하지 않으면 Authority와 User 정보를 생성해서
     * UserRepository의 save를 통해 DB에 정보를 저장
     */

//    public User findAuthority(User username) {
//
//    }

    @Transactional
    public User signup(UserDto userDto) {
        validationUser(userDto);

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        UserAuthority userAuthority = UserAuthority.builder()
                .authority(authority)
                .build();

        if(userAuthority.getAuthority() == null){
            throw new RuntimeException("권한정보가 없습니다");
        }
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(userAuthority))
                .activated(true)
                .build();

        return userRepository.save(user);
    }

    private void validationUser(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }
    }


    /**
     * username을 기준으로 권한정보를 가져옴
     */
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }


    /**
     * SecurityContext에 저장된 username의 권한 정보만 가져옴
     */
    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }
}