package project.hanseovill.domain.room;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.hanseovill.domain.Image;
import project.hanseovill.domain.Owner;
import project.hanseovill.domain.room.option.Option;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;

    private RoomSize Size;

    private Option option;

    private Address address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> image;

    private int roomCount;

}
