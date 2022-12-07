package lab_6;

import lab_1.Coach;
import lab_5.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachCRUD {

    private static String getCoachById = "SELECT * FROM coaches WHERE id=?;";

    private static String getCoach = "SELECT * FROM coaches;";
    private static String insertCoach = "INSERT INTO coaches (full_name_coach,workout)" +
            "VALUES ( ?, ?);";
    private static String updateCoach = "UPDATE coaches SET phone_number = ? WHERE id =?";
    private static String deleteCoach = "DELETE FROM coaches WHERE id =?";

    public static void saveCoach(Coach coach){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(insertCoach);
        ) {
            prepareStatement.setString(1, coach.getFullName());
            prepareStatement.setInt(2, coach.getWorkout().getId());
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Coach getCoachById(int workoutId){
        Coach coach = new Coach();
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(getCoachById);
        ) {
            prepareStatement.setInt(1, workoutId);
            ResultSet result = prepareStatement.executeQuery();
            while(result.next()){
                coach.setId(result.getInt("id"));
                coach.setFullName(result.getString("full_name_coach"));
                coach.setPhoneNumber(result.getString("phone_number"));
                coach.setWorkout(WorkoutCRUD.getWorkoutById(result.getInt("workout")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return coach;
    }
    public static List<Coach> getCoachData(){
        List<Coach> coaches = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(getCoach);
        ) {
            ResultSet result = prepareStatement.executeQuery();
            while(result.next()){
                int id =result.getInt("id");
                String name =result.getString("full_name_coach");
                String phone_number =result.getString("phone_number");
                int workout = result.getInt("workout");
                coaches.add(new Coach.Builder().setId(id).setFullName(name).setPhoneNumber(phone_number).setWorkout(WorkoutCRUD.getWorkoutById(workout)).build());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return coaches;
    }

    public static void updateCoach(int coachId, String phone_number){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(updateCoach);
        ) {
            prepareStatement.setString(1, phone_number);
            prepareStatement.setInt(2, coachId);
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteCoach(int coachId){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(deleteCoach);
        ) {
            prepareStatement.setInt(1, coachId);
            prepareStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
