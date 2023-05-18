package project.hanseovill.domain.room.option;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
public class Option {

    private String desk;

    private String closet;

    private String bed;

    private String sCloset;

    private String tv;

    private String fridge;

    private String washer;

    private String airCondition;

    private String etc;

    @Enumerated(EnumType.STRING)
    private OptionStatus status;

}
