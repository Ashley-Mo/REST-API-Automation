package getRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getRequestDemoBDD {
	// Given the URI /end point provided
	@BeforeClass
	public void SetUp() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";

	}

	// Given parameters
	// :units=imperial&origins=Washington,DC&destinations=New+York+City,NY&key=YOUR_API_KEY
	// when Resurce path: /distancematrix/json
	@Test
	public void statusCodeVerification() {
		given().param("units", "imperial").param("origins", "Washington,DC").param("destinations", "New+York+City,NY")
				.param("key", "AIzaSyBSL3NOlB9eAydam4bys5Sn84mLi-ZYPSc")

				.when().get("/distancematrix/json").then().statusCode(200);

	}

	@Test
	public void getResponseBody() {
		Response res = given().param("units", "imperial").param("origins", "Washington,DC")
				.param("destinations", "New+York+City,NY").param("key", "AIzaSyBSL3NOlB9eAydam4bys5Sn84mLi-ZYPSc")

				.when().get("/distancematrix/json");
		String data = res.prettyPrint();
		System.out.println(data);

	}

}
