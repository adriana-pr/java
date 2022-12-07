package TestLab_2;

import lab_1.Coach;
import lab_1.Workout;
import lab_2.SerializerJSON;
import lab_2.SerializerTXT;
import lab_2.SerializerXML;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.testng.AssertJUnit.assertEquals;

public class TestLab_2 {
    private String fileContent(String fileName){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
            StringBuilder string = new StringBuilder();
            while (sc.hasNextLine()){
                string.append(sc.nextLine()).append("\n");
            }
            return string.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void  toFileTestJSON(){
        Workout workout = new Workout.Builder().setId(1).setName("йога").build();
        SerializerJSON<Workout> serializer = new SerializerJSON();
        serializer.toFile("file/workout.json", workout);
        assertEquals(fileContent("file/workout1.json"),fileContent("file/workout.json"));
    }

    @Test
    public void  toFileTestListJSON() {
        List<Workout> workouts= new ArrayList<Workout>();
        Workout workout = new Workout.Builder().setId(1).setName("йога").build();
        Workout workout1 = new Workout.Builder().setId(2).setName("пілатес").build();
        workouts.add(workout);
        workouts.add(workout1);
        SerializerJSON<Workout> serializer = new SerializerJSON();
        serializer.toFileList("file/workoutList.json", workouts);
        assertEquals(fileContent("file/workoutList1.json"),fileContent("file/workoutList.json"));
    }

    @Test
    public void  readFileTestJSON(){
        SerializerJSON<Workout> serializer = new SerializerJSON();
        serializer.readFile("file/workout.json");
    }

    @Test
    public void  toFileTestListXML(){
        List<Workout> workouts= new ArrayList<Workout>();
        Workout workout = new Workout.Builder().setId(1).setName("йога").build();
        Workout workout1 = new Workout.Builder().setId(2).setName("пілатес").build();
        workouts.add(workout);
        workouts.add(workout1);
        SerializerXML<Workout> serializer = new SerializerXML<>();
        serializer.toFileList("file/workoutList.xml", workouts);
        assertEquals(fileContent("file/workoutList1.xml"),fileContent("file/workoutList.xml"));
    }
    @Test
    public void  readFileTestXML(){
        SerializerXML<Workout> serializer = new SerializerXML<>();
        serializer.readFileList("file/workoutList.xml");
    }
    @Test
    public void  toFileTestListTXT(){
        List<Workout> workouts= new ArrayList<>();
        Workout workout = new Workout.Builder().setId(1).setName("йога").build();
        Workout workout1 = new Workout.Builder().setId(2).setName("пілатес").build();
        workouts.add(workout);
        workouts.add(workout1);
        SerializerTXT<Workout> serializer = new SerializerTXT<>(Workout.class);
        serializer.toFileList("file/workoutList.txt", workouts);
        assertEquals(fileContent("file/workoutList1.txt"),fileContent("file/workoutList.txt"));
    }

    @Test
    public void  toFileTestTXTCoach(){
        Coach coach = new Coach.Builder().setId(1).setFullName("Мартинюк Андрій Сергійович").build();
        SerializerTXT<Coach> serializer = new SerializerTXT(Coach.class);
        serializer.toFile("file/coach.txt", coach);
        assertEquals(fileContent("file/coach1.txt"),fileContent("file/coach.txt"));
    }
    @Test
    public void  readFileTestTXT() throws Exception{
        SerializerTXT<Workout> serializer = new SerializerTXT<>(Workout.class);
        serializer.readFile("file/workout.txt");
    }
}

