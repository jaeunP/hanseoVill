package project.hanseovill.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.hanseovill.domain.room.Room;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")
@Getter
@NoArgsConstructor
public class Owner {

    @Id
    @Column(name = "owner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "tel", length = 20)
    private String tel;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Room> room;

    @Enumerated(EnumType.STRING)
    private Role role;



    @Builder
    public Owner(Long ownerId, String username, String password, String nickname, String tel, List<Room> room, Role role) {
        this.ownerId = ownerId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.tel = tel;
        this.room = room;
        this.role = role;
    }
}
