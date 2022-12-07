package TestLab_3;

import lab_1.Coach;
import lab_1.FitnessRoom;
import lab_1.Workout;
import lab_3.ServiceMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class TestServiceMethods {

    private static FitnessRoom fitnessRoom = new FitnessRoom();
    private static Workout workout1,workout2,workout3,workout4;
    private static Coach coach1,coach2;

    @BeforeClass
    public static void setFitnessRoom() {
         workout1 = new Workout.Builder().setId(1).setName("йога").setPrice(330).build();
         workout2 = new Workout.Builder().setId(2).setName("пілатес").setPrice(200).build();
         workout3 = new Workout.Builder().setId(3).setName("йога").setPrice(250).build();
         workout4 = new Workout.Builder().setId(4).setName("карате").setPrice(300).build();

         coach1 = new Coach.Builder().setId(1).setFullName("Ivan").setWorkout(workout1).build();
         coach2 = new Coach.Builder().setId(2).setFullName("Petro").setWorkout(workout2).build();

        fitnessRoom = new FitnessRoom.Builder().setWotkouts(List.of(workout1,workout2,workout3,workout4)).setCoachs(List.of(coach1,coach2)).build();
    }

    @Test
    public void findWorkoutByNameTest(){
        List<Workout> actual =  new ServiceMethods(fitnessRoom).findWorkoutByName("йо");
        List <Workout> expected = List.of(workout3,workout1);
        assertEquals(expected,actual);
    }
    @Test
    public void findPriceAboveTest(){
        List<Workout> actual =  new ServiceMethods(fitnessRoom).findPriceAbove(240);
        List <Workout> expected = List.of(workout3,workout4,workout1);
        assertEquals(expected,actual);
    }
    @Test
    public void findPriceBelowTest(){
        List<Workout> actual =  new ServiceMethods(fitnessRoom).findPriceBelow(270);
        List <Workout> expected = List.of(workout3,workout2);
        assertEquals(expected,actual);
    }
    @Test
    public void findCoachByNameTest(){
        List<Coach> actual =  new ServiceMethods(fitnessRoom).findCoachByName("пілатес");
        List <Coach> expected = List.of(coach2);
        assertEquals(expected,actual);
    }
}
