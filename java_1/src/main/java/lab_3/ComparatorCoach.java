package lab_3;

import lab_1.Coach;
import lab_1.Workout;

import java.util.Comparator;

public class ComparatorCoach implements Comparator<Coach> {
    @Override
    public int compare(Coach o1, Coach o2) {
        return (int) (o1.getId()-o2.getId());
    }

}
