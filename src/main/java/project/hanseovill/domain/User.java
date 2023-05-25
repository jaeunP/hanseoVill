package project.hanseovill.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import project.hanseovill.domain.authority.UserAuthority;


import javax.persistence.*;

import java.util.Set;


@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User {

    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "usertel",length = 11)
    private String userTel;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @JsonIgnore
    @OneToMany(mappedBy = "authorityName")
    private Set<UserAuthority> authorities;

    @Builder
    public User(Long userId, String username, String password, String nickname, String userTel, boolean activated, Set<UserAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.userTel = userTel;
        this.activated = activated;
        this.authorities = authorities;
    }
}