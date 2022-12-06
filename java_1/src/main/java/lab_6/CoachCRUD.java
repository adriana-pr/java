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
    private static String insertCoach = "INSERT INTO coaches (id,fullName_coach,workout)" +
            "VALUES (?, ?, ?);";
    private static String updateCoach = "UPDATE coaches SET workout = ? WHERE id =?";
    private static String deleteCoach = "DELETE FROM coaches WHERE id =?";

    public static List<Coach> saveCoach(Coach coach){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(insertCoach);
        ) {
            prepareStatement.setInt(1, coach.getId());
            prepareStatement.setString(2, coach.getFullName());
            prepareStatement.setString(3, coach.getWorkout());
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Coach> coaches  = getCoachData("SELECT * FROM coaches;");
        return coaches;
    }
    public static List<Coach> getCoachData(String query){
        List<Coach> coaches = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(query);
        ) {
            ResultSet result = prepareStatement.executeQuery();
            while(result.next()){
                int id =result.getInt("id");
                String name =result.getString("fullName_coach");
                String workout = result.getString("workout");
                coaches.add(new Coach.Builder().setId(id).setFullName(name).setWorkout(workout).build());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return coaches;
    }

    public static List<Coach> updateCoach(int coachId, String workout){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(updateCoach);
        ) {
            prepareStatement.setString(1, workout);
            prepareStatement.setInt(2, coachId);
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Coach> coaches = getCoachData("SELECT * FROM coaches;");
        return coaches;
    }

    public static List<Coach> deleteCoach(int coachId){
        try(Connection connection = DataBaseConnection.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(deleteCoach);
        ) {
            prepareStatement.setInt(1, coachId);
            prepareStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Coach> coaches = getCoachData("SELECT * FROM coaches;");
        return coaches;
    }
}
