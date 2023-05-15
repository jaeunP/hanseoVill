package project.hanseovill.entity.room;

import lombok.Getter;

import javax.persistence.Embeddable;

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

}
