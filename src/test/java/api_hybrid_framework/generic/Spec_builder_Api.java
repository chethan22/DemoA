package api_hybrid_framework.generic;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Spec_builder_Api {

	public static RequestSpecification request_spec_builder() {
		RequestSpecification req = null;
		RequestSpecBuilder req_bui = new RequestSpecBuilder();
		try {
			req = req_bui.setBaseUri(Fetch_properties.getProperties_value()).setContentType(ContentType.JSON).build();
			System.out.println("valid baseuri");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("invalid baseUri");
		}
		return req;
	}

	public static ResponseSpecification response_spec_builder(int status_code,String status_line) {

		ResponseSpecBuilder res_bui = new ResponseSpecBuilder();
		ResponseSpecification res = res_bui.expectContentType(ContentType.JSON).expectStatusCode(status_code)
				.expectStatusLine(status_line).build();
		return res;
	}

}
