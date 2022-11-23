package lab_3;

import lab_1.Workout;

import java.util.Comparator;

public class ComparatorWorkout implements Comparator<Workout> {
    @Override
    public int compare(Workout o1, Workout o2) {
        return (int) (o1.getPrice()-o2.getPrice());
    }
}
