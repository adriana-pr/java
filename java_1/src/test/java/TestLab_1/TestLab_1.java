package TestLab_1;

import lab_1.Workout;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;


public class TestLab_1 {
    @Test(expectedExceptions = AssertionError.class)
    public void priseWorkoutNegTest(){
        new Workout.Builder().setPrice(-200).build();
    }

    @Test
    public void equalTest(){
        Workout workout1 = new Workout.Builder().setId(1).setName("йога").build();
        Workout workout2 = new Workout.Builder().setId(1).setName("йога").build();
        assertEquals(workout1, workout2);
    }
    @Test
    public void equalNedativeTest(){
        Workout workout1 = new Workout.Builder().setId(1).setName("йога").build();
        Workout workout2 = new Workout.Builder().setId(2).setName("бокс").build();
        assertNotEquals(workout1, workout2);
    }

    @Test
    public void hashCodeTest(){
        Workout workout1 = new Workout.Builder().setId(1).setName("йога").build();
        Workout workout2 = new Workout.Builder().setId(2).setName("пілатес").build();
        assertNotEquals(workout1.hashCode(), workout2.hashCode());
    }
}

