package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	//Elements...
	
	@FindBy(xpath="//span[text()='My Account']") WebElement my_account;
	@FindBy(xpath="//a[text()='Register']") WebElement lnkregister;
	//@FindBy(xpath="//a[@class='btn btn-black navbar-btn']") WebElement lnkregister;
	@FindBy(xpath="//a[text()='Login'][@class='dropdown-item']") WebElement login;
	
	
	
	//Action method
	
	public void ClickMyAccount() {
		my_account.click();
	}
	public void ClickRegister() {
		lnkregister.click();
	}
	public void ClickLogin() //step no 6 from pdf...
	{ 
		login.click();	}
}
