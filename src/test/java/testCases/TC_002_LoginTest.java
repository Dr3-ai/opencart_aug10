package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyAccountPage;
import pageObjects.LoginPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	@Test(groups= {"Sanity","Master"})
	public void LoginTest() {
		try {
		logger.info("***starting TC_002_LoginTest***");
		
		HomePage hp1=new HomePage(driver);
		hp1.ClickMyAccount();
		hp1.ClickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.inputEmail(rb.getString("email"));  //get it from config.properties file       //lp.inputEmail("gjhga@gmail.com");
		lp.inputPassword(rb.getString("password"));  //lp.inputPassword("dfkdh@123");
		lp.clkLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean val=map.my_account();//return boolean value
		//map.clk_logout();
		Assert.assertEquals(val, true);
	}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		
		
		logger.info("****Finished TC_002_LoginTest*****");
	}
}

