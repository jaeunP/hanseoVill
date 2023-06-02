package project.hanseovill.dto;


import lombok.*;
import project.hanseovill.domain.Role;

@Getter
public class UserDto {
    private String username;
    private String password;
    private String nickname;
    private Role role;

    @Builder
    public UserDto(String username, String password, String nickname, Role role) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }
}


