package pasardan.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pasardan.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here if needed
}
