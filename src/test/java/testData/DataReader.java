package testData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
/**********************************
Before use this method add to pom.xml file following dependencies:

 commons-io
 jackson-databind

************************/
public class DataReader {
    public Object[][] getJsonDataToObject(String path) throws IOException {
        /**********************************
         read json file from path and write it into a string variable
         ************************/
        String jsonData = FileUtils.readFileToString(new File(System.getProperty("user.dir") + path), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        /**********************************
            create construction to reflect json structure: [] = List, {} = HashMap
            for example
            if you have json with structure
                [
                  {
                    "email": "EndToEndFirst@mailinator.com",
                    "password": "EToEPass1!",
                    "product": "ZARA COAT 3",
                    "country": "Ukraine"
                  },
                  {
                    "email": "EndToEndFirst@mailinator.com",
                    "password": "EToEPass1!",
                    "product": "ADIDAS ORIGINAL",
                    "country": "Ukraine"
                  },
                    e.c.
                ]
            create construction List<HashMap<String, String>>
            also pass this template as TypeReference
         ************************/
        List<HashMap<String, String>> listOfData = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>() {
        });
        /**********************************
         Convert Object[][] variable to store HashMaps with datasets and using for loop pass data from list into this object array
         ************************/
        Object[][] data = new Object[listOfData.size()][1];
        for (int i = 0; i < listOfData.size(); i++) {
            data[i][0] = listOfData.get(i);
        }
        return data;
    }
}
