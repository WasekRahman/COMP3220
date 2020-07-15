import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
public class convertToJSON {
   public static String convert(String fname) throws Exception {
      File input = new File(fname);
      try {
         CsvSchema csv = CsvSchema.emptySchema().withHeader();
         CsvMapper csvMapper = new CsvMapper();
         MappingIterator<Map<?, ?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(input);
         List<Map<?, ?>> list = mappingIterator.readAll();
         return list.toString();
      
      } catch(Exception e) {
         e.printStackTrace();
      }
      return "";
   }
}