package jiraApiTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.response.Response;
import utils.FileandEnv;
import utils.GenerateJson;
//import utils.JavaUtilis;

public class PostAPITest extends BaseTest {

	int newTestStepId;
	HeaderConfigs header = new HeaderConfigs();
	
//verifying the post call
	//@Test(priority =1)
	public void PostJiraStep() throws IOException {
		
		Response response_PostTestStep=RestAssured.given().auth().
				preemptive().basic(FileandEnv.envAndFile().get("username"),
						FileandEnv.envAndFile().get("password"))
				.headers(header.defaultHeaders()).
				//.headers(header.defaultHeaders()).
				body("").
				//body(GenerateJson.GenerateStringFromResource("C:\\Users\\dell\\Downloads\\RestAssuredFrameworkDemo\\RestAssuredFramework-master\\src\\main\\java\\utils\\teststep.json")).
				when()
				.put(APIPath.apiPath.post_url_test_steps).then().log().all().assertThat()
				.statusCode(200).log().all().extract().response();
				//System.out.println(response_PostTestStep);
				newTestStepId = response_PostTestStep.jsonPath().getInt("id");
			     System.out.println("***********"+newTestStepId);
		
				APIVerification.responseCodeValiddation(response_PostTestStep, 200);
				APIVerification.responseTimeValidation(response_PostTestStep);

				test.log(LogStatus.INFO, "My test has been ended.....");
				System.out.println("end of post request");
	}

}
