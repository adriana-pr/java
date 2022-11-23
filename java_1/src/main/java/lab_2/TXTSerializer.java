package lab_2;

public interface TXTSerializer<T> {
   public String toStringTXT();
   T fromStringTXT( String line,Class<T> generic);
}
