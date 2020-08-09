package api_hybrid_framework.api_scripts;

import static io.restassured.RestAssured.given;

import api_hybrid_framework.generic.Spec_builder_Api;
import io.restassured.response.Response;

public class TestCase_1 {

	public static void main(String[] args) {

		Response res1 = given().spec(Spec_builder_Api.request_spec_builder()).when().get("/api/users?page=2").then()
				.spec(Spec_builder_Api.response_spec_builder(200, "HTTP/1.1 200 OK")).extract().response();

		System.out.println(res1.asString());
		
	}

}
