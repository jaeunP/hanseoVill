package project.hanseovill.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import project.hanseovill.domain.authority.Authority;
import project.hanseovill.domain.authority.UserAuthority;

import javax.persistence.*;

import java.util.Set;


@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
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

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @OneToMany
    @Column(name = "authorities")
    private Set<Authority> authorities;

}