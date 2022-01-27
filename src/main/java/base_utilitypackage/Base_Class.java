package base_utilitypackage;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Base_Class {
	
	public static WebDriver driver;
	public static void LaunchBrowser(String BrowserName) {
		switch (BrowserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Shubh\\Desktop\\New folder (3)\\chromedriver.exe");
			driver= new ChromeDriver();	
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Shubh\\Desktop\\New folder (3)\\geckodriver.exe");
			driver = new FirefoxDriver();	
			break;
		default:
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Shubh\\Desktop\\New folder (3)\\chromedriver.exe");
			driver= new ChromeDriver();
			break;
		}
		driver.get("https://kite.zerodha.com/");
	}
	public static void ScreenShot(String Result) throws IOException {
		Date D = new Date();
		DateFormat DF = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String FD = DF.format(D);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Shubh\\Desktop\\DCTC\\Screenshot\\Zerodha_"+Result+FD+".png");
		FileHandler.copy(src, dest);
	}

}
