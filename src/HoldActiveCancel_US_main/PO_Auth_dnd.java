package HoldActiveCancel_US_main;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HoldActiveCancel_US.Step00_PO_Auth_dnd;
import lib.Excel;


public class PO_Auth_dnd {

	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
	public String sheet="Login"; 
	public String url;
	public String id;
	public String paswd;

	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SriSwathiAnushaNulu\\Documents\\Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
		//driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 4, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 4, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 5, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();
	}	

	// test to Login to the application as RIPC
	@Test(priority=0)
	public void PO_Login() throws InterruptedException 
	{

		Step00_PO_Auth_dnd login = new Step00_PO_Auth_dnd(driver);
		login.login();
	}


	// test to authorize request from PO
	@Test(priority=1)
	public void authorize_PO() 
	{

		Step00_PO_Auth_dnd auth_PO = new Step00_PO_Auth_dnd(driver);
		auth_PO.authorize_PO();
	}


}


