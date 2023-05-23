package project.hanseovill.dto;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
public class LoginDto {

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @Builder
    public LoginDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
