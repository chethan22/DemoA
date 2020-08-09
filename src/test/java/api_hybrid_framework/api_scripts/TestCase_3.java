package api_hybrid_framework.api_scripts;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import api_hybrid_framework.generic.Json_Extract;
import api_hybrid_framework.generic.Spec_builder_Api;
import io.restassured.response.Response;

public class TestCase_3 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		JSONArray a1 = Json_Extract.Nest_json("./src/test/java/api_hybrid_framework/utils/TestData.json", "dataTest");
		for (int i = 0; i < a1.size(); i++) {

			Response res = given().spec(Spec_builder_Api.request_spec_builder()).body(a1.get(i)).when()
					.post("/api/users").then().spec(Spec_builder_Api.response_spec_builder(201, "HTTP/1.1 201 Created"))
					.extract().response();

			System.out.println(res.asString());
			System.out.println(res.getStatusLine());
			System.out.println(res.getStatusCode());

		}
	}

}
