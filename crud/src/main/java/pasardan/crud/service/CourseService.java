package pasardan.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import pasardan.crud.entity.Course;
import pasardan.crud.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course getCourseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    // Populate sample data on application start
    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            repository.saveAll(List.of(
                new Course("Java Basics", "John Doe"),
                new Course("Spring Boot", "Jane Smith"),
                new Course("Database Systems", "Alice Johnson")
            ));
        }
    }
}

