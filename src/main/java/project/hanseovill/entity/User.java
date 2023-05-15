package project.hanseovill.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String userId;

    private String userPw;

    private String userTel;

    private String userNickname;


}
