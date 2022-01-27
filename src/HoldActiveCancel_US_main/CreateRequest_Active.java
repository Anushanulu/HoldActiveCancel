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

import HoldActiveCancel_US.Step01_CreateRequest_Active;

import java.io.IOException;

import org.apache.log4j.Logger;

import lib.Excel;


public class CreateRequest_Active 
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

		Step01_CreateRequest_Active login = new Step01_CreateRequest_Active(driver);
		login.login();
	}
	@Test(priority=1)
	public void Create_Req() 
	{

		Step01_CreateRequest_Active createreq = new Step01_CreateRequest_Active(driver);
		createreq.Create_New_Request();
	}
	@Test(priority=2)
	public void skill_Req() 
	{

		Step01_CreateRequest_Active skillreq = new Step01_CreateRequest_Active(driver);
		skillreq.Skill_Request();
	}
	@Test(priority=3)
	public void select_Req() 
	{

		Step01_CreateRequest_Active selectreq = new Step01_CreateRequest_Active(driver);
		selectreq.Select_Requestor();
	}

	@Test(priority=4)
	public void select_jrss() 
	{

		Step01_CreateRequest_Active selectreq = new Step01_CreateRequest_Active(driver);
		selectreq.Select_JRSS();
	}

	@Test(priority=5)
	public void req_detail() 
	{

		Step01_CreateRequest_Active reqdetail = new Step01_CreateRequest_Active(driver);
		reqdetail.Request_detailpage();
	}
	@Test(priority=6)
	public void skill_loc() 
	{

		Step01_CreateRequest_Active skillloc = new Step01_CreateRequest_Active(driver);
		skillloc.Skill_detailLocationpage();
	}
	@Test(priority=7)
	public void alert_check() 
	{

		Step01_CreateRequest_Active alertchk = new Step01_CreateRequest_Active(driver);
		alertchk.isAlertPresent();
	}
	@Test(priority=8)
	public void skill_price() 
	{

		Step01_CreateRequest_Active skillprice = new Step01_CreateRequest_Active(driver);
		skillprice.Skill_detail_skillpricepage();
	}
	@Test(priority=9)
	public void supp() 
	{

		Step01_CreateRequest_Active supplier = new Step01_CreateRequest_Active(driver);
		supplier.SupplierSelectionPage();
	}
	@Test(priority=10)
	public void reqstatus()
	{
		Step01_CreateRequest_Active status = new Step01_CreateRequest_Active(driver);
		status.reqStatus();
	}
}


