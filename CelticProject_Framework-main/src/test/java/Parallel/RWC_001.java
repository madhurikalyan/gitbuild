package Parallel;

import java.io.IOException;
import org.apache.log4j.Logger;
import com.pages.AccountTabPage;
import com.pages.BillingTab;
import com.pages.CommonObjects;
import com.pages.DashBoardPage;
import com.pages.DistanceTabPage;
import com.pages.Financepage;
import com.pages.FleetPage;
import com.pages.FleetTabPage;
import com.pages.InstallmentPage;
import com.pages.InventoryPage;
import com.pages.LoginPage;
import com.pages.Payment;
import com.pages.PaymentTab;
import com.pages.VehicleAdd;
import com.pages.VehicleAmend;
import com.pages.VehicleDelete;
import com.pages.VehicleTabPage;
import com.pages.WgtGroup;
import com.pages.WgtGroupAdd;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelUtil;
import com.qa.util.Screenshot_Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RWC_001 {

	private LoginPage loginpage = new LoginPage(Driver_Factory.getDriver());
	private DashBoardPage dashboardpage = new DashBoardPage(Driver_Factory.getDriver());
	private AccountTabPage accounttabpage = new AccountTabPage(Driver_Factory.getDriver());
	private FleetTabPage fleettabpage = new FleetTabPage(Driver_Factory.getDriver());
	private FleetPage fleetpage = new FleetPage(Driver_Factory.getDriver());
	private CommonObjects commonobjects = new CommonObjects(Driver_Factory.getDriver());
	private DistanceTabPage distancetabpage = new DistanceTabPage(Driver_Factory.getDriver());
	private WgtGroup wgtgroup = new WgtGroup(Driver_Factory.getDriver());
	private WgtGroupAdd wgtgroupadd = new WgtGroupAdd(Driver_Factory.getDriver());
	private VehicleTabPage Vehicletabpage = new VehicleTabPage(Driver_Factory.getDriver());
	private VehicleAmend vehicleAmend =new VehicleAmend(Driver_Factory.getDriver());
	private VehicleDelete vehicleDelete =new VehicleDelete(Driver_Factory.getDriver());
	private BillingTab billingtab = new BillingTab(Driver_Factory.getDriver());
	private Payment pay =new Payment(Driver_Factory.getDriver());
	private PaymentTab paymenttab = new PaymentTab(Driver_Factory.getDriver());
	private InventoryPage inventorypage = new InventoryPage(Driver_Factory.getDriver());
	private InstallmentPage installmentpage = new InstallmentPage(Driver_Factory.getDriver());
	private VehicleAdd vehicleadd= new VehicleAdd(Driver_Factory.getDriver());
	private Financepage financepage =new Financepage(Driver_Factory.getDriver());

	int RowNo=1;

	private ElementUtil eleutil =new ElementUtil();
	private Screenshot_Utility screenshotUtil =new Screenshot_Utility();
	private ConfigReader config=new ConfigReader();
	private Logger log = Logger.getLogger(RWC_001.class); 
	private ExcelUtil excelutil=null;
	//	private ExcelUtil excelutilWrite=null;
	@Given("User login as a Internal user")
	public void user_login_as_a_internal_user() throws Exception {
		excelutil = new ExcelUtil(config.readRWCexcel());
		//excelutilWrite=new ExcelUtil(config.writeexcel());
		Driver_Factory.getDriver().get(config.readLoginURL());
		log.info("****************************** Login to the application  *****************************************");
		screenshotUtil.captureScreenshot("ApplicationLogin");
		loginpage.enterUsername(config.readLoginInternalUser());
		log.info("*** Enter Username ***");
		screenshotUtil.captureScreenshot("Username");
		loginpage.enterPassword(config.readpswrd());
		log.info("*** Enter Password ***");
		screenshotUtil.captureScreenshot("Password");
		loginpage.clickLoginbtn();
		log.info("*** Click Login ***");
		screenshotUtil.captureScreenshot("Login");
	}

	@When("User will navigate to the IRPLink")
	public void user_will_navigate_to_the_irp_link() throws Exception {
		dashboardpage.clickIRPLink();
		log.info("*** Click IRP ***");
		screenshotUtil.captureScreenshot("IRP");
		dashboardpage.clickRenewFleetLink();
		log.info("*** Click RenewFleet ***");
		screenshotUtil.captureScreenshot("RenewFleet");
	}
	@Then("User will provide all the Account Number Details to start with IRP Transaction")
	public void user_will_provide_all_the_account_number_details_to_start_with_irp_transaction() throws IOException, Exception {
		fleetpage.enterAccountNo(excelutil.getCellData("PreSetup","AccountNumber",RowNo));
		log.info("*** Enter Account Number ***");
		screenshotUtil.captureScreenshot("Entering AccountNumber");
		fleetpage.enterFleetNo(excelutil.getCellData("PreSetup","FleetNumber",RowNo));
		log.info("*** Enter FleetNo ***");
		screenshotUtil.captureScreenshot("Entering FleetNumber");
		fleetpage.enterFleetyear(excelutil.getCellData("PreSetup","Fleet Expiration Year",RowNo));
		log.info("*** Click FleetYear ***");
		screenshotUtil.captureScreenshot("Entering FleetYear");
		commonobjects.clickProceed();	

	}

	@Then("User will navigate to account section and fill the data")
	public void user_will_navigate_to_account_section_and_fill_the_data_and_validate_message() throws Exception, Exception {

		//Fetch Values
		/*excelutilWrite.setCellData("Account",accounttabpage.fetchMCECustomernolbl(),0,accounttabpage.fetchMCECustomernolbl());
		excelutilWrite.setCellData("Account","accounttabpage.fetchMCECustomernolbl()",RowNo,accounttabpage.fetchMCECustomerno());
		excelutilWrite.setCellData("Account",accounttabpage.fetchRegistrationTypelbl(),0,accounttabpage.fetchRegistrationTypelbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchRegistrationTypelbl(), RowNo,accounttabpage.fetchRegistrationType());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCarrierTypelbl(),0,accounttabpage.fetchAccountCarrierTypelbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCarrierTypelbl(), RowNo,accounttabpage.fetchAccountCarrierType());
		excelutilWrite.setCellData("Account",accounttabpage.fetchIFTAAccountNbrlbl(),0,accounttabpage.fetchIFTAAccountNbrlbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchIFTAAccountNbrlbl(),RowNo,accounttabpage.fetchIFTAAccountNbr());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCustomerStatuslbl(),0,accounttabpage.fetchAccountCustomerStatuslbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCustomerStatuslbl(),RowNo,accounttabpage.fetchAccountCustomerStatus());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountStreet0lbl(),0,accounttabpage.fetchAccountStreet0lbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountStreet0lbl(),RowNo,accounttabpage.fetchAccountStreet0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountZip0lbl(),0,accounttabpage.fetchAccountZip0lbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountZip0lbl(),RowNo,accounttabpage.fetchAccountZip0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountJur0lbl(),0,accounttabpage.fetchAccountJur0lbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountJur0lbl(), RowNo,accounttabpage.fetchAccountJur0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCity0lbl(),0,accounttabpage.fetchAccountCity0lbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCity0lbl(),RowNo,accounttabpage.fetchAccountCity0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCounty0lbl(),0,accounttabpage.fetchAccountCounty0lbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCounty0lbl(), RowNo,accounttabpage.fetchAccountCounty0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCountry0lbl(),0,accounttabpage.fetchAccountCountry0lbl());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCountry0lbl(),RowNo,accounttabpage.fetchAccountCountry0());*/

		/*ExcelReader.updateExcel("Account", 0, 0, accounttabpage.fetchMCECustomernolbl());
		ExcelReader.updateExcel("Account",RowNo,0, accounttabpage.fetchMCECustomerno());
		ExcelReader.updateExcel("Account", 0, 1, accounttabpage.fetchRegistrationTypelbl());
		ExcelReader.updateExcel("Account", RowNo, 1, accounttabpage.fetchRegistrationType());
		ExcelReader.updateExcel("Account", 0, 2, accounttabpage.fetchAccountCarrierTypelbl());
		ExcelReader.updateExcel("Account", RowNo, 2, accounttabpage.fetchAccountCarrierType());
		ExcelReader.updateExcel("Account", 0, 3, accounttabpage.fetchIFTAAccountNbrlbl());
		ExcelReader.updateExcel("Account",RowNo, 3, accounttabpage.fetchIFTAAccountNbr());
		ExcelReader.updateExcel("Account", 0, 4, accounttabpage.fetchAccountCustomerStatuslbl());
		ExcelReader.updateExcel("Account", RowNo, 4, accounttabpage.fetchAccountCustomerStatus());
		ExcelReader.updateExcel("Account", 0, 5, accounttabpage.fetchAccountStreet0lbl());
		ExcelReader.updateExcel("Account", RowNo, 5, accounttabpage.fetchAccountStreet0());
		ExcelReader.updateExcel("Account", 0, 6, accounttabpage.fetchAccountZip0lbl());
		ExcelReader.updateExcel("Account", RowNo, 6, accounttabpage.fetchAccountZip0());
		ExcelReader.updateExcel("Account", 0, 7, accounttabpage.fetchAccountJur0lbl());
		ExcelReader.updateExcel("Account", RowNo, 7, accounttabpage.fetchAccountJur0());
		ExcelReader.updateExcel("Account", 0, 8, accounttabpage.fetchAccountCity0lbl());
		ExcelReader.updateExcel("Account",RowNo, 8, accounttabpage.fetchAccountCity0());
		ExcelReader.updateExcel("Account", 0, 9, accounttabpage.fetchAccountCounty0lbl());
		ExcelReader.updateExcel("Account", RowNo, 9, accounttabpage.fetchAccountCounty0());
		ExcelReader.updateExcel("Account", 0, 10, accounttabpage.fetchAccountCountry0lbl());
		ExcelReader.updateExcel("Account", RowNo, 10, accounttabpage.fetchAccountCountry0());
		accounttabpage.clickMailingAddress();
		ExcelReader.updateExcel("Account", 0, 11, accounttabpage.fetchAccountStreet1lbl());
		ExcelReader.updateExcel("Account",RowNo, 11, accounttabpage.fetchAccountStreet1());
		ExcelReader.updateExcel("Account", 0, 12, accounttabpage.fetchAccountZip1lbl());
		ExcelReader.updateExcel("Account", RowNo, 12, accounttabpage.fetchAccountZip1());
		ExcelReader.updateExcel("Account", 0, 13, accounttabpage.fetchAccountJur1lbl());
		ExcelReader.updateExcel("Account", RowNo, 13, accounttabpage.fetchAccountJur1());
		ExcelReader.updateExcel("Account", 0, 14, accounttabpage.fetchAccountCity1lbl());
		ExcelReader.updateExcel("Account", RowNo, 14, accounttabpage.fetchAccountCity1());
		ExcelReader.updateExcel("Account",0,15,accounttabpage.fetchAccountCounty1lbl());
		ExcelReader.updateExcel("Account",RowNo,15,accounttabpage.fetchAccountCounty1());
		ExcelReader.updateExcel("Account", 0, 16, accounttabpage.fetchAccountCountry1lbl());
		ExcelReader.updateExcel("Account",RowNo, 16, accounttabpage.fetchAccountCountry1());

		ExcelReader.updateExcel("Account", 0, 17, accounttabpage.fetchAccountAttentionTolbl());
		ExcelReader.updateExcel("Account", RowNo, 17, accounttabpage.fetchAccountAttentionTo());

		ExcelReader.updateExcel("Account", 0, 18, accounttabpage.fetchAccountUSDOTNolbl());
		ExcelReader.updateExcel("Account", RowNo, 18, accounttabpage.fetchAccountUSDOTNo());
		ExcelReader.updateExcel("Account", 0, 19, accounttabpage.fetchAccountTPIDlbl());
		ExcelReader.updateExcel("Account",RowNo, 19, accounttabpage.fetchAccountTPID());
		ExcelReader.updateExcel("Account", 0, 20, accounttabpage.fetchAccountContactnamelbl());
		ExcelReader.updateExcel("Account", RowNo, 20, accounttabpage.fetchAccountContactname());
		ExcelReader.updateExcel("Account", 0, 21, accounttabpage.fetchAccountEmaillbl());
		ExcelReader.updateExcel("Account", RowNo, 21, accounttabpage.fetchAccountEmail());

		ExcelReader.updateExcel("Account", 0, 22, accounttabpage.fetchAccountPrimaryPhonelbl());
		ExcelReader.updateExcel("Account", RowNo, 22, accounttabpage.fetchAccountPrimaryPhone());
		ExcelReader.updateExcel("Account", 0, 23, accounttabpage.fetchAccountAlternatePhonelbl());
		ExcelReader.updateExcel("Account",RowNo, 23, accounttabpage.fetchAccountAlternatePhone());
		ExcelReader.updateExcel("Account", 0, 24, accounttabpage.fetchAccountFaxNolbl());
		ExcelReader.updateExcel("Account", RowNo, 24, accounttabpage.fetchAccountFaxNo());
		ExcelReader.updateExcel("Account", 0, 25, accounttabpage.fetchAccountEmailnotificationlbl());
		ExcelReader.updateExcel("Account", RowNo, 25, accounttabpage.fetchAccountEmailnotification());
		ExcelReader.updateExcel("Account", 0, 26, accounttabpage.fetchAccountFaxnotificationlbl());
		ExcelReader.updateExcel("Account", RowNo, 26, accounttabpage.fetchAccountFaxnotification());
		 */
		//-------------------------------
		log.info(commonobjects.validateinfomsgs());
		accounttabpage.checkEmailNotification();
		log.info("*** Check Email Notification ***");
		screenshotUtil.captureScreenshot("Check EmailNotification");
		commonobjects.provideComments(excelutil.getCellData("AccountTab","Comments",RowNo));
		log.info("*** Enter Comments ***");
		screenshotUtil.captureScreenshot("Enter Comments in Account Section");

		commonobjects.clickProceed();
		//Account Verification Screen
		commonobjects.clickProceed();
	}

	@Then("User will navigate to Fleet section and fill the data and validate message  {string}")
	public void user_will_navigate_to_fleet_section_and_fill_the_data_and_validate_message(String expSucces) throws Exception {
		//Fetch Values
		/*	ExcelReader.updateExcel("Fleet", 0, 0, fleettabpage.fetchRegistrationtypelbl());
			ExcelReader.updateExcel("Fleet", RowNo, 0, fleettabpage.fetchRegistrationtype());
			ExcelReader.updateExcel("Fleet", 0, 1, fleettabpage.fetchfltstatuslbl());
			ExcelReader.updateExcel("Fleet", RowNo, 1, fleettabpage.fetchfltstatus());
			ExcelReader.updateExcel("Fleet", 0, 2, fleettabpage.fetchcarriertypelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 2, fleettabpage.fetchcarriertype());
			ExcelReader.updateExcel("Fleet", 0, 3, fleettabpage.fetchDBANamelbl());
			ExcelReader.updateExcel("Fleet", RowNo, 3, fleettabpage.fetchDBAName());

			ExcelReader.updateExcel("Fleet", 0, 4, fleettabpage.FleetStreet0lbl());
			ExcelReader.updateExcel("Fleet",RowNo, 4, fleettabpage.FleetStreet0());
			ExcelReader.updateExcel("Fleet", 0, 5, fleettabpage.FleetZip0lbl());
			ExcelReader.updateExcel("Fleet",RowNo, 5, fleettabpage.FleetZip0());
			ExcelReader.updateExcel("Fleet", 0, 6, fleettabpage.FleetJur0lbl());
			ExcelReader.updateExcel("Fleet",RowNo, 6, fleettabpage.FleetJur0());
			ExcelReader.updateExcel("Fleet", 0, 7, fleettabpage.FleetCity0lbl());
			ExcelReader.updateExcel("Fleet", RowNo, 7, fleettabpage.FleetCity0());
			ExcelReader.updateExcel("Fleet", 0, 8, fleettabpage.FleetCounty0lbl());
			ExcelReader.updateExcel("Fleet",RowNo, 8, fleettabpage.FleetCounty0());
			ExcelReader.updateExcel("Fleet", 0, 9, fleettabpage.FleetCountry0lbl());
			ExcelReader.updateExcel("Fleet", RowNo, 9, fleettabpage.FleetCountry0());
			ExcelReader.updateExcel("Fleet", 0, 10, fleettabpage.FleetNonDeliverable0lbl());
			ExcelReader.updateExcel("Fleet", RowNo, 10, fleettabpage.FleetNonDeliverable0());

			fleettabpage.clickMailingAddress();

			ExcelReader.updateExcel("Fleet", 0, 11, fleettabpage.FleetStreet1lbl());
			ExcelReader.updateExcel("Fleet",RowNo, 11, fleettabpage.FleetStreet1());
			ExcelReader.updateExcel("Fleet", 0, 12, fleettabpage.FleetZip1lbl());
			ExcelReader.updateExcel("Fleet", RowNo, 12, fleettabpage.FleetZip1());
			ExcelReader.updateExcel("Fleet", 0, 13, fleettabpage.FleetJur1lbl());
			ExcelReader.updateExcel("Fleet", RowNo, 13, fleettabpage.FleetJur1());
			ExcelReader.updateExcel("Fleet", 0, 14, fleettabpage.FleetCity1lbl());
			ExcelReader.updateExcel("Fleet",RowNo, 14, fleettabpage.FleetCity1());
			ExcelReader.updateExcel("Fleet", 0, 15, fleettabpage.FleetCounty1lbl());
			ExcelReader.updateExcel("Fleet",RowNo, 15, fleettabpage.FleetCounty1());
			ExcelReader.updateExcel("Fleet", 0, 16, fleettabpage.FleetCountry1lbl());
			ExcelReader.updateExcel("Fleet",RowNo, 16, fleettabpage.FleetCountry1());
			ExcelReader.updateExcel("Fleet", 0, 17, fleettabpage.FleetNonDeliverable1lbl());
			ExcelReader.updateExcel("Fleet", RowNo, 17, fleettabpage.FleetNonDeliverable1());
			ExcelReader.updateExcel("Fleet", 0, 18, fleettabpage.FleetAttentionTOlbl());
			ExcelReader.updateExcel("Fleet", RowNo, 18, fleettabpage.FleetAttentionTO());

			fleettabpage.navigateToServiceProvider();

			ExcelReader.updateExcel("Fleet", 0, 19, fleettabpage.FleetServiceProviderlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 19, fleettabpage.FleetServiceProvider());
			ExcelReader.updateExcel("Fleet", 0, 20, fleettabpage.FleetServiceLegalNamelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 20, fleettabpage.FleetServiceLegalName());
			ExcelReader.updateExcel("Fleet", 0, 21, fleettabpage.FleetService_DBANamelbl());
			ExcelReader.updateExcel("Fleet", RowNo, 21, fleettabpage.FleetService_DBAName());
			ExcelReader.updateExcel("Fleet", 0, 22, fleettabpage.FleetService_PowerOfAttroneylbl());
			ExcelReader.updateExcel("Fleet", RowNo, 22, fleettabpage.FleetService_PowerOfAttroney());

			ExcelReader.updateExcel("Fleet", 0, 23, fleettabpage.FleetService_PowerOfAttroneyEffDatelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 23, fleettabpage.FleetService_PowerOfAttroneyEffDate());
			ExcelReader.updateExcel("Fleet", 0, 24, fleettabpage.FleetService_PowerOfAttroneyExpDatelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 24, fleettabpage.FleetService_PowerOfAttroneyExpDate());
			ExcelReader.updateExcel("Fleet", 0, 25, fleettabpage.FleetService_EmailIDlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 25, fleettabpage.FleetService_EmailID());
			ExcelReader.updateExcel("Fleet", 0, 26, fleettabpage.FleetService_PhoneNolbl());
			ExcelReader.updateExcel("Fleet",RowNo, 26, fleettabpage.FleetService_PhoneNo());

			ExcelReader.updateExcel("Fleet", 0, 27, fleettabpage.FleetService_FaxNolbl());
			ExcelReader.updateExcel("Fleet",RowNo, 27, fleettabpage.FleetService_FaxNo());
			ExcelReader.updateExcel("Fleet", 0, 28, fleettabpage.FleetService_Streetlbl());
			ExcelReader.updateExcel("Fleet", RowNo, 28, fleettabpage.FleetService_Street());
			ExcelReader.updateExcel("Fleet", 0, 29, fleettabpage.FleetService_Citylbl());
			ExcelReader.updateExcel("Fleet",RowNo, 29, fleettabpage.FleetService_City());
			ExcelReader.updateExcel("Fleet", 0, 30, fleettabpage.FleetService_Jurlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 30, fleettabpage.FleetService_Jur());
			ExcelReader.updateExcel("Fleet", 0, 31, fleettabpage.FleetService_ZipCodelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 31, fleettabpage.FleetService_ZipCode());
			ExcelReader.updateExcel("Fleet", 0, 32, fleettabpage.FleetService_Countrylbl());
			ExcelReader.updateExcel("Fleet", RowNo, 32, fleettabpage.FleetService_Country());
			fleettabpage.clickOnTimeMailingAddress();
			ExcelReader.updateExcel("Fleet", 0, 33, fleettabpage.FleetServiceMailing_Streetlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 33, fleettabpage.FleetServiceMailing_Street());
			ExcelReader.updateExcel("Fleet", 0, 34, fleettabpage.FleetServiceMailing_ZipCodelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 34, fleettabpage.FleetServiceMailing_ZipCode());
			ExcelReader.updateExcel("Fleet", 0, 35, fleettabpage.FleetServiceMailing_Jurlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 35, fleettabpage.FleetServiceMailing_Jur());
			ExcelReader.updateExcel("Fleet", 0, 36, fleettabpage.FleetServiceMailing_Citylbl());
			ExcelReader.updateExcel("Fleet", RowNo, 36, fleettabpage.FleetServiceMailing_City());
			ExcelReader.updateExcel("Fleet", 0, 37, fleettabpage.FleetServiceMailing_Countylbl());
			ExcelReader.updateExcel("Fleet", RowNo, 37, fleettabpage.FleetServiceMailing_County());
			ExcelReader.updateExcel("Fleet", 0, 38, fleettabpage.FleetServiceMailing_Countrylbl());
			ExcelReader.updateExcel("Fleet",RowNo, 38, fleettabpage.FleetServiceMailing_Country());
			ExcelReader.updateExcel("Fleet", 0, 39, fleettabpage.FleetServiceMailing_AttentionTOlbl());
			ExcelReader.updateExcel("Fleet", RowNo, 39, fleettabpage.FleetServiceMailing_AttentionTO());

			ExcelReader.updateExcel("Fleet", 0, 40, fleettabpage.FleetDetails_ContactNamelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 40, fleettabpage.FleetDetails_ContactName());
			ExcelReader.updateExcel("Fleet", 0, 41, fleettabpage.FleetDetails_EmailIDlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 41, fleettabpage.FleetDetails_EmailID());
			ExcelReader.updateExcel("Fleet", 0, 42, fleettabpage.FleetDetails_PrimaryCellNbrlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 42, fleettabpage.FleetDetails_PrimaryCellNbr());
			ExcelReader.updateExcel("Fleet", 0, 43, fleettabpage.FleetDetails_AlternateCellNbrlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 43, fleettabpage.FleetDetails_AlternateCellNbr());
			ExcelReader.updateExcel("Fleet", 0, 44, fleettabpage.FleetDetails_FaxNolbl());
			ExcelReader.updateExcel("Fleet",RowNo, 44, fleettabpage.FleetDetails_FaxNo());
			ExcelReader.updateExcel("Fleet", 0, 45, fleettabpage.FleetDetails_TPIDlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 45, fleettabpage.FleetDetails_TPID());
			ExcelReader.updateExcel("Fleet", 0, 46, fleettabpage.FleetDetails_UsdotNbrlbl());
			ExcelReader.updateExcel("Fleet", RowNo, 46, fleettabpage.FleetDetails_UsdotNbr());
			ExcelReader.updateExcel("Fleet", 0, 47, fleettabpage.FleetDetails_ChangeVehUsdotTinlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 47, fleettabpage.FleetDetails_ChangeVehUsdotTin());

			ExcelReader.updateExcel("Fleet", 0, 48, fleettabpage.FleetDetails_FltTypelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 48, fleettabpage.FleetDetails_FltType());
			ExcelReader.updateExcel("Fleet", 0, 49, fleettabpage.FleetDetails_CommodityClasslbl());
			ExcelReader.updateExcel("Fleet", RowNo, 49, fleettabpage.FleetDetails_CommodityClass());
			ExcelReader.updateExcel("Fleet", 0, 50, fleettabpage.FleetDetails_FltEffDatelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 50, fleettabpage.FleetDetails_FltEffDatedtPicker());
			ExcelReader.updateExcel("Fleet", 0, 51, fleettabpage.FleetDetails_FltExpDatelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 51, fleettabpage.FleetDetails_FltExpDate());

			ExcelReader.updateExcel("Fleet", 0, 52, fleettabpage.FleetDetails_changeAddrOnUsdotlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 52, fleettabpage.FleetDetails_changeAddrOnUsdot());
			ExcelReader.updateExcel("Fleet", 0, 53, fleettabpage.FleetDetails_FirstOperatedDatelbl());
			ExcelReader.updateExcel("Fleet", RowNo, 53, fleettabpage.FleetDetails_FirstOperatedDate());
			ExcelReader.updateExcel("Fleet", 0, 54, fleettabpage.FleetDetails_WyomingIndicatorlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 54, fleettabpage.FleetDetails_WyomingIndicator());
			ExcelReader.updateExcel("Fleet", 0, 55, fleettabpage.FleetDetails_IFTADistancelbl());
			ExcelReader.updateExcel("Fleet",RowNo, 55, fleettabpage.FleetDetails_IFTADistance());
			ExcelReader.updateExcel("Fleet", 0, 56, fleettabpage.FleetDetails_MobileNotificationlbl());
			ExcelReader.updateExcel("Fleet", RowNo, 56, fleettabpage.FleetDetails_MobileNotification());

			ExcelReader.updateExcel("Fleet", 0, 57, fleettabpage.FleetDetails_IRPRequirementslbl());
			ExcelReader.updateExcel("Fleet",RowNo, 57, fleettabpage.FleetDetails_IRPRequirements());
			ExcelReader.updateExcel("Fleet", 0, 58, fleettabpage.FleetDetails_StatementOfUnderstandinglbl());
			ExcelReader.updateExcel("Fleet",RowNo, 58, fleettabpage.FleetDetails_StatementOfUnderstanding());
			ExcelReader.updateExcel("Fleet", 0, 59, fleettabpage.FleetDetails_InstallmentAgreementlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 59, fleettabpage.FleetDetails_InstallmentAgreement());
			ExcelReader.updateExcel("Fleet", 0, 60, fleettabpage.FleetDetails_PowerOfAttorneylbl());
			ExcelReader.updateExcel("Fleet",RowNo, 60, fleettabpage.FleetDetails_PowerOfAttorney());

			ExcelReader.updateExcel("Fleet", 0, 61, fleettabpage.FleetDetails_HVUTFormlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 61, fleettabpage.FleetDetails_HVUTForm());
			ExcelReader.updateExcel("Fleet", 0, 62, fleettabpage.FleetDetails_PropertyTaxlbl());
			ExcelReader.updateExcel("Fleet",RowNo, 62, fleettabpage.FleetDetails_PropertyTax());
		 */		


		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Fleet Screen"+commonobjects.FetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot("Message in Fleet Screen 1");


		fleettabpage.navigateToServiceProvider();
		log.info("*** navigateToServiceProvider ***");
		screenshotUtil.captureScreenshot("Navigate to Service provider");

		fleettabpage.clickPowerOfAttroney();
		log.info("*** Click PowerofAttroney ***");
		screenshotUtil.captureScreenshot("Check Power of Attroney");

		fleettabpage.enterEmailID(excelutil.getCellData("FleetTab","Email iD",RowNo));
		log.info("*** Entering the Emailid ***");
		screenshotUtil.captureScreenshot("Entering the Emailid");
		//Expiration Date through Excel
		//	fleettabpage.selectExpirationDate(ExcelReader.FetchDataFromSheet(config.readRWCexcel(), "FleetTab", 2, 13));
		//Expiration Date through System
		fleettabpage.selectExpirationDate(eleutil.getAddedDateInSpecifiedFormat("MMddYYYY",2));
		log.info("*** Selecting the Expiration Date ***");
		screenshotUtil.captureScreenshot("Selecting the Expiration Date");

		fleettabpage.selectIRPRequirementForm(excelutil.getCellData("FleetTab","IRP Requirements Form",RowNo));
		log.info("*** Selecting the IRPRequirementForm ***");
		screenshotUtil.captureScreenshot("Selecting the IRPRequirementForm");

		fleettabpage.selectStatementofUnderstanding(excelutil.getCellData("FleetTab","Statement of Understanding",RowNo));		
		log.info("*** Selecting StatementofUnderstanding ***");
		screenshotUtil.captureScreenshot("Selecting StatementofUnderstanding");

		fleettabpage.selectInstallmentAgreement(excelutil.getCellData("FleetTab","Installment Agreement",RowNo));
		log.info("*** Selecting InstallmentAgreement ***");
		screenshotUtil.captureScreenshot("Selecting InstallmentAgreement");

		fleettabpage.selectPowerOfAttroney(excelutil.getCellData("FleetTab","Power of Attorney",RowNo));
		log.info("*** Selecting PowerOfAttroney ***");
		screenshotUtil.captureScreenshot("Selecting PowerOfAttroney");

		fleettabpage.selectHVUTForm(excelutil.getCellData("FleetTab","HVUT - Form 2290",RowNo));
		log.info("*** Selecting HVUTForm ***");
		screenshotUtil.captureScreenshot("Selecting HVUTForm");		

		fleettabpage.selectPropertyTax(excelutil.getCellData("FleetTab","Property Tax",RowNo));
		log.info("*** Selecting PropertyTax ***");
		screenshotUtil.captureScreenshot("Selecting PropertyTax");		

		commonobjects.provideComments(excelutil.getCellData("FleetTab","Comments",RowNo));
		log.info("*** Enter Comments ***");
		screenshotUtil.captureScreenshot("Enter Comments in Fleet Section");

		commonobjects.clickProceed();
		//Fleet Verification Screen
		commonobjects.clickProceed();
	}

	@Then("User will navigate to Distance section and fill the data and validate message {string} {string}")
	public void user_will_navigate_to_distance_section_and_fill_the_data_and_validate_message(String expSucces1, String expSucces2) throws Exception, Exception {
		//Fetch Values
		/*	 ExcelReader.updateExcel("Distance",0,0,distancetabpage.DistanceReportingPeriodFromlbl()); 
				  ExcelReader.updateExcel("Distance",RowNo,0,distancetabpage.DistanceReportingPeriodFrom ()); 
				  ExcelReader.updateExcel("Distance",0,1,distancetabpage.DistanceReportingPeriodTolbl ()); 
				  ExcelReader.updateExcel("Distance",RowNo,1,distancetabpage.DistanceReportingPeriodTo()); 
				  ExcelReader.updateExcel("Distance",0,2,distancetabpage.DistanceUsdotNbrlbl());
				  ExcelReader.updateExcel("Distance",RowNo,2,distancetabpage.DistanceUsdotNbr()); 
				  ExcelReader.updateExcel("Distance",0,3,distancetabpage.DistanceEstimatedDistanceChartlbl()); 
				  ExcelReader.updateExcel("Distance",RowNo,3,distancetabpage.DistanceEstimatedDistanceChart()); 
				  ExcelReader.updateExcel("Distance",0,4,distancetabpage.DistanceOverrideContJurlbl ()); 
				  ExcelReader.updateExcel("Distance",RowNo,4,distancetabpage.DistanceOverrideContJur()); 

				  ExcelReader.updateExcel("Distance",0,5,distancetabpage.DistanceEstimatedDistancelbl());
				  ExcelReader.updateExcel("Distance",RowNo,5,distancetabpage.DistanceEstimatedDistance());
				  ExcelReader.updateExcel("Distance",0,6,distancetabpage.DistanceActualDistancelbl()); 
				  ExcelReader.updateExcel("Distance",RowNo,6,distancetabpage.DistanceActualDistance()); 

				  ExcelReader.updateExcel("Distance",0,7,distancetabpage.DistanceTotalFleetDistancelbl()); 
				  ExcelReader.updateExcel("Distance",RowNo,7,distancetabpage.DistanceTotalFleetDistance()); 

				  ExcelReader.updateExcel("Distance",0,8,distancetabpage.DistanceFRPMlgQuetionlbl());
				  ExcelReader.updateExcel("Distance",RowNo,8,distancetabpage.DistanceFRPMlgQuetion());
				  ExcelReader.updateExcel("Distance",0,9,distancetabpage.DistanceDistanceTypelbl());
				  ExcelReader.updateExcel("Distance",RowNo,9,distancetabpage.DistanceDistanceType());
				  ExcelReader.updateExcel("Distance",0,10,distancetabpage.DistanceActualDistConfirmationlbl());
				  ExcelReader.updateExcel("Distance",RowNo,10,distancetabpage.DistanceActualDistConfirmation());

				//Juris Table Verification
			     	//Juris Table header
			     	ArrayList<String> TableHeadervalues=distancetabpage.FetchTableHeader();
			    	for(int i=0;i<TableHeadervalues.size();i++) {
			    		ExcelReader.updateExcel("Distance_Juris",0,i,TableHeadervalues.get(i));
			    	}
			    	//Juris list
			    	ArrayList<String>  Juris_values=distancetabpage.FetchTable_Juris();
			    	ArrayList<String>  Distance_values=distancetabpage.FetchTable_DistanceMiles();
			    	ArrayList<String>  Percent_values=distancetabpage.FetchTable_Percent();
			    	int j=0;
			     	for(int i=0;i<Juris_values.size();i++) {

			     	ExcelReader.updateExcel("Distance_Juris", RowNo,i+j,Juris_values.get(i));  //0 0 13
			     	j++; 
			     	ExcelReader.updateExcel("Distance_Juris", RowNo,i+j,Distance_values.get(i)); //01 14
			     	j++;
			     	ExcelReader.updateExcel("Distance_Juris", RowNo,i+j,Percent_values.get(i)); //02 15
			     	}
		 */	
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Distance Screen"+commonobjects.FetchErrorMessage(expSucces1));

		screenshotUtil.captureScreenshot("Message in Distance Screen 1");
		log.info("Message in Distance Screen"+commonobjects.FetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot("Message in Distance Screen1 ");

		distancetabpage.enterAllDistanceValue(excelutil.getCellData("DistanceTab","Distance",RowNo));   	
		//distancetabpage.enterMODistanceValue(excelutil.getCellData("DistanceTab","Juri",RowNo), excelutil.getCellData("DistanceTab","Distance",RowNo));
		log.info("*** Enter MODistanceValue ***");
		screenshotUtil.captureScreenshot("Enter MODistanceValue");

		commonobjects.provideComments(excelutil.getCellData("DistanceTab","Comments",RowNo));
		log.info("*** Enter Comments ***");
		screenshotUtil.captureScreenshot("Enter Comments in Distance Section");

		commonobjects.clickProceed();

		commonobjects.clickProceed();

	}

	@Then("User will navigate to Weight group section and fill the data ans validate message {string}")
	public void user_will_navigate_to_weight_group_section_and_fill_the_data_ans_validate_message(String expSucces) throws Exception {
		//Fetch Values into Excel
		/*		ArrayList<String>  headervalues=wgtgroup.FetchTableHeader();
				for(int i=0;i<headervalues.size();i++) {
					ExcelReader.updateExcel("WeightGroup",0,i,headervalues.get(i));
				}
				ArrayList<String>  RowDatavalues=wgtgroup.FetchTableRowData();
				for(int i=0;i<RowDatavalues.size();i++) {
					ExcelReader.updateExcel("WeightGroup",RowNo,i,RowDatavalues.get(i));
				}
		 */	
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Weight Group Screen"+commonobjects.FetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot("Message in Weight Group Screen 1");

		wgtgroup.clickAddWeightGroup();
		log.info("*** Click AddweightGroup ***");
		screenshotUtil.captureScreenshot("Click AddweightGroup");
		//Add Weight Group Screen
		String WeightGroupCount_Excel=excelutil.getCellData("WeightGrouptab","TotalWeightGroups",RowNo);

		for(int weightcount=0;weightcount<Integer.valueOf(WeightGroupCount_Excel);weightcount++) {
			wgtgroupadd.selectWeightGroupType(excelutil.getCellData("WeightGrouptab","WeightGroup Type"+String.valueOf(weightcount),RowNo));

			log.info("*** Select WeightGroupType ***");
			screenshotUtil.captureScreenshot("Select WeightGroupType");
			wgtgroupadd.enterWeightGroupNo(excelutil.getCellData("WeightGrouptab","Weight Group No."+String.valueOf(weightcount),RowNo));
			log.info("*** Enter WeightGroup No ***");
			screenshotUtil.captureScreenshot("Enter WeightGroup No");
			wgtgroupadd.selectMaxGrossWeight(excelutil.getCellData("WeightGrouptab","Max Gross Weight"+String.valueOf(weightcount),RowNo));
			log.info("*** Select MaxGross Weight ***");
			screenshotUtil.captureScreenshot("Select MaxGross Weight");
			commonobjects.clickProceed();

			commonobjects.clickProceed();
		}

		//Weight Group Screen
		//Edit Existing Weight Group
		wgtgroup.clickHandimg();

		String Juri_ExcelCount=excelutil.getCellData("WeightJuris","Juris Count",RowNo);
		for(int i=0;i<Integer.valueOf(Juri_ExcelCount);i++) {
			String Juri_Excel=excelutil.getCellData("WeightJuris","Juri"+String.valueOf(i),RowNo);
			wgtgroupadd.enterWeight_JuriValue(Juri_Excel);
		}
		commonobjects.clickProceed();
		// Weight Group Verification Screen
		commonobjects.clickProceed();
	//	ArrayList<String> FetchInfoMessages1=commonobjects.validateinfomsgs();
		log.info(commonobjects.validateinfomsgs());
		//Validating JUR WITH DIFFERENT WEIGHTS
		String[] weightlist=wgtgroup.validateJurisWeightsedited(); //[AL, AR, AZ]
		for(int i=0;i<Integer.valueOf(Juri_ExcelCount);i++) {
			String Juri_Excel=excelutil.getCellData("WeightJuris","Juri"+String.valueOf(i),RowNo);
			if(weightlist[i].equalsIgnoreCase(Juri_Excel)){
				assert true;
			}
		}

		//In Weight Group Screen	
		commonobjects.clickDonebtn();
	}

	@Then("User will navigate to Add vehicle and validate the message {string} {string} {string}")
	public void user_will_navigate_to_Add_vehicle_and_validate_the_message(String expSucces, String expSucces2, String expSucces3) throws Exception {
		//Fetch values from Vehicle screen
		/*	ExcelReader.updateExcel("VehicleTab",0,0,Vehicletabpage.FetchAmendVehiclelbl()); 
		ExcelReader.updateExcel("VehicleTab",RowNo,0,Vehicletabpage.FetchAmendVehicle ()); 
		ExcelReader.updateExcel("VehicleTab",0,1,Vehicletabpage.FetchAddVehicleslbl ()); 
		ExcelReader.updateExcel("VehicleTab",RowNo,1,Vehicletabpage.FetchAddVehicles()); 
		ExcelReader.updateExcel("VehicleTab",0,2,Vehicletabpage.FetchdeleteVehiclelbl());
		ExcelReader.updateExcel("VehicleTab",RowNo,2,Vehicletabpage.FetchdeleteVehicle()); 
		ExcelReader.updateExcel("VehicleTab",0,3,Vehicletabpage.FetchRenewVehiclelbl()); 
		ExcelReader.updateExcel("VehicleTab",RowNo,3,Vehicletabpage.FetchRenewVehicle());  
		 */
		log.info(commonobjects.validateinfomsgs());
		int NoofVehiclestoAmend=Integer.valueOf(excelutil.getCellData("VehicleTab","NoofVehiclestoAmend",RowNo));
		if(NoofVehiclestoAmend>0) {

			Vehicletabpage.clickAmendVehicleRadioButton();
			log.info("*** Click AmendVehicle RadioButton ***");
			screenshotUtil.captureScreenshot("Click AmendVehicle RadioButton");

			commonobjects.clickProceed();
			log.info(commonobjects.validateinfomsgs());

			log.info("Message in Amend Vehicle Screen"+commonobjects.FetchErrorMessage(expSucces));
			screenshotUtil.captureScreenshot("Message in Amend Vehicle Screen 1");


			for(int i=0;i<NoofVehiclestoAmend;i++) {
				if(NoofVehiclestoAmend>10) {
					vehicleAmend.selectUnitNoFromSuggestions();
					log.info("*** Select Unit number ***");
					screenshotUtil.captureScreenshot("Select Unit number");
				}
				else {
					vehicleAmend.selectUnitNoFromExcel(excelutil.getCellData("VehicleAmendTab","Unit"+String.valueOf(i),RowNo));
					log.info("*** Enter Unit number ***");
					screenshotUtil.captureScreenshot("Enter Unit number");
				}
				vehicleAmend.clickSearch();


				Vehicletabpage.vehiclevalidatemessage();
				if(i==0){
					vehicleAmend.selectWeightGroupNo(excelutil.getCellData("WeightGrouptab","Vehicle_WeightGroupNo",RowNo));
					log.info("*** Enter WeightGroupNo ***");
					screenshotUtil.captureScreenshot("Enter WeightGroupNo");
					log.info("Message in Amend Vehicle Screen"+commonobjects.FetchErrorMessage(expSucces2));
					screenshotUtil.captureScreenshot("Message in Amend Vehicle Screen 2");
				}

				vehicleAmend.enterUnladenWeight(excelutil.getCellData("VehicleTab","unladenWeight",RowNo));
				log.info("*** Enter UnladenWeight ***");
				screenshotUtil.captureScreenshot("Enter UnladenWeight");


				vehicleAmend.clickTVR();
				log.info("*** Click TVR ***");
				screenshotUtil.captureScreenshot("Click TVR");

				vehicleAmend.selectSafetyChangedd(excelutil.getCellData("VehicleTab","Safety Change",RowNo));
				log.info("*** Select Safety Changedd ***");
				screenshotUtil.captureScreenshot("Select Safety Changedd");

				vehicleAmend.selectHVUTForm2290(excelutil.getCellData("VehicleTab","HVUT - Form",RowNo));
				log.info("*** Select HVUTForm2290 ***");
				screenshotUtil.captureScreenshot("Select HVUTForm2290");

				vehicleAmend.selectLeaseContract(excelutil.getCellData("VehicleTab","Lease Contract",RowNo));
				log.info("*** Select LeaseContract ***");
				screenshotUtil.captureScreenshot("Select LeaseContract");

				vehicleAmend.selectTitleDocument(excelutil.getCellData("VehicleTab","Title Document",RowNo));
				log.info("*** Select TitleDocument ***");
				screenshotUtil.captureScreenshot("Select TitleDocument");

				vehicleAmend.selectPlateReturndoc(excelutil.getCellData("VehicleTab","Plate Returned Document",RowNo));
				log.info("*** Select PlateReturndoc ***");
				screenshotUtil.captureScreenshot("Select PlateReturndoc");

				vehicleAmend.selectAffidavitDoc(excelutil.getCellData("VehicleTab","Affidavit document",RowNo));
				log.info("*** Select AffidavitDoc ***");
				screenshotUtil.captureScreenshot("Select AffidavitDoc");

				vehicleAmend.selectPropertyTax(excelutil.getCellData("VehicleTab","Property Tax",RowNo));
				log.info("*** Select PropertyTax ***");
				screenshotUtil.captureScreenshot("Select PropertyTax");

				commonobjects.provideComments(excelutil.getCellData("VehicleTab","Ammend_Comments",RowNo));

				log.info("*** Enter Comments ***");
				screenshotUtil.captureScreenshot("Enter Comments in Distance Section");

				commonobjects.clickProceed();
				//Verification Screen
				commonobjects.clickProceed();
				log.info("essage in Amend Vehicle Screen "+commonobjects.FetchErrorMessage(expSucces3));
				screenshotUtil.captureScreenshot("Message in Amend Vehicle Screen");

			}// End of for Loop
			commonobjects.clickDonebtn();
			log.info(commonobjects.validateinfomsgs());
		} //End of vehicle ammend if loop
	}


	@Then("User will Delete vehicle as per the requiremnet and validate the message {string}")
	public void user_will_delete_vehicle_as_per_the_requiremnet_and_validate_the_message(String expSucces) throws Exception {

		log.info(commonobjects.validateinfomsgs());
		int NoofVehiclestoDelete=Integer.valueOf(excelutil.getCellData("VehicleTab","NoOfVehiclesToDelete",RowNo));	
		if(NoofVehiclestoDelete>0) {
			Vehicletabpage.clickDeleteVehicleRadioButton();
			log.info("**** Click DeleteVehicle ****");
			screenshotUtil.captureScreenshot("Click Delete Vehicle");
			
			commonobjects.clickProceed();
			log.info(commonobjects.validateinfomsgs());
			//below lines of code for deleting the vehicles from suggestion box
			String Vehiclescount=excelutil.getCellData("VehicleTab","NoOfVehiclesToDelete",RowNo);
			String PlateStatus=excelutil.getCellData("VehicleTab","Delete_PlateStatus",RowNo);
			String PlateReturnedDocument=excelutil.getCellData("VehicleTab","Delete_PlateReturnedDocument",RowNo);
			String AffidavitDocument=excelutil.getCellData("VehicleTab","Delete_AffidavitDocument",RowNo);
			String Comments=excelutil.getCellData("VehicleTab","Delete_Comments",RowNo);

			if(NoofVehiclestoDelete>10) {
				vehicleDelete.deleteFewVehicles(Vehiclescount, PlateStatus, PlateReturnedDocument, AffidavitDocument, Comments);
				commonobjects.clickProceed();
				commonobjects.clickProceed();
			}
			else {

				for(int j=0;j<NoofVehiclestoDelete;j++) {
					//Enter unit # to filter & delete
					vehicleDelete.enterUnitNo(excelutil.getCellData("VehicleDeleteTab","Unit"+String.valueOf(j),RowNo));
					log.info("*** Delete vehicle Enter Unit number ***");
					screenshotUtil.captureScreenshot("Delete vehicle Enter Unit number");

					vehicleDelete.clickonSearch();
					vehicleDelete.ClickCheckBoxFromGrid();

					vehicleDelete.selectPlateStatus(PlateStatus);
					log.info("***DeleteVehicle Select PlateStatus ***");
					screenshotUtil.captureScreenshot("DeleteVehicle Select PlateStatus");

					vehicleDelete.selectPlateReturnedDocument(PlateReturnedDocument);
					log.info("***DeleteVehicle Select PlateReturndoc ***");
					screenshotUtil.captureScreenshot("DeleteVehicle Select PlateReturndoc");

					vehicleDelete.selectAffidavitDocument(AffidavitDocument);
					log.info("***DeleteVehicle Select AffidavitDoc ***");
					screenshotUtil.captureScreenshot("DeleteVehicle Select AffidavitDoc");


					vehicleDelete.entercomments(Comments);
					log.info("*** DeleteVehicle Comment ***");
					screenshotUtil.captureScreenshot("DeleteVehicle Comment");

					commonobjects.clickProceed();
					commonobjects.clickProceed();
				}//End of For Loop
			} //End of if loop

			log.info(commonobjects.validateinfomsgs());
			log.info("Message in Delete Vehicle Screen"+commonobjects.FetchErrorMessage(expSucces));
			screenshotUtil.captureScreenshot("Message in Delete Vehicle Screen 1");

			commonobjects.clickDonebtn();
			log.info(commonobjects.validateinfomsgs());
		}//End of vehicle Delete if loop
	}
	@Then("User will confirm cancel {string}")
	public void user_will_confirm_cancel(String expSucces) throws Exception {
		//verification screen before going to billing screen -Vehicles cancel from Vehicle List
		Vehicletabpage.clickVehicleList();
		log.info("*** Click VehicleList ***");
		screenshotUtil.captureScreenshot("Click VehicleList");
		vehicleadd	.enterUnitNumber(excelutil.getCellData("VehicleDeleteTab","Unit0",RowNo));
		log.info("*** Select Unit No ***");
		screenshotUtil.captureScreenshot("Select Unit No");

		vehicleAmend.clickSearch();
		log.info("*** Search Unit No ***");
		screenshotUtil.captureScreenshot("Search Unit No");
		vehicleadd.Updatevehiclelistselectunit();
		commonobjects.ClickConfirmCancel();
		eleutil.handleAlert();
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Vehicle Cancel Screen"+commonobjects.FetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot("Message in Vehicle Cancel Screen 1");

		commonobjects.clickBack();
		log.info(commonobjects.validateinfomsgs());
	}
	@Then("User will navigate to vehicle list to update existing vehicle")
	public void user_will_navigate_to_vehicle_list_to_update_existing_vehicle() throws Exception {

		//verification screen before going to billing screen -Vehicle to be Amended from Vehicle List
		Vehicletabpage.clickAmendVehicleRadioButton();

		commonobjects.clickProceed();

		vehicleAmend.selectUnitNoFromExcel(excelutil.getCellData("VehicleDeleteTab","Unit0",RowNo));

		vehicleAmend.clickSearch();

		vehicleAmend.enterUnladenWeight(excelutil.getCellData("VehicleUpdate","unladen Weight",RowNo));

		vehicleAmend.clickTVR();
		vehicleAmend.selectSafetyChangedd(excelutil.getCellData("VehicleUpdate","Safety Change",RowNo));

		vehicleAmend.selectHVUTForm2290(excelutil.getCellData("VehicleUpdate","HVUT - Form 2290",RowNo));

		vehicleAmend.selectLeaseContract(excelutil.getCellData("VehicleUpdate","Lease Contract",RowNo));

		vehicleAmend.selectTitleDocument(excelutil.getCellData("VehicleUpdate","Title Document",RowNo));

		vehicleAmend.selectPlateReturndoc(excelutil.getCellData("VehicleUpdate","Plate Returned Document",RowNo));

		vehicleAmend.selectAffidavitDoc(excelutil.getCellData("VehicleUpdate","Affidavit document",RowNo));

		vehicleAmend.selectPropertyTax(excelutil.getCellData("VehicleUpdate","Property Tax",RowNo));

		commonobjects.clickProceed();
		//AMend Verification Screen
		commonobjects.clickProceed();
		//To move from Amend Screen to Renewal Vehicle Processing
		commonobjects.clickDonebtn();
		//TO move from Renewal Vehicle Processing to Billing Screen						
		commonobjects.clickDonebtn();

	}
	@Then("User will navigate to billing to verify as well to adjust the cost & Waive Fees {string}")
	public void user_will_navigate_to_billing_to_verify_as_well_to_adjust_the_cost_waive_fees(String expSucces) throws Exception {

		//Fetch values from Biling Screen
		/*	ExcelReader.updateExcel("Billing",0,0,billingtab.fetchRegisterMonthlbl());
				  ExcelReader.updateExcel("Billing",RowNo,0,billingtab.fetchRegisterMonth()); 
				  ExcelReader.updateExcel("Billing",0,1,billingtab.fetchNoOfVehiclesinSupplbl()); 
				  ExcelReader.updateExcel("Billing",RowNo,1,billingtab.fetchNoOfVehiclesinSupp()); 
				  ExcelReader.updateExcel("Billing",0,2,billingtab.fetchSupplementStatuslbl());
				  ExcelReader.updateExcel("Billing",RowNo,2,billingtab.fetchSupplementStatus()); 
				  ExcelReader.updateExcel("Billing",0,3,billingtab.fetchEnterpriseSystemCreditlbl()); 
				  ExcelReader.updateExcel("Billing",RowNo,3,billingtab.fetchEnterpriseSystemCredit ()); 
				  ExcelReader.updateExcel("Billing",0,4,billingtab.fetchIRPSystemCreditlbl ()); 
				  ExcelReader.updateExcel("Billing",RowNo,4,billingtab.fetchIRPSystemCredit()); 
				  ExcelReader.updateExcel("Billing",0,5,billingtab.fetchRenewalFeeEffectiveDatelbl());
				  ExcelReader.updateExcel("Billing",RowNo,5,billingtab.fetchRenewalFeeEffectiveDate());
				  ExcelReader.updateExcel("Billing",0,6,billingtab.fetchInvoiceDatelbl()); 
				  ExcelReader.updateExcel("Billing",RowNo,6,billingtab.fetchInvoiceDate()); 		  
				  ExcelReader.updateExcel("Billing",0,7,billingtab.fetchApplicationReceiptDatelbl()); 
				  ExcelReader.updateExcel("Billing",RowNo,7,billingtab.fetchApplicationReceiptDate()); 
				  ExcelReader.updateExcel("Billing",0,8,billingtab.fetchPaymentDatelbl());
				  ExcelReader.updateExcel("Billing",RowNo,8,billingtab.fetchPaymentDate());
				  ExcelReader.updateExcel("Billing",0,9,billingtab.fetchExchangeRatelbl());
				  ExcelReader.updateExcel("Billing",RowNo,9,billingtab.fetchExchangeRate());

				  ExcelReader.updateExcel("Billing",0,10,billingtab.fetchManualAdjBaseJurlbl());
				  ExcelReader.updateExcel("Billing",RowNo,10,billingtab.fetchManualAdjBaseJur());
				  ExcelReader.updateExcel("Billing",0,11,billingtab.fetchBilling_BatchBillinglbl());
				  ExcelReader.updateExcel("Billing",RowNo,11,billingtab.fetchBilling_BatchBilling());
				  ExcelReader.updateExcel("Billing",0,12,billingtab.fetchBilling_TVRlbl());
				  ExcelReader.updateExcel("Billing",RowNo,12,billingtab.fetchBilling_TVR());
				  ExcelReader.updateExcel("Billing",0,13,billingtab.fetchBilling_InstallmentPlanlbl());
				  ExcelReader.updateExcel("Billing",RowNo,13,billingtab.fetchBilling_InstallmentPlan());
				  ExcelReader.updateExcel("Billing",0,14,billingtab.fetchBilling_IsUseOneTimeMailinglbl());
				  ExcelReader.updateExcel("Billing",RowNo,14,billingtab.fetchBilling_IsUseOneTimeMailing());
				  ExcelReader.updateExcel("Billing",0,16,billingtab.fetchElectronicDeliveryTypelbl());
				  ExcelReader.updateExcel("Billing",RowNo,16,billingtab.fetchElectronicDeliveryType());
				  ExcelReader.updateExcel("Billing",0,17,"Email");
				  ExcelReader.updateExcel("Billing",RowNo,17,billingtab.fetchBilling_Email());
				  ExcelReader.updateExcel("Billing",0,18,billingtab.FetchInvoiceReportTypelbl());
				  ExcelReader.updateExcel("Billing",RowNo,18,billingtab.fetchBilling_InvoiceReportType());

				  ArrayList<String> TableHeadervalues=billingtab.FetchTable_Headers();
			    	for(int i=0;i<TableHeadervalues.size();i++) {
			    		System.out.println("header value in Billing:"+TableHeadervalues.get(i));
			    		ExcelReader.updateExcel("Billing",0,i+19,TableHeadervalues.get(i));
			    	}

				  ArrayList<String> TableFeeType=billingtab.FetchTable_FeeType();
				  ArrayList<String> TableFeeAmount=billingtab.FetchTable_FeeAmount();
			    	int j=19;
				  for(int i=0;i<TableFeeType.size();i++) {
			    		ExcelReader.updateExcel("Billing",RowNo,i+j,TableFeeType.get(i));
			    		j++;
			    		ExcelReader.updateExcel("Billing",RowNo,i+j,TableFeeAmount.get(i));
			    	}
		 */
		log.info(commonobjects.validateinfomsgs());
		billingtab.clickTVR();
		log.info("*** Click TVR ***");
		screenshotUtil.captureScreenshot("Click TVR");

		billingtab.clickInstallmentPlan();
		log.info("*** Click Installement Plan ***");
		screenshotUtil.captureScreenshot("Click Installement Plan");

		billingtab.selectElectronicDeliveryType(excelutil.getCellData("BillingTab","Electronic Delivery Type",RowNo));
		log.info("*** Select Electronic DeliveryType ***");
		screenshotUtil.captureScreenshot("Select Electronic DeliveryType");

		commonobjects.provideComments(excelutil.getCellData("BillingTab","Billing_Comments",RowNo));
		commonobjects.clickProceed();

		billingtab.enterManualAdjBaseJur(excelutil.getCellData("BillingTab","Manual Adj. Base Jur.",RowNo));
		log.info("*** Enter ManualAdjBaseJur ***");
		screenshotUtil.captureScreenshot("Enter ManualAdjBaseJur");

		billingtab.clickReCalculate();
		log.info("*** Click Recalculate ***");
		screenshotUtil.captureScreenshot("Click Recalculate");

		log.info("Message in Biling Screen"+commonobjects.FetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot("Message in Biling Screen 1");

		billingtab.expandManualAdjReason();
		billingtab.enterManualAdjReasonComments(excelutil.getCellData("BillingTab","ManualReason",RowNo));
		log.info("*** Enter ManualAdjReason Comments ***");
		screenshotUtil.captureScreenshot("Enter ManualAdjReason Comments");
		billingtab.clickManualAdjReasonDeleteAllowed();
		billingtab.clickManualAdjReasonAddorUpdateComments();

		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		billingtab.selectGradeCrossingFee(excelutil.getCellData("BillingTab","Grade Crossing Fee",RowNo));  
		log.info("*** Select GradeCrossingFee ***");
		screenshotUtil.captureScreenshot("Select GradeCrossingFee");

		billingtab.clickReCalculate();
		log.info("*** Click Recalculate ***");
		screenshotUtil.captureScreenshot("Click Recalculate");
		log.info(commonobjects.validateinfomsgs());
		billingtab.expandFeeOverrideReason();

		billingtab.enterFeeOverrideReasonComments(excelutil.getCellData("BillingTab","FeeOverrideReasonComments",RowNo));

		log.info("*** Enter FeeOverrideReason Comments ***");
		screenshotUtil.captureScreenshot("Enter FeeOverrideReason Comments");

		billingtab.clickFeeOverrideReasonDeleteAllowed();
		billingtab.clickFeeOverrideReasonAddorUpdateComments();

		billingtab.clickReCalculate();
		log.info(commonobjects.validateinfomsgs());
		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		eleutil.CloseFirstChildWindow();

	}

	@Then("User will navigate to Payment Tab to input the data and validate message {string} {string} {string}")
	public void user_will_navigate_to_payment_tab_to_input_the_data_and_validate_message(String expSucces, String expSucces2, String expSucces3) throws Exception {
		//Fetch Values from Payment Tab
		/*	  ExcelReader.updateExcel("PaymentTab",0,0,paymenttab.FetchEnterpriseSystemCreditlbl());
			  ExcelReader.updateExcel("PaymentTab",RowNo,0,paymenttab.FetchEnterpriseSystemCredit()); 
			  ExcelReader.updateExcel("PaymentTab",0,1,paymenttab.FetchIRPSystemCreditlbl()); 
			  ExcelReader.updateExcel("PaymentTab",RowNo,1,paymenttab.FetchIRPSystemCredit()); 
			  ExcelReader.updateExcel("PaymentTab",0,2,paymenttab.FetchInvoiceDatelbl());
			  ExcelReader.updateExcel("PaymentTab",RowNo,2,paymenttab.FetchInvoiceDate()); 
			  ExcelReader.updateExcel("PaymentTab",0,3,paymenttab.FetchInvoiceNumberlbl()); 
			  ExcelReader.updateExcel("PaymentTab",RowNo,3,paymenttab.FetchInvoiceNumber ()); 
			  ExcelReader.updateExcel("PaymentTab",0,4,paymenttab.FetchPaymentReciptDatelbl()); 
			  ExcelReader.updateExcel("PaymentTab",RowNo,4,paymenttab.FetchPaymentReciptDate()); 

			  ExcelReader.updateExcel("PaymentTab",0,5,paymenttab.FetchManualAdjBaseJurlbl());
			  ExcelReader.updateExcel("PaymentTab",RowNo,5,paymenttab.FetchManualAdjBaseJur()); 
			  ExcelReader.updateExcel("PaymentTab",0,6,paymenttab.FetchBatchCredentiallbl()); 
			  ExcelReader.updateExcel("PaymentTab",RowNo,6,paymenttab.FetchBatchCredential()); 
			  ExcelReader.updateExcel("PaymentTab",0,7,paymenttab.FetchWireTransferFeelbl()); 
			  ExcelReader.updateExcel("PaymentTab",RowNo,7,paymenttab.FetchWireTransferFee()); 

			  ArrayList<String> Payment_TableHeadervalues=paymenttab.FetchTable_Headers();
		    	for(int i=0;i<Payment_TableHeadervalues.size();i++) {
		    		ExcelReader.updateExcel("PaymentTab",0,i+8,Payment_TableHeadervalues.get(i));
		    	}

			  ArrayList<String> Payment_TableFeeType=paymenttab.FetchTable_FeeType();
			  ArrayList<String> Payment_TableFeeAmount=paymenttab.FetchTable_FeeAmount();
		    	int k=8;
			  for(int i=0;i<Payment_TableFeeType.size();i++) {
		    		ExcelReader.updateExcel("PaymentTab",RowNo,i+k,Payment_TableFeeType.get(i));
		    		k++;
		    		ExcelReader.updateExcel("PaymentTab",RowNo,i+k,Payment_TableFeeAmount.get(i));
		    	}
		 */
		
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Payment Screen"+commonobjects.FetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot("Message in Payment Screen 1");
		log.info("Message in Payment Screen"+ commonobjects.FetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot("Message in Payment Screen 2");

		log.info("Message in Payment Screen"+commonobjects.FetchErrorMessage(expSucces3));
		screenshotUtil.captureScreenshot("Message in Payment Screen 3");


		pay.selectElectronicDeliverytype(excelutil.getCellData("Payment","ElectronicDeliveryType",RowNo));

		log.info("***Select Delivery type***");
		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		paymenttab.clickAddtoCart();
		log.info("***Click Add to Cart**");
		log.info(commonobjects.validateinfomsgs());
		paymenttab.ValidateMessage4();


	}

	@Then("User will navigate to supplement continuance and validate the meesage {string}")
	public void user_will_navigate_to_supplement_continuance_and_validate_the_meesage(String expSucces) throws Exception, Exception {
		log.info(commonobjects.validateinfomsgs());
		paymenttab.clicksupplcont();
		log.info("***Click Supplement continue***");
		screenshotUtil.captureScreenshot("Click Supplement continue");

		fleetpage.enterAccountNo(excelutil.getCellData("PreSetup","AccountNumber",RowNo));

		commonobjects.clickProceed(); 
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Fleet Screen"+commonobjects.FetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot("Message in Fleet Screen");

	}

	@Then("User will navigate to payment tab and fill the requirement")
	public void user_will_navigate_to_payment_tab_and_fill_the_requirement() throws Exception, Exception {

		//commonobjects.clickQuit();
		log.info(commonobjects.validateinfomsgs());
		paymenttab.clickverifyaddtocart();

		log.info("***Verify Cart***");
		screenshotUtil.captureScreenshot("Verify Cart");
		pay.clickPayNow();  

		log.info("***Click Paynow***");
		screenshotUtil.captureScreenshot("Click Paynow");
		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		//Fetch Values from Cart payment
		/*		ExcelReader.updateExcel("PaymentScreen",0,0,pay.FetchMCECustomerIdlbl());
			  ExcelReader.updateExcel("PaymentScreen",RowNo,0,pay.FetchMCECustomerId()); 
			  ExcelReader.updateExcel("PaymentScreen",0,1,pay.FetchlegalNamelbl()); 
			  ExcelReader.updateExcel("PaymentScreen",RowNo,1,pay.FetchlegalName()); 
			  ExcelReader.updateExcel("PaymentScreen",0,2,pay.FetchInvoiceDatelbl());
			  ExcelReader.updateExcel("PaymentScreen",RowNo,2,pay.FetchInvoiceDate()); 
			  ExcelReader.updateExcel("PaymentScreen",0,3,pay.FetchEnterpriseSystemCreditlbl()); 
			  ExcelReader.updateExcel("PaymentScreen",RowNo,3,pay.FetchEnterpriseSystemCredit()); 
			  ExcelReader.updateExcel("PaymentScreen",0,4,pay.FetchIRPSystemCreditlbl()); 
			  ExcelReader.updateExcel("PaymentScreen",RowNo,4,pay.FetchIRPSystemCredit()); 
			  ExcelReader.updateExcel("PaymentScreen",0,5,pay.FetchIftaSystemCreditlbl());
			  ExcelReader.updateExcel("PaymentScreen",RowNo,5,pay.FetchIftaSystemCredit()); 
			  ExcelReader.updateExcel("PaymentScreen",0,6,pay.FetchOpaSystemCreditlbl());
			  ExcelReader.updateExcel("PaymentScreen",RowNo,6,pay.FetchOpaSystemCredit());

			  //Invoice Grid
			  ArrayList<String> TableHeadervalues=pay.FetchTable_Headers();
		    	for(int i=0;i<TableHeadervalues.size();i++) {
		    		ExcelReader.updateExcel("PaymentScreen",0,i+7,TableHeadervalues.get(i));
		    	}

			  ArrayList<String> Table_Invoice=pay.FetchTable_InvoiceDetails();
			  for(int i=0;i<Table_Invoice.size();i++) {
				  ExcelReader.updateExcel("PaymentScreen",RowNo,i+7,Table_Invoice.get(i));
		    	}

			  ExcelReader.updateExcel("PaymentScreen",0,12,pay.FetchTotalAmountDuelbl());
			  ExcelReader.updateExcel("PaymentScreen",RowNo,12,pay.FetchTotalAmountDue());
		 */		
		paymenttab.clickpaymentadd();
		for(int i=0; i<2;i++) {

			String PaymentType=excelutil.getCellData("Payment","PaymentType"+i,RowNo);
			String PaymentNumberValue=excelutil.getCellData("Payment","PaymentChequeNo",RowNo);
			pay.selectPaymentType(i,PaymentType);	
			log.info("***Payment Type***");
			screenshotUtil.captureScreenshot("Payment Type"+i);


			pay.enterpaymentNoBasedonType(i,PaymentType,PaymentNumberValue);
			log.info("***Payment Number based on Payment Type***");
			screenshotUtil.captureScreenshot("Payment Number based on  Payment Type"+i);

			String totalAmount=pay.FetchTotalAmount();
			log.info("totalAmount is "+totalAmount);
			String cashAmount=String.format("%.2f",(Double.valueOf(totalAmount)/2));

			if(i==0) {
				pay.enterPaymentAmountBasedonType(i,PaymentType,cashAmount);
			}

			if(i==1) {
				String RemainingAmount=pay.FetchRemainingBalance();
				pay.enterPaymentAmountBasedonType(i,PaymentType,RemainingAmount);
			}
			log.info("***Payment Amount based on Payment Type***");
			screenshotUtil.captureScreenshot("Payment Amount based on  Payment Type"+i);

		}

		pay.selectPaymentReceipt(excelutil.getCellData("Payment","Payment receipt",RowNo));

		log.info("***Enter Payment type and amount***");
		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		eleutil.CloseFirstChildWindow();
	}
	@Then("user will validate message {string} {string}")
	public void user_will_validate_message(String expSucces, String expSucces2) throws Exception {
		log.info("Message in Payment Screen "+commonobjects.FetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot("Message in Payment Screen 1");
		log.info("Message in Payment Screen "+commonobjects.FetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot("Message in Payment Screen 2");
	}

	@Then("User navigate to inventory tab to input the data and validate the message {string} {string}")
	public void user_navigate_to_inventory_tab_to_input_the_data_and_validate_the_message(String expSucces, String expSucces2) throws Exception {

		inventorypage.clickoperation();

		inventorypage.clickoninventory();

		inventorypage.clicknewinventory();

		log.info("***Click Inventory***");
		screenshotUtil.captureScreenshot("Click Inventory");
		log.info(commonobjects.validateinfomsgs());
		inventorypage.selectnewinventorytype(excelutil.getCellData("InventoryTab","Inventory_Newintype",RowNo));
		log.info("Message in Inventory Screen"+commonobjects.FetchErrorMessage(expSucces));

		screenshotUtil.captureScreenshot("Message in Inventory Screen");

		inventorypage.selectnewsubinventorytype(excelutil.getCellData("InventoryTab","Inventory_Subtype",RowNo));

		inventorypage.enterfromno(excelutil.getCellData("InventoryTab","FromNo",RowNo)); //modify

		inventorypage.enterquantity(excelutil.getCellData("InventoryTab","Quantity",RowNo));

		inventorypage.enteryear(excelutil.getCellData("InventoryTab","Year",RowNo));


		log.info("***Enter details for new inventory***");
		screenshotUtil.captureScreenshot("Enter details for new inventory");
		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Payment Screen"+commonobjects.FetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot("Message in Inventory Screen 2");
		commonobjects.clickQuit();
	}
	@Then("Assign the inventory to proceed further {string} {string}")
	public void assign_the_inventory_to_proceed_further(String expSucces, String expSucces2) throws Exception, Exception {

		inventorypage.clickAssignInventory();
		log.info(commonobjects.validateinfomsgs());
		inventorypage.selectnewinventorytype(excelutil.getCellData("InventoryTab","Inventory_Newintype",RowNo));
		log.info("Message in Inventory Screen "+commonobjects.FetchErrorMessage(expSucces));

		screenshotUtil.captureScreenshot("Message in Inventory Screen 1");

		inventorypage.selectnewsubinventorytype(excelutil.getCellData("InventoryTab","Inventory_Subtype",RowNo));

		inventorypage.enterfromno(excelutil.getCellData("InventoryTab","FromNo",RowNo)); //modify

		inventorypage.enterquantity(excelutil.getCellData("InventoryTab","Quantity",RowNo));

		inventorypage.enteryear(excelutil.getCellData("InventoryTab","Year",RowNo));

		log.info("***Enter details in Assign Inventory***");
		screenshotUtil.captureScreenshot("Enter details in Assign Inventory");

		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Inventory Screen"+commonobjects.FetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot("Message in Inventory Screen 2");


		commonobjects.clickQuit();
	}

	@Then("user navigate to post payment for 2nd installment payment and fill the data and validate the message {string} {string}")
	public void user_navigate_to_post_payment_for_2nd_installment_payment_and_fill_the_data_and_validate_the_message(String expSucces, String expSucces2) throws Exception {


		financepage.clickfinance();

		financepage.clickpostpayment();
		log.info(commonobjects.validateinfomsgs());
		financepage.enterMCEid(excelutil.getCellData("PreSetup","MCENumber",RowNo));

		financepage.clicksearch();

		financepage.clickoncartid();

		financepage.clickservice();

		financepage.clickIRP();

		financepage.clickinstallmentpayment();

		financepage.clickandenterAccountNo(excelutil.getCellData("PreSetup","AccountNumber",RowNo));

		financepage.clickandenterfleet(excelutil.getCellData("PreSetup","FleetNumber",RowNo));

		financepage.clickandenterfleetyear(excelutil.getCellData("PreSetup","Vehicle and Installment Fleet Expiration Year",RowNo));

		commonobjects.clickProceed();

		financepage.clickgrid();

		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		financepage.selectpaymenttype(excelutil.getCellData("Payment","PaymentType0",RowNo));

		String totalAmount=pay.FetchTotalAmount();

		financepage.entercashamount(totalAmount);

		pay.selectPaymentReceipt(excelutil.getCellData("Payment","Payment receipt",RowNo));

		log.info("Enter the details in installement payment and proceed");
		screenshotUtil.captureScreenshot("Enter the details in installement payment and proceed");

		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in post Payment Screen"+commonobjects.FetchErrorMessage(expSucces));

		screenshotUtil.captureScreenshot("Message in post Payment Screen 1");
		log.info("Message in Post Payment Screen "+commonobjects.FetchErrorMessage(expSucces2));

		screenshotUtil.captureScreenshot("Message in post Payment Screen 2");

	}


}


