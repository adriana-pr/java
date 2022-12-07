package TestLab_3;

import lab_1.Coach;
import lab_1.FitnessRoom;
import lab_1.Workout;
import lab_3.ServiceMethodsStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class TestServiceMethodsStream {
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
    public void findWorkoutByNameStreamTest(){
        List<Workout> actual =  new ServiceMethodsStream(fitnessRoom).findWorkoutByNameStream("й");
        List <Workout> expected = List.of(workout1,workout3);
        assertEquals(expected,actual);
    }
    @Test
    public void findPriceAboveStreamTest(){
        List<Workout> actual =  new ServiceMethodsStream(fitnessRoom).findPriceAboveStream(240);
        List <Workout> expected = List.of(workout1,workout3,workout4);
        assertEquals(expected,actual);
    }
    @Test
    public void findPriceBelowStreamTest(){
        List<Workout> actual =  new ServiceMethodsStream(fitnessRoom).findPriceBelowStream(270);
        List <Workout> expected = List.of(workout2,workout3);
        assertEquals(expected,actual);
    }
    @Test
    public void findCoachByNameStreamTest(){
        List<Coach> actual =  new ServiceMethodsStream(fitnessRoom).findCoachByNameStream("пілатес");
        List <Coach> expected = List.of(coach2);
        assertEquals(expected,actual);
    }
}
