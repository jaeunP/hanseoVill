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
import project.hanseovill.domain.Member;
import project.hanseovill.dto.LoginDto;
import project.hanseovill.dto.TokenDto;
import project.hanseovill.dto.MemberDto;
import project.hanseovill.dto.UserDto;
import project.hanseovill.repository.MemberRepository;
import project.hanseovill.repository.OwnerRepository;
import project.hanseovill.security.JwtTokenUtil;


import java.security.Principal;
import java.util.Optional;


@Service
public class MemberService extends CommonService{

    public MemberService(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, MemberRepository memberRepository, OwnerRepository ownerRepository, PasswordEncoder passwordEncoder) {
        super(authenticationManager, userDetailsService, jwtTokenUtil, memberRepository, ownerRepository, passwordEncoder);
    }


    @Transactional
    public String signupMember(UserDto userDto) throws Exception {
        String username = userDto.getUsername();
        validateDuplicateUser(username);

        Role role = Role.ROLE_USER;

        Member member = Member.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .tel(userDto.getTel())
                .role(role)
                .build();
        memberRepository.save(member);

        createToken(userDto.getUsername(), userDto.getPassword());

        return member.getUsername();
    }

    //관리자 메서드로 수정하기
    public MemberDto findUser(String username) {
        Optional<Member> findUser = memberRepository.findByUsername(username);

        return MemberDto.builder()
                .username(findUser.get().getUsername())
                .nickname(findUser.get().getNickname())
                .tel(findUser.get().getTel())
                .role(findUser.get().getRole())
                .build();
    }

}