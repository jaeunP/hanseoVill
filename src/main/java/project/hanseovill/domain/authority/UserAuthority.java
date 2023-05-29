package project.hanseovill.domain.authority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import project.hanseovill.domain.User;


import javax.persistence.*;
import java.io.Serializable;



@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_authority")
public class UserAuthority implements Serializable {

    @Id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Id
    @ManyToOne
    @JoinColumn(name = "authority_name")
    private Authority authorityName;

}
