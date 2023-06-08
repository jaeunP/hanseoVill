package project.hanseovill.dto;

import lombok.*;

@RequiredArgsConstructor
@Getter
public class TokenDto {
    private final String token;
    private final String username;

}