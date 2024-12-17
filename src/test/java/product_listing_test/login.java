package product_listing_test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class login {
	
	
	// "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjIsInVzZXIiOiJtb3JfMjMxNCIsImlhdCI6MTczMzU3MjQxNH0.eU9TRgId4NO6deVihYbihKhaZoF6kQA5YmBG7AP15-I"

	@Test(enabled = false)
	public void fake_store() {
		Response rep = given().get("https://fakestoreapi.com");
		int statuscodevar = rep.getStatusCode();
		Assert.assertEquals(statuscodevar,200);
		
	}
	
	@Test(enabled = true)
	public void user_login () {
		
		JSONObject js1 = new JSONObject();
		
		js1.put("username", "mor_2314");
		js1.put("password", "83r5^_");
		
		
		
		given().body(js1.toString()).header("Content-Type", "application/JSON").when()
		.post("https://fakestoreapi.com/auth/login").then().log().all();
		
	}
	
	
	
}
