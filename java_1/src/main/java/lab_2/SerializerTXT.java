package lab_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class SerializerTXT<T extends  TXTSerializer> implements Serializer<T>  {

    private Class<T> getClass;

    public SerializerTXT(Class<T> getClass){
        this.getClass=getClass;
    }

    public void toFile(String fileName, T obj) {
        File f = new File(fileName);
        try {
            FileWriter myWriter = new FileWriter(f);
            myWriter.write(obj.toStringTXT());
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public T readFile(String file)throws Exception {
            String read = Files.readAllLines(Paths.get(file)).get(0);
            return (T) getClass.getConstructor().newInstance().fromStringTXT(read,getClass);

    }
    public void toFileList(String fileName, List<T> objList){
        File f = new File(fileName);
        try {
            FileWriter myWriter = new FileWriter(f);
            for(int i=0; i<objList.size();i++) {
                myWriter.write(objList.get(i).toStringTXT());
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> readFileList(String file) throws Exception{

            ArrayList<T> objList = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                objList.add((T) getClass.getConstructor().newInstance().fromStringTXT(line,getClass));
            }
            return objList;
    }


}
