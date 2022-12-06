import lab_1.Coach;
import lab_1.Workout;
import lab_5.DataBaseConnection;
import lab_6.CoachCRUD;
import lab_6.WorkoutCRUD;

public class Main {

    public static void main(String[] args) {
        DataBaseConnection dataBase = new DataBaseConnection();
        WorkoutCRUD crudWorkout = new WorkoutCRUD();
        CoachCRUD crudCoach = new CoachCRUD();
        Workout workout1 = new Workout.Builder().setId(1).setName("йога").setPrice(230).build();
        Workout workout2 = new Workout.Builder().setId(2).setName("пілатес").setPrice(200).build();
        Workout workout3 = new Workout.Builder().setId(3).setName("йога").setPrice(250).build();
        Workout workout4 = new Workout.Builder().setId(4).setName("карате").setPrice(300).build();

       Coach coach1 = new Coach.Builder().setId(1).setFullName("Ivan").setWorkout("йога").build();
        Coach coach2 = new Coach.Builder().setId(2).setFullName("Petro").setWorkout("пілатес").build();
//        dataBase.createTableWorkout();
//        crudWorkout.saveWorkout(workout1);
//        crudWorkout.saveWorkout(workout2);
//        crudWorkout.updateWorkout(1, 250f);
//        crudWorkout.deleteWorkout(1);
//        List<Workout> workouts = WorkoutCRUD.getWorkoutData("SELECT * FROM workouts;");
//        crudWorkout.saveWorkout(workout1);
//        crudWorkout.saveWorkout(workout3);
//        crudWorkout.saveWorkout(workout4);
//        System.out.println((crudWorkout.getWorkoutData("SELECT * FROM workouts;")));

//        dataBase.createTableCoach();
//        crudCoach.saveCoach(coach2);
//        crudCoach.updateCoach(2,"бокс");
//        crudCoach.deleteCoach(2);
//        System.out.println(crudCoach.deleteCoach(2));
    }
}
