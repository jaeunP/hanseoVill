//package project.hanseovill.api;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//
//import project.hanseovill.domain.Member;
//import project.hanseovill.dto.LoginDto;
//import project.hanseovill.dto.TokenDto;
//import project.hanseovill.dto.MemberDto;
//
//import project.hanseovill.service.MemberService;
//import project.hanseovill.service.OwnerService;
//
//import java.security.Principal;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api")
//public class OwnerApiController {
//    private final OwnerService ownerService;
//
//    @GetMapping("/findUser/{username}")
//    @Secured("ROLE_ADMIN")
//    public ResponseEntity<MemberDto> findUser(@PathVariable String username) {
//        return ResponseEntity.ok(ownerService.findUser(username));
//    }
//
//    @GetMapping("/myInfo")
//    @Secured({"ROLE_USER","ROLE_ADMIN"})
//    public ResponseEntity<MemberDto> myInfo(Principal principal){
//        return ResponseEntity.ok(ownerService.myInfo(principal));
//    }
//
//
//    @PostMapping("/signup/member")
//    public ResponseEntity<String> createUser(@RequestBody MemberDto memberDto) throws Exception {
//        return ResponseEntity.ok(ownerService.signupMember(memberDto));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<TokenDto> createAuthenticationToken(@RequestBody LoginDto userDto) throws Exception {
//        return ResponseEntity.ok(ownerService.login(userDto));
//    }
//
//
//
//
//
//}