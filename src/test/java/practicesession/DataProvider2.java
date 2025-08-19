package practicesession;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProvider2 {

	@DataProvider(name = "categoryData")
	public Object[][] categoryDataProvider() throws Exception {
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> root = mapper.readValue(new File("C:\\SDFS_workspace\\MY_API_Course\\jsonFiles\\DP2.json"),   new TypeReference<Map<String, Object>>() {});
	    Map<String, Object> categoryMap = (Map<String, Object>) root.get("category");
	    List<Map<String, Object>> kingList = (List<Map<String, Object>>) categoryMap.get("King");

	    Object[][] data = new Object[kingList.size()][2];
	    for (int i = 0; i < kingList.size(); i++) {
	        Map<String, Object> item = kingList.get(i);
	        data[i][0] = item.get("id");
	        data[i][1] = item.get("name");
	    }

	    return data;
	}
	
	@Test(dataProvider = "categoryData")
	public void validateCategoryItem(Object id, Object name) {
	    System.out.println("Validating ID: " + id + ", Name: " + name);
	}
}
