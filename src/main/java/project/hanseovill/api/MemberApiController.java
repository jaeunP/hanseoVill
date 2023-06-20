package project.hanseovill.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import project.hanseovill.dto.LoginDto;
import project.hanseovill.dto.MemberDto;

import project.hanseovill.dto.TokenDto;
import project.hanseovill.dto.UserDto;
import project.hanseovill.service.MemberService;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberApiController {
    private final MemberService memberService;

    @GetMapping("/findUser/{username}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<MemberDto> findUser(@PathVariable String username) {
        return ResponseEntity.ok(memberService.findUser(username));
    }

    @GetMapping("/myInfo")
    @Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_OWNER"})
    public ResponseEntity<UserDto> myInfo(Principal username) {
        return ResponseEntity.ok(memberService.myInfo(username));
    }

    @PostMapping("/signup/member")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(memberService.signupMember(userDto));
    }

    @PostMapping("/login/user")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto userDto) throws Exception {
        return ResponseEntity.ok(memberService.login(userDto));
    }


}