package org.testing.TestCases;

import java.io.IOException;
import java.util.Properties;

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


public class TC6_PostRequest2 {
	static int idValue;
	
	@Test
 public void testcase6() throws IOException {
		ExtentReports report=ReportHandling.reportGenerate();
		ExtentTest test=report.startTest("Testcase6");
		
	 Properties probjects=HandleProperties.loadPropertiesFile("../APIFramework/Environment.properties");
	 String bodydata=HandleJSONFile.readJSON("../APIFramework/src/test/java/org/testing/Payloads/Requestdata.json");
	 System.out.println("TC6");
	 HTTPMethods http=new HTTPMethods(probjects);
	 Response res= http.postrequest("QA_URI6", bodydata);
	 idValue= JSONParingUsingJSONPath.jsonParse(res, "id");
	 System.out.println(+idValue);
	 
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
