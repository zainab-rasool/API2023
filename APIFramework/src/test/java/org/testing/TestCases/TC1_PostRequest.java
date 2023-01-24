package org.testing.TestCases;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.HandleJSONFile;
import org.testing.utilities.HandleProperties;
import org.testing.utilities.JSONParingUsingJSONPath;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.ReportHandling;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;



//Parsing the id value from the response and storing 
public class TC1_PostRequest {
	
	static int idvalue;//static so we call with class name
	
	@Test
	public void testcase1() throws IOException {
		
		ExtentReports report=ReportHandling.reportGenerate();
		ExtentTest test=report.startTest("Testcase1");
		
		Properties probjects=HandleProperties.loadPropertiesFile("../APIFramework/Environment.properties");
		String inputBodydata=HandleJSONFile.readJSON("../APIFramework/src/test/java/org/testing/Payloads/bodydata.json");
		
		/*Scanner s=new Scanner(System.in);
		System.out.println("Enter value");
		String Value=s.next();*/
		
		String updateBodydata=JsonReplacement.JSONDataVariableValue(inputBodydata, "employee_name", "Shereen");
		System.out.println("TC1");
		HTTPMethods http=new HTTPMethods(probjects);
		Response res=http.postrequest("QA_URI", updateBodydata);
		idvalue=JSONParingUsingJSONPath.jsonParse(res, "data.id");
		System.out.println(idvalue);
		
		if(res.statusCode()==200) {
			test.log(LogStatus.PASS, "Status code is matching with the expexted status code");
		}
		else {
			test.log(LogStatus.FAIL, "Status code is not matching with the expexted status code");
		}
		
		report.endTest(test);
		report.flush();
	}

}
