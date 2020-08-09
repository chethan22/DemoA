package api_hybrid_framework.api_scripts;

import static io.restassured.RestAssured.given;

import api_hybrid_framework.generic.Spec_builder_Api;
import io.restassured.response.Response;

public class TestCase_2 {

	public static void main(String[] args) {

		Response res1 = given().spec(Spec_builder_Api.request_spec_builder()).when().get("/api/users/23").then()
				.spec(Spec_builder_Api.response_spec_builder(404, "HTTP/1.1 404 Not Found")).extract().response();
        
		System.out.println(res1.asString());
		System.out.println(res1.getStatusCode());
		System.out.println(res1.getStatusLine());

	}

}
