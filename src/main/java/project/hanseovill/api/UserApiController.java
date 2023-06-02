package project.hanseovill.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import project.hanseovill.domain.User;
import project.hanseovill.dto.LoginDto;
import project.hanseovill.dto.TokenDto;
import project.hanseovill.dto.UserDto;

import project.hanseovill.service.UserService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserApiController {
    private final UserService userService;

    @GetMapping("/findUser/{username}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<UserDto> findUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.findUser(username));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(userService.signupUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> createAuthenticationToken(@RequestBody LoginDto userDto) throws Exception {
        return ResponseEntity.ok(userService.login(userDto));
    }





}