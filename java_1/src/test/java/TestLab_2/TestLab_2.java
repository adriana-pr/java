package TestLab_2;

import lab_1.Coach;
import lab_1.Workout;
import lab_2.SerializerJSON;
import lab_2.SerializerTXT;
import lab_2.SerializerXML;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestLab_2 {
    @Test
    public void  toFileTestJSON(){
        Workout workout = new Workout.Builder().setId(1).setName("йога").build();
        SerializerJSON<Workout> serializer = new SerializerJSON();
        serializer.toFile("file/workout.json", workout);
        assertEquals(fileContent("file/workout1.json"),fileContent("file/workout.json"));
    }
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
    public void  readFileTestJSON(){
        Workout workout = new Workout.Builder().setId(1).setName("йога").build();
        SerializerJSON<Workout> serializer = new SerializerJSON();
        Workout w = serializer.readFile("file/workout.json");
        System.out.println(w);
//        assertEquals(workout,w);
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
    public void  toFileTestListTXT(){
        List<Workout> workouts= new ArrayList<>();
        Workout workout = new Workout.Builder().setId(1).setName("йога").build();
        Workout workout1 = new Workout.Builder().setId(2).setName("пілатес").build();
        workouts.add(workout);
        workouts.add(workout1);
        SerializerTXT<Workout> serializer = new SerializerTXT<>();
        serializer.toFileList("file/workoutList.txt", workouts);
        assertEquals(fileContent("file/workoutList1.txt"),fileContent("file/workoutList.txt"));
    }
//    @Test
//    public void  readFileTestTXT(){
//        Workout workout = new Workout.Builder().setId(1).setName("йога").build();
//        SerializerTXT<Workout> serializer = new SerializerTXT();
//        Workout w = serializer.readFile("file/workout.json");
//        System.out.println(w);
//        assertEquals(workout,w);
//    }
}

