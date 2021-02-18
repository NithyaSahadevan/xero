package utils;

import org.json.simple.JSONObject;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.LoginPage;

public class loginutil {
	public void loginToXero(String userName,String password) throws InterruptedException
	{
		LoginPage login=new LoginPage(commonutils.driver);
		login.setEmail(userName);
		login.setPassword(password);
		login.clickSubmit();
		Thread.sleep(5000);	
	}

}
