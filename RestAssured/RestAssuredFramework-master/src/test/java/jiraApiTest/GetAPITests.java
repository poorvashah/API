package jiraApiTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import apiVerifications.GenerateExtendReport;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.FileandEnv;
import utils.TestUtil;
//
public class GetAPITests extends GenerateExtendReport{
	
	
	@DataProvider()
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> al = TestUtil.getDataFromExcel();
		return al.iterator();
	}
	
		
	@Test(dataProvider = "getTestData")
	public void getJiraTestSteptatus(String host, String ContentType, String application, String applicationjson ) {
		
		logger=extent.createTest("Verify Get Request");
		RestAssured.baseURI = "https://sandbox.xpand-it.com";
		
	

		Response response = RestAssured.given().auth().preemptive()
				.basic(FileandEnv.envAndFile().get("username"), FileandEnv.envAndFile().get("password"))
				.header(ContentType, application + "/" + applicationjson)
				.when().get(host);
		
		Assert.assertEquals(200, response.getStatusCode()); 
		// get(APIPath.apiPath.GET_LIST_OF_POSTS);
		/*
		 * try { //APIVerification.responseCodeValiddation(response, 200);
		 * Assert.assertEquals(200, response.getStatusCode()); test.log(LogStatus.PASS,
		 * "API response 200"); } catch (AssertionError e) { test.log(LogStatus.FAIL,
		 * e.fillInStackTrace()); } //APIVerification.responseTimeValidation(response);
		 * //test.log(LogStatus.INFO, "Get API test execution ends......");
		 */
	}

	 
	
	
	/*
	 * RequestSpecification requestConfiguration;
	 * 
	 * @Test(dataProvider="getTestData") public void test0(String host) throws
	 * IOException { //given().spec(requestConfiguration).auth().preemptive().basic
	 * 
	 * requestConfiguration =new
	 * RequestSpecBuilder().setBaseUri("https://sandbox.xpand-it.com").build();
	 * 
	 * Response response =
	 * RestAssured.given().spec(requestConfiguration).auth().preemptive().basic(
	 * FileandEnv.envAndFile().get("username"),
	 * FileandEnv.envAndFile().get("password")).when().get(host); }
	 */
	
   // https://sandbox.xpand-it.com/rest/raven/1.0/api/settings/teststepstatuses
	
	
	
	
	
	
	//@Test
	public void getAPITest1() {
		
		//RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS).then().log().all().statusCode(400);
		
		
		Response response = RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_POSTS);
		
//		System.out.println(response.getBody().asString());
//		
//		System.out.println(response.getStatusCode());
//		
//		System.out.println(response.getCookies());
//		
//		System.out.println(response.getTime());
		
	
		
		JSONArray array = new JSONArray(response.getBody().asString());
		
		for(int i=0; i<array.length();i++) {
			//System.out.println(array.get(i));
			
			JSONObject obj = array.getJSONObject(i);
			System.out.println(obj.get("title"));
		}
		
	}
	
	

}
