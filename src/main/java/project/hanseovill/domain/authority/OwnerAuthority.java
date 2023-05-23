package project.hanseovill.domain.authority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@RequiredArgsConstructor
public class OwnerAuthority {

    @Id
    private String authorityName;
}
