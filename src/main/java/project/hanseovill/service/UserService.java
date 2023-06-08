package project.hanseovill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import project.hanseovill.domain.Role;
import project.hanseovill.domain.User;
import project.hanseovill.dto.LoginDto;
import project.hanseovill.dto.TokenDto;
import project.hanseovill.dto.UserDto;
import project.hanseovill.repository.UserRepository;
import project.hanseovill.security.JwtTokenUtil;


import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> userInfo(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username);
    }

    @Transactional
    public TokenDto login(LoginDto loginDto) throws Exception {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        Optional<User> byUsername = userRepository.findByUsername(username);

        if (passwordEncoder.matches(password, byUsername.get().getPassword())){
            return createToken(username, password);
        } else {
            throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다");

        }
    }

    @Transactional
    public User signupUser(UserDto userDto) throws Exception {

        Role role = Role.ROLE_USER;

        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .role(role)
                .build();
        userRepository.save(user);

        createToken(userDto.getUsername(), userDto.getPassword());

        return user;
    }

    public UserDto findUser(String username) {
        Optional<User> findUser = userRepository.findByUsername(username);

        return UserDto.builder()
                .username(findUser.get().getUsername())
                .nickname(findUser.get().getNickname())
                .role(findUser.get().getRole())
                .build();
    }

    private TokenDto createToken(String username, String password) throws Exception {
        authenticate(username, password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtTokenUtil.generateToken(userDetails);
        return new TokenDto(token, userDetails.getUsername());
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {//   인증 거부 - 계정 비활성화
            throw new Exception("계정이 비활성화 상태입니다.", e);
        } catch (BadCredentialsException e) {//  비밀번호가 일치하지 않을 때 던지는 예외
            throw new Exception("사용자 계정이 불일치 합니다.", e);
        }
    }



}