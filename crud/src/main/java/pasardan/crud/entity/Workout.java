package pasardan.crud.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String workoutType;
    private int caloriesBurned;
    private LocalDate date;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    @Override
    public String toString() {
        return "Workout [id=" + id + ", user=" + user + ", workoutType=" + workoutType + ", caloriesBurned="
                + caloriesBurned + ", date=" + date + "]";
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Workout(Long id, User user, String workoutType, int caloriesBurned, LocalDate date) {
        this.id = id;
        this.user = user;
        this.workoutType = workoutType;
        this.caloriesBurned = caloriesBurned;
        this.date = date;
    }

    public Workout() {
        //TODO Auto-generated constructor stub
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

