package lab_6;

import lab_1.Workout;
import lab_5.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkoutCRUD {
    private static String insertWorkout = "INSERT INTO workouts (id,name_workout,price)" +
            "VALUES (?, ?, ?);";
    private static String updateWorkout = "UPDATE workouts SET price = ? WHERE id =?";
    private static String deleteWorkout = "DELETE FROM workouts WHERE id =?";

    public static List<Workout> saveWorkout(Workout workout){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(insertWorkout);
        ) {
            prepareStatement.setInt(1, workout.getId());
            prepareStatement.setString(2, workout.getName());
            prepareStatement.setFloat(3, workout.getPrice());
//            prepareStatement.setDate(4, Date.valueOf(workout.getDate()));
//            prepareStatement.setTime(5, Time.valueOf(workout.getTime()));
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Workout> workouts  = getWorkoutData("SELECT * FROM workouts;");
        return workouts;
    }
    public static List<Workout> getWorkoutData(String query){
        List<Workout> workouts = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
        ) {
            ResultSet result = prepareStatement.executeQuery();
            while(result.next()){
                int id =result.getInt("id");
                String name =result.getString("name_workout");
                Float price = result.getFloat("price");
//               LocalDate date = result.getDate("date").toLocalDate();
//               LocalTime time = result.getTime("duration").toLocalTime();
                workouts.add(new Workout.Builder().setId(id).setName(name).setPrice(price).build());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return workouts;
    }

    public static List<Workout> updateWorkout(int workoutId, Float price){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(updateWorkout);
        ) {
            prepareStatement.setFloat(1, price);
            prepareStatement.setInt(2, workoutId);
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Workout> workouts = getWorkoutData("SELECT * FROM workouts;");
        return workouts;
    }

    public static List<Workout> deleteWorkout(int workoutId){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(deleteWorkout);
        ) {
            prepareStatement.setInt(1, workoutId);
            prepareStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Workout> workouts = getWorkoutData("SELECT * FROM workouts;");
        return workouts;
    }
}
