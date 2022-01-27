package basicTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base_utilitypackage.Base_Class;
import base_utilitypackage.Utility_Class;
import pom_package.Log_In_Page;
@Listeners(base_utilitypackage.Listeners.class)
public class LoginPageValidation extends Base_Class {
	Log_In_Page Login;
	Utility_Class UtilityE;
	SoftAssert Soft;
	
	@BeforeClass
	public void BaseActivity() {
		LaunchBrowser("Chrome");
		Login = new Log_In_Page(driver);
		UtilityE = new Utility_Class();
		Soft = new SoftAssert();
	}
	@BeforeMethod
	public void Resetpage() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
	}
	@Test
	public void UIDerrorvalidation() throws EncryptedDocumentException, InterruptedException, IOException {
		Login.Enterpassword(UtilityE.GetExceldata("Sheet1", 1, 1));
		Login.ClickLogin();
		String Actual = Login.GetUIDError();
		String Expected=UtilityE.GetExceldata("Sheet2", 1, 0);
		Soft.assertEquals(Actual, Expected,"Test failed");
		Soft.assertAll();
	}
	@Test
	private void PasswordErrorValidation() throws EncryptedDocumentException, InterruptedException, IOException {
		Login.EnterUserID(UtilityE.GetExceldata("Sheet1", 1, 0));
		Login.ClickLogin();
		String actual =Login.GetPassError();
		String expected=UtilityE.GetExceldata("Sheet2", 1, 1);
		Soft.assertEquals(actual, expected,"Test Fai");
		Soft.assertAll();
	}
	@AfterClass
	public void TerminateBrowser() {
		driver.quit();
	}

}
