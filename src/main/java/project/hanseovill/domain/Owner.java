package project.hanseovill.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.hanseovill.domain.room.Room;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Room> room;

    private String ownerId;

    private String ownerPw;

    private String ownerTel;

    private String ownerNickname;



}
