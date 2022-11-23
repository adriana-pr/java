package lab_2;

import java.util.List;

public interface Serializer<T> {
     void toFile(String fileName, T obj);
      T readFile(String fileName) throws Exception;
      void toFileList(String fileName, List<T> objList);
      List<T> readFileList(String fileName) throws Exception;
}
