package practicesession;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class DataDrivenTesttt {

	@DataProvider(name = "userdata")
	public static Object[][] Dt() {
		
		return new Object[][] {
			
			{"gaurav" , "var", "gv@123"},
			{"ravi", "varm", "ravi@jsjs.com"},
			{"praveen",  "kimar", "pk@jsckd.com"}
			
		};
		
	}
	
	@Test(dataProvider = "userdata")
	public static void testing(String fname, String lname, String email) {
		
		RestAssured.given()
         .header("Content-Type", "application/json")
         .body("{\"firstName\":\""+fname+"\", \"lastName\":\""+lname+"\", \"email\":\""+email+"\"}")
     .when()
         .post("/users")
     .then()
         .statusCode(201)
         .body("firstName", equalTo(fname))
         .body("email", equalTo(email));
	}
}
