package project.hanseovill.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import project.hanseovill.domain.authority.UserAuthority;


import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(length = 20)
    private String userName;

    @NotNull
    @Column(length = 15)
    private String userId;

    @NotNull
    private String userPw;

    @NotNull
    @Column(length = 11)
    private String userTel;

    @NotNull
    @Column(length = 7)
    private String userNickname;

    @Enumerated(EnumType.STRING)
    private UserAuthority authority;

}
