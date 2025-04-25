package pasardan.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import pasardan.crud.entity.User;

import pasardan.crud.repository.UserRepository;
import pasardan.crud.repository.MealRepository;
import pasardan.crud.repository.WorkoutRepository;
import pasardan.crud.service.FitnessService;


@Controller
public class FitnessController {

    @Autowired
    private FitnessService fitnessService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    // Handle adding a meal
    @PostMapping("/addMeal")
    public String addMeal(@RequestParam String mealName, @RequestParam int calories, @RequestParam Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        
        // Adding a meal
        fitnessService.addMeal(user, mealName, calories, LocalDate.now());
        return "redirect:/dashboard?userId=" + userId;  // Redirecting to the dashboard with userId
    }

    // Handle adding a workout
    @PostMapping("/addWorkout")
    public String addWorkout(@RequestParam String workoutType, @RequestParam int caloriesBurned, @RequestParam Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        
        // Adding a workout
        fitnessService.addWorkout(user, workoutType, caloriesBurned, LocalDate.now());
        return "redirect:/dashboard?userId=" + userId;  // Redirecting to the dashboard with userId
    }

    // Dashboard to show calorie balance, meals, and workouts
    @GetMapping("/dashboard")
public String viewDashboard(Model model, @RequestParam(required = false) Long userId) {
    if (userId == null) {
        return "redirect:/"; // or redirect to a page that asks for a userId
    }
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));

    int calorieBalance = fitnessService.calculateCalorieBalance(user);  // Calculate calorie balance
    model.addAttribute("calorieBalance", calorieBalance);
    model.addAttribute("user", user);
    model.addAttribute("meals", mealRepository.findByUser(user));  // Get meals for user
    model.addAttribute("workouts", workoutRepository.findByUser(user));  // Get workouts for user
    return "dashboard";  // This maps to the dashboard.html file
}

}
