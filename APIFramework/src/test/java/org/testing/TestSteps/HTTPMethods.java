package org.testing.TestSteps;

import static io.restassured.RestAssured.*;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HTTPMethods {
	
	public Properties pr;
	public HTTPMethods(Properties pr){
		this.pr=pr;
	}
	
	public Response postrequest(String urikey,String bodydata) {
		String uriValue=pr.getProperty(urikey);
		
		Response res=
				given()
		.contentType(ContentType.JSON)
		.body(bodydata)
		.when()
		.post(uriValue);
		
		System.out.println("Status code :- ");
		System.out.println(res.statusCode());
		
		System.out.println("Response data :- ");
		System.out.println(res.asString());
		
		return res;
	}
	
	public Response getAllRequest(String urikey) {
		String uriValue=pr.getProperty(urikey);
		
		Response res=
				given()
				.contentType(ContentType.JSON)
				.when().get(uriValue);
		
		System.out.println("Status code :- ");
		System.out.println(res.statusCode());
		
		System.out.println("Response data :- ");
		System.out.println(res.asString());
		return res;
				
		
	}
	
	public Response getParticularRecord(String urikey, int idvalue) {
		String uriValue=pr.getProperty(urikey)+"/"+idvalue;
		System.out.println("gg = " +uriValue);
	
		Response res=
				given()
				.contentType(ContentType.JSON)
				.when().get(uriValue);
		
		System.out.println("Status code :- ");
		System.out.println(res.statusCode());
		
		System.out.println("Response data :- ");
		System.out.println(res.asString());
		return res;
				
		
	}
	
	
	
	public Response updateRequest(String urikey, int idValue, String bodydata) {
		String uriValue=pr.getProperty(urikey)+"/"+idValue;
		
	Response res=	
		given()
		.contentType(ContentType.JSON)
		.body(bodydata)
		.when()
		.put(uriValue);
	
	System.out.println("Status Code :- ");
	System.out.println(res.statusCode());
	
	System.out.println("Response data :- ");
	System.out.println(res.asString());
	return res;
	
	}
	
	
	public Response deleteRequest(String urikey, int idValue) {
		String uriValue=pr.getProperty(urikey)+"/"+idValue;
		
		Response res=	
			given()
			.contentType(ContentType.JSON)
			.when()
			.delete(uriValue);
		
		System.out.println("Status Code :- ");
		System.out.println(res.statusCode());
		
		System.out.println("Response data :- ");
		System.out.println(res.asString());
		return res;
	}


}
