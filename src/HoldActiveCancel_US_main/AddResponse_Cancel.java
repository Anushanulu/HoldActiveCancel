
package HoldActiveCancel_US_main;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HoldActiveCancel_US.Step02_ResponseCreation_HoldActiveCancel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lib.Excel;




public class AddResponse_Cancel
{
	// TestNG logger

	public static Logger log = Logger.getLogger("TnM");

	public static String xlsFilePath =System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
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

		//System.setProperty("webdriver.chrome.driver","C:\\Chrome driver\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();

		//id = Excel.getCellValue(xlsFilePath, sheet, 2, 0);
		//paswd = Excel.getCellValue(xlsFilePath, sheet, 2, 1);
		url = Excel.getCellValue(xlsFilePath, sheet, 2, 2);

		//String url1 = "https://" +  id + ":" + paswd + "@" + url;

		driver.get(url);  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}	



	// Test to add response
	@Test(priority=0)
	public void RIPC_Login() throws IOException, InterruptedException 
	{

		Step02_ResponseCreation_HoldActiveCancel addresp = new Step02_ResponseCreation_HoldActiveCancel(driver); 
	    addresp.login();
	}
	@Test(priority=1)
	public void search_request() throws InterruptedException 
	{

		Step02_ResponseCreation_HoldActiveCancel search = new Step02_ResponseCreation_HoldActiveCancel(driver); 
		search.openRequest();
		//search.waitForFormOverlayDisappear();
	}
	@Test(priority=2)
  	public void res_Status()
 	{
 	  Step02_ResponseCreation_HoldActiveCancel status = new Step02_ResponseCreation_HoldActiveCancel(driver); 
 	  status.resStatus(" Canceled ");
 	}
}
