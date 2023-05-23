package project.hanseovill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hanseovill.domain.Image;

public interface ImageRepository extends JpaRepository <Image, Long> {
}
