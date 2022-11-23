package lab_3;

import lab_1.Coach;
import lab_1.FitnessRoom;
import lab_1.Workout;

import java.util.*;

public class ServiceMethods {
    private Comparator comparatorWorkout;
    private Comparator comparatorCoach;
    public ServiceMethods(){
         comparatorWorkout = new ComparatorWorkout();
         comparatorCoach = new ComparatorCoach();

    }

    public List<Workout> findNameWorkout(String nameWorkout, FitnessRoom fitnessRoom ){
        List<Workout> wotkouts = new ArrayList<>();
        for(Workout workout : fitnessRoom.getWotkouts()){
            if(nameWorkout==workout.getName())
            {
                wotkouts.add(workout);

            }
        }
        Collections.sort(wotkouts, comparatorWorkout);
        return wotkouts;
    }
    public List<Coach> findNameCoach(String nameWorkout, FitnessRoom fitnessRoom ){
        List<Coach> coachs = new ArrayList<>();
        for(Coach coach : fitnessRoom.getCoachs()){
            if(nameWorkout==coach.getWorkout()){
                coachs.add(coach);
            }
        }
        Collections.sort(coachs, comparatorCoach);
        return coachs;
    }
    public List<Workout> findPriceAbove(float price, FitnessRoom fitnessRoom ){
        List<Workout> wotkouts = new ArrayList<>();
        for(Workout workout : fitnessRoom.getWotkouts()){
            if(price<=workout.getPrice()){
                wotkouts.add(workout);
            }
        }
        Collections.sort(wotkouts, comparatorWorkout);
        return wotkouts;
    }
    public List<Workout> findPriceBelon(float price, FitnessRoom fitnessRoom ){
        List<Workout> wotkouts = new ArrayList<>();
        for(Workout workout : fitnessRoom.getWotkouts()){
            if(price>=workout.getPrice()){
                wotkouts.add(workout);
            }
        }
        Collections.sort(wotkouts);
        return wotkouts;
    }

}
