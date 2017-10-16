package getRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class validateResponseBDD {

	// Given the URI /end point provided
	@BeforeClass
	public void SetUp() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";

	}

	// Given parameters
	// :units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=YOUR_API_KEY
	// when Resurce path: /distancematrix/json
	// then verify distance text, status code, and content type
	@Test
	public void statusCodeVerification() {
		given().param("units", "imperial").param("origins", "Washington,DC").param("destinations", "New+York+City,NY")
				.param("key", "AIzaSyBSL3NOlB9eAydam4bys5Sn84mLi-ZYPSc")

				.when().get("/distancematrix/json").then().statusCode(200).and()
				.body("rows[0].elements[0].distance.text", equalTo("225 mi")).contentType(ContentType.JSON);

	}

}
