package postRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class postRequestDemo {
	@BeforeClass
	public void setUp() {

		RestAssured.baseURI = "https://maps.googleapis.com";
		// Resource path
		RestAssured.basePath = "/maps/api";
	}

	/// place/add/json?key=
	@Test
	public void postRequestStatus() {
		given().queryParam("key", "AIzaSyCGVLBUggqFWXHskMYxcVWRgrhepnzHuG4")
				.body(("{" + "\"location\": {" + "\"lat\": -33.8669710," + "\"lng\": 151.1958750" + "},"
						+ "\"accuracy\": 50," + "\"name\": \"Google Shoes!\"," + "\"phone_number\": \"(02) 9374 4000\","
						+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
						+ "\"types\": [\"shoe_store\"]," + "\"website\": \"http://www.google.com.au/\","
						+ "\"language\": \"en-AU\"" + "}"))
				.when().post("/place/add/json").then().statusCode(200).contentType(ContentType.JSON)
				.body("scope", equalTo("APP")).body("status", equalTo("OK"));

	}

}
