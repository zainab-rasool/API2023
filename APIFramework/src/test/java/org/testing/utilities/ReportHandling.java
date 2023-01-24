package org.testing.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportHandling {
	
	public static ExtentReports reportGenerate() {
		ExtentReports extent=new ExtentReports("../APIFramework/report.html", false);
		return extent;
	}

}
