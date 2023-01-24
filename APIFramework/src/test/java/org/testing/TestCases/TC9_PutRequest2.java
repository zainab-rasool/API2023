package org.testing.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.HandleJSONFile;
import org.testing.utilities.HandleProperties;
import org.testing.utilities.ReportHandling;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC9_PutRequest2 {
	
	@Test
	public void testcase9() throws IOException {
		
		ExtentReports report=ReportHandling.reportGenerate();
		ExtentTest test=report.startTest("Testcase9");
		
		Properties probjects=HandleProperties.loadPropertiesFile("../APIFramework/Environment.properties");
		String updatedbodydta=HandleJSONFile.readJSON("../APIFramework/src/test/java/org/testing/Payloads/Requestupdate.json");
		System.out.println("TC9");
		HTTPMethods http=new HTTPMethods(probjects);
		/*http.updateRequest("QA_URI6", TC6_PostRequest2.idValue, updatedbodydta);
		http.updateRequest("QA_URI6", 101, updatedbodydta);*/
		Response res=http.updateRequest("QA_URI6", 21, updatedbodydta);
		
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
