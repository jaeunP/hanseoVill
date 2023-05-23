package project.hanseovill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hanseovill.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserId(String userId);
}
