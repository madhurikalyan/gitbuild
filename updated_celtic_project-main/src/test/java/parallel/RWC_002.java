package parallel;


import java.io.IOException;
import com.celtic.automation.cmcs.factory.DriverFactory;
import com.celtic.automation.cmcs.pages.AccountTabPage;
import com.celtic.automation.cmcs.pages.BillingTab;
import com.celtic.automation.cmcs.pages.CommonObjects;
import com.celtic.automation.cmcs.pages.DashBoardPage;
import com.celtic.automation.cmcs.pages.DistanceTabPage;
import com.celtic.automation.cmcs.pages.Financepage;
import com.celtic.automation.cmcs.pages.FleetPage;
import com.celtic.automation.cmcs.pages.FleetTabPage;
import com.celtic.automation.cmcs.pages.InstallmentPage;
import com.celtic.automation.cmcs.pages.InventoryPage;
import com.celtic.automation.cmcs.pages.LoginPage;
import com.celtic.automation.cmcs.pages.Payment;
import com.celtic.automation.cmcs.pages.PaymentTab;
import com.celtic.automation.cmcs.pages.VehicleAdd;
import com.celtic.automation.cmcs.pages.VehicleAmend;
import com.celtic.automation.cmcs.pages.VehicleDelete;
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

import org.apache.log4j.Logger;
import org.junit.rules.ErrorCollector;
import org.testng.asserts.SoftAssert;

public class RWC_002 extends DriverFactory {
	 SoftAssert softassert = new SoftAssert();
	 
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
		private InstallmentPage installmentpage = new InstallmentPage(DriverFactory.getDriver());
		private VehicleAdd vehicleadd= new VehicleAdd(DriverFactory.getDriver());
		private Financepage financepage =new Financepage(DriverFactory.getDriver());

		int RowNo=2;

		private ElementUtil eleutil =new ElementUtil();
		private Screenshot_Utility screenshotUtil =new Screenshot_Utility();
		private ConfigReader config=new ConfigReader();
		private Logger log = Logger.getLogger(RWC_001.class); 
		private ReadExcelUtil excelutil=null;
		private WriteExcelUtil excelutilWrite=null;
		private ErrorCollector error = new ErrorCollector();
		String className = this.getClass().getName().split("[.]")[1];
		
		@Given("User login as Internal user")
		public void user_login_as_internal_user() throws Exception {
			excelutil = new ReadExcelUtil(config.readRwcExcel());
			//excelutil.meth(config.readRWCexcel());
			excelutilWrite=new WriteExcelUtil();
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

		@When("User will navigate to IRP")
		public void user_will_navigate_to_irp()  throws Exception {
			dashboardpage.clickIRPLink();
			log.info("*** Click IRP ***");
			screenshotUtil.captureScreenshot(className,"IRP");
			dashboardpage.clickRenewFleetLink();
			log.info("*** Click RenewFleet ***");
			screenshotUtil.captureScreenshot(className,"RenewFleet");
		}

	@Then("User will navigate to renew fleet and search for  Reinstated Account Number")
	public void user_will_navigate_to_renew_fleet_and_search_for_reinstated_account_number()
			throws IOException, Exception {
		fleetpage.enterAccountNo(excelutil.getCellData("PreSetup","AccountNumber",RowNo));
			fleetpage.enterFleetNo(excelutil.getCellData("PreSetup","FleetNumber",RowNo)); //uncomment for full flow
	fleetpage.enterFleetyear(excelutil.getCellData("PreSetup","Fleet Expiration Year",RowNo));//uncomment for full flow
		commonobjects.clickProceed();
		

	}

	@Then("User should navigate to Account screen and provides all the required input to proceed")
	public void user_should_navigate_to_account_screen_and_provides_all_the_required_input_to_proceed()
			throws Exception {
		//Fetch Values
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchMCECustomernolbl(),RowNo,accounttabpage.fetchMCECustomerno());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchRegistrationTypelbl(), RowNo,accounttabpage.fetchRegistrationType());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountCarrierTypeLbl(), RowNo,accounttabpage.fetchAccountCarrierType());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchIFTAAccountNbrlbl(),RowNo,accounttabpage.fetchIFTAAccountNbr());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountCustomerStatusLbl(),RowNo,accounttabpage.fetchAccountCustomerStatus());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountStreet0Lbl(),RowNo,accounttabpage.fetchAccountStreet0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountZip0lbl(),RowNo,accounttabpage.fetchAccountZip0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountJur0lbl(), RowNo,accounttabpage.fetchAccountJur0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountCity0lbl(),RowNo,accounttabpage.fetchAccountCity0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountCounty0lbl(), RowNo,accounttabpage.fetchAccountCounty0());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab1()+accounttabpage.fetchAccountCountry0lbl(),RowNo,accounttabpage.fetchAccountCountry0());

		accounttabpage.clickMailingAddress();
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountStreet1lbl(),RowNo,accounttabpage.fetchAccountStreet1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountZip1lbl(), RowNo,accounttabpage.fetchAccountZip1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountJur1lbl(), RowNo,accounttabpage.fetchAccountJur1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountCity1lbl(),RowNo,accounttabpage.fetchAccountCity1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountCounty1lbl(),RowNo,accounttabpage.fetchAccountCounty1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountCountry1lbl(),RowNo,accounttabpage.fetchAccountCountry1());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountsTab2()+accounttabpage.fetchAccountAttentionTolbl(),RowNo,accounttabpage.fetchAccountAttentionTo());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountUSDOTNolbl(), RowNo,accounttabpage.fetchAccountUSDOTNo());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountTPIDlbl(),RowNo,accounttabpage.fetchAccountTPID());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountContactnamelbl(), RowNo,accounttabpage.fetchAccountContactname());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountEmaillbl(),RowNo,accounttabpage.fetchAccountEmail());

		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountPrimaryPhonelbl(),RowNo,accounttabpage.fetchAccountPrimaryPhone());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountAlternatePhonelbl(), RowNo,accounttabpage.fetchAccountAlternatePhone());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountFaxNolbl(),RowNo,accounttabpage.fetchAccountFaxNo());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountEmailnotificationlbl(), RowNo,accounttabpage.fetchAccountEmailnotification());
		excelutilWrite.setCellData(config.writeRwcExcel(),"Account",accounttabpage.fetchAccountFaxnotificationlbl(),RowNo,accounttabpage.fetchAccountFaxnotification());

		log.info(commonobjects.validateInfoMsgs());
		// In Account Page
		log.info(commonobjects.validateInfoMsgs());
		accounttabpage.checkEmailNotification();
		log.info("*** Check Email Notification ***");
		screenshotUtil.captureScreenshot(className,"Check EmailNotification");
		commonobjects.provideComments(excelutil.getCellData("AccountTab","Comments",RowNo));
		log.info("*** Enter Comments ***");
		screenshotUtil.captureScreenshot(className,"Enter Comments in Account Section");

		//commonobjects.clickProceed();
	
	}

	@Then("user should navigate to Account verification screen and proceed further")
	public void user_should_navigate_to_account_verification_screen_and_proceed_further() throws InterruptedException {
		// In Account Verification Screen
		commonobjects.clickProceed();
	}

	@Then("user should navigate to Fleet  screen and update Fleet Expiration Date & Fleet Type & Commodity Class and proceed further")
	public void user_should_navigate_to_fleet_screen_and_update_fleet_expiration_date_fleet_type_commodity_class_and_proceed_further()
			throws IOException, Exception {
		//Fetch Fleet Details screen 
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchRegistrationtypelbl(), RowNo,fleettabpage.fetchRegistrationtype());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchfltstatuslbl(),RowNo,fleettabpage.fetchfltstatus());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchcarriertypelbl(), RowNo,fleettabpage.fetchcarriertype());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchDBANamelbl(),RowNo, fleettabpage.fetchDBAName());

				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetStreet0Lbl(),RowNo,fleettabpage.fleetStreet0());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetZip0Lbl(),RowNo,fleettabpage.fleetZip0());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetJur0Lbl(), RowNo,fleettabpage.fleetJur0());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetCity0Lbl(),RowNo, fleettabpage.fleetCity0());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetCounty0Lbl(), RowNo,fleettabpage.fleetCounty0());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetCountry0Lbl(),RowNo,fleettabpage.FleetCountry0());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.fleetNonDeliverable0Lbl(), RowNo,fleettabpage.fleetNonDeliverable0());

				fleettabpage.clickMailingAddress();
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetStreet1Lbl(),RowNo,fleettabpage.fleetStreet1());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetZip1Lbl(),RowNo,fleettabpage.fleetZip1());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetJur1Lbl(), RowNo,fleettabpage.fleetJur1());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetCity1Lbl(),RowNo, fleettabpage.FleetCity1());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetCounty1Lbl(), RowNo,fleettabpage.fleetCounty1());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetCountry1Lbl(),RowNo,fleettabpage.fleetCountry1());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetNonDeliverable1Lbl(), RowNo,fleettabpage.fleetNonDeliverable1());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.fleetAttentionToLbl(), RowNo,fleettabpage.fleetAttentionTO());

				fleettabpage.navigateToServiceProvider();
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceProviderLbl(), RowNo,fleettabpage.fleetServiceProvider());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceLegalNameLbl(),RowNo,fleettabpage.fleetServiceLegalName());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceDBANameLbl(), RowNo,fleettabpage.fleetServiceDBAName());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServicePowerOfAttroneyLbl(),RowNo, fleettabpage.fleetServicePowerOfAttroney());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServicePowerOfAttroneyEffDateLbl(), RowNo,fleettabpage.fleetServicePowerOfAttroneyEffDate());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServicePowerOfAttroneyExpDateLbl(),RowNo,fleettabpage.fleetServicePowerOfAttroneyExpDate());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceEmailIdLbl(), RowNo,fleettabpage.fleetServiceEmailId());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServicePhoneNoLbl(),RowNo, fleettabpage.fleetServicePhoneNo());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceFaxNoLbl(), RowNo,fleettabpage.fleetServiceFaxNo());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceStreetLbl(),RowNo,fleettabpage.fleetServiceStreet());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceCityLbl(), RowNo,fleettabpage.fleetServiceCity());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceJurLbl(),RowNo, fleettabpage.fleetServiceJur());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceZipCodeLbl(), RowNo,fleettabpage.fleetServiceZipCode());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.fleetServiceCountryLbl(),RowNo,fleettabpage.fleetServiceCountry());

				fleettabpage.clickOnTimeMailingAddress();
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingStreetLbl(), RowNo,fleettabpage.fleetServiceMailingStreet());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingZipCodeLbl(),RowNo, fleettabpage.fleetServiceMailingZipCode());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingJurLbl(), RowNo,fleettabpage.fleetServiceMailingJur());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingCityLbl(),RowNo,fleettabpage.fleetServiceMailingCity());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingCountyLbl(), RowNo,fleettabpage.fleetServiceMailingCounty());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingCountryLbl(),RowNo, fleettabpage.fleetServiceMailingCountry());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.fleetServiceMailingAttentionToLbl(), RowNo,fleettabpage.fleetServiceMailingAttentionTo());

				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsContactNameLbl(),RowNo,fleettabpage.fleetDetailsContactName());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsEmailIdLbl(), RowNo,fleettabpage.fleetDetailsEmailId());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsPrimaryCellNbrLbl(),RowNo, fleettabpage.fleetDetailsPrimaryCellNbr());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsAlternateCellNbrLbl(), RowNo,fleettabpage.fleetDetailsAlternateCellNbr());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFaxNoLbl(),RowNo, fleettabpage.fleetDetailsFaxNo());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsTpIdLbl(), RowNo,fleettabpage.fleetDetailsTPID());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsUsdotNbrLbl(),RowNo,fleettabpage.fleetDetailsUsdotNbr());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsChangeVehUsdotTinLbl(), RowNo,fleettabpage.fleetDetailsChangeVehUsdotTin());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFltTypeLbl(),RowNo, fleettabpage.fleetDetailsFltType());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsCommodityClassLbl(), RowNo,fleettabpage.fleetDetailsCommodityClass());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFltEffDateLbl(),RowNo,fleettabpage.fleetDetailsFltEffDatedtPicker());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFltExpDateLbl(), RowNo,fleettabpage.fleetDetailsFltExpDate());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsChangeAddrOnUsdotLbl(),RowNo, fleettabpage.fleetDetailsChangeAddrOnUsdot());

				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsFirstOperatedDateLbl(),RowNo,fleettabpage.fleetDetailsFirstOperatedDate());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsWyomingIndicatorLbl(), RowNo,fleettabpage.fleetDetailsWyomingIndicator());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsIFTADistanceLbl(),RowNo, fleettabpage.fleetDetailsIFTADistance());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsMobileNotificationLbl(), RowNo,fleettabpage.fleetDetailsMobileNotification());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsIRPRequirementsLbl(),RowNo, fleettabpage.fleetDetailsIRPRequirements());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsStatementOfUnderstandingLbl(), RowNo,fleettabpage.fleetDetailsStatementOfUnderstanding());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsInstallmentAgreementLbl(),RowNo,fleettabpage.fleetDetailsInstallmentAgreement());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsPowerOfAttorneyLbl(), RowNo,fleettabpage.fleetDetailsPowerOfAttorney());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsHVUTFormLbl(),RowNo, fleettabpage.fleetDetailsHVUTForm());
				excelutilWrite.setCellData(config.writeRwcExcel(),"Fleet",fleettabpage.fleetDetailsPropertyTaxLbl(), RowNo,fleettabpage.fleetDetailsPropertyTax());

		fleettabpage.navigateToServiceProvider();

		fleettabpage.clickPowerOfAttroney();

		fleettabpage.enterEmailID(excelutil.getCellData("FleetTab","Email iD",RowNo));

		fleettabpage.enterContactName(excelutil.getCellData("FleetTab","Contact Name",RowNo));

		fleettabpage.enterprimaryPhone(excelutil.getCellData("FleetTab","Primary Phone",RowNo));

		fleettabpage.selectFleetType(excelutil.getCellData("FleetTab","Fleet type",RowNo));

		fleettabpage
				.selectCommodityClass(excelutil.getCellData("FleetTab","Commodity Class",RowNo));

		fleettabpage
				.selectEffectiveDate(excelutil.getCellData("FleetTab","Effective Date",RowNo));

		fleettabpage
				.selectExpirationDate(excelutil.getCellData("FleetTab","Expiration Date",RowNo));

		fleettabpage.selectFirstOperatedDate(excelutil.getCellData("FleetTab","First Operated Date",RowNo));

		// Collecting Documents only for Power Of Attorney
		fleettabpage
				.selectPowerOfAttroney(excelutil.getCellData("FleetTab","Power of Attorney",RowNo));

		commonobjects.provideComments(excelutil.getCellData("FleetTab","Comments",RowNo));
		
		commonobjects.clickProceed();
	}

	@Then("user should navigate to Fleet verification screen and proceed further")
	public void user_should_navigate_to_fleet_verification_screen_and_proceed_further() throws Exception {

		// Fleet Verification Screen
		commonobjects.clickProceed();
	}

/*	@Then("user should land on Distance screen and select Estimated Distance and proceed further")
	public void user_should_land_on_distance_screen_and_select_estimated_distance_and_proceed_further()
			throws IOException, Exception {
		
		  eleutil.updateExcel("Distance",0,0,distancetabpage.DistanceReportingPeriodFromlbl()); 
		  eleutil.updateExcel("Distance",1,0,distancetabpage.DistanceReportingPeriodFrom ()); 
		  eleutil.updateExcel("Distance",0,1,distancetabpage.DistanceReportingPeriodTolbl ()); 
		  eleutil.updateExcel("Distance",1,1,distancetabpage.DistanceReportingPeriodTo()); 
		  eleutil.updateExcel("Distance",0,2,distancetabpage.DistanceUsdotNbrlbl());
		  eleutil.updateExcel("Distance",1,2,distancetabpage.DistanceUsdotNbr()); 
		  eleutil.updateExcel("Distance",0,3,distancetabpage.DistanceEstimatedDistanceChartlbl()); 
		  eleutil.updateExcel("Distance",1,3,distancetabpage.DistanceEstimatedDistanceChart()); 
		  eleutil.updateExcel("Distance",0,4,distancetabpage.DistanceOverrideContJurlbl ()); 
		  eleutil.updateExcel("Distance",1,4,distancetabpage.DistanceOverrideContJur()); 
		  
		  eleutil.updateExcel("Distance",0,5,distancetabpage.DistanceEstimatedDistancelbl());
		  eleutil.updateExcel("Distance",1,5,distancetabpage.DistanceEstimatedDistance());
		  eleutil.updateExcel("Distance",0,6,distancetabpage.DistanceActualDistancelbl()); 
		  eleutil.updateExcel("Distance",1,6,distancetabpage.DistanceActualDistance()); 
		  
		  eleutil.updateExcel("Distance",0,7,distancetabpage.DistanceTotalFleetDistancelbl()); 
		  eleutil.updateExcel("Distance",1,7,distancetabpage.DistanceTotalFleetDistance()); 
		  
		  eleutil.updateExcel("Distance",0,8,distancetabpage.DistanceFRPMlgQuetionlbl());
		  eleutil.updateExcel("Distance",1,8,distancetabpage.DistanceFRPMlgQuetion());
		  eleutil.updateExcel("Distance",0,9,distancetabpage.DistanceDistanceTypelbl());
		  eleutil.updateExcel("Distance",1,9,distancetabpage.DistanceDistanceType());
		  eleutil.updateExcel("Distance",0,10,distancetabpage.DistanceActualDistConfirmationlbl());
		  eleutil.updateExcel("Distance",1,10,distancetabpage.DistanceActualDistConfirmation());
		 
		//Juris Table Verification
	     	//Juris Table header
	     	ArrayList<String> TableHeadervalues=distancetabpage.FetchTableHeader();
	    	for(int i=0;i<TableHeadervalues.size();i++) {
	    		eleutil.updateExcel("Distance_Juris",0,i,TableHeadervalues.get(i));
	    	}
	    	//Juris list
	    	ArrayList<String>  Juris_values=distancetabpage.FetchTable_Juris();
	    	ArrayList<String>  Distance_values=distancetabpage.FetchTable_DistanceMiles();
	    	ArrayList<String>  Percent_values=distancetabpage.FetchTable_Percent();
	    	int j=0;
	     	for(int i=0;i<Juris_values.size();i++) {
	     		
	     	eleutil.updateExcel("Distance_Juris", 1,i+j,Juris_values.get(i));  //0 0 13
	     	j++; 
	     	eleutil.updateExcel("Distance_Juris", 1,i+j,Distance_values.get(i)); //01 14
	     	j++;
	     	eleutil.updateExcel("Distance_Juris", 1,i+j,Percent_values.get(i)); //02 15
	     	
	     	}
	     	
		distancetabpage.selectYesOrNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "DistanceTab", 2, 4));
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "DistanceTab", 2, 2));
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		commonobjects.clickProceed();

	}

	@Then("user should navigate to Distance verification screen and proceed further")
	public void user_should_navigate_to_distance_verification_screen_and_proceed_further() throws InterruptedException {
		// Distance Verification Screen
		commonobjects.clickProceed();
	}

	@Then("user should land on the Weight Group screen and go for Add Weight group")
	public void user_should_land_on_the_weight_group_screen_and_go_for_add_weight_group()
			throws IOException, Exception {
		
		//Fetch Values into Excel
		ArrayList<String>  headervalues=wgtgroup.FetchTableHeader();
		for(int i=0;i<headervalues.size();i++) {
			eleutil.updateExcel("WeightGroup",0,i,headervalues.get(i));
		}
		ArrayList<String>  RowDatavalues=wgtgroup.FetchTableRowData();
		for(int i=0;i<RowDatavalues.size();i++) {
			eleutil.updateExcel("WeightGroup",1,i,RowDatavalues.get(i));
		}
		
		// Weight Group
		wgtgroup.clickAddWeightGroup();
		wgtgroupadd.selectWeightGroupType(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 0));
		wgtgroupadd.enterWeightGroupNo(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 1));
		wgtgroupadd.selectMaxGrossWeight(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 2));
		commonobjects.clickProceed();
		commonobjects.clickProceed();
	}

	@Then("user should land on the Add Weight Group screen and provide all the required input to proceed")
	public void user_should_land_on_the_add_weight_group_screen_and_provide_all_the_required_input_to_proceed()
			throws IOException, Exception {
		// Weight Group
		wgtgroup.clickAddWeightGroup();
		wgtgroupadd.selectWeightGroupType(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 8));
		wgtgroupadd.enterWeightGroupNo(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 9));
		wgtgroupadd.selectMaxGrossWeight(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 10));
		commonobjects.clickProceed();
		commonobjects.clickProceed();
	}

	@Then("user should land on the Add Weight Group Verification screen and go for  Weight group")
	public void user_should_land_on_the_add_weight_group_verification_screen_and_go_for_weight_group()
			throws IOException, Exception {
		// Add Weight Group verification Screen
		// Weight Group
		wgtgroup.clickAddWeightGroup();
		wgtgroupadd.selectWeightGroupType(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 11));
		wgtgroupadd.enterWeightGroupNo(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 12));
		wgtgroupadd.selectMaxGrossWeight(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 13));
		commonobjects.clickProceed();
		commonobjects.clickProceed();
	}

	@Then("user should land on the Weight Group and edit the existing weight group to proceed to Vehicle screen")
	public void user_should_land_on_the_weight_group_and_edit_the_existing_weight_group_to_proceed_to_vehicle_screen()
			throws IOException, Exception {
		// Edit Existing Weight Group
		wgtgroup.clickHandimg();
		String Juri_ExcelCount = ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 4);
		for (int i = 0; i < Integer.valueOf(Juri_ExcelCount); i++) {
			String Juri_Excel = ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab",2, i + 5);
			wgtgroupadd.enterWeight_JuriValue(Juri_Excel);
		}
		commonobjects.clickProceed();
		
		// Weight Group Verification Screen
		commonobjects.clickProceed();
		// Validating JUR WITH DIFFERENT WEIGHTS
		String[] weightlist = wgtgroup.validateJurisWeightsedited(); // [AL, AR, AZ]
		for (int i = 0; i < Integer.valueOf(Juri_ExcelCount); i++) {
			String Juri_Excel = ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab",2, i + 5);
			if (weightlist[i].equalsIgnoreCase(Juri_Excel)) {
				assert true;
			}
		}
		// In Weight Group Screen
		commonobjects.clickDonebtn();
	}

	@Then("user should land on the Vehicle Screen and")
	public void user_should_land_on_the_vehicle_screen_and() throws IOException, Exception {
		//Fetch values from Vehicle screen
		  eleutil.updateExcel("VehicleTab",0,0,Vehicletabpage.FetchAmendVehiclelbl()); 
		  eleutil.updateExcel("VehicleTab",1,0,Vehicletabpage.FetchAmendVehicle ()); 
		  eleutil.updateExcel("VehicleTab",0,1,Vehicletabpage.FetchAddVehicleslbl ()); 
		  eleutil.updateExcel("VehicleTab",1,1,Vehicletabpage.FetchAddVehicles()); 
		  eleutil.updateExcel("VehicleTab",0,2,Vehicletabpage.FetchdeleteVehiclelbl());
		  eleutil.updateExcel("VehicleTab",1,2,Vehicletabpage.FetchdeleteVehicle()); 
		  eleutil.updateExcel("VehicleTab",0,3,Vehicletabpage.FetchRenewVehiclelbl()); 
		  eleutil.updateExcel("VehicleTab",1,3,Vehicletabpage.FetchRenewVehicle());  
		
		  //Perform Actions
		Vehicletabpage.clickAddVehicleRadioButton();
		commonobjects.clickProceed();
		int AddVehiclesCount_Excel=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,0));
		int j=0;
		for(int i=1;i<=AddVehiclesCount_Excel;i++) {
		vehicleadd.enterVINNumber(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,1+j));
		vehicleadd.clickSearch();
		vehicleadd.selectBodyType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,3+j));
		vehicleadd.enterDetailsUnitNumber(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 2+j));
		vehicleadd.selectWeightGroupNumber(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 4+j));
		vehicleadd.enterYear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,5+j));
		vehicleadd.selectMake(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,6+j));
		vehicleadd.enterAxle(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,7+j));
		vehicleadd
				.enterUnladenWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,11+j));
		vehicleadd.enterseats(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 9+j));
		vehicleadd.selectColor(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,10+j));
		vehicleadd.EmptyenterPurchaseDate(eleutil.getDateInSpecifiedFormat("MMddYYYY",-1));
		vehicleadd.EmptyenterInStateExpirationDate(eleutil.getDateInSpecifiedFormat("MMddYYYY",1));
		vehicleadd.enterPurchaseprice(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 12+j));
		vehicleadd
				.enterFactoryPrice(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 13+j));
		vehicleadd.checkTVR();
		vehicleadd.enterTVRDays(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 14+j));
		vehicleadd.selectTitleJurisdiction(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 15+j));
		vehicleadd.enterTitleNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 16+j));
		vehicleadd.checkExistingPlate();
		vehicleadd.enterExistingPlate(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 25+j));
		vehicleadd
				.enterInStatePlate(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 19+j));
		vehicleadd.selectInStatePlateType(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 17+j));
		vehicleadd.enterInStatePlateWeight(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 18+j));
		vehicleadd.selectSafetyChange(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 24+j));
		vehicleadd.checkGradeCrossingFee();
		vehicleadd.checkBicenetenniall();
		vehicleadd.enterInStateFee(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 20+j));
		vehicleadd.selectAffidavitDoc(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2, 35+j));
		commonobjects.clickProceed();
		commonobjects.clickProceed();
		j+=35;
		}
		commonobjects.clickDonebtn();

		// Update Vehicle
		Vehicletabpage.clickVehicleList();
		vehicleadd.UpdatevehiclelistUnit(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2,0));
		vehicleadd.Updatevehiclelistsearch();
		vehicleadd.Updatevehiclelistselectunit();
		vehicleadd.selectTitleJurisdiction( 
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2, 1)); //AB - ALBERTA

		vehicleadd.EmptyenterInStateExpirationDate(eleutil.getDateInSpecifiedFormat("MMddYYYY",2));
		vehicleadd
				.enterInStatePlate(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2, 2));
		vehicleadd.enterInStateFee(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2,3));
		vehicleadd.selectInStatePlateType(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2, 4));
		vehicleadd.enterInStatePlateWeight(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2, 5));
		vehicleadd.selectSafetyChange(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2, 6)); //O - Owner
		commonobjects.clickProceed();
		commonobjects.clickProceed();
		
		commonobjects.clickDonebtn();
		//Delete Vehicle
		Vehicletabpage.clickVehicleList();
		vehicleadd.UpdatevehiclelistUnit(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2,0)); //1
		vehicleadd.Updatevehiclelistsearch();
		vehicleadd.Updatevehiclelistselectunit();
		vehicleadd.CancelVehicle();
		eleutil.handleAlert();
		commonobjects.clickDonebtn();
	}

	@Then("user should land on the Billing screen with open status and Request for TVR & set Delivery Type as PDF with Comments")
	public void user_should_land_on_the_billing_screen_with_open_status_and_request_for_tvr_set_delivery_type_as_pdf_with_comments()
			throws Exception, Throwable {
		 eleutil.updateExcel("Billing",0,0,billingtab.fetchRegisterMonthlbl());
		 eleutil.updateExcel("Billing",1,0,billingtab.fetchRegisterMonth()); 
		  eleutil.updateExcel("Billing",0,1,billingtab.fetchNoOfVehiclesinSupplbl()); 
		  eleutil.updateExcel("Billing",1,1,billingtab.fetchNoOfVehiclesinSupp()); 
		  eleutil.updateExcel("Billing",0,2,billingtab.fetchSupplementStatuslbl());
		  eleutil.updateExcel("Billing",1,2,billingtab.fetchSupplementStatus()); 
		  eleutil.updateExcel("Billing",0,3,billingtab.fetchEnterpriseSystemCreditlbl()); 
		  eleutil.updateExcel("Billing",1,3,billingtab.fetchEnterpriseSystemCredit ()); 
		  eleutil.updateExcel("Billing",0,4,billingtab.fetchIRPSystemCreditlbl ()); 
		  eleutil.updateExcel("Billing",1,4,billingtab.fetchIRPSystemCredit()); 
		  eleutil.updateExcel("Billing",0,5,billingtab.fetchRenewalFeeEffectiveDatelbl());
		  eleutil.updateExcel("Billing",1,5,billingtab.fetchRenewalFeeEffectiveDate());
		  eleutil.updateExcel("Billing",0,6,billingtab.fetchInvoiceDatelbl()); 
		  eleutil.updateExcel("Billing",1,6,billingtab.fetchInvoiceDate()); 		  
		  eleutil.updateExcel("Billing",0,7,billingtab.fetchApplicationReceiptDatelbl()); 
		  eleutil.updateExcel("Billing",1,7,billingtab.fetchApplicationReceiptDate()); 
		  eleutil.updateExcel("Billing",0,8,billingtab.fetchPaymentDatelbl());
		  eleutil.updateExcel("Billing",1,8,billingtab.fetchPaymentDate());
		  eleutil.updateExcel("Billing",0,9,billingtab.fetchExchangeRatelbl());
		  eleutil.updateExcel("Billing",1,9,billingtab.fetchExchangeRate());
		  
		  eleutil.updateExcel("Billing",0,10,billingtab.fetchManualAdjBaseJurlbl());
		  eleutil.updateExcel("Billing",1,10,billingtab.fetchManualAdjBaseJur());
		  eleutil.updateExcel("Billing",0,11,billingtab.fetchBilling_BatchBillinglbl());
		  eleutil.updateExcel("Billing",1,11,billingtab.fetchBilling_BatchBilling());
		  eleutil.updateExcel("Billing",0,12,billingtab.fetchBilling_TVRlbl());
		  eleutil.updateExcel("Billing",1,12,billingtab.fetchBilling_TVR());
		  eleutil.updateExcel("Billing",0,13,billingtab.fetchBilling_InstallmentPlanlbl());
		  eleutil.updateExcel("Billing",1,13,billingtab.fetchBilling_InstallmentPlan());
		  eleutil.updateExcel("Billing",0,14,billingtab.fetchBilling_IsUseOneTimeMailinglbl());
		  eleutil.updateExcel("Billing",1,14,billingtab.fetchBilling_IsUseOneTimeMailing());
		  eleutil.updateExcel("Billing",0,16,billingtab.fetchElectronicDeliveryTypelbl());
		  eleutil.updateExcel("Billing",1,16,billingtab.fetchElectronicDeliveryType());
		  eleutil.updateExcel("Billing",0,17,"Email");
		  eleutil.updateExcel("Billing",1,17,billingtab.fetchBilling_Email());
		  eleutil.updateExcel("Billing",0,18,billingtab.FetchInvoiceReportTypelbl());
		  eleutil.updateExcel("Billing",1,18,billingtab.fetchBilling_InvoiceReportType());
		  
		  ArrayList<String> TableHeadervalues=billingtab.FetchTable_Headers();
	    	for(int i=0;i<TableHeadervalues.size();i++) {
	    		eleutil.updateExcel("Billing",0,i+19,TableHeadervalues.get(i));
	    	}

		  ArrayList<String> TableFeeType=billingtab.FetchTable_FeeType();
		  ArrayList<String> TableFeeAmount=billingtab.FetchTable_FeeAmount();
	    	int j=19;
		  for(int i=0;i<TableFeeType.size();i++) {
	    		eleutil.updateExcel("Billing",1,i+j,TableFeeType.get(i));
	    		j++;
	    		eleutil.updateExcel("Billing",1,i+j,TableFeeAmount.get(i));
	    	}

	    billingtab.clickTVR();
	    eleutil.updateExcel("Billing",0,15,billingtab.fetchBilling_TVRNoOfDayslbl());
		eleutil.updateExcel("Billing",1,15,billingtab.fetchBilling_TVRNoOfDays());
		 
		billingtab.clickInstallmentPlan();
		billingtab.selectElectronicDeliveryType(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "BillingTab",2, 1));
		commonobjects.expandCommentSection();
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "BillingTab",2, 2));
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		commonobjects.clickProceed();
		billingtab.enterManualAdjBaseJur(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",2,0));
		billingtab.clickReCalculate();
		commonobjects.validateErrorMessage(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",2,3));
		billingtab.expandManualAdjReason();
		billingtab.enterManualAdjReasonComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",2,4));
		billingtab.clickManualAdjReasonDeleteAllowed();
		billingtab.clickManualAdjReasonAddorUpdateComments();
		billingtab.clickReCalculate();
		commonobjects.clickProceed();
		//Billing Verification Screen
		eleutil.CloseFirstChildWindow();  //To close PDF Window
		//Payment Tab
		  eleutil.updateExcel("PaymentTab",0,0,paymenttab.FetchEnterpriseSystemCreditlbl());
		  eleutil.updateExcel("PaymentTab",1,0,paymenttab.FetchEnterpriseSystemCredit()); 
		  eleutil.updateExcel("PaymentTab",0,1,paymenttab.FetchIRPSystemCreditlbl()); 
		  eleutil.updateExcel("PaymentTab",1,1,paymenttab.FetchIRPSystemCredit()); 
		  eleutil.updateExcel("PaymentTab",0,2,paymenttab.FetchInvoiceDatelbl());
		  eleutil.updateExcel("PaymentTab",1,2,paymenttab.FetchInvoiceDate()); 
		  eleutil.updateExcel("PaymentTab",0,3,paymenttab.FetchInvoiceNumberlbl()); 
		  eleutil.updateExcel("PaymentTab",1,3,paymenttab.FetchInvoiceNumber ()); 
		  eleutil.updateExcel("PaymentTab",0,4,paymenttab.FetchPaymentReciptDatelbl()); 
		  eleutil.updateExcel("PaymentTab",1,4,paymenttab.FetchPaymentReciptDate()); 
		  eleutil.updateExcel("PaymentTab",0,5,paymenttab.FetchManualAdjBaseJurlbl());
		  eleutil.updateExcel("PaymentTab",1,5,paymenttab.FetchManualAdjBaseJur()); 
		  eleutil.updateExcel("PaymentTab",0,6,paymenttab.FetchBatchCredentiallbl()); 
		  eleutil.updateExcel("PaymentTab",1,6,paymenttab.FetchBatchCredential()); 
		  eleutil.updateExcel("PaymentTab",0,7,paymenttab.FetchWireTransferFeelbl()); 
		  eleutil.updateExcel("PaymentTab",1,7,paymenttab.FetchWireTransferFee()); 
		
		  ArrayList<String> Payment_TableHeadervalues=paymenttab.FetchTable_Headers();
	    	for(int i=0;i<Payment_TableHeadervalues.size();i++) {
	    		eleutil.updateExcel("PaymentTab",0,i+8,Payment_TableHeadervalues.get(i));
	    	}

		  ArrayList<String> Payment_TableFeeType=paymenttab.FetchTable_FeeType();
		  ArrayList<String> Payment_TableFeeAmount=paymenttab.FetchTable_FeeAmount();
	    	int k=8;
		  for(int i=0;i<Payment_TableFeeType.size();i++) {
	    		eleutil.updateExcel("PaymentTab",1,i+k,Payment_TableFeeType.get(i));
	    		k++;
	    		eleutil.updateExcel("PaymentTab",1,i+k,Payment_TableFeeAmount.get(i));
	    	}
	}

	@Then("user should land on the Payment Init Verification screen & click on Pay Now")
	public void user_should_land_on_the_payment_init_verification_screen_click_on_pay_now()
			throws Exception, Exception {
		commonobjects.clickProceed();
		paymenttab.clickPayNow();
			}

	@Then("user should land on the Payment Collection page")
	public void user_should_land_on_the_payment_collection_page() throws IOException, Exception {
		 eleutil.updateExcel("PaymentScreen",0,0,pay.FetchMCECustomerIdlbl());
		  eleutil.updateExcel("PaymentScreen",1,0,pay.FetchMCECustomerId()); 
		  eleutil.updateExcel("PaymentScreen",0,1,pay.FetchlegalNamelbl()); 
		  eleutil.updateExcel("PaymentScreen",1,1,pay.FetchlegalName()); 
		  eleutil.updateExcel("PaymentScreen",0,2,pay.FetchInvoiceDatelbl());
		  eleutil.updateExcel("PaymentScreen",1,2,pay.FetchInvoiceDate()); 
		  eleutil.updateExcel("PaymentScreen",0,3,pay.FetchEnterpriseSystemCreditlbl()); 
		  eleutil.updateExcel("PaymentScreen",1,3,pay.FetchEnterpriseSystemCredit()); 
		  eleutil.updateExcel("PaymentScreen",0,4,pay.FetchIRPSystemCreditlbl()); 
		  eleutil.updateExcel("PaymentScreen",1,4,pay.FetchIRPSystemCredit()); 
		  eleutil.updateExcel("PaymentScreen",0,5,pay.FetchIftaSystemCreditlbl());
		  eleutil.updateExcel("PaymentScreen",1,5,pay.FetchIftaSystemCredit()); 
		  eleutil.updateExcel("PaymentScreen",0,6,pay.FetchOpaSystemCreditlbl());
		  eleutil.updateExcel("PaymentScreen",1,6,pay.FetchOpaSystemCredit());
		  
		  ArrayList<String> TableHeadervalues=pay.FetchTable_Headers();
	    	for(int i=0;i<TableHeadervalues.size();i++) {
	    		eleutil.updateExcel("PaymentScreen",0,i+7,TableHeadervalues.get(i));
	    	}

		  ArrayList<String> Table_Invoice=pay.FetchTable_InvoiceDetails();
		  for(int i=0;i<Table_Invoice.size();i++) {
	    		eleutil.updateExcel("PaymentScreen",1,i+7,Table_Invoice.get(i));
	    	}
		  eleutil.updateExcel("PaymentScreen",0,12,pay.FetchTotalAmountDuelbl());
		  eleutil.updateExcel("PaymentScreen",1,12,pay.FetchTotalAmountDue());
			String paymenttype=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,1);
			String totalAmount=pay.FetchTotalAmount();
			pay.selectPaymentType(0,paymenttype);	
			String PaymentNumberValue=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,0);
			pay.enterpaymentNoBasedonType(0,paymenttype,PaymentNumberValue);
			String cashAmount=String.valueOf(Double.valueOf(totalAmount));
				pay.enterPaymentAmountBasedonType(0,paymenttype,cashAmount);
		pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,3));
		commonobjects.clickProceed();
		//payment Verification Screen
		commonobjects.clickProceed();
		
		eleutil.CloseFirstChildWindow();  //To close PDF Window
		//VehicleDocs
		dashboardpage.clickIRPLink();
		  vehicledocs.ClickVehicledocuments();
		    fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "PreSetup", 2, 0));
			fleetpage.enterFleetNo_Supplement(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "PreSetup", 2, 2));
			fleetpage.enterFleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "PreSetup",2,5));
			commonobjects.clickProceed();

			//VehicleDocs
			//Fetch Values from Vehicle Document Screen
			ArrayList<String> TableHeader1=vehicledocs.FetchTableHeader1();
	    	for(int i=0;i<TableHeader1.size();i++) {
	    		eleutil.updateExcel("Vehicle Document",0,i,TableHeader1.get(i));
	    	}
	    	ArrayList<String> TableHeader2=vehicledocs.FetchTableHeader2();
	    	for(int i=0;i<TableHeader2.size()-1;i++) {
	    		eleutil.updateExcel("Vehicle Document",0,i+TableHeader1.size(),TableHeader2.get(i));
	    	}
	    	//Juris list
	    	ArrayList<String>  row_values=vehicledocs.FetchTable_Rows();
	     	for(int i=1;i<row_values.size()-1;i++) {
	     	eleutil.updateExcel("Vehicle Document", 1,i-1,row_values.get(i));  //0 0 13
	     	}
			vehicledocs.SelectHVUT(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleDocuments",2,0));
			vehicledocs.SelectLeaseContract(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleDocuments",2,1));
			vehicledocs.SelectTitleDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleDocuments",2,2));
			vehicledocs.SelectPlateReturn(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleDocuments",2,3));
		    commonobjects.clickProceed();
			eleutil.CloseFirstChildWindow();  //To close PDF Window
			dashboardpage.clickIRPLink();
		    financepage.clickinstallmentpayment();
			financepage.clickandenterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,0));
			financepage.clickandenterfleet(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,2));
			financepage.clickandenterfleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,5));
			commonobjects.clickProceed();
			financepage.clickgrid();
			
			//Fetch Vallues from 
			eleutil.updateExcel("InstallmentPayment", 0, 0, financepage.Fetch_PostPayment_AccountNolbl());
			eleutil.updateExcel("InstallmentPayment", 1, 0, financepage.Fetch_PostPayment_AccountNo());
			eleutil.updateExcel("InstallmentPayment", 0, 1, financepage.Fetch_FleetNolbl());
			eleutil.updateExcel("InstallmentPayment", 1, 1, financepage.Fetch_FleetNo());
			eleutil.updateExcel("InstallmentPayment", 0, 2, financepage.Fetch_LegalNamelbl());
			eleutil.updateExcel("InstallmentPayment", 1, 2, financepage.Fetch_LegalName());
			eleutil.updateExcel("InstallmentPayment", 0, 3, financepage.Fetch_FleerMonthYearlbl());
			eleutil.updateExcel("InstallmentPayment", 1, 3, financepage.Fetch_FleerMonthYear());
			eleutil.updateExcel("InstallmentPayment", 0, 4, financepage.Fetch_SupplementNolbl());
			eleutil.updateExcel("InstallmentPayment", 1, 4, financepage.Fetch_SupplementNo());
			eleutil.updateExcel("InstallmentPayment", 0, 5, financepage.Fetch_DBANamelbl());
			eleutil.updateExcel("InstallmentPayment", 1, 5, financepage.Fetch_DBAName());
			eleutil.updateExcel("InstallmentPayment", 0, 6, financepage.Fetch_FleetTypelbl());
			eleutil.updateExcel("InstallmentPayment", 1, 6, financepage.Fetch_FleetType());
			eleutil.updateExcel("InstallmentPayment", 0, 7, financepage.Fetch_SupplementDesclbl());
			eleutil.updateExcel("InstallmentPayment", 1, 7, financepage.Fetch_SupplementDesc());
			eleutil.updateExcel("InstallmentPayment", 0, 8, financepage.Fetch_USDOTlbl());
			eleutil.updateExcel("InstallmentPayment", 1, 8, financepage.Fetch_USDOT());
			eleutil.updateExcel("InstallmentPayment", 0, 9, financepage.Fetch_SupplementEffectiveDatelbl());
			eleutil.updateExcel("InstallmentPayment", 1, 9, financepage.Fetch_SupplementEffectiveDate());
			eleutil.updateExcel("InstallmentPayment", 0, 10, financepage.Fetch_SupplementStatuslbl());
			eleutil.updateExcel("InstallmentPayment", 1, 10, financepage.Fetch_SupplementStatus());
			eleutil.updateExcel("InstallmentPayment", 0, 11, financepage.Fetch_InvoiceDatelbl());
			eleutil.updateExcel("InstallmentPayment", 1, 11, financepage.Fetch_InvoiceDate());
			eleutil.updateExcel("InstallmentPayment", 0, 12, financepage.Fetch_Invoicenolbl());
			eleutil.updateExcel("InstallmentPayment", 1, 12, financepage.Fetch_Invoiceno());
			eleutil.updateExcel("InstallmentPayment", 0, 13, financepage.Fetch_EnterpriseSystemCreditlbl());
			eleutil.updateExcel("InstallmentPayment", 1, 13, financepage.Fetch_EnterpriseSystemCredit());
			eleutil.updateExcel("InstallmentPayment", 0, 14, financepage.Fetch_Installment_ReceiptDatelbl());
			eleutil.updateExcel("InstallmentPayment", 1, 14, financepage.Fetch_Installment_ReceiptDate());
			eleutil.updateExcel("InstallmentPayment", 0, 15, financepage.Fetch_InstallmentPlanNumberlbl());
			eleutil.updateExcel("InstallmentPayment", 1, 15, financepage.Fetch_InstallmentPlanNumber());
		
			 ArrayList<String> Table_Headervalues=financepage.FetchTableHeader();
		    	for(int i=0;i<Table_Headervalues.size();i++) {
		    		eleutil.updateExcel("InstallmentPayment",0,i+16,Table_Headervalues.get(i));
		    	}

			  ArrayList<String> Table_Values=financepage.FetchTable_RowValues();
			  for(int i=0;i<Table_Values.size();i++) {
		    		eleutil.updateExcel("InstallmentPayment",1,i+16,Table_Values.get(i));
		    	}

			commonobjects.clickProceed();
			
			//Installment Verification Screen
			commonobjects.clickProceed();
			
			//Installment Payment mode screen
			
			String paymenttype1=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,1);
			String totalAmount1=pay.FetchTotalAmount();
			pay.selectPaymentType(0,paymenttype1);	
			String PaymentNumberValue1=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,0);
			pay.enterpaymentNoBasedonType(0,paymenttype1,PaymentNumberValue1);
			String cashAmount1=String.valueOf(Double.valueOf(totalAmount1));
				pay.enterPaymentAmountBasedonType(0,paymenttype1,cashAmount1);
				pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,3));
			commonobjects.clickProceed();
			//Installment Verification Screen
			commonobjects.clickProceed();

			eleutil.CloseFirstChildWindow();
			ArrayList<String> Complete_InfoMsgs=commonobjects.validateinfomsgs();
	    	for(int i=0;i<Complete_InfoMsgs.size();i++) {
	    		ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"CompletionPage",2,i);
	    	}

	}
	@Then("user verifies details in Fleet Enquiry")
	public void user_verifies_details_in_fleet_enquiry() throws Exception {
		String ParentWindow=eleutil.GetParentWindow();
	  dashboardpage.clickFleetEnquiry(); 
	String childWindow= eleutil.SwitchtoFirstChildWindow();
	  fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,0));
	  commonobjects.clickProceed();
	  enquiry.fleetenquiryvaluevalidation(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Enquiry",2,0));
	eleutil.closespecificWindow(childWindow);
	eleutil.SwitchspecificWindow(ParentWindow);
	}
	
	@Then("user verifies details in Supplement Enquiry")
	public void user_verifies_details_in_Supplement_enquiry() throws Exception {
		String ParentWindow=eleutil.GetParentWindow();
		  dashboardpage.clickSupplementEnquiry(); 
		String childWindow= eleutil.SwitchtoFirstChildWindow();
		enquiry.enterSupplementEnquiryAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,0));
		  commonobjects.clickProceed();
	enquiry.SupplementEnquiryvaluevalidation(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Enquiry",2,0));
	eleutil.closespecificWindow(childWindow);
	eleutil.SwitchspecificWindow(ParentWindow);
	}
	@Then("user verifies details in Vehicle Enquiry")
	public void user_verifies_details_in_Vehicle_enquiry() throws Exception {
		dashboardpage.clickIRPLink();
		String ExpiryYear_Excel=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Enquiry",2,0);
		String ParentWindow=eleutil.GetParentWindow();
		dashboardpage.clickVehicleEnquiry();
		String childWindow= eleutil.SwitchtoFirstChildWindow();
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,0));
		commonobjects.clickProceed();
		enquiry.clickVehicleEnquiryUnitNo();
		 int AddVehiclesCount_Excel=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,0));
		  int j=35;
			for(int i=1;i<=AddVehiclesCount_Excel; i++) {
				String ActualVIN=enquiry.fetchVehicleEnquiryVIN(String.valueOf(i),ExpiryYear_Excel);
				String expectedVIN=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleAddTab",2,1+j);
				if(ActualVIN !=null) {
				softassert.assertEquals(ActualVIN, expectedVIN);
				j+=35;
				}
			}
			softassert.assertAll();
			eleutil.closespecificWindow(childWindow);
			eleutil.SwitchspecificWindow(ParentWindow);
			
	}
	@Then("user verifies details in Vehicle Supplement Enquiry")
	public void user_verifies_details_in_Vehicle_Supplement_enquiry() throws Exception {
		String ExpiryYear_Excel=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Enquiry",2,0);
		String ParentWindow=eleutil.GetParentWindow();
		dashboardpage.clickVehicleSupplementEnquiry();
		String childWindow= eleutil.SwitchtoFirstChildWindow();
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,0));
		commonobjects.clickProceed();
		enquiry.clickVehicleSupplementUnitNo();
		 int AddVehiclesCount_Excel=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,0));
		  int j=35;
			for(int i=1;i<=AddVehiclesCount_Excel; i++) {
				String ActualVIN=enquiry.FetchVehicleSupplementEnquiryVIN(String.valueOf(i),ExpiryYear_Excel);
				String expectedVIN=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleAddTab",2,1+j);
				if(ActualVIN !=null) {
				softassert.assertEquals(ActualVIN, expectedVIN);
				j+=35;
				}
			}
			softassert.assertAll();
			eleutil.closespecificWindow(childWindow);
			eleutil.SwitchspecificWindow(ParentWindow);
			}
	*/
}