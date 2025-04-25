package pasardan.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import pasardan.crud.entity.Workout;
import pasardan.crud.entity.User;
import pasardan.crud.entity.Meal;
import pasardan.crud.repository.MealRepository;
import pasardan.crud.repository.WorkoutRepository;

@Service
public class FitnessService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    // Add a meal for the user
    public void addMeal(User user, String mealName, int calories, LocalDate date) {
        Meal meal = new Meal();
        meal.setUser(user);
        meal.setMealName(mealName);
        meal.setCalories(calories);
        meal.setDate(date);
        mealRepository.save(meal);
    }

    // Add a workout for the user
    public void addWorkout(User user, String workoutType, int caloriesBurned, LocalDate date) {
        Workout workout = new Workout();
        workout.setUser(user);
        workout.setWorkoutType(workoutType);
        workout.setCaloriesBurned(caloriesBurned);
        workout.setDate(date);
        workoutRepository.save(workout);
    }

    // Calculate calorie balance (calories consumed - calories burned)
    public int calculateCalorieBalance(User user) {
        int totalCaloriesConsumed = mealRepository.findByUser(user).stream()
                .mapToInt(Meal::getCalories)
                .sum();

        int totalCaloriesBurned = workoutRepository.findByUser(user).stream()
                .mapToInt(Workout::getCaloriesBurned)
                .sum();

        return totalCaloriesConsumed - totalCaloriesBurned;
    }
}

