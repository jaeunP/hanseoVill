package project.hanseovill.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.hanseovill.domain.room.ContractTerm;

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
    private Member member;

    @ManyToOne
    private Owner owner;

    private LocalDateTime date;

    private ContractTerm term;

}
