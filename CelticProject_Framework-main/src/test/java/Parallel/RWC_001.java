package Parallel;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
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
import com.qa.util.ExcelReader;
import com.qa.util.Screenshot_Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RWC_001 {
	
	 LoginPage loginpage = new LoginPage(Driver_Factory.getDriver());
	 DashBoardPage dashboardpage = new DashBoardPage(Driver_Factory.getDriver());
	 AccountTabPage accounttabpage = new AccountTabPage(Driver_Factory.getDriver());
	 FleetTabPage fleettabpage = new FleetTabPage(Driver_Factory.getDriver());
	 FleetPage fleetpage = new FleetPage(Driver_Factory.getDriver());
	 CommonObjects commonobjects = new CommonObjects(Driver_Factory.getDriver());
	 DistanceTabPage distancetabpage = new DistanceTabPage(Driver_Factory.getDriver());
	WgtGroup wgtgroup = new WgtGroup(Driver_Factory.getDriver());
	WgtGroupAdd wgtgroupadd = new WgtGroupAdd(Driver_Factory.getDriver());
	VehicleTabPage Vehicletabpage = new VehicleTabPage(Driver_Factory.getDriver());
	VehicleAmend vehicleAmend =new VehicleAmend(Driver_Factory.getDriver());
	VehicleDelete vehicleDelete =new VehicleDelete(Driver_Factory.getDriver());
	BillingTab billingtab = new BillingTab(Driver_Factory.getDriver());
	Payment pay =new Payment(Driver_Factory.getDriver());
	PaymentTab paymenttab = new PaymentTab(Driver_Factory.getDriver());
	InventoryPage inventorypage = new InventoryPage(Driver_Factory.getDriver());
	InstallmentPage installmentpage = new InstallmentPage(Driver_Factory.getDriver());
	VehicleAdd vehicleadd= new VehicleAdd(Driver_Factory.getDriver());
	Financepage financepage =new Financepage(Driver_Factory.getDriver());
	
	int RowNo=1;
	
	ElementUtil eleutil =new ElementUtil();
	private Screenshot_Utility screenshotUtil =new Screenshot_Utility();
	ConfigReader config=new ConfigReader();
	Logger log = Logger.getLogger(RWC_001.class); 
	@Given("User login as a Internal user")
	public void user_login_as_a_internal_user() throws Exception {

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
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",RowNo,0));
		log.info("*** Enter Account Number ***");
		screenshotUtil.captureScreenshot("Entering AccountNumber");
		fleetpage.enterFleetNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",RowNo,2));
		log.info("*** Enter FleetNo ***");
		screenshotUtil.captureScreenshot("Entering FleetNumber");
		fleetpage.enterFleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",RowNo,3));
		log.info("*** Click FleetYear ***");
		screenshotUtil.captureScreenshot("Entering FleetYear");
		commonobjects.clickProceed();	
        
	}

	@Then("User will navigate to account section and fill the data and validate message {string}")
	public void user_will_navigate_to_account_section_and_fill_the_data_and_validate_message(String expSucces) throws Exception, Exception {

		//Fetch Values
		ExcelReader.updateExcel("Account", 0, 0, accounttabpage.fetchMCECustomernolbl());
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

		//-------------------------------
		String actualSuccMessg = accounttabpage.ValidateMessage();
		Assert.assertEquals(actualSuccMessg, expSucces);
		log.info(actualSuccMessg);
		screenshotUtil.captureScreenshot("ValidationMessage");
		

		accounttabpage.checkEmailNotification();
			log.info("*** Check Email Notification ***");
			screenshotUtil.captureScreenshot("Check EmailNotification");
			commonobjects.provideComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"AccountTab",RowNo,0));
			log.info("*** Enter Comments ***");
			screenshotUtil.captureScreenshot("Enter Comments in Account Section");
			
			commonobjects.clickProceed();
//Account Verification Screen
			commonobjects.clickProceed();
		}

		@Then("User will navigate to Fleet section and fill the data and validate message {string} {string} {string}")
	public void user_will_navigate_to_fleet_section_and_fill_the_data_and_validate_message(String expSucces1, String expSucces2, String expSucces3) throws Exception {
//Fetch Values
			ExcelReader.updateExcel("Fleet", 0, 0, fleettabpage.fetchRegistrationtypelbl());
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
			String actualSuccMessg1 = fleettabpage.FleetValidateMessage1();
			
			Assert.assertEquals(actualSuccMessg1, expSucces1);
			
			log.info(actualSuccMessg1);
			screenshotUtil.captureScreenshot("ValidateMessage");
					
	        String actualSuccMessg2 = fleettabpage.FleetValidateMessage2();
			
			Assert.assertEquals(actualSuccMessg2, expSucces2);
			
			log.info(actualSuccMessg2);
			
			screenshotUtil.captureScreenshot("ValidateMessage");

					
	     String actualSuccMessg3 = fleettabpage.FleetValidateMessage3();
			
			Assert.assertEquals(actualSuccMessg3, expSucces3);
			
			log.info(actualSuccMessg3);
			
			screenshotUtil.captureScreenshot("ValidateMessage");

					
			fleettabpage.navigateToServiceProvider();
			log.info("*** navigateToServiceProvider ***");
			screenshotUtil.captureScreenshot("Navigate to Service provider");
			
			fleettabpage.clickPowerOfAttroney();
			log.info("*** Click PowerofAttroney ***");
			screenshotUtil.captureScreenshot("Check Power of Attroney");
			
			fleettabpage.enterEmailID(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",RowNo,0));
			log.info("*** Entering the Emailid ***");
			screenshotUtil.captureScreenshot("Entering the Emailid");
			//Expiration Date through Excel
		//	fleettabpage.selectExpirationDate(ExcelReader.FetchDataFromSheet(config.readRWCexcel(), "FleetTab", 2, 13));
			//Expiration Date through System
			fleettabpage.selectExpirationDate(eleutil.getDateInSpecifiedFormat("MMddYYYY",2));
			log.info("*** Selecting the Expiration Date ***");
			screenshotUtil.captureScreenshot("Selecting the Expiration Date");
			
			fleettabpage.selectIRPRequirementForm(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",RowNo,1));
			log.info("*** Selecting the IRPRequirementForm ***");
			screenshotUtil.captureScreenshot("Selecting the IRPRequirementForm");
			
			fleettabpage.selectStatementofUnderstanding(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",RowNo,2));		
			log.info("*** Selecting StatementofUnderstanding ***");
			screenshotUtil.captureScreenshot("Selecting StatementofUnderstanding");
			
			fleettabpage.selectInstallmentAgreement(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",RowNo,3));
			log.info("*** Selecting InstallmentAgreement ***");
			screenshotUtil.captureScreenshot("Selecting InstallmentAgreement");
			
			fleettabpage.selectPowerOfAttroney(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",RowNo,4));
			log.info("*** Selecting PowerOfAttroney ***");
			screenshotUtil.captureScreenshot("Selecting PowerOfAttroney");
			
			fleettabpage.selectHVUTForm(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",RowNo,5));
			log.info("*** Selecting HVUTForm ***");
			screenshotUtil.captureScreenshot("Selecting HVUTForm");		
			
			fleettabpage.selectPropertyTax(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",RowNo,6));
			log.info("*** Selecting PropertyTax ***");
			screenshotUtil.captureScreenshot("Selecting PropertyTax");		
			
			commonobjects.provideComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",RowNo,7));
			log.info("*** Enter Comments ***");
			screenshotUtil.captureScreenshot("Enter Comments in Fleet Section");
			
			commonobjects.clickProceed();
			//Fleet Verification Screen
			commonobjects.clickProceed();
		}
			
			@Then("User will navigate to Distance section and fill the data and validate message {string} {string} {string}")
			public void user_will_navigate_to_distance_section_and_fill_the_data_and_validate_message(String expSucces1, String expSucces2, String expSucces3) throws Exception, Exception {
			    //Fetch Values
				 ExcelReader.updateExcel("Distance",0,0,distancetabpage.DistanceReportingPeriodFromlbl()); 
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
			     	
				String actualSuccMessg1 = distancetabpage.DistanceValidateMessage1();
				
				Assert.assertEquals(actualSuccMessg1, expSucces1);
						
				log.info(actualSuccMessg1);
				screenshotUtil.captureScreenshot("ValidateMessage");
	
				
				String actualSuccMessg2 = distancetabpage.DistanceValidateMessage2();
				
				Assert.assertEquals(actualSuccMessg2, expSucces2);
				
				log.info(actualSuccMessg2);
				screenshotUtil.captureScreenshot("ValidateMessage");

				distancetabpage.enterAllDistanceValue(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",RowNo,1));   	
				//distancetabpage.enterMODistanceValue(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",RowNo,0), ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",RowNo,1));
				log.info("*** Enter MODistanceValue ***");
				screenshotUtil.captureScreenshot("Enter MODistanceValue");
				
				commonobjects.provideComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",RowNo,2));
				log.info("*** Enter Comments ***");
				screenshotUtil.captureScreenshot("Enter Comments in Distance Section");
				
		     	commonobjects.clickProceed();
		     	
			    String actualSuccMessg3 = distancetabpage.DistanceValidateMessage3();
				
				Assert.assertEquals(actualSuccMessg3, expSucces3);

				log.info(actualSuccMessg3);
				screenshotUtil.captureScreenshot("ValidateMessage");
				
				commonobjects.clickProceed();

			}

	@Then("User will navigate to Weight group section and fill the data ans validate message {string}")
	public void user_will_navigate_to_weight_group_section_and_fill_the_data_ans_validate_message(String expSucces) throws Exception {
		//Fetch Values into Excel
				ArrayList<String>  headervalues=wgtgroup.FetchTableHeader();
				for(int i=0;i<headervalues.size();i++) {
					ExcelReader.updateExcel("WeightGroup",0,i,headervalues.get(i));
				}
				ArrayList<String>  RowDatavalues=wgtgroup.FetchTableRowData();
				for(int i=0;i<RowDatavalues.size();i++) {
					ExcelReader.updateExcel("WeightGroup",RowNo,i,RowDatavalues.get(i));
				}
				
		String actualSuccMessage = wgtgroup.WeightValidatemessage();
		
		Assert.assertEquals(actualSuccMessage, expSucces);
		log.info(actualSuccMessage);
		screenshotUtil.captureScreenshot("ValidateMessage");

		
		wgtgroup.clickAddWeightGroup();
		log.info("*** Click AddweightGroup ***");
		screenshotUtil.captureScreenshot("Click AddweightGroup");
		//Add Weight Group Screen
		String WeightGroupCount_Excel=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",RowNo,1);
		
		for(int weightcount=0;weightcount<Integer.valueOf(WeightGroupCount_Excel);weightcount++) {
		int j=2;
		wgtgroupadd.selectWeightGroupType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",RowNo,weightcount+j));
		
		log.info("*** Select WeightGroupType ***");
		screenshotUtil.captureScreenshot("Select WeightGroupType");
	     j++;
		wgtgroupadd.enterWeightGroupNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",RowNo,weightcount+j));
		log.info("*** Enter WeightGroup No ***");
		screenshotUtil.captureScreenshot("Enter WeightGroup No");
		j++;
		wgtgroupadd.selectMaxGrossWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",RowNo,weightcount+j));
		log.info("*** Select MaxGross Weight ***");
		screenshotUtil.captureScreenshot("Select MaxGross Weight");
		ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",RowNo,1);
		commonobjects.clickProceed();
		
		commonobjects.clickProceed();
		}
		
		//Weight Group Screen
		//Edit Existing Weight Group
		wgtgroup.clickHandimg();
		
		String Juri_ExcelCount=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightJuris",RowNo,0);
		for(int i=0;i<Integer.valueOf(Juri_ExcelCount);i++) {
		String Juri_Excel=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightJuris",RowNo,i+1);
		wgtgroupadd.enterWeight_JuriValue(Juri_Excel);
		}
			commonobjects.clickProceed();
			// Weight Group Verification Screen
			commonobjects.clickProceed();
			
			//Validating JUR WITH DIFFERENT WEIGHTS
			String[] weightlist=wgtgroup.validateJurisWeightsedited(); //[AL, AR, AZ]
			for(int i=0;i<Integer.valueOf(Juri_ExcelCount);i++) {
				String Juri_Excel=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightJuris",RowNo,i+1);
				if(weightlist[i].equalsIgnoreCase(Juri_Excel)){
					assert true;
				}
			}
			
			//In Weight Group Screen	
				commonobjects.clickDonebtn();
				}

	@Then("User will navigate to add, amend vehicle as per the requirement and Validate the message {string} {string} {string}")
public void user_will_navigate_to_add_amend_vehicle_as_per_the_requirement_and_validate_the_message(String expSucces, String expSucces2, String expSucces3) throws Exception {
		//Fetch values from Vehicle screen
		ExcelReader.updateExcel("VehicleTab",0,0,Vehicletabpage.FetchAmendVehiclelbl()); 
		ExcelReader.updateExcel("VehicleTab",RowNo,0,Vehicletabpage.FetchAmendVehicle ()); 
		ExcelReader.updateExcel("VehicleTab",0,1,Vehicletabpage.FetchAddVehicleslbl ()); 
		ExcelReader.updateExcel("VehicleTab",RowNo,1,Vehicletabpage.FetchAddVehicles()); 
		ExcelReader.updateExcel("VehicleTab",0,2,Vehicletabpage.FetchdeleteVehiclelbl());
		ExcelReader.updateExcel("VehicleTab",RowNo,2,Vehicletabpage.FetchdeleteVehicle()); 
		ExcelReader.updateExcel("VehicleTab",0,3,Vehicletabpage.FetchRenewVehiclelbl()); 
		ExcelReader.updateExcel("VehicleTab",RowNo,3,Vehicletabpage.FetchRenewVehicle());  
		int NoofVehiclestoAmend=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,5));
	if(NoofVehiclestoAmend>0) {
			
		Vehicletabpage.clickAmendVehicleRadioButton();
		log.info("*** Click AmendVehicle RadioButton ***");
		screenshotUtil.captureScreenshot("Click AmendVehicle RadioButton");
					
		commonobjects.clickProceed();
		
		String actualSuccMessage = Vehicletabpage.VehicleValidateMessage1();
		
		Assert.assertEquals(actualSuccMessage, expSucces);

		log.info(actualSuccMessage);
		screenshotUtil.captureScreenshot("ValidateMessage");

		
		for(int i=0;i<NoofVehiclestoAmend;i++) {
			if(NoofVehiclestoAmend>10) {
				vehicleAmend.selectUnitNoFromSuggestions();
				log.info("*** Select Unit number ***");
				screenshotUtil.captureScreenshot("Select Unit number");
			}
			else {
				vehicleAmend.selectUnitNoFromExcel(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleAmendTab",RowNo,i));
				log.info("*** Enter Unit number ***");
				screenshotUtil.captureScreenshot("Enter Unit number");
			}
			vehicleAmend.clickSearch();


			Vehicletabpage.vehiclevalidatemessage();
			if(i==0){
				vehicleAmend.selectWeightGroupNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",RowNo,0));
				log.info("*** Enter WeightGroupNo ***");
				screenshotUtil.captureScreenshot("Enter WeightGroupNo");
				String actualSuccMessage2 = Vehicletabpage.VehicleValidateMessage2();
				Assert.assertEquals(actualSuccMessage2, expSucces2);
				log.info(actualSuccMessage2);
				screenshotUtil.captureScreenshot("ValidateMessage");
			}
			
			
			vehicleAmend.enterUnladenWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,14));
			log.info("*** Enter UnladenWeight ***");
			screenshotUtil.captureScreenshot("Enter UnladenWeight");
			
			
			vehicleAmend.clickTVR();
			log.info("*** Click TVR ***");
			screenshotUtil.captureScreenshot("Click TVR");
		
			vehicleAmend.selectSafetyChangedd(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,29));
			log.info("*** Select Safety Changedd ***");
			screenshotUtil.captureScreenshot("Select Safety Changedd");
			
			vehicleAmend.selectHVUTForm2290(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,36));
			log.info("*** Select HVUTForm2290 ***");
			screenshotUtil.captureScreenshot("Select HVUTForm2290");
			
			vehicleAmend.selectLeaseContract(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,37));
			log.info("*** Select LeaseContract ***");
			screenshotUtil.captureScreenshot("Select LeaseContract");
			
			vehicleAmend.selectTitleDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,38));
			log.info("*** Select TitleDocument ***");
			screenshotUtil.captureScreenshot("Select TitleDocument");
			
			vehicleAmend.selectPlateReturndoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,39));
			log.info("*** Select PlateReturndoc ***");
			screenshotUtil.captureScreenshot("Select PlateReturndoc");
			
			vehicleAmend.selectAffidavitDoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,40));
			log.info("*** Select AffidavitDoc ***");
			screenshotUtil.captureScreenshot("Select AffidavitDoc");
			
			vehicleAmend.selectPropertyTax(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,41));
			log.info("*** Select PropertyTax ***");
			screenshotUtil.captureScreenshot("Select PropertyTax");
			
			commonobjects.provideComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,42));
			
			log.info("*** Enter Comments ***");
			screenshotUtil.captureScreenshot("Enter Comments in Distance Section");
			
			commonobjects.clickProceed();
			//Verification Screen
			commonobjects.clickProceed();
			
			String actualSuccMessage3 = Vehicletabpage.VehicleValidateMessage3();
			Assert.assertEquals(actualSuccMessage3, expSucces3);
			log.info(actualSuccMessage3);
			screenshotUtil.captureScreenshot("ValidateMessage");
			
		}// End of for Loop
			commonobjects.clickDonebtn();
	} //End of vehicle ammend if loop
}
			@Then("User will Delete Vehicle as per the requiremnet and navigate to billing validate the message {string} {string} {string} {string} {string}")
	public void user_will_delete_vehicle_as_per_the_requiremnet_and_navigate_to_billing_validate_the_message(String expSucces, String expSucces2, String expSucces3, String expSucces4, String expSucces5) throws Exception {

		String actualSuccMessage = vehicleDelete.DeleteValidationMessage();
		Assert.assertEquals(actualSuccMessage, expSucces);
		log.info(actualSuccMessage);
		screenshotUtil.captureScreenshot("ValidateMessage");
		log.info(actualSuccMessage);
		screenshotUtil.captureScreenshot("ValidateMessage");

		int NoofVehiclestoDelete=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,0));
	if(NoofVehiclestoDelete>0) {
		Vehicletabpage.clickDeleteVehicleRadioButton();
		log.info("**** Click DeleteVehicle ****");
		screenshotUtil.captureScreenshot("Click Delete Vehicle");
		commonobjects.clickProceed();
		//below lines of code for deleting the vehicles from suggestion box
		String Vehiclescount=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,0);
		String PlateStatus=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,1);
		String PlateReturnedDocument=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,2);
		String AffidavitDocument=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,3);
		String Comments=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,4);
		
		if(NoofVehiclestoDelete>10) {
			vehicleDelete.deleteFewVehicles(Vehiclescount, PlateStatus, PlateReturnedDocument, AffidavitDocument, Comments);
		commonobjects.clickProceed();
		commonobjects.clickProceed();
}
		else {

		for(int j=0;j<NoofVehiclestoDelete;j++) {
			//Enter unit # to filter & delete
			vehicleDelete.enterUnitNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",RowNo,j));
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

		String actualSuccMessage2 = vehicleDelete.DeleteValidationMessage();
				
				Assert.assertEquals(actualSuccMessage2, expSucces2);
				log.info(actualSuccMessage2);
				screenshotUtil.captureScreenshot("ValidateMessage");
				
				commonobjects.clickDonebtn();
	}//End of vehicle Delete if loop
	//verification screen before going to billing screen -Vehicles cancel from Vehicle List
		Vehicletabpage.clickVehicleList();
		log.info("*** Click VehicleList ***");
		screenshotUtil.captureScreenshot("Click VehicleList");
		
		vehicleadd.enterUnitNumber(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",RowNo,0));
		log.info("*** Select Unit No ***");
		screenshotUtil.captureScreenshot("Select Unit No");

		vehicleAmend.clickSearch();
		log.info("*** Search Unit No ***");
		screenshotUtil.captureScreenshot("Search Unit No");
		vehicleadd.Updatevehiclelistselectunit();
		commonobjects.ClickConfirmCancel();
		eleutil.handleAlert();
		
		String actualSuccMessage3 = vehicleDelete.DeleteValidationMessage();
		Assert.assertEquals(actualSuccMessage3, expSucces3);
		log.info(actualSuccMessage3);
		screenshotUtil.captureScreenshot("ValidateMessage");

		commonobjects.clickBack();
		//verification screen before going to billing screen -Vehicle to be Amended from Vehicle List
				Vehicletabpage.clickAmendVehicleRadioButton();
				
				commonobjects.clickProceed();
				
				vehicleAmend.selectUnitNoFromExcel(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",RowNo,0));
				
				vehicleAmend.clickSearch();
				
				vehicleAmend.enterUnladenWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,14));
				
				vehicleAmend.clickTVR();
				vehicleAmend.selectSafetyChangedd(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,29));
				
				vehicleAmend.selectHVUTForm2290(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,36));
				
				vehicleAmend.selectLeaseContract(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,37));
				
				vehicleAmend.selectTitleDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,38));
				
				vehicleAmend.selectPlateReturndoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,39));
				
				vehicleAmend.selectAffidavitDoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,40));
				
				vehicleAmend.selectPropertyTax(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",RowNo,41));

				commonobjects.clickProceed();
				//AMend Verification Screen
				commonobjects.clickProceed();
				//To move from Amend Screen to Renewal Vehicle Processing
				commonobjects.clickDonebtn();
		//TO move from Renewal Vehicle Processing to Billing Screen						
				commonobjects.clickDonebtn();
				
				//Fetch values from Biling Screen
				ExcelReader.updateExcel("Billing",0,0,billingtab.fetchRegisterMonthlbl());
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

				billingtab.clickTVR();
				log.info("*** Click TVR ***");
				screenshotUtil.captureScreenshot("Click TVR");
				
				billingtab.clickInstallmentPlan();
				log.info("*** Click Installement Plan ***");
				screenshotUtil.captureScreenshot("Click Installement Plan");
				
				billingtab.selectElectronicDeliveryType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",RowNo,14));
				log.info("*** Select Electronic DeliveryType ***");
				screenshotUtil.captureScreenshot("Select Electronic DeliveryType");
				
				commonobjects.provideComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",RowNo,17));
				commonobjects.clickProceed();
				
				billingtab.enterManualAdjBaseJur(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",RowNo,2));
				log.info("*** Enter ManualAdjBaseJur ***");
				screenshotUtil.captureScreenshot("Enter ManualAdjBaseJur");
				
				billingtab.clickReCalculate();
				log.info("*** Click Recalculate ***");
				screenshotUtil.captureScreenshot("Click Recalculate");
				
				String actualSuccMessage4 = billingtab.ValidateMessage2(); //Manual billing
				Assert.assertEquals(actualSuccMessage4, expSucces4);
				log.info(actualSuccMessage4);
				screenshotUtil.captureScreenshot("ValidateMessage");
				
				billingtab.expandManualAdjReason();
				billingtab.enterManualAdjReasonComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",RowNo,18));
				log.info("*** Enter ManualAdjReason Comments ***");
				screenshotUtil.captureScreenshot("Enter ManualAdjReason Comments");
				billingtab.clickManualAdjReasonDeleteAllowed();
				billingtab.clickManualAdjReasonAddorUpdateComments();
				
				commonobjects.clickProceed();
				
			    billingtab.selectGradeCrossingFee(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",RowNo,6));  
			    log.info("*** Select GradeCrossingFee ***");
				screenshotUtil.captureScreenshot("Select GradeCrossingFee");
				
				billingtab.clickReCalculate();
				log.info("*** Click Recalculate ***");
				screenshotUtil.captureScreenshot("Click Recalculate");
				
				String actualSuccMessage5 = billingtab.ValidateMessage2(); //Fee Overriden
				Assert.assertEquals(actualSuccMessage5, expSucces5);
				log.info(actualSuccMessage5);
				screenshotUtil.captureScreenshot("ValidateMessage");

				//commonobjects.validateErrorMessage(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",RowNo,20));
				billingtab.expandFeeOverrideReason();
				
				billingtab.enterFeeOverrideReasonComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",RowNo,19));
				
				log.info("*** Enter FeeOverrideReason Comments ***");
				screenshotUtil.captureScreenshot("Enter FeeOverrideReason Comments");
				
				billingtab.clickFeeOverrideReasonDeleteAllowed();
				billingtab.clickFeeOverrideReasonAddorUpdateComments();
				
				billingtab.clickReCalculate();
				
				commonobjects.clickProceed();
				
				eleutil.CloseFirstChildWindow();
			
		}
			
		@Then("User will navigate to Payment Tab and fill the requirement and validate message {string} {string} {string}")
		public void user_will_navigate_to_payment_tab_and_fill_the_requirement_and_validate_message(String expSucces, String expSucces2, String expSucces3) throws Exception, Exception {
			//Fetch Values from Payment Tab
			  ExcelReader.updateExcel("PaymentTab",0,0,paymenttab.FetchEnterpriseSystemCreditlbl());
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

			String actualSuccMessage = paymenttab.ValidateMessage1();
			Assert.assertEquals(actualSuccMessage, expSucces);
			
			log.info(actualSuccMessage);
			screenshotUtil.captureScreenshot("ValidateMessage");

			
			String actualSuccMessage2 = paymenttab.ValidateMessage2();
			Assert.assertEquals(actualSuccMessage2, expSucces2);

			log.info(actualSuccMessage2);
			screenshotUtil.captureScreenshot("ValidateMessage");

			
			String actualSuccMessage3 = paymenttab.ValidateMessage3();
			Assert.assertEquals(actualSuccMessage3, expSucces3);
			
			log.info(actualSuccMessage3);
			screenshotUtil.captureScreenshot("ValidateMessage");

			
			pay.selectElectronicDeliverytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",RowNo,4));
			
			log.info("***Select Delivery type***");
			commonobjects.clickProceed();
			
			paymenttab.clickAddtoCart();
			log.info("***Click Add to Cart**");
			
			paymenttab.ValidateMessage4();
			
			
		}

		@Then("User will navigate to Supplementary Tab and validate the meesage {string}")
		public void user_will_navigate_to_supplementary_tab_and_validate_the_meesage(String expSucces) throws Exception, Exception {

			
			paymenttab.clicksupplcont();
			log.info("***Click Supplement continue***");
			screenshotUtil.captureScreenshot("Click Supplement continue");

			fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",RowNo,0));
			//paymenttab.clickandenteraccno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,0));
			
			commonobjects.clickProceed(); 

			String actualSuccMessage = paymenttab.ValidateMessage5();
			Assert.assertEquals(actualSuccMessage, expSucces);	
			log.info(actualSuccMessage);
			screenshotUtil.captureScreenshot("Validate Message");
		}

		@Then("User will navigate to payment tab and Fill the requirement")
		public void user_will_navigate_to_payment_tab_and_fill_the_requirement() throws Exception, Exception {

			//commonobjects.clickQuit();
			
			paymenttab.clickverifyaddtocart();
			
			log.info("***Verify Cart***");
			screenshotUtil.captureScreenshot("Verify Cart");
			pay.clickPayNow();  
			
			log.info("***Click Paynow***");
			screenshotUtil.captureScreenshot("Click Paynow");
			commonobjects.clickProceed();
			
			//Fetch Values from Cart payment
			ExcelReader.updateExcel("PaymentScreen",0,0,pay.FetchMCECustomerIdlbl());
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
			
			  paymenttab.clickpaymentadd();
			for(int i=0; i<2;i++) {
				String PaymentType=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",RowNo,i+1);
				String PaymentNumberValue=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",RowNo,0);
				pay.selectPaymentType(i,PaymentType);	
				log.info("***Payment Type***");
				screenshotUtil.captureScreenshot("Payment Type"+i);
				
				
				pay.enterpaymentNoBasedonType(i,PaymentType,PaymentNumberValue);
				log.info("***Payment Number based on Payment Type***");
				screenshotUtil.captureScreenshot("Payment Number based on  Payment Type"+i);
				
				if(i==0) {
					String totalAmount=pay.FetchTotalAmount();
					String cashAmount=String.valueOf(Double.valueOf(totalAmount)/2);
					pay.enterPaymentAmountBasedonType(i,PaymentType,cashAmount);
				}
				
				if(i==1) {
					String RemainingAmount=pay.FetchRemainingBalance();
					pay.enterPaymentAmountBasedonType(i,PaymentType,RemainingAmount);
				}
				log.info("***Payment Amount based on Payment Type***");
				screenshotUtil.captureScreenshot("Payment Amount based on  Payment Type"+i);
				
			}
			
			pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",RowNo,3));
			
			log.info("***Enter Payment type and amount***");
			commonobjects.clickProceed();
			
			commonobjects.clickProceed();

			eleutil.CloseFirstChildWindow();
		}
		  @Then("user will Validate Message {string} {string}{string}{string}")
public void user_will_validate_message(String expSucces, String expSucces2, String expSucces3, String expSucces4) throws Exception, Exception {

			String actualSuccMessage = pay.ValidateMessage1();
			Assert.assertEquals(actualSuccMessage,expSucces);
			log.info(actualSuccMessage);
			screenshotUtil.captureScreenshot("ValidateMessage");
			
			String actualSuccMessage2 = pay.ValidateMessage2();
			Assert.assertEquals(actualSuccMessage2,expSucces2);
			log.info(actualSuccMessage2);
			screenshotUtil.captureScreenshot("Validate Message");
			
			String actualSuccMessage3 =	pay.ValidateMessage3();
			Assert.assertEquals(actualSuccMessage3,expSucces3);
			log.info(actualSuccMessage3);
			screenshotUtil.captureScreenshot("ValidateMessage");
			
			String actualSuccMessage4 =pay.ValidateMessage4();
			Assert.assertEquals(actualSuccMessage4,expSucces4);
			log.info(actualSuccMessage4);
			screenshotUtil.captureScreenshot("ValidateMessage");
		}

		@Then("User Navigate to inventry tab and fill the data and validate the message {string} {string}")
		public void user_navigate_to_inventry_tab_and_fill_the_data_and_validate_the_message(String expSucces, String expSucces2) throws Exception, Exception {
	
			inventorypage.clickoperation();
			
		inventorypage.clickoninventory();
		
		inventorypage.clicknewinventory();
	
	log.info("***Click Inventory***");
	screenshotUtil.captureScreenshot("Click Inventory");
		inventorypage.selectnewinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,0));
		
		
		String actualSuccMessage = inventorypage.ValidateMessage();
		Assert.assertEquals(actualSuccMessage,expSucces);
		log.info(actualSuccMessage);
		screenshotUtil.captureScreenshot("Validate Message");
		
		inventorypage.selectnewsubinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,1));
		
		inventorypage.enterfromno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,2)); //modify
		
		inventorypage.enterquantity(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,3));
		
		inventorypage.enteryear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,4));
		
		
		log.info("***Enter details for new inventory***");
		screenshotUtil.captureScreenshot("Enter details for new inventory");
		commonobjects.clickProceed();
		
		commonobjects.clickProceed();
		

		String actualSuccMessage2 = inventorypage.ValidateMessage();
		Assert.assertEquals(actualSuccMessage2,expSucces2);
		
		log.info(actualSuccMessage2);
		screenshotUtil.captureScreenshot("Validate Message");
		commonobjects.clickQuit();
		inventorypage.clickAssignInventory();
	
		inventorypage.selectnewinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,0));
		
	inventorypage.Highlightthemessage();
	inventorypage.selectnewsubinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,1));
	
	inventorypage.enterfromno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,2)); //modify
	
	inventorypage.enterquantity(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,3));
	
	inventorypage.enteryear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",RowNo,4));
	
	log.info("***Enter details in Assign Inventory***");
	screenshotUtil.captureScreenshot("Enter details in Assign Inventory");
	
	commonobjects.clickProceed();
	
	commonobjects.clickProceed();
	
	inventorypage.Highlightthemessage();
	
	commonobjects.clickQuit();
		}

		@Then("user navite to Financetab and navigate to installment payment and fill the data and valite the message {string} {string}")
		public void user_navite_to_financetab_and_navigate_to_installment_payment_and_fill_the_data_and_valite_the_message(String expSucces, String expSucces2) throws Exception, Exception {

			
			financepage.clickfinance();
			
			financepage.clickpostpayment();
			
			financepage.enterMCEid(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",RowNo,1));
			
			financepage.clicksearch();
			
			financepage.clickoncartid();
			
			financepage.clickservice();
			
			financepage.clickIRP();
			
			financepage.clickinstallmentpayment();
			
			financepage.clickandenterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",RowNo,0));
			
			financepage.clickandenterfleet(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",RowNo,2));
			
			financepage.clickandenterfleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",RowNo,5));
			
			commonobjects.clickProceed();
		
			financepage.clickgrid();
			
			commonobjects.clickProceed();
			
			commonobjects.clickProceed();
			
			financepage.selectpaymenttype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",RowNo,1));
			
			String totalAmount=pay.FetchTotalAmount();
			
			financepage.entercashamount(totalAmount);
			
			pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",RowNo,3));
			
			log.info("Enter the details in installement payment and proceed");
			screenshotUtil.captureScreenshot("Enter the details in installement payment and proceed");
			
			commonobjects.clickProceed();
			
			commonobjects.clickProceed();


			String actualSuccMessage = installmentpage.ValidateMessage1();
			Assert.assertEquals(actualSuccMessage,expSucces);
			log.info(actualSuccMessage);
			screenshotUtil.captureScreenshot("Validate Message");
			
			String actualSuccMessage2 = installmentpage.ValidateMessage2();
			Assert.assertEquals(actualSuccMessage2,expSucces2);

			log.info(actualSuccMessage2);
			screenshotUtil.captureScreenshot("Validate Message");
					
	}

		
	}
	
	
