package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class commonutils {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports report;
	public static ExtentTest logger;

	public static void launchBrowser(String browser) throws Exception {

		// Check if parameter passed from TestNG is 'firefox'/chrome
		if (browser.toLowerCase().startsWith("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();

	}

	public static void gotoXeroUrl() {

		driver.get("https://login.xero.com/");

	}

	public static JSONObject readTestData(String tcName) throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		try {
			FileReader reader = new FileReader(
					"/Users/nithya/eclipse-workspace/xeroProject/src/test/java/testdata/data.json");
			Object obj = jsonparser.parse(reader);
			JSONObject jObject = (JSONObject) obj;
			JSONObject tcObject = (JSONObject) jObject.get(tcName);
			return tcObject;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void waitExplicitly(int iSeconds, WebElement ele) {
		wait = new WebDriverWait(driver, iSeconds);
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void generateReport(String path, String tcName) {
		report = new ExtentReports(path, true);
		logger = report.startTest("xero " + tcName);
	}

	public static void endReport() {
		report.endTest(logger);
		report.flush();
		report.close();
	}

	// screenshot
	public static String takescreenshot(String tc) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String path = System.getProperty("user.dir") + "/screenshots/"+tc+".jpeg";
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		System.out.println("The fileName is `" + path + "`");
		File destnFile = new File(path);
		FileUtils.copyFile(sourceFile, destnFile);
		return path;
	}

}
