package project.hanseovill.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.hanseovill.entity.room.Room;

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
