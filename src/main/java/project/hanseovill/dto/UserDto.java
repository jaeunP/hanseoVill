package project.hanseovill.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import project.hanseovill.domain.authority.UserAuthority;

@Getter
public class UserDto {
    private Long id;
    private String userName;
    private String userId;
    private String userPw;
    private String userTel;
    private String userNickname;
    private UserAuthority authority;

    @Builder
    public UserDto(Long id, String userName, String userId, String userPw, String userTel, String userNickname, UserAuthority authority) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.userTel = userTel;
        this.userNickname = userNickname;
        this.authority = authority;
    }

}
