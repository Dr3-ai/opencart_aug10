package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging



//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//ChromeOptions options=new ChromeOptions();
	
	public ResourceBundle rb; //depricated...
	public static WebDriver driver;
	public Logger logger; //for logs generating
	
	//public MessageFormat msf;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br) {
		
		rb=ResourceBundle.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass());//for logs generating
		
		//options.addArguments("headless"); //use for without opening browser
		//options.setExperimentalOption("excludeSwitchs", new String[] {"enable-automation"});//to remove control by automated software line...
		//WebDriverManager.chromedriver().setup();
		if (br.equals("chrome")) 
		{		
			driver=new ChromeDriver(); //options
		}
		
		else if (br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		else {
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		//driver.get(rb.getString("appURL"));
		driver.get("http://localhost/opencart/upload/index.php");
		//driver.get(rb.getString("appURL2"));//https://www.opencart.com/
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown() {
		//driver.close();
		driver.quit();
	}
	
	public String RandomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String RandomNumber() {
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return generatedString2;
	}
	
	//to returning combination...
	public String RandomAlphaNum() {
		String str=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return str+num;  //str+"@"+num--->password...
	}
	

	public String captureScreen(String tname) throws IOException {

		//String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//String timeStamp="2023107153829";
	
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + RandomNumber() + ".png";
		

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}