package practicesession;

public class ValidateHeader {

	public void test() {
	RestAssured.given()
    .when()
        .get("https://api.example.com/data")
    .then()
        .header("Content-Type"); // Assert Content-Type header exists


	RestAssured.given()
    .when()
        .get("https://api.example.com/data")
    .then()
        .header("Content-Type", "application/json;charset=UTF-8");




	RestAssured.given()
    .when()
        .get("https://api.example.com/data")
    .then()
        .header("Content-Type", containsString("application/json")) // Value contains "application/json"
        .header("Cache-Control", not(emptyOrNullString())) // Cache-Control is not empty or null
        .header("X-Rate-Limit-Remaining", greaterThan(0)); // X-Rate-Limit-Remaining is a number greater than 0
//headers(String header1, Matcher<?> matcher1, String header2, Matcher<?> matcher2, ...): For asserting multiple headers in a single call.



	RestAssured.given()
    .when()
        .get("https://api.example.com/data")
    .then()
        .headers(
            "Content-Type", containsString("json"),
            "X-Custom-Header", equalTo("myValue")
        );

	}
}
