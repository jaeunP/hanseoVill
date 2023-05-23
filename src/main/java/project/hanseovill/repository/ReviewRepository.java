package project.hanseovill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hanseovill.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
