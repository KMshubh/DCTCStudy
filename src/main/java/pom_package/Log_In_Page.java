package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log_In_Page {
	public Log_In_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//input[@id='userid']") 
	private WebElement UserId;
	
	@FindBy (id = "password")
	private WebElement Password;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement SubmitButon;
	
	@FindBy (xpath = "//span[text()='Password should be minimum 6 characters.']")
	private WebElement PassWordErrorMsg;
	
	@FindBy (xpath = "//span[text()='User ID should be minimum 6 characters.']")
	private WebElement UserIDErrorMsg;
	
	public void EnterUserID(String Userid) throws InterruptedException {
		UserId.sendKeys(Userid);
		Thread.sleep(2000);
	}
	public void Enterpassword(String PassWord) throws InterruptedException {
		Password.sendKeys(PassWord);
		Thread.sleep(2000);
	}
	public void ClickLogin() throws InterruptedException {
		SubmitButon.click();
		Thread.sleep(1000);
	}
	public String GetUIDError() {
		return UserIDErrorMsg.getText();
	}
	public String GetPassError() {
		return PassWordErrorMsg.getText();
	}
	public void ClearPasword() throws InterruptedException {
		Thread.sleep(1000);
		Password.clear();
	}
	public void ClearUserId() throws InterruptedException {
		Thread.sleep(1000);
		UserId.clear();
	}
	public void completeLogin(String Userid,String PassWord) throws InterruptedException {
		UserId.sendKeys(Userid);
		Thread.sleep(2000);
		Password.sendKeys(PassWord);
		Thread.sleep(2000);
		SubmitButon.click();
		Thread.sleep(2000);
	}


}
