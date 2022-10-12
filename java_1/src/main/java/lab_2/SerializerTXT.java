package lab_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class SerializerTXT<T>  {

    public void toFile(String fileName, T obj) {
        File f = new File(fileName);
        try {
            FileWriter myWriter = new FileWriter(f);
            myWriter.write(obj.toString());
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public T readFile(String file) {
        try {
            String fileName = file;
            String read = Files.readAllLines(Paths.get(file)).get(0);
            return (T) read;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void toFileList(String fileName, List<T> objList){
        File f = new File(fileName);
        try {
            FileWriter myWriter = new FileWriter(f);
            for(int i=0; i<objList.size();i++) {
                myWriter.write(objList.get(i).toString());
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> readFileList(String file) {
        try {
            String fileName = file;
            ArrayList<T> objList = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                objList.add((T) line);
            }
            return objList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
