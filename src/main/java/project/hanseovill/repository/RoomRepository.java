package project.hanseovill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hanseovill.domain.room.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
