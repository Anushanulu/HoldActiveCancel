package HoldActiveCancel_IN_main;

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

import HoldActiveCancel_IN.Step03_CreateRequest_Hold_IN;

import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequest_Hold_IN
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
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Project csa\\Softwares\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 12, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 12, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 12, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url); 
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC
	@Test(priority=0)
	public void RIPC_Login() throws InterruptedException 
	{

		Step03_CreateRequest_Hold_IN login = new Step03_CreateRequest_Hold_IN(driver);
		login.login();
				
	}
	@Test(priority=1)
	public void holdAction()
	{
		Step03_CreateRequest_Hold_IN holdaction = new Step03_CreateRequest_Hold_IN(driver);
		holdaction.holdReq();
	}
	
	@Test(priority=2)
	public void reqstatus()
	{
		Step03_CreateRequest_Hold_IN status = new Step03_CreateRequest_Hold_IN(driver);
		status.reqStatus();
	}
	


}