package project.hanseovill.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import project.hanseovill.domain.Role;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDto {
    private Long memberId;
    private String username;
    private String password;
    private String nickname;
    private String tel;
    private Role role;

    @Builder

    public MemberDto(Long memberId, String username, String password, String nickname, String tel, Role role) {
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.tel = tel;
        this.role = role;
    }
}


