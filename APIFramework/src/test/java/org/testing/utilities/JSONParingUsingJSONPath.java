package org.testing.utilities;

import io.restassured.response.Response;

public class JSONParingUsingJSONPath {
	
	public static int jsonParse(Response res, String JSONPath) {
		
		int extractValue= res.jsonPath().get(JSONPath);
		return extractValue;
		
	}

}
