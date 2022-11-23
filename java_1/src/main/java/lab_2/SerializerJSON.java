package lab_2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab_1.Workout;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializerJSON<T> implements Serializer<T> {

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
            return objectMapper.readValue(new File(fileName), new TypeReference<T>() {});
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
            return objectMapper.readValue(new File(fileName), new TypeReference<List<T>>() {});

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}


