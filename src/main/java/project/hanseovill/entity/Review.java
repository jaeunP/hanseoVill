package project.hanseovill.entity;

import lombok.Getter;
import project.hanseovill.entity.room.Room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Image image;

    private LocalDateTime reviewTime;


}
