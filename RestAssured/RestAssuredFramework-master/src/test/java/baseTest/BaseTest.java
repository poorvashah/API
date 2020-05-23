package baseTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import utils.FileandEnv;



//@Listeners(ExtentReportListner.class)
//public class BaseTest extends ExtentReportListner



public class BaseTest{
	
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeClass
	public void baseTest() {
		 htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		 htmlReporter.config().setEncoding("utf-8");
		 htmlReporter.config().setDocumentTitle("Automation Repors");
		 htmlReporter.config().setReportName("API");
		 htmlReporter.config().setTheme(Theme.STANDARD);
		 
		 extent = new ExtentReports();
		 extent.setSystemInfo("org", "NIIt");
		 extent.attachReporter(htmlReporter);
		//RestAssured.baseURI = FileandEnv.envAndFile().get("ServerUrl");
	}

	
	
}
