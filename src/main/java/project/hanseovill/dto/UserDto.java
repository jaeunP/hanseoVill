package project.hanseovill.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import project.hanseovill.domain.Role;
import project.hanseovill.domain.room.Room;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long userId;
    private String username;
    private String password;
    private String nickname;
    private String tel;
    private Role role;
    private List<Room> room;

    @Builder
    public UserDto(Long userId, String username, String password, String nickname, String tel, Role role, List<Room> room) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.tel = tel;
        this.role = role;
        this.room = room;
    }
}
