package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.LoginPage;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.commonutils;
import utils.loginutil;

public class testcase01 {
	
	@BeforeMethod
	@Parameters("browser")
	public void launch(String browser) throws Exception {	
		commonutils.generateReport("/Users/nithya/eclipse-workspace/xeroProject/Reports/XeroProject.html", "TC01");
		commonutils.launchBrowser(browser);
		commonutils.gotoXeroUrl();
	}
	
	//@Test
	/*public void tc01A() throws IOException, ParseException, InterruptedException {
		JSONObject jObject = commonutils.readTestData("tc01");
		String email = (String) jObject.get("username");
		String password = (String) jObject.get("password");
		
		loginutil login = new loginutil();
		login.loginToXero(email,password);
		String url = commonutils.driver.getCurrentUrl();
		if(url.equals("https://go.xero.com/Dashboard/"))
		{
			System.out.println("HomePage is loaded");
			commonutils.logger.log(LogStatus.PASS, "Successfuly logged in to HomePage");
		}
		else {
			System.out.println("HomePage is not loaded");
			commonutils.logger.log(LogStatus.FAIL, "HomePage is not loaded");
			commonutils.takescreenshot("tc01");
		}
	}
	
	@Test
	public void tc01B() throws IOException, ParseException, InterruptedException {
		JSONObject jObject = commonutils.readTestData("tc01b");
		String email = (String) jObject.get("username");
		String password = (String) jObject.get("password");
		
		loginutil login = new loginutil();
		login.loginToXero(email,password);
		String msg = LoginPage.getErrorMessage();
		System.out.println(msg);
		if(msg=="Your email or password is incorrect")
		{
			System.out.println("valid error");
			commonutils.logger.log(LogStatus.PASS, "valid error");
		}
		else {
			System.out.println("invalid error");
			commonutils.logger.log(LogStatus.FAIL, "invalid error");
			commonutils.takescreenshot("tc01b");
		}
	}
	
	@Test
	public void tc01C() throws IOException, ParseException, InterruptedException {
		JSONObject jObject = commonutils.readTestData("tc01c");
		String email = (String) jObject.get("username");
		String password = (String) jObject.get("password");
		
		loginutil login = new loginutil();
		login.loginToXero(email,password);
		String msg = LoginPage.getErrorMessage();
		System.out.println(msg);
		if(msg=="Your email or password is incorrect")
		{
			System.out.println("valid error");
			commonutils.logger.log(LogStatus.PASS, "valid error");
		}
		else {
			System.out.println("invalid error");
			commonutils.logger.log(LogStatus.FAIL, "invalid error");
			commonutils.takescreenshot("tc01c");
		}
	}*/
	
	@AfterMethod
	public void quit() {

		commonutils.endReport();
		commonutils.quitBrowser();
	}
}
