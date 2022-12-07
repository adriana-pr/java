package lab_3;

import lab_1.Coach;
import lab_1.FitnessRoom;
import lab_1.Workout;

import java.util.*;

public class ServiceMethods {
    private FitnessRoom fitnessRoom;
    private Comparator comparatorWorkout;
    private Comparator comparatorCoach;

    public ServiceMethods(FitnessRoom fitnessRoom) {
        this.fitnessRoom = fitnessRoom;
        this.comparatorWorkout = new ComparatorWorkout();
        this.comparatorCoach = new ComparatorCoach();
    }



    public List<Workout> findWorkoutByName(String nameWorkout) {
        List<Workout> workouts = new ArrayList<>();
        for (Workout workout : fitnessRoom.getWorkouts()) {
            if (workout.getName().contains(nameWorkout)) {
                workouts.add(workout);

            }
        }
        Collections.sort(workouts, comparatorWorkout);
        return workouts;
    }

    public List<Coach> findCoachByName(String nameWorkout) {
        List<Coach> coachs = new ArrayList<>();
        for (Coach coach : fitnessRoom.getCoaches()) {
            if (nameWorkout == coach.getWorkout().getName()) {
                coachs.add(coach);
            }
        }
        Collections.sort(coachs, comparatorCoach);
        return coachs;
    }

    public List<Workout> findPriceAbove(float price) {
        List<Workout> workouts = new ArrayList<>();
        for (Workout workout : fitnessRoom.getWorkouts()) {
            if (price <= workout.getPrice()) {
                workouts.add(workout);
            }
        }
        Collections.sort(workouts, comparatorWorkout);
        return workouts;
    }

    public List<Workout> findPriceBelow(float price) {
        List<Workout> workouts = new ArrayList<>();
        for (Workout workout : fitnessRoom.getWorkouts()) {
            if (price >= workout.getPrice()) {
                workouts.add(workout);
            }
        }
        Collections.sort(workouts);
        return workouts;
    }

}
