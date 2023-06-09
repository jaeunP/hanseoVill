package project.hanseovill.domain;

import lombok.Getter;
import project.hanseovill.domain.room.Room;

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
    private Member member;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Image image;

    private LocalDateTime reviewTime;


}
