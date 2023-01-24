package org.testing.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.HandleProperties;
import org.testing.utilities.ReportHandling;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class TC8_GetParticularRecord {
	
	@Test
	public void testcase8() throws IOException {
		
		ExtentReports report=ReportHandling.reportGenerate();
		ExtentTest test=report.startTest("Testcase8");
		
		Properties probjects=HandleProperties.loadPropertiesFile("../APIFramework/Environment.properties");
		System.out.println("TC8");
		HTTPMethods http=new HTTPMethods(probjects);
		Response res=http.getParticularRecord("QA_URI6", TC6_PostRequest2.idValue);
		res=http.getParticularRecord("QA_URI6", 32);
		
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
