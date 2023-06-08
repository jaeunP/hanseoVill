package project.hanseovill.domain.room;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import project.hanseovill.domain.Image;
import project.hanseovill.domain.Owner;
import project.hanseovill.domain.room.option.Option;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String roomName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Enumerated(EnumType.STRING)
    private RoomSize size;

    @Enumerated(EnumType.STRING)
    private Option option;

    @Embedded
    private Address address;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Image> image;

    private int roomCount;

    @Builder
    public Room(Long id, String roomName, Owner owner, RoomSize size, Option option, Address address, int roomCount) {
        this.id = id;
        this.roomName = roomName;
        this.owner = owner;
        this.size = size;
        this.option = option;
        this.address = address;
        this.roomCount = roomCount;
    }
}
