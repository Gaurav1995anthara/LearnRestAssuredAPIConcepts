package practicesession;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Multipartt {

	
	// multipart/form-data is the content type used when uploading files through APIs.
	// Each form field, including files, is sent as a separate part in the body. 
	// I use .multiPart() in Rest Assured to send files, and .formParam() to include additional text fields.
	
	
	//In multipart/form-data, the boundary is a special string used to separate each form field in the request body.
	//It's included in the Content-Type header, and each part is delimited by that boundary. In Rest Assured, I don't manually set the boundary — it's auto-generated when using .multiPart(), ensuring proper formatting and reducing errors.
	
	
	@Test
	public void mt() {
		
		RestAssured.given()
	    .multiPart("file", new File("path/to/image.jpg"))
	    .multiPart("name", "gaurav")
	.when()
	    .post("/upload");
	}
	
	
	@Test
	public void mt1() {
		File uploadFile = new File("src/test/resources/image.png");

		RestAssured.given()
		    .multiPart("file", uploadFile, "image/png")  // image type
		    .formParam("description", "A test image")
		.when()
		    .post("/api/upload");
	}
	
	
}
