package org.testing.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.HandleJSONFile;
import org.testing.utilities.HandleProperties;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.ReportHandling;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC4_PutRequest {
	
	@Test
	public void testcase4() throws IOException {
		
		ExtentReports report=ReportHandling.reportGenerate();
		ExtentTest test=report.startTest("Testcase4");
		
		Properties probjects=HandleProperties.loadPropertiesFile("../APIFramework/Environment.properties");
		String inputbodydata=HandleJSONFile.readJSON("../APIFramework/src/test/java/org/testing/Payloads/bodydata_update.json");
		//String updatebodydata=JsonReplacement.JSONDataVariableValue(inputbodydata, "id", TC1_PostRequest.idvalue);
		System.out.println("TC4");
		HTTPMethods http=new HTTPMethods(probjects);
		//http.updateRequest("QA_URI", TC1_PostRequest.idvalue, updatebodydata);
		
		Response res=http.updateRequest("QA_URI4", 21, inputbodydata);
		
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
