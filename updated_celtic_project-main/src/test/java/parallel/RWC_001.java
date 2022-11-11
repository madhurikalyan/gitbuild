package parallel;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.celtic.automation.cmcs.factory.DriverFactory;
import com.celtic.automation.cmcs.pages.AccountTabPage;
import com.celtic.automation.cmcs.pages.BillingTab;
import com.celtic.automation.cmcs.pages.CommonObjects;
import com.celtic.automation.cmcs.pages.DashBoardPage;
import com.celtic.automation.cmcs.pages.DistanceTabPage;
import com.celtic.automation.cmcs.pages.Financepage;
import com.celtic.automation.cmcs.pages.FleetPage;
import com.celtic.automation.cmcs.pages.FleetTabPage;
import com.celtic.automation.cmcs.pages.InventoryPage;
import com.celtic.automation.cmcs.pages.LoginPage;
import com.celtic.automation.cmcs.pages.Payment;
import com.celtic.automation.cmcs.pages.PaymentTab;
import com.celtic.automation.cmcs.pages.VehicleAdd;
import com.celtic.automation.cmcs.pages.VehicleAmend;
import com.celtic.automation.cmcs.pages.VehicleDelete;
import com.celtic.automation.cmcs.pages.VehicleList;
import com.celtic.automation.cmcs.pages.VehicleTabPage;
import com.celtic.automation.cmcs.pages.WgtGroup;
import com.celtic.automation.cmcs.pages.WgtGroupAdd;
import com.celtic.automation.cmcs.util.ConfigReader;
import com.celtic.automation.cmcs.util.ElementUtil;
import com.celtic.automation.cmcs.util.ReadExcelUtil;
import com.celtic.automation.cmcs.util.Screenshot_Utility;
import com.celtic.automation.cmcs.util.WriteExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.junit.rules.ErrorCollector;

public class RWC_001 {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private DashBoardPage dashboardpage = new DashBoardPage(DriverFactory.getDriver());
	private AccountTabPage accounttabpage = new AccountTabPage(DriverFactory.getDriver());
	private FleetTabPage fleettabpage = new FleetTabPage(DriverFactory.getDriver());
	private FleetPage fleetpage = new FleetPage(DriverFactory.getDriver());
	private CommonObjects commonobjects = new CommonObjects(DriverFactory.getDriver());
	private DistanceTabPage distancetabpage = new DistanceTabPage(DriverFactory.getDriver());
	private WgtGroup wgtgroup = new WgtGroup(DriverFactory.getDriver());
	private WgtGroupAdd wgtgroupadd = new WgtGroupAdd(DriverFactory.getDriver());
	private VehicleTabPage Vehicletabpage = new VehicleTabPage(DriverFactory.getDriver());
	private VehicleAmend vehicleAmend =new VehicleAmend(DriverFactory.getDriver());
	private VehicleDelete vehicleDelete =new VehicleDelete(DriverFactory.getDriver());
	private BillingTab billingtab = new BillingTab(DriverFactory.getDriver());
	private Payment pay =new Payment(DriverFactory.getDriver());
	private PaymentTab paymenttab = new PaymentTab(DriverFactory.getDriver());
	private InventoryPage inventorypage = new InventoryPage(DriverFactory.getDriver());
	private VehicleAdd vehicleadd= new VehicleAdd(DriverFactory.getDriver());
	private Financepage financepage =new Financepage(DriverFactory.getDriver());
	private VehicleList vehiclelist =new VehicleList(DriverFactory.getDriver());

	private int readRowNo=1;
	private int writeRowNo=1;
	private String cancelDeletedVehicle=null;
	private String cancelAmendedVehicle=null;
	private ElementUtil eleutil =new ElementUtil();
	private Screenshot_Utility screenshotUtil =new Screenshot_Utility();
	private ConfigReader config=new ConfigReader();
	private Logger log = Logger.getLogger(RWC_001.class); 
	private ReadExcelUtil excelutil=null;
	private WriteExcelUtil excelutilWrite=null;
	private ErrorCollector error = new ErrorCollector();
	private String className = this.getClass().getName().split("[.]")[1];
	

	@Given("User login as a Internal user")
	public void user_login_as_a_internal_user() throws Exception {
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

	@When("User will navigate to the IRPLink")
	public void user_will_navigate_to_the_irp_link() throws Exception {
		dashboardpage.clickIRPLink();
		log.info("*** Click IRP ***");
		screenshotUtil.captureScreenshot(className,"IRP");
		dashboardpage.clickRenewFleetLink();
		log.info("*** Click RenewFleet ***");
		screenshotUtil.captureScreenshot(className,"RenewFleet");
	}

	@Then("User will provide all the Account Number Details to start with IRP Transaction")
	public void user_will_provide_all_the_account_number_details_to_start_with_irp_transaction() throws IOException, Exception {
		excelutil = new ReadExcelUtil(config.readRwcExcel());
		excelutilWrite=new WriteExcelUtil();
		
		fleetpage.enterAccountNo(excelutil.getCellData("PreSetup","AccountNumber",readRowNo));
		log.info("*** Enter Account Number ***");
		screenshotUtil.captureScreenshot(className,"Entering AccountNumber");
		fleetpage.enterFleetNo(excelutil.getCellData("PreSetup","FleetNumber",readRowNo));
		log.info("*** Enter FleetNo ***");
		screenshotUtil.captureScreenshot(className,"Entering FleetNumber");
		fleetpage.enterFleetyear(excelutil.getCellData("PreSetup","Fleet Expiration Year",readRowNo));
		log.info("*** Click FleetYear ***");
		screenshotUtil.captureScreenshot(className,"Entering FleetYear");
		commonobjects.clickProceed();	

	}

	@Then("User will navigate to account section and fill the data")
	public void user_will_navigate_to_account_section_and_fill_the_data_and_validate_message() throws Exception, Exception {
		//Fetch Values
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchMCECustomernolbl(),writeRowNo,accounttabpage.fetchMCECustomerno());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchRegistrationTypelbl(), writeRowNo,accounttabpage.fetchRegistrationType());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountCarrierTypeLbl(), writeRowNo,accounttabpage.fetchAccountCarrierType());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchIFTAAccountNbrlbl(),writeRowNo,accounttabpage.fetchIFTAAccountNbr());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountCustomerStatusLbl(),writeRowNo,accounttabpage.fetchAccountCustomerStatus());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountStreet0Lbl(),writeRowNo,accounttabpage.fetchAccountStreet0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountZip0lbl(),writeRowNo,accounttabpage.fetchAccountZip0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountJur0lbl(), writeRowNo,accounttabpage.fetchAccountJur0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountCity0lbl(),writeRowNo,accounttabpage.fetchAccountCity0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountCounty0lbl(), writeRowNo,accounttabpage.fetchAccountCounty0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountCountry0lbl(),writeRowNo,accounttabpage.fetchAccountCountry0());

		accounttabpage.clickMailingAddress();
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountStreet1lbl(),writeRowNo,accounttabpage.fetchAccountStreet1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountZip1lbl(), writeRowNo,accounttabpage.fetchAccountZip1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountJur1lbl(), writeRowNo,accounttabpage.fetchAccountJur1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountCity1lbl(),writeRowNo,accounttabpage.fetchAccountCity1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountCounty1lbl(),writeRowNo,accounttabpage.fetchAccountCounty1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountCountry1lbl(),writeRowNo,accounttabpage.fetchAccountCountry1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountAttentionTolbl(),writeRowNo,accounttabpage.fetchAccountAttentionTo());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountUSDOTNolbl(), writeRowNo,accounttabpage.fetchAccountUSDOTNo());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountTPIDlbl(),writeRowNo,accounttabpage.fetchAccountTPID());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountContactnamelbl(), writeRowNo,accounttabpage.fetchAccountContactname());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountEmaillbl(),writeRowNo,accounttabpage.fetchAccountEmail());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountPrimaryPhonelbl(),writeRowNo,accounttabpage.fetchAccountPrimaryPhone());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountAlternatePhonelbl(), writeRowNo,accounttabpage.fetchAccountAlternatePhone());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountFaxNolbl(),writeRowNo,accounttabpage.fetchAccountFaxNo());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountEmailnotificationlbl(), writeRowNo,accounttabpage.fetchAccountEmailnotification());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountFaxnotificationlbl(),writeRowNo,accounttabpage.fetchAccountFaxnotification());

		log.info(commonobjects.validateInfoMsgs());
		accounttabpage.checkEmailNotification();
		log.info("*** Check Email Notification ***");
		screenshotUtil.captureScreenshot(className,"Check EmailNotification");
		commonobjects.provideComments(excelutil.getCellData("AccountTab","Comments",readRowNo));
		log.info("*** Enter Comments ***");
		screenshotUtil.captureScreenshot(className,"Enter Comments in Account Section");

		commonobjects.clickProceed();
		//Account Verification Screen
		commonobjects.clickProceed();
	}

	@Then("User will navigate to Fleet section and fill the data and validate message  {string}")
	public void user_will_navigate_to_fleet_section_and_fill_the_data_and_validate_message(String expSucces) throws Exception {
		//Fetch Fleet Details screen 
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchRegistrationtypelbl(), writeRowNo,fleettabpage.fetchRegistrationtype());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchfltstatuslbl(),writeRowNo,fleettabpage.fetchfltstatus());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchcarriertypelbl(), writeRowNo,fleettabpage.fetchcarriertype());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchDBANamelbl(),writeRowNo, fleettabpage.fetchDBAName());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetStreet0Lbl(),writeRowNo,fleettabpage.fleetStreet0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetZip0Lbl(),writeRowNo,fleettabpage.fleetZip0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetJur0Lbl(), writeRowNo,fleettabpage.fleetJur0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetCity0Lbl(),writeRowNo, fleettabpage.fleetCity0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetCounty0Lbl(), writeRowNo,fleettabpage.fleetCounty0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetCountry0Lbl(),writeRowNo,fleettabpage.FleetCountry0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetNonDeliverable0Lbl(), writeRowNo,fleettabpage.fleetNonDeliverable0());

		fleettabpage.clickMailingAddress();
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetStreet1Lbl(),writeRowNo,fleettabpage.fleetStreet1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetZip1Lbl(),writeRowNo,fleettabpage.fleetZip1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetJur1Lbl(), writeRowNo,fleettabpage.fleetJur1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetCity1Lbl(),writeRowNo, fleettabpage.FleetCity1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetCounty1Lbl(), writeRowNo,fleettabpage.fleetCounty1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetCountry1Lbl(),writeRowNo,fleettabpage.fleetCountry1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetNonDeliverable1Lbl(), writeRowNo,fleettabpage.fleetNonDeliverable1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetAttentionToLbl(), writeRowNo,fleettabpage.fleetAttentionTO());

		fleettabpage.navigateToServiceProvider();
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceProviderLbl(), writeRowNo,fleettabpage.fleetServiceProvider());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceLegalNameLbl(),writeRowNo,fleettabpage.fleetServiceLegalName());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceDBANameLbl(), writeRowNo,fleettabpage.fleetServiceDBAName());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServicePowerOfAttroneyLbl(),writeRowNo, fleettabpage.fleetServicePowerOfAttroney());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServicePowerOfAttroneyEffDateLbl(), writeRowNo,fleettabpage.fleetServicePowerOfAttroneyEffDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServicePowerOfAttroneyExpDateLbl(),writeRowNo,fleettabpage.fleetServicePowerOfAttroneyExpDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceEmailIdLbl(), writeRowNo,fleettabpage.fleetServiceEmailId());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServicePhoneNoLbl(),writeRowNo, fleettabpage.fleetServicePhoneNo());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceFaxNoLbl(), writeRowNo,fleettabpage.fleetServiceFaxNo());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceStreetLbl(),writeRowNo,fleettabpage.fleetServiceStreet());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceCityLbl(), writeRowNo,fleettabpage.fleetServiceCity());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceJurLbl(),writeRowNo, fleettabpage.fleetServiceJur());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceZipCodeLbl(), writeRowNo,fleettabpage.fleetServiceZipCode());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceCountryLbl(),writeRowNo,fleettabpage.fleetServiceCountry());

		fleettabpage.clickOnTimeMailingAddress();
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingStreetLbl(), writeRowNo,fleettabpage.fleetServiceMailingStreet());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingZipCodeLbl(),writeRowNo, fleettabpage.fleetServiceMailingZipCode());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingJurLbl(), writeRowNo,fleettabpage.fleetServiceMailingJur());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingCityLbl(),writeRowNo,fleettabpage.fleetServiceMailingCity());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingCountyLbl(), writeRowNo,fleettabpage.fleetServiceMailingCounty());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingCountryLbl(),writeRowNo, fleettabpage.fleetServiceMailingCountry());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingAttentionToLbl(), writeRowNo,fleettabpage.fleetServiceMailingAttentionTo());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsContactNameLbl(),writeRowNo,fleettabpage.fleetDetailsContactName());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsEmailIdLbl(), writeRowNo,fleettabpage.fleetDetailsEmailId());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsPrimaryCellNbrLbl(),writeRowNo, fleettabpage.fleetDetailsPrimaryCellNbr());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsAlternateCellNbrLbl(), writeRowNo,fleettabpage.fleetDetailsAlternateCellNbr());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFaxNoLbl(),writeRowNo, fleettabpage.fleetDetailsFaxNo());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsTpIdLbl(), writeRowNo,fleettabpage.fleetDetailsTPID());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsUsdotNbrLbl(),writeRowNo,fleettabpage.fleetDetailsUsdotNbr());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsChangeVehUsdotTinLbl(), writeRowNo,fleettabpage.fleetDetailsChangeVehUsdotTin());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFltTypeLbl(),writeRowNo, fleettabpage.fleetDetailsFltType());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsCommodityClassLbl(), writeRowNo,fleettabpage.fleetDetailsCommodityClass());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFltEffDateLbl(),writeRowNo,fleettabpage.fleetDetailsFltEffDatedtPicker());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFltExpDateLbl(), writeRowNo,fleettabpage.fleetDetailsFltExpDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsChangeAddrOnUsdotLbl(),writeRowNo, fleettabpage.fleetDetailsChangeAddrOnUsdot());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFirstOperatedDateLbl(),writeRowNo,fleettabpage.fleetDetailsFirstOperatedDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsWyomingIndicatorLbl(), writeRowNo,fleettabpage.fleetDetailsWyomingIndicator());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsIFTADistanceLbl(),writeRowNo, fleettabpage.fleetDetailsIFTADistance());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsMobileNotificationLbl(), writeRowNo,fleettabpage.fleetDetailsMobileNotification());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsIRPRequirementsLbl(),writeRowNo, fleettabpage.fleetDetailsIRPRequirements());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsStatementOfUnderstandingLbl(), writeRowNo,fleettabpage.fleetDetailsStatementOfUnderstanding());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsInstallmentAgreementLbl(),writeRowNo,fleettabpage.fleetDetailsInstallmentAgreement());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsPowerOfAttorneyLbl(), writeRowNo,fleettabpage.fleetDetailsPowerOfAttorney());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsHVUTFormLbl(),writeRowNo, fleettabpage.fleetDetailsHVUTForm());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsPropertyTaxLbl(), writeRowNo,fleettabpage.fleetDetailsPropertyTax());

		String actualtext = commonobjects.fetchErrorMessage(expSucces);

		try {
			Assert.assertEquals(actualtext, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}

		CommonStep.scenario.log("Message in Fleet Screen"+actualtext);


		log.info(commonobjects.validateInfoMsgs());
		log.info("Message in Fleet Screen "+commonobjects.fetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot(className,"Message in Fleet Screen 1");


		fleettabpage.navigateToServiceProvider();
		log.info("*** navigateToServiceProvider ***");
		screenshotUtil.captureScreenshot(className,"Navigate to Service provider");

		fleettabpage.clickPowerOfAttroney();
		log.info("*** Click PowerofAttroney ***");
		screenshotUtil.captureScreenshot(className,"Check Power of Attroney");

		fleettabpage.enterEmailID(excelutil.getCellData("FleetTab","Email iD",readRowNo));
		log.info("*** Entering the Emailid ***");
		screenshotUtil.captureScreenshot(className,"Entering the Emailid");
		//Expiration Date through Excel
		//	fleettabpage.selectExpirationDate(ExcelReader.FetchDataFromSheet(config.readRWCexcel(), "FleetTab", 2, 13));
		//Expiration Date through System
		fleettabpage.selectExpirationDate(eleutil.getAddedDateInSpecifiedFormat("MMddYYYY",2));
		log.info("*** Selecting the Expiration Date ***");
		screenshotUtil.captureScreenshot(className,"Selecting the Expiration Date");

		fleettabpage.selectIRPRequirementForm(excelutil.getCellData("FleetTab","IRP Requirements Form",readRowNo));
		log.info("*** Selecting the IRPRequirementForm ***");
		screenshotUtil.captureScreenshot(className,"Selecting the IRPRequirementForm");

		fleettabpage.selectStatementofUnderstanding(excelutil.getCellData("FleetTab","Statement of Understanding",readRowNo));		
		log.info("*** Selecting StatementofUnderstanding ***");
		screenshotUtil.captureScreenshot(className,"Selecting StatementofUnderstanding");

		fleettabpage.selectInstallmentAgreement(excelutil.getCellData("FleetTab","Installment Agreement",readRowNo));
		log.info("*** Selecting InstallmentAgreement ***");
		screenshotUtil.captureScreenshot(className,"Selecting InstallmentAgreement");

		fleettabpage.selectPowerOfAttroney(excelutil.getCellData("FleetTab","Power of Attorney",readRowNo));
		log.info("*** Selecting PowerOfAttroney ***");
		screenshotUtil.captureScreenshot(className,"Selecting PowerOfAttroney");

		fleettabpage.selectHVUTForm(excelutil.getCellData("FleetTab","HVUT - Form 2290",readRowNo));
		log.info("*** Selecting HVUTForm ***");
		screenshotUtil.captureScreenshot(className,"Selecting HVUTForm");		

		fleettabpage.selectPropertyTax(excelutil.getCellData("FleetTab","Property Tax",readRowNo));
		log.info("*** Selecting PropertyTax ***");
		screenshotUtil.captureScreenshot(className,"Selecting PropertyTax");		

		commonobjects.provideComments(excelutil.getCellData("FleetTab","Comments",readRowNo));
		log.info("*** Enter Comments ***");
		screenshotUtil.captureScreenshot(className,"Enter Comments in Fleet Section");

		commonobjects.clickProceed();
		//Fleet Verification Screen
		commonobjects.clickProceed();
	}

	@Then("User will navigate to Distance section and fill the data and validate message {string} {string}")
	public void user_will_navigate_to_distance_section_and_fill_the_data_and_validate_message(String expSucces1, String expSucces2) throws Exception, Exception {
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceReportingPeriodFromlbl(), writeRowNo,distancetabpage.distanceReportingPeriodFrom());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceReportingPeriodTolbl(), writeRowNo,distancetabpage.distanceReportingPeriodTo());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceUsdotNbrlbl(), writeRowNo,distancetabpage.distanceUsdotNbr());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceEstimatedDistanceChartlbl(), writeRowNo,distancetabpage.distanceEstimatedDistanceChart());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceOverrideContJurlbl(), writeRowNo,distancetabpage.distanceOverrideContJur());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceEstimatedDistancelbl(), writeRowNo,distancetabpage.distanceEstimatedDistance());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceActualDistancelbl(), writeRowNo,distancetabpage.distanceActualDistance());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceTotalFleetDistancelbl(), writeRowNo,distancetabpage.distanceTotalFleetDistance());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceFRPMlgQuetionlbl(), writeRowNo,distancetabpage.distanceFRPMlgQuetion());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceDistanceTypelbl(), writeRowNo,distancetabpage.distanceDistanceType());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Distance",distancetabpage.distanceActualDistConfirmationlbl(), writeRowNo,distancetabpage.distanceActualDistConfirmation());


		//Juris Table Verification
		//Juris Table header

		ArrayList<String>  Juris_values=distancetabpage.FetchTable_Juris();
		ArrayList<String>  Distance_values=distancetabpage.FetchTable_DistanceMiles();
		ArrayList<String>  Percent_values=distancetabpage.FetchTable_Percent();

		for(int i=0;i<Juris_values.size();i++) {
			excelutilWrite.setCellData(config.writeRwcExcel(),"Distance_Juris",distancetabpage.distanceJurisTableHeaderJuri()+i, writeRowNo,Juris_values.get(i));
			excelutilWrite.setCellData(config.writeRwcExcel(),"Distance_Juris",distancetabpage.distanceJurisTableHeaderDistance()+i, writeRowNo,Distance_values.get(i));
			excelutilWrite.setCellData(config.writeRwcExcel(),"Distance_Juris",distancetabpage.distanceJurisTableHeaderPercent()+i, writeRowNo,Percent_values.get(i));
		}

		//Juris list
		String actualmessage = commonobjects.fetchErrorMessage(expSucces1);
		try {
			Assert.assertEquals(actualmessage, expSucces1);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Distance Screen"+ actualmessage);

		log.info(commonobjects.validateInfoMsgs());
		log.info("Message in Distance Screen"+commonobjects.fetchErrorMessage(expSucces1));

		screenshotUtil.captureScreenshot(className,"Message in Distance Screen 1");

		String actualmessage2 = commonobjects.fetchErrorMessage(expSucces2);
		try {
			Assert.assertEquals(actualmessage2, expSucces2);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Distance Screen"+ actualmessage2);

		log.info("Message in Distance Screen"+commonobjects.fetchErrorMessage(expSucces1));

		screenshotUtil.captureScreenshot(className,"Message in Distance Screen 1");

		distancetabpage.enterAllDistanceValue(excelutil.getCellData("DistanceTab","Distance",readRowNo));   	
		//distancetabpage.enterMODistanceValue(excelutil.getCellData("DistanceTab","Juri",RowNo), excelutil.getCellData("DistanceTab","Distance",RowNo));
		log.info("*** Enter MODistanceValue ***");
		screenshotUtil.captureScreenshot(className,"Enter MODistanceValue");

		commonobjects.provideComments(excelutil.getCellData("DistanceTab","Comments",readRowNo));
		log.info("*** Enter Comments ***");
		screenshotUtil.captureScreenshot(className,"Enter Comments in Distance Section");

		commonobjects.clickProceed();

		commonobjects.clickProceed();

	}

	@Then("User will navigate to Weight group section and fill the data ans validate message {string}")
	public void user_will_navigate_to_weight_group_section_and_fill_the_data_ans_validate_message(String expSucces) throws Exception {
		//Fetch Values into Excel
		ArrayList<String>  headervalues=wgtgroup.fetchTableHeader();
		ArrayList<String>  RowDatavalues=wgtgroup.fetchTableRowData();
		int j,k=0;
		for(int i=0;i<RowDatavalues.size();i++) {
			if(i>5){
				j=i%6;
				if(j==0){
					k++;
				}
				excelutilWrite.setCellData(config.writeRwcExcel(),"WeightGroup",headervalues.get(j)+k, writeRowNo,RowDatavalues.get(i));
				log.info("Weight Group headervalues"+headervalues.get(j));
				log.info("Weight Group RowDatavalues"+RowDatavalues.get(i));
			}
			else{
				excelutilWrite.setCellData(config.writeRwcExcel(),"WeightGroup",headervalues.get(i)+k, writeRowNo,RowDatavalues.get(i)); 
				log.info("Weight Group headervalues"+headervalues.get(i));
				log.info("Weight Group RowDatavalues"+RowDatavalues.get(i));
			}

		}

		String actualmessage = commonobjects.fetchErrorMessage(expSucces);
		try {
			Assert.assertEquals(actualmessage, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}

		CommonStep.scenario.log("Message in Weight Group Screen"+actualmessage);


		log.info(commonobjects.validateInfoMsgs());
		log.info("Message in Weight Group Screen"+commonobjects.fetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot(className,"Message in Weight Group Screen 1");

		wgtgroup.clickAddWeightGroup();
		log.info("*** Click AddweightGroup ***");
		screenshotUtil.captureScreenshot(className,"Click AddweightGroup");
		//Add Weight Group Screen
		String WeightGroupCount_Excel=excelutil.getCellData("WeightGrouptab","TotalWeightGroups",readRowNo);

		for(int weightcount=0;weightcount<Integer.valueOf(WeightGroupCount_Excel);weightcount++) {
			wgtgroupadd.selectWeightGroupType(excelutil.getCellData("WeightGrouptab","WeightGroup Type"+String.valueOf(weightcount),readRowNo));

			log.info("*** Select WeightGroupType ***");
			screenshotUtil.captureScreenshot(className,"Select WeightGroupType");
			wgtgroupadd.enterWeightGroupNo(excelutil.getCellData("WeightGrouptab","Weight Group No."+String.valueOf(weightcount),readRowNo));
			log.info("*** Enter WeightGroup No ***");
			screenshotUtil.captureScreenshot(className,"Enter WeightGroup No");
			wgtgroupadd.selectMaxGrossWeight(excelutil.getCellData("WeightGrouptab","Max Gross Weight"+String.valueOf(weightcount),readRowNo));
			log.info("*** Select MaxGross Weight ***");
			screenshotUtil.captureScreenshot(className,"Select MaxGross Weight");
			commonobjects.clickProceed();

			commonobjects.clickProceed();
		}

		//Weight Group Screen
		//Edit Existing Weight Group
		wgtgroup.clickHandImg();

		String juriExcelCount=excelutil.getCellData("WeightJuris","Juris Count",readRowNo);
		for(int i=0;i<Integer.valueOf(juriExcelCount);i++) {
			String juriExcel=excelutil.getCellData("WeightJuris","Juri"+String.valueOf(i),readRowNo);
			wgtgroupadd.enterWeightJuriValue(juriExcel);
		}
		commonobjects.clickProceed();
		// Weight Group Verification Screen
		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());
		//Validating JUR WITH DIFFERENT WEIGHTS
		String[] weightlist=wgtgroup.validateJurisWeightsedited(); //[AL, AR, AZ]
		for(int i=0;i<Integer.valueOf(juriExcelCount);i++) {
			String Juri_Excel=excelutil.getCellData("WeightJuris","Juri"+String.valueOf(i),readRowNo);
			if(weightlist[i].equalsIgnoreCase(Juri_Excel)){
				assert true;
			}
		}

		//In Weight Group Screen	
		commonobjects.clickDoneBtn();
	}

	@Then("User will navigate to Add vehicle and validate the message {string} {string} {string}")
	public void user_will_navigate_to_Add_vehicle_and_validate_the_message(String expSucces, String expSucces2, String expSucces3) throws Exception {
		excelutilWrite.setCellData(config.writeRwcExcel(),"VehicleTab",Vehicletabpage.fetchAmendVehicleLbl(), writeRowNo,Vehicletabpage.fetchAmendVehicle());
		excelutilWrite.setCellData(config.writeRwcExcel(),"VehicleTab",Vehicletabpage.fetchAddVehiclesLbl(), writeRowNo,Vehicletabpage.fetchAddVehicles());
		excelutilWrite.setCellData(config.writeRwcExcel(),"VehicleTab",Vehicletabpage.fetchDeleteVehicleLbl(), writeRowNo,Vehicletabpage.fetchDeleteVehicle());
		excelutilWrite.setCellData(config.writeRwcExcel(),"VehicleTab",Vehicletabpage.fetchRenewVehicleLbl(), writeRowNo,Vehicletabpage.fetchRenewVehicle());

		log.info(commonobjects.validateInfoMsgs());

		int NoofVehiclestoAmend=Integer.valueOf(excelutil.getCellData("VehicleTab","NoofVehiclestoAmend",readRowNo));
		if(NoofVehiclestoAmend>0) {

			Vehicletabpage.clickAmendVehicleRadioButton();
			log.info("*** Click AmendVehicle RadioButton ***");
			screenshotUtil.captureScreenshot(className,"Click AmendVehicle RadioButton");

			commonobjects.clickProceed();
			log.info(commonobjects.validateInfoMsgs());

			String actualmessage = commonobjects.fetchErrorMessage(expSucces);
			try {
				Assert.assertEquals(actualmessage, expSucces);
			}
			catch(Throwable e) {
				error.addError(e);
			}
			CommonStep.scenario.log("Message in Amend Vehicle Screen"+actualmessage);

			log.info("Message in Amend Vehicle Screen"+commonobjects.fetchErrorMessage(expSucces));
			screenshotUtil.captureScreenshot(className,"Message in Amend Vehicle Screen 1");


			for(int i=0;i<NoofVehiclestoAmend;i++) {
				if(NoofVehiclestoAmend>Integer.valueOf(config.readAmendVehicleCondition())) {
					vehicleAmend.selectUnitNoFromSuggestions();
					log.info("*** Select Unit number ***");
					screenshotUtil.captureScreenshot(className,"Select Unit number");
				}
				else {
					vehicleAmend.enterUnitNo(excelutil.getCellData("VehicleAmendTab","Unit"+String.valueOf(i),readRowNo));
					log.info("*** Enter Unit number ***");
					screenshotUtil.captureScreenshot(className,"Enter Unit number");
				}
				vehicleAmend.clickSearch();
String vehicleBodyType=vehicleAmend.fetchAmendVehicleBodyType();

				if(vehicleBodyType.equalsIgnoreCase("CG - Converter Gear") || vehicleBodyType.equalsIgnoreCase("MT - Motor Totor")||
				   vehicleBodyType.equalsIgnoreCase("RT - Road Truck")|| vehicleBodyType.equalsIgnoreCase("TK - Straight Truck")||
				   vehicleBodyType.equalsIgnoreCase("TR - Tractor")|| vehicleBodyType.equalsIgnoreCase("TT - Truck Tractor") ||
				 vehicleBodyType.equalsIgnoreCase("WR - Wrecker")) {
					vehicleAmend.selectWeightGroupNo(excelutil.getCellData("WeightGrouptab","Vehicle_WeightGroupNo",readRowNo));

					log.info("*** Enter WeightGroupNo ***");
					screenshotUtil.captureScreenshot(className,"Enter WeightGroupNo");
					String actualmessage1 = commonobjects.fetchErrorMessage(expSucces2);
					try {
						Assert.assertEquals(actualmessage1, expSucces2);
					}
					catch(Throwable e) {
						error.addError(e);
					}
					CommonStep.scenario.log("Message in Amend Vehicle Screen"+actualmessage1);

					log.info("Message in Amend Vehicle Screen"+commonobjects.fetchErrorMessage(expSucces2));
					screenshotUtil.captureScreenshot(className,"Message in Amend Vehicle Screen 2");
				}
				vehicleAmend.enterUnladenWeight(excelutil.getCellData("VehicleTab","unladenWeight",readRowNo));
				log.info("*** Enter UnladenWeight ***");
				screenshotUtil.captureScreenshot(className,"Enter UnladenWeight");


				vehicleAmend.clickTVR();
				log.info("*** Click TVR ***");
				screenshotUtil.captureScreenshot(className,"Click TVR");

				vehicleAmend.selectSafetyChangedd(excelutil.getCellData("VehicleTab","Safety Change",readRowNo));
				log.info("*** Select Safety Changedd ***");
				screenshotUtil.captureScreenshot(className,"Select Safety Changedd");

				vehicleAmend.selectHVUTForm2290(excelutil.getCellData("VehicleTab","HVUT - Form",readRowNo));
				log.info("*** Select HVUTForm2290 ***");
				screenshotUtil.captureScreenshot(className,"Select HVUTForm2290");

				vehicleAmend.selectLeaseContract(excelutil.getCellData("VehicleTab","Lease Contract",readRowNo));
				log.info("*** Select LeaseContract ***");
				screenshotUtil.captureScreenshot(className,"Select LeaseContract");

				vehicleAmend.selectTitleDocument(excelutil.getCellData("VehicleTab","Title Document",readRowNo));
				log.info("*** Select TitleDocument ***");
				screenshotUtil.captureScreenshot(className,"Select TitleDocument");

				vehicleAmend.selectPlateReturndoc(excelutil.getCellData("VehicleTab","Plate Returned Document",readRowNo));
				log.info("*** Select PlateReturndoc ***");
				screenshotUtil.captureScreenshot(className,"Select PlateReturndoc");

				vehicleAmend.selectAffidavitDoc(excelutil.getCellData("VehicleTab","Affidavit document",readRowNo));
				log.info("*** Select AffidavitDoc ***");
				screenshotUtil.captureScreenshot(className,"Select AffidavitDoc");

				vehicleAmend.selectPropertyTax(excelutil.getCellData("VehicleTab","Property Tax",readRowNo));
				log.info("*** Select PropertyTax ***");
				screenshotUtil.captureScreenshot(className,"Select PropertyTax");

				commonobjects.provideComments(excelutil.getCellData("VehicleTab","Ammend_Comments",readRowNo));

				log.info("*** Enter Comments ***");
				screenshotUtil.captureScreenshot(className,"Enter Comments in Distance Section");

				commonobjects.clickProceed();
				//Verification Screen
				commonobjects.clickProceed();

				String actualmessage2 = commonobjects.fetchErrorMessage(expSucces3);
				try {
					Assert.assertEquals(actualmessage2, expSucces3);
				}
				catch(Throwable e) {
					error.addError(e);
				}
				CommonStep.scenario.log("Message in Amend Vehicle Screen "+actualmessage2);


				log.info("essage in Amend Vehicle Screen "+commonobjects.fetchErrorMessage(expSucces3));
				screenshotUtil.captureScreenshot(className,"Message in Amend Vehicle Screen");

			}// End of for Loop
			commonobjects.clickDoneBtn();
			log.info(commonobjects.validateInfoMsgs());
		} //End of vehicle ammend if loop
	}


	@Then("User will Delete vehicle as per the requiremnet and validate the message {string}")
	public void user_will_delete_vehicle_as_per_the_requiremnet_and_validate_the_message(String expSucces) throws Exception {
		log.info(commonobjects.validateInfoMsgs());
		int NoofVehiclestoDelete=Integer.valueOf(excelutil.getCellData("VehicleTab","NoOfVehiclesToDelete",readRowNo));	
		if(NoofVehiclestoDelete>0) {
			Vehicletabpage.clickDeleteVehicleRadioButton();
			log.info("**** Click DeleteVehicle ****");
			screenshotUtil.captureScreenshot(className,"Click Delete Vehicle");

			commonobjects.clickProceed();
			log.info(commonobjects.validateInfoMsgs());
			//below lines of code for deleting the vehicles from suggestion box
			String Vehiclescount=excelutil.getCellData("VehicleTab","NoOfVehiclesToDelete",readRowNo);
			String PlateStatus=excelutil.getCellData("VehicleTab","Delete_PlateStatus",readRowNo);
			String PlateReturnedDocument=excelutil.getCellData("VehicleTab","Delete_PlateReturnedDocument",readRowNo);
			String AffidavitDocument=excelutil.getCellData("VehicleTab","Delete_AffidavitDocument",readRowNo);
			String Comments=excelutil.getCellData("VehicleTab","Delete_Comments",readRowNo);

			if(NoofVehiclestoDelete>Integer.valueOf(config.readDeleteVehicleCondition())) {
				vehicleDelete.deleteFewVehicles(Vehiclescount, PlateStatus, PlateReturnedDocument, AffidavitDocument, Comments);
				commonobjects.clickProceed();
				commonobjects.clickProceed();
			}
			else {

				for(int j=0;j<NoofVehiclestoDelete;j++) {
					//Enter unit # to filter & delete
					vehicleDelete.enterUnitNo(excelutil.getCellData("VehicleDeleteTab","Unit"+String.valueOf(j),readRowNo));
					log.info("*** Delete vehicle Enter Unit number ***");
					screenshotUtil.captureScreenshot(className,"Delete vehicle Enter Unit number");

					vehicleDelete.clickonSearch();
					vehicleDelete.ClickCheckBoxFromGrid();

					vehicleDelete.selectPlateStatus(PlateStatus);
					log.info("***DeleteVehicle Select PlateStatus ***");
					screenshotUtil.captureScreenshot(className,"DeleteVehicle Select PlateStatus");

					vehicleDelete.selectPlateReturnedDocument(PlateReturnedDocument);
					log.info("***DeleteVehicle Select PlateReturndoc ***");
					screenshotUtil.captureScreenshot(className,"DeleteVehicle Select PlateReturndoc");

					vehicleDelete.selectAffidavitDocument(AffidavitDocument);
					log.info("***DeleteVehicle Select AffidavitDoc ***");
					screenshotUtil.captureScreenshot(className,"DeleteVehicle Select AffidavitDoc");


					vehicleDelete.entercomments(Comments);
					log.info("*** DeleteVehicle Comment ***");
					screenshotUtil.captureScreenshot(className,"DeleteVehicle Comment");

					commonobjects.clickProceed();
					commonobjects.clickProceed();
				}//End of For Loop
			} //End of if loop
			String actualmessage = commonobjects.fetchErrorMessage(expSucces);
			try {
				Assert.assertEquals(actualmessage, expSucces);
			}
			catch(Throwable e) {
				error.addError(e);
			}
			CommonStep.scenario.log("Message in Delete Vehicle Screen"+actualmessage);

			log.info(commonobjects.validateInfoMsgs());
			log.info("Message in Delete Vehicle Screen"+commonobjects.fetchErrorMessage(expSucces));
			screenshotUtil.captureScreenshot(className,"Message in Delete Vehicle Screen 1");
			commonobjects.clickDoneBtn();
			log.info(commonobjects.validateInfoMsgs());
		}//End of vehicle Delete if loop
	}
	@Then("User will navigate to vehicle list to cancel the existing amended vehicle and amend it again {string}")
	public void user_will_navigate_to_vehicle_list_to_cancel_the_existing_amended_vehicle_and_amend_it_again(String expSucces) throws Exception {
	//verification screen before going to billing screen -Vehicles cancel from Vehicle List
		Vehicletabpage.clickVehicleList();
		log.info("*** Click VehicleList ***");
		screenshotUtil.captureScreenshot(className,"Click VehicleList");
		int NoofVehiclestoAmend=Integer.valueOf(excelutil.getCellData("VehicleTab","NoofVehiclestoAmend",readRowNo));
		cancelAmendedVehicle=vehiclelist.fetchRequiredUnitNumber("AMEND");
		log.info("Cancelling the recently Amended Vehicle"+cancelAmendedVehicle);
		
		if(NoofVehiclestoAmend>Integer.valueOf(config.readAmendVehicleCondition())) {
			//Canceling the Amended Vehicle
			//	vehicleadd.enterUnitNumber(excelutil.getCellData("VehicleAmendTab","Unit0",RowNo));
			vehicleadd.enterUnitNumber(cancelAmendedVehicle);
		}
		else {
			vehicleadd.enterUnitNumber(excelutil.getCellData("VehicleAmendTab","Unit0",readRowNo));
		}
		log.info("*** Select Unit No ***");
		screenshotUtil.captureScreenshot(className,"Select Unit No");

		vehicleAmend.clickSearch();
		log.info("*** Search Unit No ***");
		//screenshotUtil.captureScreenshot(className,"Search Unit No");
		//	}
		vehicleadd.selectFirstHandIcon();
		commonobjects.clickCancelBtn();
		eleutil.handleAlert();
		log.info(commonobjects.validateInfoMsgs());
		log.info("Message in Vehicle Cancel Screen"+commonobjects.fetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot(className,"Message in Vehicle Cancel Screen 1");

		//Amending the Recently Cancelled Vehicle
		Vehicletabpage.clickAmendVehicleRadioButton();

		commonobjects.clickProceed();
		log.info("Amending the recently Cancelled Vehicle"+cancelAmendedVehicle);
		vehicleAmend.enterUnitNo(cancelAmendedVehicle);
		//vehicleAmend.enterUnitNo(excelutil.getCellData("VehicleAmendTab","Unit0",RowNo));

		vehicleAmend.clickSearch();

		vehicleAmend.enterUnladenWeight(excelutil.getCellData("VehicleUpdate","unladen Weight",readRowNo));

		vehicleAmend.clickTVR();
		vehicleAmend.selectSafetyChangedd(excelutil.getCellData("VehicleUpdate","Safety Change",readRowNo));

		vehicleAmend.selectHVUTForm2290(excelutil.getCellData("VehicleUpdate","HVUT - Form 2290",readRowNo));

		vehicleAmend.selectLeaseContract(excelutil.getCellData("VehicleUpdate","Lease Contract",readRowNo));

		vehicleAmend.selectTitleDocument(excelutil.getCellData("VehicleUpdate","Title Document",readRowNo));

		vehicleAmend.selectPlateReturndoc(excelutil.getCellData("VehicleUpdate","Plate Returned Document",readRowNo));

		vehicleAmend.selectAffidavitDoc(excelutil.getCellData("VehicleUpdate","Affidavit document",readRowNo));

		vehicleAmend.selectPropertyTax(excelutil.getCellData("VehicleUpdate","Property Tax",readRowNo));

		commonobjects.clickProceed();
		//AMend Verification Screen
		commonobjects.clickProceed();
		//To move from Amend Screen to Renewal Vehicle Processing
		commonobjects.clickDoneBtn();
	}
		@Then("User will navigate to vehicle list to cancel the existing deleted vehicle and delete it again {string}")
		public void user_will_navigate_to_vehicle_list_to_cancel_the_existing_deleted_vehicle_and_delete_it_again(String expSucces) throws Exception {
		//Canceling the Deleted Vehicle
				Vehicletabpage.clickVehicleList();
				log.info("*** Click VehicleList ***");
				screenshotUtil.captureScreenshot(className,"Click VehicleList");
				int NoofVehiclestoDelete=Integer.valueOf(excelutil.getCellData("VehicleTab","NoOfVehiclesToDelete",readRowNo));
				cancelDeletedVehicle=vehiclelist.fetchRequiredUnitNumber("DELETE");
				if(NoofVehiclestoDelete>Integer.valueOf(config.readDeleteVehicleCondition())) {
					log.info("Cancelling the recently Deleted Vehicle"+cancelDeletedVehicle);
					vehicleadd.enterUnitNumber(cancelDeletedVehicle);
				}
				else {
					vehicleadd.enterUnitNumber(excelutil.getCellData("VehicleDeleteTab","Unit0",readRowNo));	
				}
				log.info("*** Select Unit No ***");
				screenshotUtil.captureScreenshot(className,"Select Unit No");

				vehicleAmend.clickSearch();
				log.info("*** Search Unit No ***");
				screenshotUtil.captureScreenshot(className,"Search Unit No");
				//	}
				vehicleadd.selectFirstHandIcon();
				commonobjects.ClickConfirmCancel();
				eleutil.handleAlert();
				log.info(commonobjects.validateInfoMsgs());

				String actualmessage = commonobjects.fetchErrorMessage(expSucces);
				try {
					Assert.assertEquals(actualmessage, expSucces);

				}
				catch(Throwable e) {
					error.addError(e);
				}
				CommonStep.scenario.log("Message in Vehicle Cancel Screen"+ actualmessage);


				log.info("Message in Vehicle Cancel Screen"+commonobjects.fetchErrorMessage(expSucces)); 
				screenshotUtil.captureScreenshot(className,"Message in Vehicle Cancel Screen 1");

				commonobjects.clickBack();
				log.info(commonobjects.validateInfoMsgs());

		//Delete the recently cancelled vehicle
		Vehicletabpage.clickDeleteVehicleRadioButton();
		log.info("**** Click DeleteVehicle ****");
		screenshotUtil.captureScreenshot(className,"Click Delete Vehicle");

		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());
		//below lines of code for deleting the vehicles from suggestion box
		String plateStatus=excelutil.getCellData("VehicleTab","Delete_PlateStatus",readRowNo);
		String plateReturnedDocument=excelutil.getCellData("VehicleTab","Delete_PlateReturnedDocument",readRowNo);
		String affidavitDocument=excelutil.getCellData("VehicleTab","Delete_AffidavitDocument",readRowNo);
		String Comments=excelutil.getCellData("VehicleTab","Delete_Comments",readRowNo);
		log.info("Deleting the recently Cancelled Vehicle"+cancelDeletedVehicle);
		vehicleDelete.enterUnitNo(cancelDeletedVehicle);

		//vehicleDelete.enterUnitNo(excelutil.getCellData("VehicleDeleteTab","Unit0",RowNo));
		log.info("*** Delete vehicle Enter Unit number ***");
		screenshotUtil.captureScreenshot(className,"Delete vehicle Enter Unit number");

		vehicleDelete.clickonSearch();
		vehicleDelete.ClickCheckBoxFromGrid();

		vehicleDelete.selectPlateStatus(plateStatus);
		log.info("***DeleteVehicle Select PlateStatus ***");
		screenshotUtil.captureScreenshot(className,"DeleteVehicle Select PlateStatus");

		vehicleDelete.selectPlateReturnedDocument(plateReturnedDocument);
		log.info("***DeleteVehicle Select PlateReturndoc ***");
		screenshotUtil.captureScreenshot(className,"DeleteVehicle Select PlateReturndoc");

		vehicleDelete.selectAffidavitDocument(affidavitDocument);
		log.info("***DeleteVehicle Select AffidavitDoc ***");
		screenshotUtil.captureScreenshot(className,"DeleteVehicle Select AffidavitDoc");


		vehicleDelete.entercomments(Comments);
		log.info("*** DeleteVehicle Comment ***");
		screenshotUtil.captureScreenshot(className,"DeleteVehicle Comment");

		commonobjects.clickProceed();
		commonobjects.clickProceed();
		commonobjects.clickDoneBtn();
		//TO move from Renewal Vehicle Processing to Billing Screen						

		commonobjects.clickDoneBtn();

	}
	@Then("User will navigate to billing to verify as well to adjust the cost & Waive Fees {string}")
	public void user_will_navigate_to_billing_to_verify_as_well_to_adjust_the_cost_waive_fees(String expSucces) throws Exception {
		//Fetch values from Biling Screen
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchRegisterMonthlbl(),writeRowNo,billingtab.fetchRegisterMonth());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchNoOfVehiclesinSupplbl(),writeRowNo,billingtab.fetchNoOfVehiclesinSupp());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchSupplementStatuslbl(),writeRowNo,billingtab.fetchSupplementStatus());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchEnterpriseSystemCreditlbl(),writeRowNo,billingtab.fetchEnterpriseSystemCredit());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchIRPSystemCreditlbl(),writeRowNo,billingtab.fetchIRPSystemCredit());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchRenewalFeeEffectiveDatelbl(),writeRowNo,billingtab.fetchRenewalFeeEffectiveDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchInvoiceDatelbl(),writeRowNo,billingtab.fetchInvoiceDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchApplicationReceiptDatelbl(),writeRowNo,billingtab.fetchApplicationReceiptDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchPaymentDatelbl(),writeRowNo,billingtab.fetchPaymentDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchExchangeRatelbl(),writeRowNo,billingtab.fetchExchangeRate());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchManualAdjBaseJurlbl(),writeRowNo,billingtab.fetchManualAdjBaseJur());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchBilling_BatchBillinglbl(),writeRowNo,billingtab.fetchBilling_BatchBilling());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchBilling_TVRlbl(),writeRowNo,billingtab.fetchBilling_TVR());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchBilling_InstallmentPlanlbl(),writeRowNo,billingtab.fetchBilling_InstallmentPlan());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchBilling_IsUseOneTimeMailinglbl(),writeRowNo,billingtab.fetchBilling_IsUseOneTimeMailing());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchElectronicDeliveryTypelbl(),writeRowNo,billingtab.fetchElectronicDeliveryType());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing","Email",writeRowNo,billingtab.fetchBilling_Email());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchInvoiceReportTypelbl(),writeRowNo,billingtab.fetchBilling_InvoiceReportType());

		ArrayList<String> TableFeeType=billingtab.FetchTable_FeeType();
		ArrayList<String> TableFeeAmount=billingtab.FetchTable_FeeAmount();

		for(int i=0;i<TableFeeType.size();i++) {
			excelutilWrite.setCellData(config.writeRwcExcel(),"BillingGrid",billingtab.fetchBillingGridFeeType()+i,writeRowNo,TableFeeType.get(i));
			excelutilWrite.setCellData(config.writeRwcExcel(),"BillingGrid",billingtab.fetchBillingGridFeeAmount()+i,writeRowNo,TableFeeAmount.get(i));
		}	

		log.info(commonobjects.validateInfoMsgs());

		billingtab.clickTVR();
		log.info("*** Click TVR ***");
		screenshotUtil.captureScreenshot(className,"Click TVR");
		excelutilWrite.setCellData(config.writeRwcExcel(),"Billing",billingtab.fetchBillingTVRNoOfDayslbl(),writeRowNo,billingtab.fetchBilling_TVRNoOfDays());
		billingtab.clickInstallmentPlan();
		log.info("*** Click Installement Plan ***");
		screenshotUtil.captureScreenshot(className,"Click Installement Plan");

		billingtab.selectElectronicDeliveryType(excelutil.getCellData("BillingTab","Electronic Delivery Type",readRowNo));
		log.info("*** Select Electronic DeliveryType ***");
		screenshotUtil.captureScreenshot(className,"Select Electronic DeliveryType");

		commonobjects.provideComments(excelutil.getCellData("BillingTab","Billing_Comments",readRowNo));
		commonobjects.clickProceed();

		billingtab.enterManualAdjBaseJur(excelutil.getCellData("BillingTab","Manual Adj. Base Jur.",readRowNo));
		log.info("*** Enter ManualAdjBaseJur ***");
		screenshotUtil.captureScreenshot(className,"Enter ManualAdjBaseJur");

		billingtab.clickReCalculate();
		log.info("*** Click Recalculate ***");
		screenshotUtil.captureScreenshot(className,"Click Recalculate");
		String actualmessage = commonobjects.fetchErrorMessage(expSucces);
		try {
			Assert.assertEquals(actualmessage, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Biling Screen"+ actualmessage);

		log.info("Message in Biling Screen"+commonobjects.fetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot(className,"Message in Biling Screen 1");

		billingtab.expandManualAdjReason();
		billingtab.enterManualAdjReasonComments(excelutil.getCellData("BillingTab","ManualReason",readRowNo));
		log.info("*** Enter ManualAdjReason Comments ***");
		screenshotUtil.captureScreenshot(className,"Enter ManualAdjReason Comments");
		billingtab.clickManualAdjReasonDeleteAllowed();
		billingtab.clickManualAdjReasonAddorUpdateComments();

		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());
		//Check whether Late Filing Penalty,Late Pay Penalty are greater than zero
		//Bicentennial Fee,Grade Crossing Fee,Replacement Plate Fee,Second Plate Fee,Late Filing Penalty,Late Pay Penalty,Transfer Fee,Transfer Revenue Fee,Wire Transfer Fee
		//S - System Error,M - MCE Agent Error,D - Natural Disaster,O - Other
		boolean LateFilingPenaltyAmount=billingtab.getAmount(excelutil.getCellData("BillingTab","Late Filing Penalty",readRowNo));
		log.info("Late Filing Penalty Amount is Greater than zero - "+LateFilingPenaltyAmount);
		boolean LatePayPenaltyAmount=billingtab.getAmount(excelutil.getCellData("BillingTab","Late Pay Penaltys",readRowNo));
		log.info("Late pay Penalty Amount is Greater than zero - "+LatePayPenaltyAmount);
		if(LateFilingPenaltyAmount==true &&LatePayPenaltyAmount==true) {
			String FeeDescriptiontoWaiveOff=excelutil.getCellData("BillingTab","Grade Crossing Fee",readRowNo);
			String FeeWaiveOffReason=excelutil.getCellData("BillingTab","Grade Crossing Fee Waive Off",readRowNo);
			billingtab.selectWaiveOff(FeeDescriptiontoWaiveOff,FeeWaiveOffReason);
			log.info("*** Waived off for "+FeeDescriptiontoWaiveOff +"  "+" with Reason "+ FeeWaiveOffReason + " ***");
			screenshotUtil.captureScreenshot(className,"Waived off Fee");
		}
		billingtab.clickReCalculate();
		log.info("*** Click Recalculate ***");
		screenshotUtil.captureScreenshot(className,"Click Recalculate");
		log.info(commonobjects.validateInfoMsgs());
		billingtab.expandFeeOverrideReason();

		billingtab.enterFeeOverrideReasonComments(excelutil.getCellData("BillingTab","FeeOverrideReasonComments",readRowNo));

		log.info("*** Enter FeeOverrideReason Comments ***");
		screenshotUtil.captureScreenshot(className,"Enter FeeOverrideReason Comments");

		billingtab.clickFeeOverrideReasonDeleteAllowed();
		billingtab.clickFeeOverrideReasonAddorUpdateComments();

		billingtab.clickReCalculate();
		log.info(commonobjects.validateInfoMsgs());

		String mainwidow=eleutil.GetParentWindow();
		commonobjects.clickProceed();
		commonobjects.waitForSpinner();
		eleutil.waitForTwoWindow(2);
		String childWindow=eleutil.SwitchtoFirstChildWindow();
		eleutil.saveAsFile();
		String fileLocation=System.getProperty("user.dir")+"\\"+config.readDownloadFolder();
		log.info("fileLocation"+fileLocation);
		String DesiredPath=eleutil.checkFileExistence(fileLocation,"Billing","pdf");
		eleutil.sleepTime(4000); //to wait for the PDF Load completely
		eleutil.uploadFile(DesiredPath);
		eleutil.sleepTime(4000); //to display the file upload is completed
		eleutil.closeSpecificWindow(childWindow);
		eleutil.SwitchSpecificWindow(mainwidow);
	}

	@Then("User will navigate to Payment Tab to input the data and validate message {string} {string} {string}")
	public void user_will_navigate_to_payment_tab_to_input_the_data_and_validate_message(String expSucces, String expSucces2, String expSucces3) throws Exception {
		//Fetch Values from Cart payment
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchEnterpriseSystemCreditlbl(),writeRowNo,paymenttab.FetchEnterpriseSystemCredit());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchIRPSystemCreditlbl(),writeRowNo,paymenttab.FetchIRPSystemCredit());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchInvoiceDatelbl(),writeRowNo,paymenttab.FetchInvoiceDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchInvoiceNumberlbl(),writeRowNo,paymenttab.FetchInvoiceNumber());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchPaymentReciptDatelbl(),writeRowNo,paymenttab.FetchPaymentReciptDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchManualAdjBaseJurlbl(),writeRowNo,paymenttab.FetchManualAdjBaseJur());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchBatchCredentiallbl(),writeRowNo,paymenttab.FetchBatchCredential());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchWireTransferFeelbl(),writeRowNo,paymenttab.FetchWireTransferFee());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchElectronicDeliveryTypelbl(),writeRowNo,paymenttab.FetchElectronicDeliveryType());
		ArrayList<String> Payment_TableFeeType=paymenttab.FetchTable_FeeType();
		ArrayList<String> Payment_TableFeeAmount=paymenttab.FetchTable_FeeAmount();
		for(int i=0;i<Payment_TableFeeType.size();i++) {
			excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchHeaderFeeType()+i,writeRowNo,Payment_TableFeeType.get(i));
			excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentTab",paymenttab.FetchHeaderFeeAmount()+i,writeRowNo,Payment_TableFeeAmount.get(i));
		}

		log.info(commonobjects.validateInfoMsgs());
		String actualmessage = commonobjects.fetchErrorMessage(expSucces);
		try {
			Assert.assertEquals(actualmessage, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Payment Screen"+ expSucces);

		log.info("Message in Payment Screen"+commonobjects.fetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot(className,"Message in Payment Screen 1");


		String actualmessage2 = commonobjects.fetchErrorMessage(expSucces2);
		try {
			Assert.assertEquals(actualmessage2, expSucces2);
		}
		catch(Throwable e) {
			error.addError(e);
		}

		CommonStep.scenario.log("Message in Payment Screen"+ expSucces2);

		log.info("Message in Payment Screen"+ commonobjects.fetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot(className,"Message in Payment Screen 2");
		String actualmessage3 = commonobjects.fetchErrorMessage(expSucces3);
		try {
			Assert.assertEquals(actualmessage3, expSucces3);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Payment Screen"+ expSucces3);

		log.info("Message in Payment Screen"+commonobjects.fetchErrorMessage(expSucces3));
		screenshotUtil.captureScreenshot(className,"Message in Payment Screen 3");
		pay.selectElectronicDeliverytype(excelutil.getCellData("Payment","ElectronicDeliveryType",readRowNo));
		log.info("***Select Delivery type***");
		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());

		//Navigates to Payment Verification Screen
		paymenttab.clickAddtoCart();
		log.info("***Click Add to Cart**");
		log.info(commonobjects.validateInfoMsgs());
		commonobjects.validateInfoMsgs();
	}

	@Then("User will navigate to supplement continuance and validate the meesage {string}")
	public void user_will_navigate_to_supplement_continuance_and_validate_the_meesage(String expSucces) throws Exception, Exception {
		log.info(commonobjects.validateInfoMsgs());
		paymenttab.clicksupplcont();
		log.info("***Click Supplement continue***");
		screenshotUtil.captureScreenshot(className,"Click Supplement continue");
		fleetpage.enterAccountNo(excelutil.getCellData("PreSetup","AccountNumber",readRowNo));
		commonobjects.clickProceed(); 
		log.info(commonobjects.validateInfoMsgs());
		String actualmessage = commonobjects.fetchErrorMessage(expSucces);
		try {
			Assert.assertEquals(actualmessage, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Fleet Screen"+ expSucces);
		log.info("Message in Fleet Screen"+commonobjects.fetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot(className,"Message in Fleet Screen");
	}

	@Then("User will navigate to payment tab and fill the requirement")
	public void user_will_navigate_to_payment_tab_and_fill_the_requirement() throws Exception, Exception {

		log.info(commonobjects.validateInfoMsgs());
		paymenttab.clickVerifyAddToCart();

		log.info("***Verify Cart***");
		screenshotUtil.captureScreenshot(className,"Verify Cart");
		pay.clickPayNow();  

		log.info("***Click Paynow***");
		screenshotUtil.captureScreenshot(className,"Click Paynow");
		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());
		//Fetch Values from 
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",pay.fetchMCECustomerIdLbl(),writeRowNo,pay.fetchMCECustomerId());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",pay.fetchMCECustomerId(),writeRowNo,pay.fetchLegalName());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",pay.fetchInvoiceDateLbl(),writeRowNo,pay.fetchInvoiceDate());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",pay.fetchEnterpriseSystemCreditLbl(),writeRowNo,pay.fetchEnterpriseSystemCredit());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",pay.fetchIRPSystemCreditLbl(),writeRowNo,pay.fetchIRPSystemCredit());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",pay.fetchIftaSystemCreditLbl(),writeRowNo,pay.fetchIftaSystemCredit());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",pay.fetchOpaSystemCreditLbl(),writeRowNo,pay.fetchOpaSystemCredit());
		excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",pay.fetchTotalAmountDueLbl(),writeRowNo,pay.fetchTotalAmountDue());

		ArrayList<String> TableHeadervalues=pay.fetchTableHeaders();
		ArrayList<String> Table_Invoice=pay.FetchTable_InvoiceDetails();
		for(int i=0;i<Table_Invoice.size();i++) {
			excelutilWrite.setCellData(config.writeRwcExcel(),"PaymentScreen",TableHeadervalues.get(i),writeRowNo,Table_Invoice.get(i));
		}

		paymenttab.clickPaymenToAdd();
		for(int i=0; i<2;i++) {

			String PaymentType=excelutil.getCellData("Payment","PaymentType"+i,readRowNo);
			String PaymentNumberValue=excelutil.getCellData("Payment","PaymentChequeNo",readRowNo);
			pay.selectPaymentType(i,PaymentType);	
			log.info("***Payment Type***");
			screenshotUtil.captureScreenshot(className,"Payment Type"+i);


			pay.enterpaymentNoBasedonType(i,PaymentType,PaymentNumberValue);
			log.info("***Payment Number based on Payment Type***");
			screenshotUtil.captureScreenshot(className,"Payment Number based on  Payment Type"+i);

			String totalAmount=pay.FetchTotalAmount();
			log.info("totalAmount is "+totalAmount);
			String cashAmount=String.format("%.2f",(Double.valueOf(totalAmount)/2));

			if(i==0) {
				pay.enterPaymentAmountBasedonType(i,PaymentType,cashAmount);
			}

			if(i==1) {
				String RemainingAmount=pay.fetchRemainingBalance();
				pay.enterPaymentAmountBasedonType(i,PaymentType,RemainingAmount);
			}
			log.info("***Payment Amount based on Payment Type***");
			screenshotUtil.captureScreenshot(className,"Payment Amount based on  Payment Type"+i);

		}

		pay.selectPaymentReceipt(excelutil.getCellData("Payment","Payment receipt",readRowNo));
		log.info("***Enter Payment type and amount***");
		String mainwidow=eleutil.GetParentWindow();
		commonobjects.clickProceed();
		commonobjects.waitForSpinner();
		commonobjects.clickProceed();
		commonobjects.waitForSpinner();

		log.info(commonobjects.validateInfoMsgs());
		eleutil.waitForTwoWindow(2);
		String childWindow=eleutil.SwitchtoFirstChildWindow();
		eleutil.saveAsFile();
		String fileLocation=System.getProperty("user.dir")+"\\"+config.readDownloadFolder();
		log.info("fileLocation"+fileLocation);
		String DesiredPath=eleutil.checkFileExistence(fileLocation,"Payment","pdf");
		eleutil.sleepTime(4000);  //to wait for the PDF Load completely
		eleutil.uploadFile(DesiredPath);
		eleutil.sleepTime(4000); //to display the file upload is completed

		eleutil.closeSpecificWindow(childWindow);
		eleutil.SwitchSpecificWindow(mainwidow);
	}
	@Then("user will validate message {string} {string}")
	public void user_will_validate_message(String expSucces, String expSucces2) throws Exception {
		String actualmessage = commonobjects.fetchErrorMessage(expSucces);
		try {
			Assert.assertEquals(actualmessage, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}

		CommonStep.scenario.log("Message in Payment Screen "+ expSucces);

		log.info("Message in Payment Screen "+commonobjects.fetchErrorMessage(expSucces));
		screenshotUtil.captureScreenshot(className,"Message in Payment Screen 1");

		String actualmessage1 = commonobjects.fetchErrorMessage(expSucces2);
		try {
			Assert.assertEquals(actualmessage1, expSucces2);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Payment Screen "+ expSucces2);
		log.info("Message in Payment Screen "+commonobjects.fetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot(className,"Message in Payment Screen 2");
	}

	@Then("User navigate to inventory tab to input the data and validate the message {string} {string}")
	public void user_navigate_to_inventory_tab_to_input_the_data_and_validate_the_message(String expSucces, String expSucces2) throws Exception {
		inventorypage.clickOperation();
		inventorypage.clickOnInventory();
		inventorypage.clickNewInventory();
		log.info("***Click Inventory***");
		screenshotUtil.captureScreenshot(className,"Click Inventory");
		log.info(commonobjects.validateInfoMsgs());
		inventorypage.selectNewInventoryType(excelutil.getCellData("InventoryTab","Inventory_Newintype",readRowNo));
		String actualmessage = commonobjects.fetchErrorMessage(expSucces);
		try {
			Assert.assertEquals(actualmessage, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Inventory Screen"+ expSucces);


		log.info("Message in Inventory Screen"+commonobjects.fetchErrorMessage(expSucces));

		screenshotUtil.captureScreenshot(className,"Message in Inventory Screen");

		inventorypage.selectNewSubInventoryType(excelutil.getCellData("InventoryTab","Inventory_Subtype",readRowNo));

		inventorypage.enterFromNo(excelutil.getCellData("InventoryTab","FromNo",readRowNo)); //modify

		inventorypage.enterQuantity(excelutil.getCellData("InventoryTab","Quantity",readRowNo));

		inventorypage.enterYear(excelutil.getCellData("InventoryTab","Year",readRowNo));


		log.info("***Enter details for new inventory***");
		screenshotUtil.captureScreenshot(className,"Enter details for new inventory");
		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());
		String actualmessage2 = commonobjects.fetchErrorMessage(expSucces2);
		try {
			Assert.assertEquals(actualmessage2, expSucces2);

		}
		catch(Throwable e) {
			error.addError(e);
		}

		CommonStep.scenario.log("Message in Payment Screen"+ expSucces2);

		log.info("Message in Payment Screen"+commonobjects.fetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot(className,"Message in Inventory Screen 2");
		commonobjects.clickQuit();
	}
	@Then("Assign the inventory to proceed further {string} {string}")
	public void assign_the_inventory_to_proceed_further(String expSucces, String expSucces2) throws Exception, Exception {

		inventorypage.clickAssignInventory();
		log.info(commonobjects.validateInfoMsgs());
		inventorypage.selectNewInventoryType(excelutil.getCellData("InventoryTab","Inventory_Newintype",readRowNo));
		String actualmessage = commonobjects.fetchErrorMessage(expSucces);
		try {
			Assert.assertEquals(actualmessage, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Inventory Screen "+ expSucces);

		log.info("Message in Inventory Screen "+commonobjects.fetchErrorMessage(expSucces));

		screenshotUtil.captureScreenshot(className,"Message in Inventory Screen 1");

		inventorypage.selectNewSubInventoryType(excelutil.getCellData("InventoryTab","Inventory_Subtype",readRowNo));

		inventorypage.enterFromNo(excelutil.getCellData("InventoryTab","FromNo",readRowNo)); //modify

		inventorypage.enterQuantity(excelutil.getCellData("InventoryTab","Quantity",readRowNo));

		inventorypage.enterYear(excelutil.getCellData("InventoryTab","Year",readRowNo));

		log.info("***Enter details in Assign Inventory***");
		screenshotUtil.captureScreenshot(className,"Enter details in Assign Inventory");

		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());
		String actualmessage2 = commonobjects.fetchErrorMessage(expSucces2);
		try {
			Assert.assertEquals(actualmessage2, expSucces2);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Inventory Screen"+ expSucces2);

		log.info("Message in Inventory Screen"+commonobjects.fetchErrorMessage(expSucces2));
		screenshotUtil.captureScreenshot(className,"Message in Inventory Screen 2");


		commonobjects.clickQuit();
	}

	@Then("user navigate to post payment for 2nd installment payment and fill the data and validate the message {string} {string}")
	public void user_navigate_to_post_payment_for_2nd_installment_payment_and_fill_the_data_and_validate_the_message(String expSucces, String expSucces2) throws Exception {


		financepage.clickfinance();

		financepage.clickpostpayment();
		log.info(commonobjects.validateInfoMsgs());
		financepage.enterMCEid(excelutil.getCellData("PreSetup","MCENumber",readRowNo));

		financepage.clicksearch();

		financepage.clickoncartid();

		financepage.clickservice();

		financepage.clickIRP();

		financepage.clickinstallmentpayment();

		financepage.clickandenterAccountNo(excelutil.getCellData("PreSetup","AccountNumber",readRowNo));

		financepage.clickandenterfleet(excelutil.getCellData("PreSetup","FleetNumber",readRowNo));

		financepage.clickandenterfleetyear(excelutil.getCellData("PreSetup","Vehicle and Installment Fleet Expiration Year",readRowNo));

		commonobjects.clickProceed();

		financepage.clickgrid();

		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());
		financepage.selectpaymenttype(excelutil.getCellData("Payment","PaymentType0",readRowNo));

		String totalAmount=pay.FetchTotalAmount();

		financepage.entercashamount(totalAmount);

		pay.selectPaymentReceipt(excelutil.getCellData("Payment","Payment receipt",readRowNo));

		log.info("Enter the details in installement payment and proceed");
		screenshotUtil.captureScreenshot(className,"Enter the details in installement payment and proceed");

		commonobjects.clickProceed();

		commonobjects.clickProceed();
		log.info(commonobjects.validateInfoMsgs());
		String actualmessage = commonobjects.fetchErrorMessage(expSucces);
		try {
			Assert.assertEquals(actualmessage, expSucces);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in post Payment Screen"+ expSucces);

		log.info("Message in post Payment Screen"+commonobjects.fetchErrorMessage(expSucces));

		screenshotUtil.captureScreenshot(className,"Message in post Payment Screen 1");

		String actualmessage1 = commonobjects.fetchErrorMessage(expSucces2);

		try {
			Assert.assertEquals(actualmessage1, expSucces2);
		}
		catch(Throwable e) {
			error.addError(e);
		}
		CommonStep.scenario.log("Message in Post Payment Screen "+ expSucces2);

		log.info("Message in Post Payment Screen "+commonobjects.fetchErrorMessage(expSucces2));

		screenshotUtil.captureScreenshot(className,"Message in post Payment Screen 2");

	}


}


