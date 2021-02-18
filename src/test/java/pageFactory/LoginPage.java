package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonutils;

public class LoginPage {

	@FindBy(id = "email")
	WebElement textEmail;

	@FindBy(id = "password")
	WebElement textPassword;

	@FindBy(id = "submitButton")
	WebElement btnsubmit;

	@FindBy(xpath = " //body/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]")
	static
	WebElement textErrMsg;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/a[1]")
	WebElement forgotPwd;
	
	
	public LoginPage(WebDriver driver) {

		commonutils.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// set email name
	public void setEmail(String email) {

		commonutils.waitExplicitly(5, textEmail);
		textEmail.sendKeys(email);

	}

	// set password
	public void setPassword(String password) {

		commonutils.waitExplicitly(5, textPassword);
		textPassword.sendKeys(password);

	}

	// Click submit button
	public void clickSubmit() {

		commonutils.waitExplicitly(5, btnsubmit);
		btnsubmit.click();

	}
	
	// Click forgot pw button
		public void clickForgotpw() {

			commonutils.waitExplicitly(5, forgotPwd);
			forgotPwd.click();

		}

	// return err msg
		public static String getErrorMessage() {

			commonutils.waitExplicitly(10, textErrMsg);
			return textErrMsg.getText();

		}
}
