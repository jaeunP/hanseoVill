package project.hanseovill.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Builder
public class LoginDto {
    private String username;
    private String password;

    @Builder
    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
