package pasardan.crud.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    public Meal(Long id, User user, String mealName, int calories, LocalDate date) {
        this.id = id;
        this.user = user;
        this.mealName = mealName;
        this.calories = calories;
        this.date = date;
    }

    public Meal() {
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Meal [id=" + id + ", user=" + user + ", mealName=" + mealName + ", calories=" + calories + ", date="
                + date + "]";
    }

    private String mealName;
    private int calories;
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

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

