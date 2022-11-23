package TestLab_4;

import lab_1.Workout;
import org.testng.annotations.Test;

public class TestException {

    @Test
    public void priseWorkoutNegTest(){
        new Workout.Builder().setPrice(-200).build();
    }

}
