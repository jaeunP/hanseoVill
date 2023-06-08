package project.hanseovill.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import project.hanseovill.dto.LoginDto;
import project.hanseovill.dto.OwnerDto;
import project.hanseovill.dto.TokenDto;
import project.hanseovill.dto.MemberDto;

import project.hanseovill.service.UserService;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberApiController {
    private final UserService userService;



    @GetMapping("/findUser/{username}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<MemberDto> findUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.findUser(username));
    }

    @GetMapping("/myInfo")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<MemberDto> myInfo(Principal principal){
        return ResponseEntity.ok(userService.userInfo(principal));
    }

    @PostMapping("/signup/owner")
    public ResponseEntity<String> createOwner(@RequestBody OwnerDto ownerDto) throws Exception {
        return ResponseEntity.ok(userService.signupOwner(ownerDto));
    }


    @PostMapping("/signup/member")
    public ResponseEntity<String> createUser(@RequestBody MemberDto memberDto) throws Exception {
        return ResponseEntity.ok(userService.signupUser(memberDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> createAuthenticationToken(@RequestBody LoginDto userDto) throws Exception {
        return ResponseEntity.ok(userService.login(userDto));
    }





}