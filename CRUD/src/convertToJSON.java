/*
 * 
 */
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
// TODO: Auto-generated Javadoc

/**
 * The Class convertToJSON.
 */
public class convertToJSON {
   
   /**
    * Convert.
    *
    * @param fname the fname
    * @return the string
    * @throws Exception the exception
    */
   public static String convert(String fname) throws Exception {
<<<<<<< Updated upstream
      File input = new File(fname +".csv");
=======
      File input = new File(fname+".csv");
>>>>>>> Stashed changes
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
