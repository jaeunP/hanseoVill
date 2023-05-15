package project.hanseovill.entity.room;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@RequiredArgsConstructor
public class Address {

    private String zipcode;

    private String streetAdr;

    private String detailAdr;
}
