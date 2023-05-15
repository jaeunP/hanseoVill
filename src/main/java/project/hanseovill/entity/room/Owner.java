package project.hanseovill.entity.room;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Room> room;

    private String OwnerId;

    private String OwnerPw;

    private String ownerTel;

    private String ownerNickname;

    ;



}
