package twitterapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TwitterExtractResponse {

	String consumerKey = "vDOg7UucQ5MFTkGH6evjuxjX5";
	String consumerSecret = "A5xOs0Ye8Yj24dUA069Qm6DcU1xIJwkRcR6d1UKbm9cxt8KCYu";
	String AccessToken = "781257766983770114-N2KtLerFvMPqx3CyRRLglqmXL93vxlk";
	String AccessSecret = "ryxVrrwbnJwH7pHRzl8fR5hMvliRH19yIvbiH9HI4aarA";

	@BeforeClass
	public void setup() {
		RestAssured.basePath = "/1.1/statuses";
		RestAssured.baseURI = "https://api.twitter.com";
	}

	@Test
	public void postTweet() {
		given().auth().oauth(consumerKey, consumerSecret, AccessToken, AccessSecret)
				.queryParam("status", "Happy Thanksgiving!!!").when().post("/update.json").then().statusCode(200);
	}

}
