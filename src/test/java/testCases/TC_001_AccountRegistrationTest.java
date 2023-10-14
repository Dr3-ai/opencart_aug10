package testCases;

//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	void test_account_registration() throws InterruptedException {
		try {
			
			logger.debug("Application logs...");
			logger.info("*** Starting TC_001_AccountRegistrationTest ***");//to showing the msg in logs
			
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("clicked on my account link");
		
		hp.ClickRegister();
		logger.info("Clicked on registration link");
		
		AccountRegistrationPage acc_reg=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data...");
		
		acc_reg.setFirstName(RandomString());
		acc_reg.setLastName(RandomString().toUpperCase()); //"Rajpoot"
		acc_reg.setEmail(RandomString()+"@gmail.com"); //abhishek432@gmail.com
		//acc_reg.txtCountry("India");
		String value=RandomAlphaNum(); //if require same value for 2 method other call directly inside method...
		acc_reg.txtPassword(value); //"abhi@123"  //RamdomAlphaNum()-->if 2 method there in sequeces still it will provide diff password.everytime change the value.
		//acc_reg.pictureA();
		//acc_reg.register_button();
		//Assert.assertEquals(acc_reg.msg_Confirmation(), true);
		acc_reg.clk_newsletter();
		acc_reg.clk_tc_agree();
		acc_reg.clk_for_continue();
		logger.info("Clicked on Continue...");
		
		String res_msg=acc_reg.msg_Confirmation();
		logger.info("Validating expected Message");
		Assert.assertEquals(res_msg, "Your Account Has Been Created!","Test Failed");
		
		}catch(Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
}
	
}
