import lab_1.Coach;
import lab_1.Workout;
import lab_5.DataBaseConnection;
import lab_6.CoachCRUD;
import lab_6.WorkoutCRUD;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {
        DataBaseConnection dataBase = new DataBaseConnection();
        WorkoutCRUD crudWorkout = new WorkoutCRUD();
        CoachCRUD crudCoach = new CoachCRUD();
        Workout workout1 = new Workout.Builder().setName("йога").setPrice(230).setDate(LocalDate.of(2022,11,23)).build();
        Workout workout2 = new Workout.Builder().setName("пілатес").setPrice(200).setDate(LocalDate.of(2022,11,21)).build();
        Workout workout3 = new Workout.Builder().setName("йога").setPrice(250).setDate(LocalDate.of(2022,11,10)).build();
        Workout workout4 = new Workout.Builder().setName("карате").setPrice(300).setDate(LocalDate.of(2022,11,05)).build();

       Coach coach1 = new Coach.Builder().setFullName("Ivan").setWorkout(crudWorkout.getWorkoutById(2)).build();
//        Coach coach2 = new Coach.Builder().setId(2).setFullName("Petro").setWorkout(2).build();
//        dataBase.createTableWorkout();
//        dataBase.createTableCoach();
//        dataBase.dropTableCoach();
//        dataBase.dropTableWorkout();
//        crudWorkout.saveWorkout(workout1);
//        System.out.println(crudWorkout.getWorkoutData());
//        crudWorkout.saveWorkout(workout2);
//        crudWorkout.updateWorkout(1, 250f);
//        crudWorkout.deleteWorkout(1);
//        System.out.println(crudWorkout.getWorkoutData());
//        List<Workout> workouts = WorkoutCRUD.getWorkoutData("SELECT * FROM workouts;");
//        crudWorkout.saveWorkout(workout1);
//        crudWorkout.saveWorkout(workout3);
//        crudWorkout.saveWorkout(workout4);
//        System.out.println((crudWorkout.getWorkoutData("SELECT * FROM workouts;")));

//        dataBase.createTableCoach();
//        crudCoach.saveCoach(coach1);
//        crudCoach.updateCoach(1,"+380972347109");
//        crudCoach.deleteCoach(1);
//        System.out.println(crudCoach.getCoachData());
//        System.out.println(crudCoach.getCoachById(3));
//        System.out.println(crudCoach.deleteCoach(2));
    }
}
