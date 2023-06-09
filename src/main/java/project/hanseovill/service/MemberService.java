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
import project.hanseovill.repository.MemberRepository;
import project.hanseovill.security.JwtTokenUtil;


import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberDto myInfo(Principal principal) {
        String username = principal.getName();
        Optional<Member> member = memberRepository.findByUsername(username);

        MemberDto memberDto = MemberDto.builder()
                .memberId(member.get().getMemberId())
                .username(member.get().getUsername())
                .nickname(member.get().getNickname())
                .tel(member.get().getTel())
                .build();

        return memberDto;
    }

    @Transactional
    public TokenDto login(LoginDto loginDto) throws Exception {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        Optional<Member> byUsername = memberRepository.findByUsername(username);

        if (passwordEncoder.matches(password, byUsername.get().getPassword())){
            return createToken(username, password);
        } else {
            throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다");

        }
    }

    @Transactional
    public String signupMember(MemberDto memberDto) throws Exception {

        Role role = Role.ROLE_USER;

        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .nickname(memberDto.getNickname())
                .tel(memberDto.getTel())
                .role(role)
                .build();
        memberRepository.save(member);

        createToken(memberDto.getUsername(), memberDto.getPassword());

        return member.getUsername();
    }

    public MemberDto findUser(String username) {
        Optional<Member> findUser = memberRepository.findByUsername(username);

        return MemberDto.builder()
                .username(findUser.get().getUsername())
                .nickname(findUser.get().getNickname())
                .tel(findUser.get().getTel())
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