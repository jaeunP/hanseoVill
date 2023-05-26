package project.hanseovill.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.hanseovill.domain.User;
import project.hanseovill.domain.authority.Authority;
import project.hanseovill.domain.authority.UserAuthority;
import project.hanseovill.dto.UserDto;
import project.hanseovill.repository.UserRepository;

import java.util.Collections;


@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


//    회원가입
    @Transactional
    public User signup(UserDto userDto) {
        validateUser(userDto);

        Authority role_user = Authority.builder()
                .authorityName("ROLE_USER")
                .build();


        UserAuthority authority = UserAuthority.builder()
                .authorityName(role_user)
                .build();


        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return userRepository.save(user);
    }




    //유저 검증
    private void validateUser(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }
    }


    // user의 유효성 검증
//    private void validateUser(User user) {
//        List<User> findMembers = userRepository.findByUserId(user.getUserId());
//        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 아이디입니다.");
//        }
//    }


}
