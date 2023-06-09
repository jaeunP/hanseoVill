package project.hanseovill.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;




@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "tel", length = 20)
    private String tel;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(Long memberId, String username, String password, String nickname, String tel, Role role) {
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.tel = tel;
        this.role = role;
    }
}