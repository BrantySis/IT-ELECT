package pasardan.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pasardan.crud.entity.Workout;
import pasardan.crud.entity.User;
import java.util.List;


public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUser(User user);
}
