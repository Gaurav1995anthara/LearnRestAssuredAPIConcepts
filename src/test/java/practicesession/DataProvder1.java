package practicesession;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class DataProvder1 {
	
	@DataProvider(name = "userData")
    public Object[][] userDataProvider() throws Exception {
       
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> users = mapper.readValue(
        		new String(Files.readAllBytes(Paths.get("C:\\SDFS_workspace\\MY_API_Course\\jsonFiles\\DP1.json"))),
                new TypeReference<List<Map<String, String>>>() {}
        );
        
        // Convert List to Object[][] for DataProvider
        Object[][] data = new Object[users.size()][3];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i).get("firstName");
            data[i][1] = users.get(i).get("lastName");
            data[i][2] = users.get(i).get("email");
        }
        return data;
    }
            

	@Test(dataProvider = "userData")
    public void createUserTest(Object firstName, Object lastName, Object email) {
        System.out.println("Creating user: " + firstName + " " + lastName + ", Email: " + email);
    }
}
