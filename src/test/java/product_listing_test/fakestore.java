package product_listing_test;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class fakestore {

	
	@Test(enabled = false)
	public void fake_store() {
		Response rep = given().get("https://fakestoreapi.com");
		int statuscodevar = rep.getStatusCode();
		Assert.assertEquals(statuscodevar,200);
		
	}
	
	@Test(enabled = true)
	public void get_all_product () {
		given().get("https://fakestoreapi.com/products").then().statusCode(200).log().all();
	}

	@Test(enabled = true)
	public void get_a_single_product () {
		given().get("https://fakestoreapi.com/products/1").then().statusCode(200).log().all();
	}
	
	@Test(enabled = true)
	public void limit_result () {
		given().get("https://fakestoreapi.com/products?limit=5").then().statusCode(200).log().all();
	}
	
	@Test(enabled = true)
	public void sort_results () {
		given().get("https://fakestoreapi.com/products?sort=desc").then().statusCode(200).log().all();
	}
	
	@Test(enabled = true)
	public void get_all_categories () {
		given().get("https://fakestoreapi.com/products/categories").then().statusCode(200).log().all();
	}
	
	@Test(enabled = true)
	public void get_product_in_a_specific_categories () {
		given().get("https://fakestoreapi.com/products/category/jewelery").then().statusCode(200).log().all();
	}
	
//	@Test(enabled = true)
//	public void API_Authentication () {
//		
//		JSONObject js1 = new JSONObject();
//		js1.put("clientName", "postman");
//		js1.put("clientEmail", "asdfgg@example.com");
//		given().body(js1.toString()).header("Content-Type", "application/JSON").when()
//		.post("https://fakestoreapi.com/products").then().log().all();
//		
//	}
	
	@Test(enabled = true)
	public void add_new_product () {
		
		JSONObject js1 = new JSONObject();
		
		js1.put("title", "test product");
		js1.put("price", 13.5);
		js1.put("description", "lorem ipsum set");
		js1.put("image", "https://i.pravatar.cc");
		js1.put("category", "electronic");
		
		
		given().body(js1.toString()).header("Content-Type", "application/JSON").when()
		.post("https://fakestoreapi.com/products").then().log().all();
		
	}

	@Test(enabled = true)
	public void update_a_product () {
		
		JSONObject js = new JSONObject();
		
		js.put("title", "test product");
		js.put("price", 13.5);
		js.put("description", "https://i.pravatar.cc");
		js.put("image", "https://i.pravatar.cc");
		js.put("category", "electronic");
		

		given().body(js.toJSONString()).when().put("https://fakestoreapi.com/products/7").then().statusCode(200).log().all();
		
		
		
		}
	
	@Test(enabled = true)
	public void delete_a_product () {

		given().delete("https://fakestoreapi.com/products/6").then().statusCode(200).log().all();
	}
	
	
}
