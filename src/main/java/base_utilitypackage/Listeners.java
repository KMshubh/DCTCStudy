package base_utilitypackage;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {
	
	// it will only execute if test gets failed
	@Override
	public void onTestFailure(ITestResult result){
		try {
			Base_Class.ScreenShot("Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// it will only execute if test gets Pass
	@Override
	public void onTestSuccess(ITestResult result){
		try {
			Base_Class.ScreenShot("Pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//It will only execute when test is Skipped
	@Override
	public void onTestSkipped(ITestResult result){
		Reporter.log("Test Is Skipped",true);
	}

}
