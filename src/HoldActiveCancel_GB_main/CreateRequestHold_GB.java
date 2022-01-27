package HoldActiveCancel_GB_main;

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

import HoldActiveCancel_GB.Step03_CreateRequestHold_GB;


import java.io.IOException;

import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequestHold_GB
{
	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;
	public String id_green;
	public String paswd_green;
	public String url_green;
	public String url2;

	public WebDriver driver;


	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");

		//ProfilesIni ini = new ProfilesIni();
		//FirefoxProfile profile = ini.getProfile("default");
		//WebDriver driver =  new FirefoxDriver(profile);

		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Softwares\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();

		//System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 6, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 6, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 6, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC

	@Test(priority=0)
	public void RIPC_Login() throws InterruptedException, IOException 
	{

		Step03_CreateRequestHold_GB login = new Step03_CreateRequestHold_GB(driver);
		login.login();
	}
	@Test(priority=1)
	public void holdAction()
	{
		Step03_CreateRequestHold_GB holdaction = new Step03_CreateRequestHold_GB(driver);
		holdaction.holdReq();
	}
	
	@Test(priority=2)
	public void reqstatus()
	{
		Step03_CreateRequestHold_GB status = new Step03_CreateRequestHold_GB(driver);
		status.reqStatus();
	}
	
	
}

