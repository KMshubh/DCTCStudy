package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pin_Page {
	public Pin_Page(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}

}
