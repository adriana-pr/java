package lab_6;

import lab_1.Workout;
import lab_5.DataBaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkoutCRUD {

    private static String getWorkoutById = "SELECT * FROM workouts WHERE id =?;";
    private static String getWorkout = "SELECT * FROM workouts;";
    private static String insertWorkout = "INSERT INTO workouts (name_workout,price,date)" +
            "VALUES (?, ?,?);";
    private static String updateWorkout = "UPDATE workouts SET price = ? WHERE id =?;";
    private static String deleteWorkout = "DELETE FROM workouts WHERE id =?;";

    public static void saveWorkout(Workout workout){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(insertWorkout);
        ) {
//            prepareStatement.setInt(1, workout.getId());
            prepareStatement.setString(1, workout.getName());
            prepareStatement.setFloat(2, workout.getPrice());
            prepareStatement.setDate(3, Date.valueOf(workout.getDate()));
//            prepareStatement.setTime(5, Time.valueOf(workout.getTime()));
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Workout getWorkoutById(int workoutId){
        Workout workout = new Workout();
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(getWorkoutById);
        ) {
            prepareStatement.setInt(1, workoutId);
            ResultSet result = prepareStatement.executeQuery();
            while(result.next()){
                workout.setId(result.getInt("id"));
                workout.setName(result.getString("name_workout"));
                workout.setPrice(result.getFloat("price"));
                workout.setDate(result.getDate("date").toLocalDate());
//                LocalTime time = result.getTime("duration").toLocalTime();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workout;
    }

    public static List<Workout> getWorkoutData(){
        List<Workout> workouts = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(getWorkout);
        ) {
            ResultSet result = prepareStatement.executeQuery();
            while(result.next()){
                int id =result.getInt("id");
                String name =result.getString("name_workout");
                Float price = result.getFloat("price");
               LocalDate date = result.getDate("date").toLocalDate();
//               LocalTime time = result.getTime("duration").toLocalTime();
                workouts.add(new Workout.Builder().setId(id).setName(name).setPrice(price).setDate(date).build());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return workouts;
    }

    public static void updateWorkout(int workoutId, Float price){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(updateWorkout);
        ) {
            prepareStatement.setFloat(1, price);
            prepareStatement.setInt(2, workoutId);
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteWorkout(int workoutId){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(deleteWorkout);
        ) {
            prepareStatement.setInt(1, workoutId);
            prepareStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
