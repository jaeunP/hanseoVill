package project.hanseovill.entity.room;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.hanseovill.entity.Image;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Owner owner;

    private RoomSize roomSize;

    private Option option;

    private Address address;

    @OneToMany
    private List<Image> image;

    @ManyToOne
    private Owner ownerTel;

    private int roomCount;

}
