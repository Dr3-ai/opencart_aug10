package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) throws InterruptedException {
		super(driver);
		Thread.sleep(5000);
	}
	
	//Element
	
	//@FindBy(id="input-username") WebElement txtUsername;
	
	@FindBy(id="input-firstname") WebElement txtFirstname;
	
	@FindBy(id="input-lastname") WebElement txtLastname;
	
	@FindBy(id="input-email") WebElement txtEmail;
	
	//@FindBy(id="input-country") WebElement txtCountry; //only in latest page not there when accessing by localhost
	
	@FindBy(id="input-password") WebElement txtPassword;
	
	//@FindBy(xpath="//ul[@class='list-inline']//img") List<WebElement> approve_pic; //not there
	
	//@FindBy(xpath="//div[text()=' Success: You passed!'") WebElement exp_value; //not there-->for live webapp
	
	@FindBy(id="input-newsletter") WebElement newsletter;
	//@FindBy(xpath="//button[text()='Register'][1]") WebElement button_regis;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']") WebElement msgConfirmation;
	@FindBy(xpath="//input[@name='agree']") WebElement tc_agree;
	
	@FindBy(xpath="//button[text()='Continue']") WebElement clk_continue;
	//Action methods
	public void setFirstName(String f_name) {
		txtFirstname.sendKeys(f_name);
	}
	
	public void setLastName(String l_name) {
		txtLastname.sendKeys(l_name);
	}
	
	public void setEmail(String mail) {
		txtEmail.sendKeys(mail);
	}
	
	/*
	public void txtCountry(String country) {
		Select country_nm=new Select(txtCountry); 
		country_nm.selectByVisibleText(country);		
	}*/
	
	public void txtPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	/*
	public void pictureA()  //value:approve_pic.size()  //for selecting img
	{
		for (int i=1;i<=approve_pic.size();i++) {
			approve_pic.get(i).click();
			String act_value=" Success: You passed!";
			if (exp_value.getText().equals(act_value)) {
				break;
			}
			
		}
	}*/
	
	/*
	public void register_button() {
		button_regis.click();
	}
	*/
	public String msg_Confirmation() {
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	public void clk_newsletter() {
		newsletter.click();
	}
	
	public void clk_tc_agree() {
		tc_agree.click();
	}
	
	public void clk_for_continue() {
		clk_continue.click();
	}
}
