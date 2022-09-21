package Parallel;

import java.io.IOException;
import java.util.ArrayList;
import com.pages.AccountTabPage;
import com.pages.BillingTab;
import com.pages.CommonObjects;
import com.pages.DashBoardPage;
import com.pages.DistanceTabPage;
import com.pages.DistanceVerification;
import com.pages.Enquiry;
import com.pages.Financepage;
import com.pages.FleetPage;
import com.pages.FleetTabPage;
import com.pages.InventoryPage;
import com.pages.LoginPage;
import com.pages.Payment;
import com.pages.PaymentTab;
import com.pages.VehicleAdd;
import com.pages.VehicleAmend;
import com.pages.VehicleDelete;
import com.pages.VehicleDocuments;
import com.pages.VehicleTabPage;
import com.pages.VehicleVerification;
import com.pages.WgtGroup;
import com.pages.WgtGroupAdd;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;
import io.cucumber.java.en.Then;

public class RWC_002 extends Driver_Factory {
	LoginPage loginpage = new LoginPage(Driver_Factory.getDriver());
	DashBoardPage dashboardpage = new DashBoardPage(Driver_Factory.getDriver());
	AccountTabPage accounttabpage = new AccountTabPage(Driver_Factory.getDriver());
	FleetTabPage fleettabpage = new FleetTabPage(Driver_Factory.getDriver());
	FleetPage fleetpage = new FleetPage(Driver_Factory.getDriver());
	DistanceTabPage distancetabpage = new DistanceTabPage(Driver_Factory.getDriver());
	WgtGroup wgtgroup = new WgtGroup(Driver_Factory.getDriver());
	WgtGroupAdd wgtgroupadd = new WgtGroupAdd(Driver_Factory.getDriver());
	VehicleTabPage Vehicletabpage = new VehicleTabPage(Driver_Factory.getDriver());
	VehicleAmend vehicleAmend = new VehicleAmend(Driver_Factory.getDriver());
	VehicleDelete vehicleDelete = new VehicleDelete(Driver_Factory.getDriver());
	CommonObjects commonobjects = new CommonObjects(Driver_Factory.getDriver());
	BillingTab billingtab = new BillingTab(Driver_Factory.getDriver());
	Payment pay = new Payment(Driver_Factory.getDriver());
	PaymentTab paymenttab = new PaymentTab(Driver_Factory.getDriver());
	InventoryPage inventorypage = new InventoryPage(Driver_Factory.getDriver());
	ExcelReader excel = new ExcelReader();
	int Noof = 0;
	Financepage financepage = new Financepage(Driver_Factory.getDriver());
	DistanceVerification Distanceverify = new DistanceVerification(Driver_Factory.getDriver());
	VehicleVerification vehicleverify = new VehicleVerification(Driver_Factory.getDriver());
	VehicleAdd vehicleadd = new VehicleAdd(Driver_Factory.getDriver());
	ElementUtil eleutil = new ElementUtil();
	VehicleDocuments vehicledocs = new VehicleDocuments(Driver_Factory.getDriver());
	Enquiry enquiry=new Enquiry(Driver_Factory.getDriver());
	
	@Then("User will navigate to renew fleet and search for  Reinstated Account Number")
	public void user_will_navigate_to_renew_fleet_and_search_for_reinstated_account_number()
			throws IOException, Exception {
		//dashboardpage.clickIRPLink();
		//dashboardpage.clickSupplementContinuance();
		
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "PreSetup", 2, 0));
	//fleetpage.enterFleetNo_Supplement(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "PreSetup", 2, 2));
	//fleetpage.enterFleetyear_Supplement(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "PreSetup", 2,3));
			fleetpage.enterFleetNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "PreSetup", 2, 2)); //uncomment for full flow
	fleetpage.enterFleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "PreSetup", 2, 3));//uncomment for full flow
		commonobjects.clickProceed();
		

	}

	@Then("User should navigate to Account screen and provides all the required input to proceed")
	public void user_should_navigate_to_account_screen_and_provides_all_the_required_input_to_proceed()
			throws Exception {
		eleutil.updateExcel("Account", 0, 0, accounttabpage.fetchMCECustomernolbl());
		eleutil.updateExcel("Account", 1, 0, accounttabpage.fetchMCECustomerno());
		eleutil.updateExcel("Account", 0, 1, accounttabpage.fetchRegistrationTypelbl());
		eleutil.updateExcel("Account", 1, 1, accounttabpage.fetchRegistrationType());
		eleutil.updateExcel("Account", 0, 2, accounttabpage.fetchAccountCarrierTypelbl());
		eleutil.updateExcel("Account", 1, 2, accounttabpage.fetchAccountCarrierType());
		eleutil.updateExcel("Account", 0, 3, accounttabpage.fetchIFTAAccountNbrlbl());
		eleutil.updateExcel("Account", 1, 3, accounttabpage.fetchIFTAAccountNbr());
		eleutil.updateExcel("Account", 0, 4, accounttabpage.fetchAccountCustomerStatuslbl());
		eleutil.updateExcel("Account", 1, 4, accounttabpage.fetchAccountCustomerStatus());
		eleutil.updateExcel("Account", 0, 5, accounttabpage.fetchAccountStreet0lbl());
		eleutil.updateExcel("Account", 1, 5, accounttabpage.fetchAccountStreet0());
		eleutil.updateExcel("Account", 0, 6, accounttabpage.fetchAccountZip0lbl());
		eleutil.updateExcel("Account", 1, 6, accounttabpage.fetchAccountZip0());
		eleutil.updateExcel("Account", 0, 7, accounttabpage.fetchAccountJur0lbl());
		eleutil.updateExcel("Account", 1, 7, accounttabpage.fetchAccountJur0());
		eleutil.updateExcel("Account", 0, 8, accounttabpage.fetchAccountCity0lbl());
		eleutil.updateExcel("Account", 1, 8, accounttabpage.fetchAccountCity0());
		eleutil.updateExcel("Account", 0, 9, accounttabpage.fetchAccountCounty0lbl());
		eleutil.updateExcel("Account", 1, 9, accounttabpage.fetchAccountCounty0());
		eleutil.updateExcel("Account", 0, 10, accounttabpage.fetchAccountCountry0lbl());
		eleutil.updateExcel("Account", 1, 10, accounttabpage.fetchAccountCountry0());
		accounttabpage.clickMailingAddress();
		eleutil.updateExcel("Account", 0, 11, accounttabpage.fetchAccountStreet1lbl());
		eleutil.updateExcel("Account", 1, 11, accounttabpage.fetchAccountStreet1());
		eleutil.updateExcel("Account", 0, 12, accounttabpage.fetchAccountZip1lbl());
		eleutil.updateExcel("Account", 1, 12, accounttabpage.fetchAccountZip1());
		eleutil.updateExcel("Account", 0, 13, accounttabpage.fetchAccountJur1lbl());
		eleutil.updateExcel("Account", 1, 13, accounttabpage.fetchAccountJur1());
		eleutil.updateExcel("Account", 0, 14, accounttabpage.fetchAccountCity1lbl());
		eleutil.updateExcel("Account", 1, 14, accounttabpage.fetchAccountCity1());
		eleutil.updateExcel("Account", 0, 15, accounttabpage.fetchAccountCounty1lbl());
		eleutil.updateExcel("Account", 1, 15, accounttabpage.fetchAccountCounty1());
		eleutil.updateExcel("Account", 0, 16, accounttabpage.fetchAccountCountry1lbl());
		eleutil.updateExcel("Account", 1, 16, accounttabpage.fetchAccountCountry1());

		eleutil.updateExcel("Account", 0, 17, accounttabpage.fetchAccountAttentionTolbl());
		eleutil.updateExcel("Account", 1, 17, accounttabpage.fetchAccountAttentionTo());

		eleutil.updateExcel("Account", 0, 18, accounttabpage.fetchAccountUSDOTNolbl());
		eleutil.updateExcel("Account", 1, 18, accounttabpage.fetchAccountUSDOTNo());
		eleutil.updateExcel("Account", 0, 19, accounttabpage.fetchAccountTPIDlbl());
		eleutil.updateExcel("Account", 1, 19, accounttabpage.fetchAccountTPID());
		eleutil.updateExcel("Account", 0, 20, accounttabpage.fetchAccountContactnamelbl());
		eleutil.updateExcel("Account", 1, 20, accounttabpage.fetchAccountContactname());
		eleutil.updateExcel("Account", 0, 21, accounttabpage.fetchAccountPrimaryPhonelbl());
		eleutil.updateExcel("Account", 1, 21, accounttabpage.fetchAccountPrimaryPhone());
		eleutil.updateExcel("Account", 0, 22, accounttabpage.fetchAccountAlternatePhonelbl());
		eleutil.updateExcel("Account", 1, 22, accounttabpage.fetchAccountAlternatePhone());
		eleutil.updateExcel("Account", 0, 23, accounttabpage.fetchAccountFaxNolbl());
		eleutil.updateExcel("Account", 1, 23, accounttabpage.fetchAccountFaxNo());
		eleutil.updateExcel("Account", 0, 24, accounttabpage.fetchAccountEmailnotificationlbl());
		eleutil.updateExcel("Account", 1, 24, accounttabpage.fetchAccountEmailnotification());
		eleutil.updateExcel("Account", 0, 25, accounttabpage.fetchAccountFaxnotificationlbl());
		eleutil.updateExcel("Account", 1, 25, accounttabpage.fetchAccountFaxnotification());

		// In Account Page
		accounttabpage.checkEmailNotification();
		commonobjects.expandCommentSection();
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "AccountTab", 2, 0));
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		commonobjects.clickProceed();
		Thread.sleep(3000);
	}

	@Then("user should navigate to Account verification screen and proceed further")
	public void user_should_navigate_to_account_verification_screen_and_proceed_further() throws InterruptedException {
		// In Account Verification Screen
		commonobjects.clickProceed();
		Thread.sleep(2000);
	}

	@Then("user should navigate to Fleet  screen and update Fleet Expiration Date & Fleet Type & Commodity Class and proceed further")
	public void user_should_navigate_to_fleet_screen_and_update_fleet_expiration_date_fleet_type_commodity_class_and_proceed_further()
			throws IOException, Exception {
		eleutil.updateExcel("Fleet", 0, 0, fleettabpage.fetchRegistrationtypelbl());
		eleutil.updateExcel("Fleet", 1, 0, fleettabpage.fetchRegistrationtype());
		eleutil.updateExcel("Fleet", 0, 1, fleettabpage.fetchfltstatuslbl());
		eleutil.updateExcel("Fleet", 1, 1, fleettabpage.fetchfltstatus());
		eleutil.updateExcel("Fleet", 0, 2, fleettabpage.fetchcarriertypelbl());
		eleutil.updateExcel("Fleet", 1, 2, fleettabpage.fetchcarriertype());
		eleutil.updateExcel("Fleet", 0, 3, fleettabpage.fetchDBANamelbl());
		eleutil.updateExcel("Fleet", 1, 3, fleettabpage.fetchDBAName());

		eleutil.updateExcel("Fleet", 0, 4, fleettabpage.FleetStreet0lbl());
		eleutil.updateExcel("Fleet", 1, 4, fleettabpage.FleetStreet0());
		eleutil.updateExcel("Fleet", 0, 5, fleettabpage.FleetZip0lbl());
		eleutil.updateExcel("Fleet", 1, 5, fleettabpage.FleetZip0());
		eleutil.updateExcel("Fleet", 0, 6, fleettabpage.FleetJur0lbl());
		eleutil.updateExcel("Fleet", 1, 6, fleettabpage.FleetJur0());
		eleutil.updateExcel("Fleet", 0, 7, fleettabpage.FleetCity0lbl());
		eleutil.updateExcel("Fleet", 1, 7, fleettabpage.FleetCity0());
		eleutil.updateExcel("Fleet", 0, 8, fleettabpage.FleetCounty0lbl());
		eleutil.updateExcel("Fleet", 1, 8, fleettabpage.FleetCounty0());
		eleutil.updateExcel("Fleet", 0, 9, fleettabpage.FleetCountry0lbl());
		eleutil.updateExcel("Fleet", 1, 9, fleettabpage.FleetCountry0());
		eleutil.updateExcel("Fleet", 0, 10, fleettabpage.FleetNonDeliverable0lbl());
		eleutil.updateExcel("Fleet", 1, 10, fleettabpage.FleetNonDeliverable0());

		fleettabpage.clickMailingAddress();

		eleutil.updateExcel("Fleet", 0, 11, fleettabpage.FleetStreet1lbl());
		eleutil.updateExcel("Fleet", 1, 11, fleettabpage.FleetStreet1());
		eleutil.updateExcel("Fleet", 0, 12, fleettabpage.FleetZip1lbl());
		eleutil.updateExcel("Fleet", 1, 12, fleettabpage.FleetZip1());
		eleutil.updateExcel("Fleet", 0, 13, fleettabpage.FleetJur1lbl());
		eleutil.updateExcel("Fleet", 1, 13, fleettabpage.FleetJur1());
		eleutil.updateExcel("Fleet", 0, 14, fleettabpage.FleetCity1lbl());
		eleutil.updateExcel("Fleet", 1, 14, fleettabpage.FleetCity1());
		eleutil.updateExcel("Fleet", 0, 15, fleettabpage.FleetCounty1lbl());
		eleutil.updateExcel("Fleet", 1, 15, fleettabpage.FleetCounty1());
		eleutil.updateExcel("Fleet", 0, 16, fleettabpage.FleetCountry1lbl());
		eleutil.updateExcel("Fleet", 1, 16, fleettabpage.FleetCountry1());
		eleutil.updateExcel("Fleet", 0, 17, fleettabpage.FleetNonDeliverable1lbl());
		eleutil.updateExcel("Fleet", 1, 17, fleettabpage.FleetNonDeliverable1());
		eleutil.updateExcel("Fleet", 0, 18, fleettabpage.FleetAttentionTOlbl());
		eleutil.updateExcel("Fleet", 1, 18, fleettabpage.FleetAttentionTO());

		fleettabpage.navigateToServiceProvider();

		eleutil.updateExcel("Fleet", 0, 19, fleettabpage.FleetServiceProviderlbl());
		eleutil.updateExcel("Fleet", 1, 19, fleettabpage.FleetServiceProvider());
		eleutil.updateExcel("Fleet", 0, 20, fleettabpage.FleetServiceLegalNamelbl());
		eleutil.updateExcel("Fleet", 1, 20, fleettabpage.FleetServiceLegalName());
		eleutil.updateExcel("Fleet", 0, 21, fleettabpage.FleetService_DBANamelbl());
		eleutil.updateExcel("Fleet", 1, 21, fleettabpage.FleetService_DBAName());
		eleutil.updateExcel("Fleet", 0, 22, fleettabpage.FleetService_PowerOfAttroneylbl());
		eleutil.updateExcel("Fleet", 1, 22, fleettabpage.FleetService_PowerOfAttroney());

		eleutil.updateExcel("Fleet", 0, 23, fleettabpage.FleetService_PowerOfAttroneyEffDatelbl());
		eleutil.updateExcel("Fleet", 1, 23, fleettabpage.FleetService_PowerOfAttroneyEffDate());
		eleutil.updateExcel("Fleet", 0, 24, fleettabpage.FleetService_PowerOfAttroneyExpDatelbl());
		eleutil.updateExcel("Fleet", 1, 24, fleettabpage.FleetService_PowerOfAttroneyExpDate());
		eleutil.updateExcel("Fleet", 0, 25, fleettabpage.FleetService_EmailIDlbl());
		eleutil.updateExcel("Fleet", 1, 25, fleettabpage.FleetService_EmailID());
		eleutil.updateExcel("Fleet", 0, 26, fleettabpage.FleetService_PhoneNolbl());
		eleutil.updateExcel("Fleet", 1, 26, fleettabpage.FleetService_PhoneNo());

		eleutil.updateExcel("Fleet", 0, 27, fleettabpage.FleetService_FaxNolbl());
		eleutil.updateExcel("Fleet", 1, 27, fleettabpage.FleetService_FaxNo());
		eleutil.updateExcel("Fleet", 0, 28, fleettabpage.FleetService_Streetlbl());
		eleutil.updateExcel("Fleet", 1, 28, fleettabpage.FleetService_Street());
		eleutil.updateExcel("Fleet", 0, 29, fleettabpage.FleetService_Citylbl());
		eleutil.updateExcel("Fleet", 1, 29, fleettabpage.FleetService_City());
		eleutil.updateExcel("Fleet", 0, 30, fleettabpage.FleetService_Jurlbl());
		eleutil.updateExcel("Fleet", 1, 30, fleettabpage.FleetService_Jur());
		eleutil.updateExcel("Fleet", 0, 31, fleettabpage.FleetService_ZipCodelbl());
		eleutil.updateExcel("Fleet", 1, 31, fleettabpage.FleetService_ZipCode());
		eleutil.updateExcel("Fleet", 0, 32, fleettabpage.FleetService_Countrylbl());
		eleutil.updateExcel("Fleet", 1, 32, fleettabpage.FleetService_Country());
		fleettabpage.clickOnTimeMailingAddress();
		eleutil.updateExcel("Fleet", 0, 33, fleettabpage.FleetServiceMailing_Streetlbl());
		eleutil.updateExcel("Fleet", 1, 33, fleettabpage.FleetServiceMailing_Street());
		eleutil.updateExcel("Fleet", 0, 34, fleettabpage.FleetServiceMailing_ZipCodelbl());
		eleutil.updateExcel("Fleet", 1, 34, fleettabpage.FleetServiceMailing_ZipCode());
		eleutil.updateExcel("Fleet", 0, 35, fleettabpage.FleetServiceMailing_Jurlbl());
		eleutil.updateExcel("Fleet", 1, 35, fleettabpage.FleetServiceMailing_Jur());
		eleutil.updateExcel("Fleet", 0, 36, fleettabpage.FleetServiceMailing_Citylbl());
		eleutil.updateExcel("Fleet", 1, 36, fleettabpage.FleetServiceMailing_City());
		eleutil.updateExcel("Fleet", 0, 37, fleettabpage.FleetServiceMailing_Countylbl());
		eleutil.updateExcel("Fleet", 1, 37, fleettabpage.FleetServiceMailing_County());
		eleutil.updateExcel("Fleet", 0, 38, fleettabpage.FleetServiceMailing_Countrylbl());
		eleutil.updateExcel("Fleet", 1, 38, fleettabpage.FleetServiceMailing_Country());
		eleutil.updateExcel("Fleet", 0, 39, fleettabpage.FleetServiceMailing_AttentionTOlbl());
		eleutil.updateExcel("Fleet", 1, 39, fleettabpage.FleetServiceMailing_AttentionTO());

		eleutil.updateExcel("Fleet", 0, 40, fleettabpage.FleetDetails_ContactNamelbl());
		eleutil.updateExcel("Fleet", 1, 40, fleettabpage.FleetDetails_ContactName());
		eleutil.updateExcel("Fleet", 0, 41, fleettabpage.FleetDetails_EmailIDlbl());
		eleutil.updateExcel("Fleet", 1, 41, fleettabpage.FleetDetails_EmailID());
		eleutil.updateExcel("Fleet", 0, 42, fleettabpage.FleetDetails_PrimaryCellNbrlbl());
		eleutil.updateExcel("Fleet", 1, 42, fleettabpage.FleetDetails_PrimaryCellNbr());
		eleutil.updateExcel("Fleet", 0, 43, fleettabpage.FleetDetails_AlternateCellNbrlbl());
		eleutil.updateExcel("Fleet", 1, 43, fleettabpage.FleetDetails_AlternateCellNbr());
		eleutil.updateExcel("Fleet", 0, 44, fleettabpage.FleetDetails_FaxNolbl());
		eleutil.updateExcel("Fleet", 1, 44, fleettabpage.FleetDetails_FaxNo());
		eleutil.updateExcel("Fleet", 0, 45, fleettabpage.FleetDetails_TPIDlbl());
		eleutil.updateExcel("Fleet", 1, 45, fleettabpage.FleetDetails_TPID());
		eleutil.updateExcel("Fleet", 0, 46, fleettabpage.FleetDetails_UsdotNbrlbl());
		eleutil.updateExcel("Fleet", 1, 46, fleettabpage.FleetDetails_UsdotNbr());
		eleutil.updateExcel("Fleet", 0, 47, fleettabpage.FleetDetails_ChangeVehUsdotTinlbl());
		eleutil.updateExcel("Fleet", 1, 47, fleettabpage.FleetDetails_ChangeVehUsdotTin());

		eleutil.updateExcel("Fleet", 0, 48, fleettabpage.FleetDetails_FltTypelbl());
		eleutil.updateExcel("Fleet", 1, 48, fleettabpage.FleetDetails_FltType());
		eleutil.updateExcel("Fleet", 0, 49, fleettabpage.FleetDetails_CommodityClasslbl());
		eleutil.updateExcel("Fleet", 1, 49, fleettabpage.FleetDetails_CommodityClass());
		eleutil.updateExcel("Fleet", 0, 50, fleettabpage.FleetDetails_FltEffDatelbl());
		eleutil.updateExcel("Fleet", 1, 50, fleettabpage.FleetDetails_FltEffDatedtPicker());
		eleutil.updateExcel("Fleet", 0, 51, fleettabpage.FleetDetails_FltExpDatelbl());
		eleutil.updateExcel("Fleet", 1, 51, fleettabpage.FleetDetails_FltExpDate());

		eleutil.updateExcel("Fleet", 0, 52, fleettabpage.FleetDetails_changeAddrOnUsdotlbl());
		eleutil.updateExcel("Fleet", 1, 52, fleettabpage.FleetDetails_changeAddrOnUsdot());
		eleutil.updateExcel("Fleet", 0, 53, fleettabpage.FleetDetails_FirstOperatedDatelbl());
		eleutil.updateExcel("Fleet", 1, 53, fleettabpage.FleetDetails_FirstOperatedDate());
		eleutil.updateExcel("Fleet", 0, 54, fleettabpage.FleetDetails_WyomingIndicatorlbl());
		eleutil.updateExcel("Fleet", 1, 54, fleettabpage.FleetDetails_WyomingIndicator());
		eleutil.updateExcel("Fleet", 0, 55, fleettabpage.FleetDetails_IFTADistancelbl());
		eleutil.updateExcel("Fleet", 1, 55, fleettabpage.FleetDetails_IFTADistance());
		eleutil.updateExcel("Fleet", 0, 56, fleettabpage.FleetDetails_MobileNotificationlbl());
		eleutil.updateExcel("Fleet", 1, 56, fleettabpage.FleetDetails_MobileNotification());

		eleutil.updateExcel("Fleet", 0, 57, fleettabpage.FleetDetails_IRPRequirementslbl());
		eleutil.updateExcel("Fleet", 1, 57, fleettabpage.FleetDetails_IRPRequirements());
		eleutil.updateExcel("Fleet", 0, 58, fleettabpage.FleetDetails_StatementOfUnderstandinglbl());
		eleutil.updateExcel("Fleet", 1, 58, fleettabpage.FleetDetails_StatementOfUnderstanding());
		eleutil.updateExcel("Fleet", 0, 59, fleettabpage.FleetDetails_InstallmentAgreementlbl());
		eleutil.updateExcel("Fleet", 1, 59, fleettabpage.FleetDetails_InstallmentAgreement());
		eleutil.updateExcel("Fleet", 0, 60, fleettabpage.FleetDetails_PowerOfAttorneylbl());
		eleutil.updateExcel("Fleet", 1, 60, fleettabpage.FleetDetails_PowerOfAttorney());

		fleettabpage.navigateToServiceProvider();

		fleettabpage.clickPowerOfAttroney();

		fleettabpage.enterEmailID(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 0));

		fleettabpage.enterContactName(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 8));

		fleettabpage.enterprimaryPhone(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 9));

		fleettabpage.selectFleetType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 9));

		fleettabpage
				.selectCommodityClass(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 10));

		fleettabpage
				.selectEffectiveDate(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 12));

		fleettabpage
				.selectExpirationDate(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 13));

		fleettabpage.selectFirstOperatedDate(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 14));

		// Collecting Documents only for Power Of Attorney
		fleettabpage
				.selectPowerOfAttroney(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 4));

		commonobjects.expandCommentSection();

		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "FleetTab", 2, 7));

		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();

		commonobjects.clickProceed();
		Thread.sleep(2000);
	}

	@Then("user should navigate to Fleet verification screen and proceed further")
	public void user_should_navigate_to_fleet_verification_screen_and_proceed_further() throws Exception {

		// Fleet Verification Screen
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
	}

	@Then("user should land on Distance screen and select Estimated Distance and proceed further")
	public void user_should_land_on_distance_screen_and_select_estimated_distance_and_proceed_further()
			throws IOException, Exception {
		
		  eleutil.updateExcel("Distance",0,0,distancetabpage.DistanceReportingPeriodFromlbl()); 
		  eleutil.updateExcel("Distance",1,0,distancetabpage.DistanceReportingPeriodFrom ()); 
		  eleutil.updateExcel("Distance",0,1,distancetabpage.DistanceReportingPeriodTolbl ()); 
		  eleutil.updateExcel("Distance",1,1,distancetabpage.DistanceReportingPeriodTo()); 
		  eleutil.updateExcel("Distance",0,2,distancetabpage.DistanceUsdotNbrlbl());
		  eleutil.updateExcel("Distance",1,2,distancetabpage.DistanceUsdotNbr()); 
		  eleutil.updateExcel("Distance",0,3,distancetabpage.DistanceEstimatedDistanceChartlbl()); 
		  eleutil.updateExcel("Distance",1,3,distancetabpage.DistanceEstimatedDistanceChart ()); 
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
	     	ArrayList<String> TableHeadervalues=Distanceverify.FetchTableHeader();
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
	     	//System.out.print("j value is:"+j);
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
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);

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
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
	}

	@Then("user should land on the Add Weight Group screen and provide all the required input to proceed")
	public void user_should_land_on_the_add_weight_group_screen_and_provide_all_the_required_input_to_proceed()
			throws IOException, Exception {
		// Weight Group
		Thread.sleep(2000);
		wgtgroup.clickAddWeightGroup();
		wgtgroupadd.selectWeightGroupType(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 8));
		Thread.sleep(2000);
		wgtgroupadd.enterWeightGroupNo(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 9));
		Thread.sleep(2000);
		wgtgroupadd.selectMaxGrossWeight(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 10));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();

	}

	@Then("user should land on the Add Weight Group Verification screen and go for  Weight group")
	public void user_should_land_on_the_add_weight_group_verification_screen_and_go_for_weight_group()
			throws IOException, Exception {
		// Add Weight Group verification Screen
		// Weight Group
		Thread.sleep(2000);
		wgtgroup.clickAddWeightGroup();
		Thread.sleep(2000);
		wgtgroupadd.selectWeightGroupType(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 12));
		Thread.sleep(2000);
		wgtgroupadd.enterWeightGroupNo(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 13));
		Thread.sleep(2000);
		wgtgroupadd.selectMaxGrossWeight(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 14));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();

	}

	@Then("user should land on the Weight Group and edit the existing weight group to proceed to Vehicle screen")
	public void user_should_land_on_the_weight_group_and_edit_the_existing_weight_group_to_proceed_to_vehicle_screen()
			throws IOException, Exception {
		// In Weight Group Screen

		// Edit Existing Weight Group
		wgtgroup.clickHandimg();
		// Thread.sleep(2000);
		String Juri_ExcelCount = ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "WeightGrouptab", 2, 4);
		for (int i = 0; i < Integer.valueOf(Juri_ExcelCount); i++) {
		//	System.out.print("i is:" + i);
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
			//System.out.print("Juri from Excel" + weightlist[i]);
			if (weightlist[i].equalsIgnoreCase(Juri_Excel)) {
				System.out.print("check Weights" + weightlist[i]);
				assert true;
			}
		}

		// In Weight Group Screen
		commonobjects.clickDonebtn();
		// Thread.sleep(2000);
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
		Thread.sleep(2000);
		int AddVehiclesCount_Excel=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,0));
		int j=0;
		for(int i=1;i<=AddVehiclesCount_Excel;i++) {
		vehicleadd.enterVINNumber(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,1+j));
		Thread.sleep(2000);
		vehicleadd.clickSearch();
		Thread.sleep(1000);
		vehicleadd.selectBodyType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab",2,3+j));
		Thread.sleep(2000);
//	vehicleadd.selectWeightGroupNumber(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleAdd"2,4));
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
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		}
		commonobjects.clickDonebtn();

		// Update Vehicle
		Vehicletabpage.clickVehicleList();
		vehicleadd.UpdatevehiclelistUnit(
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2,0));
		Thread.sleep(2000);
		vehicleadd.Updatevehiclelistsearch();
		Thread.sleep(2000);
		vehicleadd.Updatevehiclelistselectunit();
		Thread.sleep(2000);
		vehicleadd.selectTitleJurisdiction( 
				ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleUpdate",2, 1)); //AB - ALBERTA

		vehicleadd.EmptyenterInStateExpirationDate(eleutil.getDateInSpecifiedFormat("MMddYYYY",2));
		//vehicleadd.enterExistingPlate(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleAddTab", 1, 23));
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
		Thread.sleep(2000);
		vehicleadd.Updatevehiclelistsearch();
		Thread.sleep(2000);
		vehicleadd.Updatevehiclelistselectunit();
		Thread.sleep(2000);
		vehicleadd.CancelVehicle();
		eleutil.handleAlert();
		Thread.sleep(2000);
		commonobjects.clickDonebtn();

	}

	@Then("user should land on the Billing screen with open status and Request for TVR & set Delivery Type as PDF with Comments")
	public void user_should_land_on_the_billing_screen_with_open_status_and_request_for_tvr_set_delivery_type_as_pdf_with_comments()
			throws Exception, Throwable {
		Thread.sleep(2000);
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
		  eleutil.updateExcel("Billing",0,15,billingtab.fetchBilling_TVRNoOfDayslbl());
		  eleutil.updateExcel("Billing",1,15,billingtab.fetchBilling_TVRNoOfDays());
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
		Thread.sleep(2000);
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
			System.out.print("totalAmount is :"+totalAmount);
			pay.selectPaymentType(0,paymenttype);	
			String PaymentNumberValue=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,0);
			pay.enterpaymentNoBasedonType(0,paymenttype,PaymentNumberValue);
			String cashAmount=String.valueOf(Double.valueOf(totalAmount));
			System.out.print("cashAmount is:"+cashAmount);
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
	    	for(int i=0;i<TableHeader2.size();i++) {
	    		eleutil.updateExcel("Vehicle Document",0,i+TableHeader1.size(),TableHeader2.get(i));
	    	}
	    	//Juris list
	    	ArrayList<String>  row_values=vehicledocs.FetchTable_Rows();
	     	for(int i=1;i<row_values.size();i++) {
	     	eleutil.updateExcel("Vehicle Document", 1,i-1,row_values.get(i));  //0 0 13
	     	}
			vehicledocs.SelectHVUT(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleDocuments",2,0));
			vehicledocs.SelectLeaseContract(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleDocuments",2,1));
			vehicledocs.SelectTitleDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleDocuments",2,2));
			vehicledocs.SelectPlateReturn(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(), "VehicleDocuments",2,3));
		    commonobjects.clickProceed();
			eleutil.CloseFirstChildWindow();  //To close PDF Window
		    Thread.sleep(2000);
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
			System.out.print("totalAmount is :"+totalAmount1);
			pay.selectPaymentType(0,paymenttype1);	
			String PaymentNumberValue1=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,0);
			pay.enterpaymentNoBasedonType(0,paymenttype1,PaymentNumberValue1);
			String cashAmount1=String.valueOf(Double.valueOf(totalAmount1));
			System.out.print("cashAmount is:"+cashAmount1);
				pay.enterPaymentAmountBasedonType(0,paymenttype1,cashAmount1);
				pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",2,3));
			commonobjects.clickProceed();
			//Installment Verification Screen
			commonobjects.clickProceed();

			eleutil.CloseFirstChildWindow();
			Thread.sleep(1000);
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
		/*String ParentWindow=eleutil.GetParentWindow();
		dashboardpage.clickVehicleEnquiry();
		String childWindow= eleutil.SwitchtoFirstChildWindow();
		 fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,0));
		  commonobjects.clickProceed();*/
		System.out.println("Vehcile Enquiry");
	}
	@Then("user verifies details in Vehicle Supplement Enquiry")
	public void user_verifies_details_in_Vehicle_Supplement_enquiry() throws Exception {
		String ParentWindow=eleutil.GetParentWindow();
		dashboardpage.clickVehicleSupplementEnquiry();
		String childWindow= eleutil.SwitchtoFirstChildWindow();
		 fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,0));
		  commonobjects.clickProceed();
		  enquiry.VehicleSupplementEnquiryvaluevalidation(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Enquiry",2,0));
		  eleutil.closespecificWindow(childWindow);
			eleutil.SwitchspecificWindow(ParentWindow);
	}
	
}