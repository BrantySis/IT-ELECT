package pasardan.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pasardan.crud.entity.Meal;
import pasardan.crud.entity.User;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUser(User user);
}
