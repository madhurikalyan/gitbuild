package parallel;


import java.io.IOException;
import org.apache.log4j.Logger;
import com.celtic.automation.cmcs.factory.DriverFactory;
import com.celtic.automation.cmcs.pages.BillingTab;
import com.celtic.automation.cmcs.pages.CommonObjects;
import com.celtic.automation.cmcs.pages.DashBoardPage;
import com.celtic.automation.cmcs.pages.FleetPage;
import com.celtic.automation.cmcs.pages.LoginPage;
import com.celtic.automation.cmcs.pages.Reinstatement;
import com.celtic.automation.cmcs.util.ConfigReader;
import com.celtic.automation.cmcs.util.ReadExcelUtil;
import com.celtic.automation.cmcs.util.Screenshot_Utility;
import com.celtic.automation.cmcs.util.WriteExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RIN_001 {
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private DashBoardPage dashboardpage = new DashBoardPage(DriverFactory.getDriver());
	private FleetPage fleetpage = new FleetPage(DriverFactory.getDriver());
	private CommonObjects commonobjects = new CommonObjects(DriverFactory.getDriver());
	private BillingTab billingtab = new BillingTab(DriverFactory.getDriver());
	private ConfigReader config=new ConfigReader();
	private	int readRowNo=3;
	private int writeRowNo=4;
	private ReadExcelUtil excelutil=null;
	private WriteExcelUtil excelutilWrite=null;
	private Logger log = Logger.getLogger(RWC_001.class); 
	private Screenshot_Utility screenshotUtil =new Screenshot_Utility();
	private Reinstatement reinstate =new Reinstatement(DriverFactory.getDriver());
	private String className = this.getClass().getName().split("[.]")[1];
	
@Given("User login as an Internal user")
public void user_login_as_an_internal_user() throws Exception {
	excelutil = new ReadExcelUtil(config.readRINexcel());
	excelutilWrite=new WriteExcelUtil();
	excelutilWrite.setCellData(config.writeRinExcel(),"Sheet1","Account",writeRowNo,"30942");

	DriverFactory.getDriver().get(config.readLoginURL());
	log.info("****************************** Login to the application  *****************************************");
	screenshotUtil.captureScreenshot(className,"ApplicationLogin");
	loginpage.enterUsername(config.readLoginInternalUser());
	log.info("*** Enter Username ***");
	screenshotUtil.captureScreenshot(className,"Username");
	loginpage.enterPassword(config.readPswrd());
	log.info("*** Enter Password ***");
	screenshotUtil.captureScreenshot(className,"Password");
	loginpage.clickLoginBtn();
	log.info("*** Click Login ***");
	screenshotUtil.captureScreenshot(className,"Login");
}
	@When("User will navigate to IRP & Reinstate Fleet")
	public void user_will_navigate_to_irp_reinstate_fleet() throws Exception {
		
		dashboardpage.clickIRPLink();
		log.info("*** Click IRP ***");
		screenshotUtil.captureScreenshot(className,"IRP");
	
		commonobjects.waitForSpinner();
		dashboardpage.clickFleetMore();
		log.info("*** Click Fleet More ***");
		screenshotUtil.captureScreenshot(className,"FleetMore");
		
		dashboardpage.clickFleetReinstatement();
		log.info("*** Click Fleet Reinstatement ***");
		screenshotUtil.captureScreenshot(className,"FleetReinstatement");
		commonobjects.waitForSpinner();
	}

	@Then("User will provide all the inputs & select the record on the grid")
	public void user_will_provide_all_the_inputs_select_the_record_on_the_grid() throws Exception {
		fleetpage.enterAccountNo(excelutil.getCellData("PreSetup","AccountNumber",readRowNo));
		log.info("*** Enter Account Number ***");
		screenshotUtil.captureScreenshot(className,"Entering AccountNumber");
	
		fleetpage.enterLastInactiveDays(excelutil.getCellData("PreSetup","InactiveDate",readRowNo));
		log.info("*** Enter Last Inactive Days ***");
		screenshotUtil.captureScreenshot(className,"Entering Last Inactive Days");
		
		commonobjects.clickProceed();	
		//select 1st record
		fleetpage.clickFirstHandimg();
		
	}

	@Then("User will navigate to Distance page & Proceed")
	public void user_will_navigate_to_distance_page_proceed() throws IOException, Exception {
		//Land on the Distance page
		//distancetabpage.validatesubhdr(ExcelReader.FetchDataFromSheet(ConfigReader.readRINexcel(),"PreSetup",rownum,2));
		log.info(commonobjects.validateInfoMsgs());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceReportingPeriodFromlbl(),writeRowNo,reinstate.distanceReportingPeriodFrom());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceReportingPeriodTolbl(), writeRowNo,reinstate.distanceReportingPeriodTo());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceUsdotNbrlbl(), writeRowNo,reinstate.distanceUsdotNbr());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceEstimatedDistanceChartlbl(), writeRowNo,reinstate.distanceEstimatedDistanceChart());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceOverrideContJurlbl(), writeRowNo,reinstate.distanceOverrideContJur());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceEstimatedDistancelbl(), writeRowNo,reinstate.distanceEstimatedDistance());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceActualDistancelbl(), writeRowNo,reinstate.distanceActualDistance());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceTotalFleetDistancelbl(), writeRowNo,reinstate.distanceTotalFleetDistance());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceFRPMlgQuetionlbl(), writeRowNo,reinstate.distanceFRPMlgQuetion());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceDistanceTypelbl(), writeRowNo,reinstate.distanceDistanceType());
		excelutilWrite.setCellData(config.writeRinExcel(),"Distance",reinstate.distanceActualDistConfirmationlbl(), writeRowNo,reinstate.distanceActualDistConfirmation());

		commonobjects.clickProceed();
				}

	@Then("User will navigate to billing Page & provide mandatory inputs & proceed")
	public void user_will_navigate_to_billing_page_provide_mandatory_inputs_proceed() throws IOException, Exception {
		//land on the billing page
		billingtab.enterreceiptdate(excelutil.getCellData("Billing","LastReceiptDate",readRowNo));
		log.info("*** Enter  Receipt  Date ***");
		screenshotUtil.captureScreenshot(className,"Entering Receipt Date");
		
		commonobjects.clickProceed();
	}

	@Then("User will validate the Success Information Message")
	public void user_will_validate_the_success_information_message() throws IOException, Exception {
		//Validating the information message
		commonobjects.validateInfoMessage(excelutil.getCellData("Billing","InformationMessage",readRowNo));
		log.info("*** Validating the information Message ***");
		screenshotUtil.captureScreenshot(className,"Validating Information Message");
		
		dashboardpage.clickLogout();

	}
	
}
