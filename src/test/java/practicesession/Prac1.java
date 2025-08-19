package practicesession;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Maps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Prac1 {

	public static String getRandomEmailID() {
		
		return "gv1"+System.currentTimeMillis()+"@opentest.com";
	}
	
	public static String getRandomName() {
		
		return "gk" + System.currentTimeMillis();
	}
	
		@Test(enabled = false)
		public static void learn1() {
			
			RestAssured.baseURI = "https://petstore3.swagger.io";
			
			Response res = given().log().all()
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "    \"id\": 10,\r\n"
					+ "    \"name\": \"doggie\",\r\n"
					+ "    \"category\": {\r\n"
					+ "        \"id\": 1,\r\n"
					+ "        \"name\": \"Dogs\"\r\n"
					+ "    },\r\n"
					+ "    \"photoUrls\": [\r\n"
					+ "        \"hello\",\r\n"
					+ "        \"hii\"\r\n"
					+ "    ],\r\n"
					+ "    \"tags\": [\r\n"
					+ "        {\r\n"
					+ "            \"id\": 1,\r\n"
					+ "            \"name\": \"gv1\"\r\n"
					+ "        },\r\n"
					+ "        {\r\n"
					+ "            \"id\": 2,\r\n"
					+ "            \"name\": \"gv2\"\r\n"
					+ "        }\r\n"
					+ "    ],\r\n"
					+ "    \"status\": \"available\"\r\n"
					+ "}")
			.when().post("/api/v3/pet")
			.then().log().all()
			.assertThat()
			.statusCode(200)
			.extract().response();
			
			System.out.println("======================================="+res.prettyPrint());
			
			JsonPath js = res.jsonPath();
			
			System.out.println("is is -- " + js.getInt("id"));
			
			System.out.println("category name  --- " + js.getString("category.name"));
			
			List<String> ls = js.getList("photoUrls");
			for(String i : ls) {
				System.out.println("-=-=-=-=-="+i);
			}
			
			int id1 = js.get("tags[0].id");
			String name1 = js.get("tags[1].name");
			
			System.out.println("----------"+ id1);
			System.out.println("----------"+ name1);
			
			
			List<Map<String, Object>> tags = js.getList("tags");
			for (Map<String, Object> tag : tags) {
			    System.out.println("Tag ID: " + tag.get("id"));
			    System.out.println("Tag Name: " + tag.get("name"));
			}
			
			
			List<String> photoList = js.getList("photoUrls");
			List<String> expectedPhotos = Arrays.asList("hello", "hii");
			Assert.assertEquals(photoList, expectedPhotos, "yes correct");
			
			//headers
		
			Headers head = res.getHeaders();
			List<Header>  list = head.asList();
			System.out.println(list);
			
		}
		
		
		@Test(enabled = false)
		public static void dtest() throws IOException {
			
			RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
			
			String email = getRandomEmailID();
			String name = getRandomName();
			
			String rawjson = new String(Files.readAllBytes(Paths.get("C:/SDFS_workspace/MY_API_Course/jsonFiles/mylearn.json")));
			String updatedjson = rawjson.replace("{{email}}", email);
			updatedjson = updatedjson.replace("{{name}}", name);
			
			Response res = given().log().all().contentType(ContentType.JSON)
			.body(updatedjson)
			.when()
			.post("/public/v2/users")
			.then()
			.statusCode(201)
			.extract()
			.response();
			
		}
		
		@Test
		public static void ddtest() {
			
			RestAssured.baseURI= "https://petstore3.swagger.io";
			
			Response ans = RestAssured.given()
					.contentType(ContentType.JSON)
					.body("{\r\n"
							+ "    \"id\": 11,\r\n"
							+ "    \"name\": \"doggie\",\r\n"
							+ "    \"category\": {\r\n"
							+ "        \"id\": 1,\r\n"
							+ "        \"name\": \"Dogs\"\r\n"
							+ "    },\r\n"
							+ "    \"photoUrls\": [\r\n"
							+ "        \"hello\",\r\n"
							+ "        \"hii\"\r\n"
							+ "    ],\r\n"
							+ "    \"tags\": [\r\n"
							+ "        {\r\n"
							+ "            \"id\": 1,\r\n"
							+ "            \"name\": \"gv1\"\r\n"
							+ "        },\r\n"
							+ "        {\r\n"
							+ "            \"id\": 2,\r\n"
							+ "            \"name\": \"gv2\"\r\n"
							+ "        }\r\n"
							+ "    ],\r\n"
							+ "    \"status\": \"available\"\r\n"
							+ "}")
			.when()
			.post("/api/v3/pet")
			.then()
			.extract()
			.response();
			
			System.out.println(ans.prettyPrint());
			
			JsonPath js1 = ans.jsonPath();
			
			int id = js1.getInt("id");
			System.out.println("---" + id);
			
			Object cat = js1.get("category");
			
			if(cat instanceof Map) {
				
				Map<String, Object> errorObject = (Map<String, Object>) cat;
				System.out.println("heyyyyyy");
				Assert.assertEquals(errorObject.get("id"), 1);
				Assert.assertEquals(errorObject.get("name"), "Dogs");
			
			String name = js1.get("category.name");
			System.out.println("-----" +name);
			List<String> photos = js1.getList("photoUrls");
			for(String i : photos) {
				System.out.println("--------"+i);
			}
			
			
			List<Object> tgid = js1.getList("tags.id");
			List<Object> tgname = js1.getList("tags.name");
			for(Object m : tgid) {
				System.out.println("oooooooooooo" + m);
			}
			
			
			List<Map<String,Object>> tag = js1.getList("tags");
			
			for(Map<String,Object> j : tag) {
				
				System.out.println(j.get("id"));
				System.out.println(j.get("name"));
			}
			
			
			//Map<Integer,Object> expected = new LinkedHashMap<Integer,Object>();
			//expected.put(1, "gv1");
			//expected.put(2, "gv2");
			Map<Integer, Object> expected = Map.of(1, "gv1", 2, "gv2");
			Map<Integer,Object> actual = new LinkedHashMap<Integer,Object>();
			List<Map<String,Object>> tagTarget = js1.getList("tags");
			System.out.println("target" + tagTarget);
			for(Map<String,Object> j : tagTarget) {
				
				actual.put((Integer) j.get("id"), j.get("name"));
			
			}
			
			Assert.assertEquals(expected, actual);
			
		}
		
		}
		@Test
		public static void dynamic() {
			
			Map<Integer, Object> expected1 = Map.of(1, "gv1", 2, "gv2");
			Map<Integer,Object> actual1 = new LinkedHashMap<Integer,Object>();
			
			
			Response res = null;
			
			JsonPath jp = res.jsonPath();
			
			Object resultans = jp.get("value");
			
			if(resultans instanceof String) {
				
				Assert.assertEquals("expected", resultans);
				Assert.assertNotNull(resultans);
			}else if(resultans instanceof Map) {
				
				Map<String, Object> errorObject = (Map<String, Object>) resultans;
				Assert.assertEquals(errorObject.get("id"), "expected value");
				Assert.assertEquals(errorObject.get("name"), "expected name");
			}else {
				
				List<Map<String, Object>> rq = (List<Map<String, Object>>) resultans;
				
				for(Map<String, Object> k1 : rq) {
					
					actual1.put((Integer) k1.get("id"), k1.get("name"));
				}
				
				Assert.assertEquals(expected1, actual1);
			}
			
			
			
			
			
		}
}
