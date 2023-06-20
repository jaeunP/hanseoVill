package project.hanseovill.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import project.hanseovill.dto.LoginDto;
import project.hanseovill.dto.TokenDto;
import project.hanseovill.dto.UserDto;
import project.hanseovill.service.OwnerService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OwnerApiController {
    private final OwnerService ownerService;

    @PostMapping("/signup/owner")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(ownerService.signupOwner(userDto));
    }

    @PostMapping("/login/owner")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto userDto) throws Exception {
        return ResponseEntity.ok(ownerService.login(userDto));
    }

}