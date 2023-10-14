package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_Login_DDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void TC_LoginDDT(String email,String password,String exp) {
		
		logger.info("***starting TC_003_Login_DDT***");
		try {
		HomePage hp1=new HomePage(driver);
		hp1.ClickMyAccount();
		hp1.ClickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.inputEmail(email);  //lp.inputEmail(rb.getString("email"));  //get it from config.properties file       //lp.inputEmail("gjhga@gmail.com");
		//lp.inputPassword(rb.getString("password"));  //lp.inputPassword("dfkdh@123");
		lp.inputPassword(password);
		lp.clkLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean val=map.my_account();//return boolean value
		
		if (exp.equals("Valid")) {
			if (val==true) {
				map.clk_logout();
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}
		
		else {
			if (val==false) {
				Assert.assertTrue(true);
			}
			else {
				map.clk_logout();
				Assert.fail();
			}
		}
		/*
		if (exp.equals("Invalid")) {
			if (val==true) {
				map.clk_logout();
				Assert.fail();
			}
			else {
				Assert.assertTrue(true);
			}
		}*/}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC_003_Login_DDT***");
	}
}
