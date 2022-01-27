package HoldActiveCancel_IN;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import lib.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step05_CreateRequest_Cancel_IN {
 
private WebDriver driver;
public static String xlsFilePath = System.getProperty("user.dir") + "\\src\\testdata\\testdata.xls";
public String sheet="Login";

// Define the element 
/*@FindBy (xpath = ".//*[@id='content-main']/p[2]/a") private WebElement loginToContractor_Link;
@FindBy ( id="btn_signin") private WebElement Signin_Button ;
@FindBy ( xpath=".//*[@id='desktop']") private WebElement Username_Box ;
@FindBy ( xpath=".//*[@id='body']/div[1]/div[2]/div/div/form/input[4]") private WebElement Password_Box ;*/

//New login code
@FindBy ( xpath= "//span[@id='credentialSignin']") private WebElement cred_login;
//@FindBy ( xpath= "//input[@id='otp-input']") private WebElement otp_box;
//@FindBy(id = "submit_btn")    private WebElement otp_submit_btn;
@FindBy ( xpath= "//input[@name='username']") private WebElement login_username;
@FindBy ( xpath= "//input[@name='password']") private WebElement login_password;
@FindBy ( id="login-button") private WebElement login_Button ;
@FindBy(id = "otp-input")	private WebElement passcodeBox;
@FindBy(id = "submit_btn")	private WebElement SubmitPasscode;
@FindBy (xpath = "//label[@id='totp_label']") private WebElement Authenticator_App_option;
@FindBy (xpath = "//input[@id='newTotp-otp-input']") private WebElement EnterAccessCode_Box;
@FindBy (xpath = "//button[contains(text(),'Next: Verify')]") private WebElement Verify_Button;
@FindBy (xpath = ".//div[@id='totp_item']") private WebElement Totp_Link;
@FindBy (xpath = "//input[@id='otp-input']") private WebElement OTP_TextBox;
@FindBy (xpath = "//button[@id='submit_btn']") private WebElement OTP_Submit_Button;

@FindBy (xpath = ".//*[@id='content-main']/form[1]/div/span/input") private WebElement Create_New_Request;

//Skill Request Page	
@FindBy (id ="FLD_REQ_TYPE") private WebElement New_Request ;
@FindBy ( id="FLD_NORMAL_TYPE1") private WebElement Time_Materials ;
@FindBy (name = "btnContinue") private WebElement Continue ;

//Select Requestor
@FindBy  (id = "FLD_REQST_CO") private WebElement  Requesting_Company ;
@FindBy (id= "FLD_REQST_ORG" ) private WebElement Requesting_Organization ;

// Job Role/Skill
@FindBy ( xpath= ".//*[@id='JRSS_SELECTION1']") private WebElement Priced_JRSS;
//@FindBy ( xpath= ".//*[@id='JRSS_SELECTION2']") private WebElement Priced_JRSS;
@FindBy ( id = "FLD_JOB_ROLE" ) private WebElement Select_JobRole ;
@FindBy ( id = "FLD_SKILL_SET") private WebElement Select_SkillSet;

//Project Creation
@FindBy ( id="FLD_PROJ_NAME") private WebElement Project_Name;
@FindBy ( id="FLD_CONTACT_NAME") private WebElement Customer_Name;
@FindBy (id="FLD_IS_GLOBAL_RESOURCE0") private WebElement GlobalResource_No ;
@FindBy ( id="FLD_CONTACT_NAME") private WebElement CustomerName_Refernce ;
@FindBy ( xpath = ".//*[@id='FLD_IS_FED_CONTRACT']")  private WebElement Govt_FederalContract ;
@FindBy ( id="FLD_CLIENT") private WebElement Client ;
@FindBy ( id="FLD_BRAND") private WebElement Brand ;
@FindBy ( id="FLD_SECTOR") private WebElement Sector ;
@FindBy ( id="FLD_INDUSTRY") private WebElement Industry ;
@FindBy ( id="fldRegulatedAcc1") private WebElement FDA ;
@FindBy ( id="fldRegulatedAcc2") private WebElement FFIEC ;
@FindBy ( id="fldRegulatedAcc4") private WebElement NREG ;
@FindBy ( xpath = " .//*[@value='I'] " ) private WebElement Accounting_Type ;
@FindBy ( xpath = ".//*[@name='btnAddContingentMgr']")  private WebElement Project_Task_Manager_AddButton ;;
@FindBy ( xpath = ".//*[@id='FLD_IS_TIME_APPROVAL_TASK1']")  private WebElement Will_Manager_perform_TimeApproval_Yes ;
@FindBy ( xpath = ".//*[@id='FLD_IS_TIME_APPROVAL_TASK0']")  private WebElement Will_Manager_perform_TimeApproval_No ;
@FindBy ( xpath = ".//*[@name='btnAddTimeApprovalMgr']")  private WebElement TimeApproverID_AddButton ;

@FindBy ( xpath = ".//*[@name='FLD_EMP_WEB_ID']")  private WebElement Email_Id_TextBox ;
@FindBy ( xpath = ".//*[@name='BTN_GO']")  private WebElement GoButton ;
@FindBy (xpath = ".//*[@id='content-main']/table[4]/tbody/tr[2]/td[1]/a" ) private WebElement Name ;
@FindBy ( xpath = ".//input[@name='TEMP TIME APPROVER BUTTON']")  private WebElement UseAsTimeApprover_Button ;
@FindBy ( xpath = ".//input[@name='TEMP MANAGER FOR CR BUTTON']")  private WebElement UseAsManager_Button ;


//Skill detail Location
@FindBy ( id="FLD_WRK_LOC_STATE" ) private WebElement State_Region_Province;
@FindBy ( id="FLD_WRK_LOC_CITY" ) private WebElement City ;
@FindBy ( id="FLD_WRK_LOC" ) private WebElement Work_Location ;
@FindBy ( name="Continue" ) private WebElement Continue_2 ;
@FindBy (id="FLD_ALT_WORK_LOC" ) private WebElement Alternate_Workloc ;
@FindBy (id="FLD_FLOW_DOWN_TRMS" ) private WebElement FlowDown_Checkbox ;
@FindBy ( xpath = "//*[@id='FLD_FLOW_DOWN_RESTRICTION1']") private WebElement Flowdown_NoRadio ;
//@FindBy (xpath = ".//*[@id='FLD_ABOVE_MATRIX_RATES']") private WebElement Above_Matrix_Rate;
@FindBy (xpath = ".//*[@id='FLD_ABOVE_MATRIX_RATES0']") private WebElement Below_Matrix_Rate;

//Skill detail skill price
@FindBy ( id="FLD_RQSTD_SKILL_LVL" ) private WebElement Skill_Level;
@FindBy (id="FLD_RQSTD_PRICE_LVL" )  private WebElement Price_Level;
@FindBy (id="FLD_QTY_SKILL_NEEDED" ) private WebElement Quantity ;
@FindBy (xpath =".//*[@id='FLD_ST']") private WebElement ST_time;
@FindBy ( xpath= ".//h3[contains(text(),'Supplier warning' )]") private WebElement SuppWarning_header;
@FindBy ( id= "FLD_SUPPWARN_SUPPSELJUST") private WebElement SuppWarning_msg;
@FindBy ( id="FLD_WARNING_JUST") private WebElement just_dropdwon;
@FindBy ( xpath= "//input[@name='fldSelectSuppForReq' and @value='3']") private WebElement third_supp;
@FindBy ( id= "FLD_SUPP_NM") private WebElement sup_name;
@FindBy ( id= "FLD_CONTACT_NM") private WebElement contact_name;
@FindBy ( id= "FLD_CONTACT_PHONE_NUM") private WebElement contact_num;

//Skill Summary Page
@FindBy (xpath = ".//*[@value='Continue to request summary'] ") private WebElement ContinueToRequestSummary;

//Review Skill request
@FindBy (name = "Submit request") private WebElement SubmitRequest;

//Request Created
@FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated;
@FindBy ( xpath="//input[@name='btnCancel']") private WebElement btnCancel;
@FindBy ( xpath= ".//*[@id='content-main']/table[1]/tbody/tr/td[1]/h1 ") private WebElement RequestCreated_Header;

@FindBy ( xpath="//*[@id='site-home']") private WebElement contract_src_application ;

//Request Search
@FindBy ( xpath = ".//*[@id='left-nav']/div/a[8]" ) private WebElement LHS_Search_tab ;
@FindBy ( id="FLD_REQ_NUM_SEARCH" ) private WebElement Request_Num_Fld ;
@FindBy ( name="GO" ) private WebElement Search_GO_btn ;
@FindBy ( xpath = ".//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[1]/a" ) private WebElement Request_Num_link ;
@FindBy ( xpath="//*[@id='content-main']/form/table[3]/tbody/tr[2]/td[6]") private WebElement Req_status ;



	//Cancel Action
		@FindBy ( xpath="//input[@value='Cancel Skill(s)']") private WebElement Cancelskill_btn ;
		@FindBy ( xpath= "//*[@id='TBLCOL_REASON~0']") private WebElement Cancel_Reason;
		@FindBy ( xpath= "//*[@id='TBLCOL_COMMENTS~0']") private WebElement comments ;
		@FindBy ( xpath= "//input[@name='btnSaveAndContinue']") private WebElement saveAndContinue;	
	
// Initialize the web elements 
public Step05_CreateRequest_Cancel_IN(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


// Function to login to the application
public void login() throws InterruptedException{

	WebDriverWait wait00 = new WebDriverWait(driver, 180);
	wait00.until(ExpectedConditions.visibilityOf(cred_login));
	cred_login.click();
	
	//new login changes
	WebDriverWait wait01 = new WebDriverWait(driver, 180);
	wait01.until(ExpectedConditions.visibilityOf(login_Button));
	wait01.until(ExpectedConditions.elementToBeClickable(login_Button));
	login_username.clear();
	login_username.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 12, 0));
	Thread.sleep(1000);
	login_password.clear();
	login_password.sendKeys(Excel.getCellValue(xlsFilePath, sheet, 12, 1));
	
	//Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).save(System.getProperty("user.dir") + "\\src\\test\\resources\\Screens\\GB");
	login_Button.click();
	try{
		WebDriverWait wait1 = new WebDriverWait(driver, 50);
		wait1.until(ExpectedConditions.visibilityOf(Authenticator_App_option));
		
		Authenticator_App_option.click();
		System.out.println("Authenticator option is selected for authentication");
	}catch(NoSuchElementException | TimeoutException e)
	{
		System.out.println("Page to select Authenticator app option is not displayed");
		e.printStackTrace();
	}
	
	try {

		String otpKeyStr = "VUESKO3ATJJPQRG3";// csatestin1@c25a0161.toronto.ca.ibm.com 
		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now();
		
		

		OTP_TextBox.sendKeys(twoFactorCode);
		System.out.println("value fetched from box= "+OTP_TextBox.getAttribute("value"));
	
		OTP_Submit_Button.click();
		System.out.println("clicked on OTP submit button");
		WebDriverWait wait02 = new WebDriverWait(driver, 100);
		wait02.until(ExpectedConditions.visibilityOf(Create_New_Request));
		System.out.println("Title of page= "+driver.getTitle());
	}
	catch (Exception e) {
		System.out.println("no OTP screen");
		e.printStackTrace();
		WebDriverWait wait02 = new WebDriverWait(driver, 100);
		wait02.until(ExpectedConditions.visibilityOf(Create_New_Request));
		System.out.println("Title of page= "+driver.getTitle());
	}	
	WebDriverWait wait03 = new WebDriverWait(driver, 180);
	wait03.until(ExpectedConditions.visibilityOf(LHS_Search_tab));

	LHS_Search_tab.click();

	WebDriverWait wait04 = new WebDriverWait(driver, 160);
	wait04.until(ExpectedConditions.visibilityOf(Request_Num_Fld)); 

	Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15));
	Search_GO_btn.click();

	WebDriverWait wait05 = new WebDriverWait(driver, 160);
	wait05.until(ExpectedConditions.visibilityOf(Request_Num_link)); 

	Request_Num_link.click();
}
public void cancelReq()
{
	WebDriverWait wait08 = new WebDriverWait(driver, 160);
	wait08.until(ExpectedConditions.visibilityOf(Cancelskill_btn));
	Cancelskill_btn.click();
	
	WebDriverWait wait09 = new WebDriverWait(driver, 160);
	wait09.until(ExpectedConditions.visibilityOf(Cancel_Reason));
	Select reasonList = new Select(Cancel_Reason);
	reasonList.selectByValue("CCSN");
	//driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	
	WebDriverWait wait10 = new WebDriverWait(driver, 180);
	wait10.until(ExpectedConditions.visibilityOf(comments));
	comments.sendKeys("Canceled the candidate");
	
	WebDriverWait wait11 = new WebDriverWait(driver, 180);
	wait11.until(ExpectedConditions.visibilityOf(saveAndContinue));
	saveAndContinue.click();
	
}

public void reqStatus()
{
	contract_src_application.click();
	WebDriverWait wait12 = new WebDriverWait(driver, 180);
	wait12.until(ExpectedConditions.visibilityOf(LHS_Search_tab));
	LHS_Search_tab.click();

	WebDriverWait wait13 = new WebDriverWait(driver, 160);
	wait13.until(ExpectedConditions.visibilityOf(Request_Num_Fld)); 
	Request_Num_Fld.sendKeys(Excel.getCellValue(xlsFilePath, "Request_creation", 3, 15));
	Search_GO_btn.click();

	
	WebDriverWait wait14 = new WebDriverWait(driver, 160);
	wait14.until(ExpectedConditions.visibilityOf(Req_status)); 
	String strExpected = "Canceled";
	//Assert.assertEquals(expected, Req_status.getText());
	if (strExpected.equals(Req_status.getText())) {
		System.out.println("Request status is matching with expected");
	} else {
		System.out.println("Request status is not matching with expected");
	}
	
	
	
}




}

