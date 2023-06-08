package project.hanseovill.dto;

import lombok.*;

@Getter
public class TokenDto {
    private final String token;
    private final String username;

    public TokenDto(String token, String username) {
        this.token = token;
        this.username = username;
    }
}