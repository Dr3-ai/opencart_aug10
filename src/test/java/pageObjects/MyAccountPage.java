package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement myaccount;
	@FindBy(xpath="//a[text()='Logout'][@class='list-group-item']") WebElement logout;
	
	public boolean my_account() {
		try {
		boolean rtn=myaccount.isDisplayed();
		return rtn;
	}catch(Exception e) {
		return false;
	}		
}
	public void clk_logout() {
		logout.click();
	}
}