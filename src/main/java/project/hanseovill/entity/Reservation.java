package project.hanseovill.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.hanseovill.entity.room.Owner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    private User user;

    private Owner owner;

    private LocalDateTime date;

}
