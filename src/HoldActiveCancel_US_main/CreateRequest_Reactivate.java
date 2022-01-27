package HoldActiveCancel_US_main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HoldActiveCancel_US.Step04_CreateRequest_Reactive;

import java.io.IOException;

import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequest_Reactivate 
{
	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;


	public WebDriver driver;


	@BeforeTest
	public void setup()
	{

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		url = Excel.getCellValue(xlsFilePath, sheet, 1, 2);
		driver.get(url);  
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC
	@Test(priority=0)
	public void RIPC_Login() throws IOException, InterruptedException 
	{

		Step04_CreateRequest_Reactive login = new Step04_CreateRequest_Reactive(driver);
		login.login();
	}
	@Test(priority=1)
	public void reactiveAction()
	{
		Step04_CreateRequest_Reactive reactivation = new Step04_CreateRequest_Reactive(driver);
		reactivation.reactiveReq();
	}
	@Test(priority=2)
	public void reqstatus()
	{
		Step04_CreateRequest_Reactive status = new Step04_CreateRequest_Reactive(driver);
		status.reqStatus();
	}
	
}


