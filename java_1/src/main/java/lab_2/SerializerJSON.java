package lab_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lab_1.Workout;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SerializerJSON<T> implements Serializer <T> {

    public void toFile(String fileName, T obj){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T readFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fileName), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void toFileList(String fileName, List<T> objList){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), objList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> readFileList(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fileName), new TypeReference<List<T>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    SerializerJSON p = new SerializerJSON();
//    List<Workout> ws= new ArrayList<Workout>();
//        Workout w  = new Workout.Builder().setId(1).setName("йога").build();
//        Workout w1 = new Workout.Builder().setId(2).setName("пілатес").build();
//        ws.add(w);
//        ws.add(w1);
//    p.toFile("file/workoutList1.json", w);
//        Object w;
//        w = p.readFile("file/workout1.json");
//        System.out.println(w);
}
}


