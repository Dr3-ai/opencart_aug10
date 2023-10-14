package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
		//System.out.println("hello world");
		}
	
	//Elements
	@FindBy(xpath="//input[@id='input-email']") WebElement inp_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement inp_password;
	
	@FindBy(xpath="//button[text()='Login']") WebElement clk_login;
	
	//action methods
	public void inputEmail(String mailName) {
		inp_email.sendKeys(mailName);
	}
	public void inputPassword(String passwordDetails) {
		inp_password.sendKeys(passwordDetails);
	}
	public void clkLogin() {
		clk_login.click();
	}	
	
}
