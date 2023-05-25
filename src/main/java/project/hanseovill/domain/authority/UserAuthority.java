package project.hanseovill.domain.authority;

import lombok.Getter;
import project.hanseovill.domain.User;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Entity
public class UserAuthority implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Id
    @ManyToOne
    @JoinColumn(name = "authority_name")
    private Authority authorityName;
}
