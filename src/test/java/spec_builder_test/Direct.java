package spec_builder_test;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Direct {

	protected RequestSpecification reqSpec;

    @BeforeClass
    public void setup() {
        reqSpec = RestAssured
            .given()
                .baseUri("https://api.example.com")
                .header("Authorization", "Bearer token123")
                .contentType(ContentType.JSON);
    }

}
