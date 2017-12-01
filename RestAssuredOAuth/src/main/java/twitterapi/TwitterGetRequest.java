package twitterapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TwitterGetRequest {

	String consumerKey = "vDOg7UucQ5MFTkGH6evjuxjX5";
	String consumerSecret = "A5xOs0Ye8Yj24dUA069Qm6DcU1xIJwkRcR6d1UKbm9cxt8KCYu";
	String AccessToken = "781257766983770114-N2KtLerFvMPqx3CyRRLglqmXL93vxlk";
	String AccessSecret = "ryxVrrwbnJwH7pHRzl8fR5hMvliRH19yIvbiH9HI4aarA";
	String tweetid = "";

	@BeforeClass
	public void setup() {
		RestAssured.basePath = "/1.1/statuses";
		RestAssured.baseURI = "https://api.twitter.com";
	}

	@Test
	public void postTweet() {
		Response response = given().auth().oauth(consumerKey, consumerSecret, AccessToken, AccessSecret)
				.queryParam("status", "Mundo increíble").when().post("/update.json").then().statusCode(200).extract()
				.response();
		tweetid = response.path("id_str");
		System.out.println("The Tweet id is : " + tweetid);

	}

	@Test(dependsOnMethods = { "postTweet" })
	public void readTweet() {
		Response response = given().auth().oauth(consumerKey, consumerSecret, AccessToken, AccessSecret)
				.queryParam("id", tweetid).when().get("show.json").then().extract().response();
		String text = response.path("text");
		System.out.println("The tweet: " + text);

	}
}
