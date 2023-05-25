package project.hanseovill.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
public class LoginDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Builder
    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
