package pasardan.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pasardan.crud.entity.Course;
import pasardan.crud.service.CourseService;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController { 

    @Autowired
    private CourseService service;

    // Display all courses
    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = service.getAllCourses();
        model.addAttribute("courses", courses);
        return "index"; // Ensure this matches your Thymeleaf template
    }

    // Show create form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "create";
    }

    // Save new course
    @PostMapping("/save")
    public String saveCourse(@ModelAttribute Course course) {
        service.saveCourse(course);
        return "redirect:/courses";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = service.getCourseById(id);
        if (course == null) {
            return "redirect:/courses?error=notfound";
        }
        model.addAttribute("course", course);
        return "edit";
    }

    // Update course
    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course) {
        Course existingCourse = service.getCourseById(id);
        if (existingCourse == null) {
            return "redirect:/courses?error=notfound";
        }
        existingCourse.setName(course.getName());
        existingCourse.setAuthor(course.getAuthor());
        service.saveCourse(existingCourse);
        return "redirect:/courses";
    }

    // Delete course
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
        return "redirect:/courses";
    }
}

