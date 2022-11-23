package lab_3;

import lab_1.Coach;
import lab_1.FitnessRoom;
import lab_1.Workout;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ServiceMethodsStream {

    private Comparator comparatorWorkout;
    private Comparator comparatorCoach;

    public ServiceMethodsStream(){
        comparatorWorkout = new ComparatorWorkout();
        comparatorCoach = new ComparatorCoach();

    }

    public List<Workout> findNameWorkoutStream(String nameWorkout, FitnessRoom fitnessRoom ){
        return (List<Workout>) fitnessRoom.getWotkouts().stream().filter(
                workout -> workout.getName()== nameWorkout).sorted(comparatorWorkout).collect(Collectors.toList());
    }
    public List<Coach> findNameCoachStream(String nameWorkout, FitnessRoom fitnessRoom ){
        return fitnessRoom.getCoachs().stream().filter(
                coach -> coach.getWorkout()== nameWorkout).sorted().collect(Collectors.toList());
    }
    public List<Workout> findPriceAboveStream(float price, FitnessRoom fitnessRoom ){
        return (List<Workout>) fitnessRoom.getWotkouts().stream().filter(
                workout -> workout.getPrice()>= price).sorted(comparatorWorkout).collect(Collectors.toList());
    }
    public List<Workout> findPriceBelonStream(float price, FitnessRoom fitnessRoom ){
        return  fitnessRoom.getWotkouts().stream().filter(
                workout -> workout.getPrice()<= price).sorted().collect(Collectors.toList());
    }


}
