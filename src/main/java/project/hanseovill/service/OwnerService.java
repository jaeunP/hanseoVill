package project.hanseovill.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import project.hanseovill.domain.Owner;
import project.hanseovill.domain.Role;

import project.hanseovill.dto.LoginDto;
import project.hanseovill.dto.TokenDto;
import project.hanseovill.dto.UserDto;
import project.hanseovill.repository.OwnerRepository;
import project.hanseovill.security.CustomOwner;
import project.hanseovill.security.CustomOwnerService;
import project.hanseovill.security.JwtTokenUtil;


import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OwnerService{
    private final AuthenticationManager authenticationManager;
    private final CustomOwnerService customOwnerService;
    private final JwtTokenUtil jwtTokenUtil;
    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String signupOwner(UserDto userDto) throws Exception {
        String username = userDto.getUsername();
//        validateDuplicateUser(username);

        Role role = Role.ROLE_OWNER;

        Owner owner = Owner.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .tel(userDto.getTel())
                .role(role)
                .build();
        ownerRepository.save(owner);

        return owner.getUsername();
    }

    @Transactional
    public TokenDto login(LoginDto loginDto) throws Exception {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        Optional<Owner> byUsername = ownerRepository.findByUsername(username);

        if (passwordEncoder.matches(password, byUsername.get().getPassword())){
            return createToken(username, password);
        } else {
            throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다");
        }
    }

    public UserDto myInfo(Principal principal) {
        String username = principal.getName();
        Optional<Owner> owner = ownerRepository.findByUsername(username);
        UserDto userDto = UserDto.builder()
                .userId(owner.get().getOwnerId())
                .username(owner.get().getUsername())
                .nickname(owner.get().getNickname())
                .tel(owner.get().getTel())
                .role(owner.get().getRole())
                .build();

        return userDto;
    }

    private TokenDto createToken(String username, String password) throws Exception {

        CustomOwner userDetails = customOwnerService.loadUserByUsername(username);
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