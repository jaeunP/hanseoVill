package project.hanseovill.dto;

import lombok.Builder;
import lombok.Getter;
import project.hanseovill.domain.Owner;
import project.hanseovill.domain.room.Address;
import project.hanseovill.domain.room.RoomSize;
import project.hanseovill.domain.room.option.Option;

@Getter
public class RoomDto {

    private Long id;
    private String roomName;
    private Owner owner;
    private RoomSize size;
    private Option option;
    private Address address;
    private int roomCount;

    @Builder
    public RoomDto(Long id, String roomName, Owner owner, RoomSize size, Option option, Address address, int roomCount) {
        this.id = id;
        this.roomName = roomName;
        this.owner = owner;
        this.size = size;
        this.option = option;
        this.address = address;
        this.roomCount = roomCount;
    }
}
