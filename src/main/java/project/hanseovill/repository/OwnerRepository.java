package project.hanseovill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hanseovill.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
