package pasardan.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pasardan.crud.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}


