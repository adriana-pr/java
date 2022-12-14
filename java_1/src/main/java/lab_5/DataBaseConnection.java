package lab_5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    static final String jdbcUrl="jdbc:postgresql://localhost:5433/fitnessClub";
    static final String user="postgres";
    static final String password="12345678";

    public static Connection getConnection(){
        Connection connection =null;
        try {
            connection =  DriverManager.getConnection(jdbcUrl,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void createTableWorkout(){
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ){
            String tableWorkout =" CREATE TABLE workouts" +
                    "( id serial PRIMARY KEY," +
                    " name_workout varchar(100)," +
                    " price FLOAT," +
                    " date date ," +
                    " duration time )";
            statement.execute(tableWorkout);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTableCoach(){
        try (  Connection connection = getConnection();
               Statement statement = connection.createStatement();
               ){
            String tableCoach =" CREATE TABLE coaches" +
                    "( id serial PRIMARY KEY," +
                    " full_name_coach varchar(150)," +
                    " phone_number varchar(13) UNIQUE," +
                    " address varchar(100)," +
                    " workout integer NOT NULL," +
                    "FOREIGN KEY(workout) REFERENCES workouts (id) )";
            statement.execute(tableCoach);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropTableCoach() throws SQLException {
        try(
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ){
            String dropCoach = "DROP TABLE IF EXISTS coaches";
            statement.execute(dropCoach);
        }
    }
    public void dropTableWorkout() throws SQLException {
        try(
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ){
            String dropWorkout = "DROP TABLE IF EXISTS workouts";
            statement.execute(dropWorkout);
        }

    }


}
