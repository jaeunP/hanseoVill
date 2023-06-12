package project.hanseovill.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import project.hanseovill.dto.LoginDto;
import project.hanseovill.dto.TokenDto;
import project.hanseovill.dto.UserDto;
import project.hanseovill.service.CommonService;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommonApiController {
    private final CommonService commonService;

    @GetMapping("/myInfo")
    @Secured({"ROLE_USER", "ROLE_ADMIN", "ROLE_OWNER"})
    public ResponseEntity<UserDto> myInfo(Principal username){
        return ResponseEntity.ok(commonService.myInfo(username));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto userDto) throws Exception {
        return ResponseEntity.ok(commonService.login(userDto));
    }
}
