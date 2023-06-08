package project.hanseovill.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import project.hanseovill.domain.Role;
import project.hanseovill.domain.Member;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDto {
    private String username;
    private String password;
    private String nickname;
    private String tel;
    private Role role;

    @Builder
    public MemberDto(String username, String password, String nickname, String tel, Role role) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.tel = tel;
        this.role = role;
    }

    public static MemberDto createDto(Member member){
        return new MemberDto(
                member.getUsername(),
                member.getPassword(),
                member.getNickname(),
                member.getTel(),
                member.getRole()
        );
    }

}


