package lab_3;

import lab_1.Coach;
import lab_1.FitnessRoom;
import lab_1.Workout;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ServiceMethodsStream {

    private FitnessRoom fitnessRoom;
    private Comparator comparatorWorkout;
    private Comparator comparatorCoach;

    public ServiceMethodsStream(FitnessRoom fitnessRoom) {
        this.fitnessRoom = fitnessRoom;
        this.comparatorWorkout = new ComparatorWorkout();
        this.comparatorCoach = new ComparatorCoach();
    }


    public List<Workout> findWorkoutByNameStream(String nameWorkout){
        return fitnessRoom.getWorkouts().stream().filter(
                workout -> workout.getName().contains(nameWorkout)).collect(Collectors.toList());
    }
    public List<Coach> findCoachByNameStream(String nameWorkout){
        return fitnessRoom.getCoachs().stream().filter(
                coach -> coach.getWorkout()== nameWorkout).collect(Collectors.toList());
    }
    public List<Workout> findPriceAboveStream(float price ){
        return fitnessRoom.getWorkouts().stream().filter(
                workout -> workout.getPrice()>= price).collect(Collectors.toList());
    }
    public List<Workout> findPriceBelowStream(float price){
        return  fitnessRoom.getWorkouts().stream().filter(
                workout -> workout.getPrice()<= price).collect(Collectors.toList());
    }


}
