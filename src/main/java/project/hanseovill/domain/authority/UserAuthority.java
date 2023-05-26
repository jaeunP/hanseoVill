package project.hanseovill.domain.authority;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.hanseovill.domain.User;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Entity
@NoArgsConstructor
public class UserAuthority implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Id
    @ManyToOne
    @JoinColumn(name = "authority_name")
    private Authority authorityName;

    @Builder
    public UserAuthority(User userId, Authority authorityName) {
        this.userId = userId;
        this.authorityName = authorityName;
    }
}
