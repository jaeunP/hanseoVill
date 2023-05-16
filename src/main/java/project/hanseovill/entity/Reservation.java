package project.hanseovill.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.hanseovill.entity.room.ContractTerm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Owner owner;

    private LocalDateTime date;

    private ContractTerm term;

}
