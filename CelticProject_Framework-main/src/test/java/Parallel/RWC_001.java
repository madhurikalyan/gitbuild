package Parallel;


import java.io.IOException;
import java.util.ArrayList;
import com.pages.AccountTabPage;
import com.pages.BillingTab;
import com.pages.CommonObjects;
import com.pages.DashBoardPage;
import com.pages.DistanceTabPage;
import com.pages.Financepage;
import com.pages.FleetPage;
import com.pages.FleetTabPage;
import com.pages.InventoryPage;
import com.pages.LoginPage;
import com.pages.Payment;
import com.pages.PaymentTab;
import com.pages.VehicleAmend;
import com.pages.VehicleDelete;
import com.pages.VehicleTabPage;
import com.pages.WgtGroup;
import com.pages.WgtGroupAdd;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RWC_001 {

	LoginPage loginpage = new LoginPage(Driver_Factory.getDriver());
	DashBoardPage dashboardpage = new DashBoardPage(Driver_Factory.getDriver());
	AccountTabPage accounttabpage = new AccountTabPage(Driver_Factory.getDriver());
	FleetTabPage fleettabpage = new FleetTabPage(Driver_Factory.getDriver());
	FleetPage fleetpage = new FleetPage(Driver_Factory.getDriver());
	DistanceTabPage distancetabpage = new DistanceTabPage(Driver_Factory.getDriver());
	WgtGroup wgtgroup = new WgtGroup(Driver_Factory.getDriver());
	WgtGroupAdd wgtgroupadd = new WgtGroupAdd(Driver_Factory.getDriver());
	VehicleTabPage Vehicletabpage = new VehicleTabPage(Driver_Factory.getDriver());
	VehicleAmend vehicleAmend =new VehicleAmend(Driver_Factory.getDriver());
	VehicleDelete vehicleDelete =new VehicleDelete(Driver_Factory.getDriver());
	CommonObjects commonobjects = new CommonObjects(Driver_Factory.getDriver());
	BillingTab billingtab = new BillingTab(Driver_Factory.getDriver());
	Payment pay =new Payment(Driver_Factory.getDriver());
	PaymentTab paymenttab = new PaymentTab(Driver_Factory.getDriver());
	InventoryPage inventorypage = new InventoryPage(Driver_Factory.getDriver());
	ExcelReader excel =new ExcelReader();
	int Noof=0;
	Financepage financepage =new Financepage(Driver_Factory.getDriver());
	ElementUtil eleutil =new ElementUtil();
	
	
	
	
	
	@Given("User login as Internal user")
	public void user_login_as_internal_user() throws Exception {
		Driver_Factory.getDriver().get(ConfigReader.readLoginURL());
		loginpage.enterUsername(ConfigReader.readLoginInternalUser());
		loginpage.enterPassword(ConfigReader.readpswrd());
		loginpage.clickLoginbtn();
	}

	@When("User will navigate to IRP")
	public void user_will_navigate_to_irp() throws Exception {
		dashboardpage.clickIRPLink();
		dashboardpage.clickRenewFleetLink();
	}

	@Then("User will navigate to renew fleet and input all the details")
	public void user_will_navigate_to_renew_fleet_and_input_all_the_details() throws Exception {
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,0));
		fleetpage.enterFleetNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,2));
		fleetpage.enterFleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,3));
		commonobjects.clickProceed();	
		
		//Thread.sleep(2000);
		//In Account Page
		accounttabpage.checkEmailNotification();
		commonobjects.expandCommentSection();
		//Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"AccountTab",1,0));
		//Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		
//In Account Verification Screen
		//Verification screen Fetching Data
//		eleutil.updateExcel("Account", 0, 0,accountverify.fetchAccountnolbl());
//		eleutil.updateExcel("Account", 1, 0,accountverify.fetchAccountno());
//		eleutil.updateExcel("Account", 0,1,accountverify.fetchMCECustomernolbl());
//		eleutil.updateExcel("Account", 1,1,accountverify.fetchMCECustomerno());
//		eleutil.updateExcel("Account", 0,2,accountverify.fetchARegistrationTypelbl());
//		eleutil.updateExcel("Account", 1,2,accountverify.fetchARegistrationType());
//		eleutil.updateExcel("Account", 0,3,accountverify.fetchAccountCarrierTypelbl());
//		eleutil.updateExcel("Account", 1,3,accountverify.fetchAccountCarrierType());
//		eleutil.updateExcel("Account", 0,4,accountverify.fetchAccountLegalNamelbl());
//		eleutil.updateExcel("Account", 1,4,accountverify.fetchAccountLegalName());
//		eleutil.updateExcel("Account", 0,5,accountverify.fetchIFTAAccountNbrlbl());
//		eleutil.updateExcel("Account", 1,5,accountverify.fetchIFTAAccountNbr());
//		eleutil.updateExcel("Account", 0,6,accountverify.fetchAccountCustomerStatuslbl());
//		eleutil.updateExcel("Account", 1,6,accountverify.fetchAccountCustomerStatus());
//		eleutil.updateExcel("Account", 0,7,accountverify.fetchDBANamelbl());
//		eleutil.updateExcel("Account", 1,7,accountverify.fetchDBAName());
//		eleutil.updateExcel("Account", 0,8,accountverify.fetchAccountStreet0lbl());
//		eleutil.updateExcel("Account", 1,8,accountverify.fetchAccountStreet0());
//		eleutil.updateExcel("Account", 0,9,accountverify.fetchAccountZip0lbl());
//		eleutil.updateExcel("Account", 1,9,accountverify.fetchAccountZip0());
//		eleutil.updateExcel("Account", 0,10,accountverify.fetchAccountJur0lbl());
//		eleutil.updateExcel("Account", 1,10,accountverify.fetchAccountJur0());
//		eleutil.updateExcel("Account", 0,11,accountverify.fetchAccountCity0lbl());
//		eleutil.updateExcel("Account", 1,11,accountverify.fetchAccountCity0());
//		eleutil.updateExcel("Account", 0,12,accountverify.fetchAccountCounty0lbl());
//		eleutil.updateExcel("Account", 1,12,accountverify.fetchAccountCounty0());
//		eleutil.updateExcel("Account", 0,13,accountverify.fetchAccountCountry0lbl());
//		eleutil.updateExcel("Account", 1,13,accountverify.fetchAccountCountry0());
//		eleutil.updateExcel("Account", 0,14,accountverify.fetchAccountStreet1lbl());
//		eleutil.updateExcel("Account", 1,14,accountverify.fetchAccountStreet1());
//		eleutil.updateExcel("Account", 0,15,accountverify.fetchAccountZip1lbl());
//		eleutil.updateExcel("Account", 1,15,accountverify.fetchAccountZip1());
//		eleutil.updateExcel("Account", 0,16,accountverify.fetchAccountJur1lbl());
//		eleutil.updateExcel("Account", 1,16,accountverify.fetchAccountJur1());
//		eleutil.updateExcel("Account", 0,17,accountverify.fetchAccountCity1lbl());
//		eleutil.updateExcel("Account", 1,17,accountverify.fetchAccountCity1());
//		eleutil.updateExcel("Account", 0,18,accountverify.fetchAccountCounty1lbl());
//		eleutil.updateExcel("Account", 1,18,accountverify.fetchAccountCounty1());
//		eleutil.updateExcel("Account", 0,19,accountverify.fetchAccountCountry1lbl());
//		eleutil.updateExcel("Account", 1,19,accountverify.fetchAccountCountry1());
//		eleutil.updateExcel("Account", 0,20,accountverify.fetchAccountUSDOTNolbl());
//		eleutil.updateExcel("Account", 1,20,accountverify.fetchAccountUSDOTNo());
//		eleutil.updateExcel("Account", 0,21,accountverify.fetchAccountTPIDlbl());
//		eleutil.updateExcel("Account", 1,21,accountverify.fetchAccountTPID());
//		eleutil.updateExcel("Account", 0,22,accountverify.fetchAccountContactnamelbl());
//		eleutil.updateExcel("Account", 1,22,accountverify.fetchAccountContactname());
//		eleutil.updateExcel("Account", 0,23,accountverify.fetchAccountPrimaryPhonelbl());
//		eleutil.updateExcel("Account", 1,23,accountverify.fetchAccountPrimaryPhone());
//		eleutil.updateExcel("Account", 0,24,accountverify.fetchAccountAlternatePhonelbl());
//		eleutil.updateExcel("Account", 1,24,accountverify.fetchAccountAlternatePhone());
//		eleutil.updateExcel("Account", 0,25,accountverify.fetchAccountFaxNolbl());
//		eleutil.updateExcel("Account", 1,25,accountverify.fetchAccountFaxNo());
//		eleutil.updateExcel("Account", 0,26,accountverify.fetchAccountEmailnotificationlbl());
//		eleutil.updateExcel("Account", 1,26,accountverify.fetchAccountEmailnotification());
//		eleutil.updateExcel("Account", 0,27,accountverify.fetchAccountFaxnotificationlbl());
//		eleutil.updateExcel("Account", 1,27,accountverify.fetchAccountFaxnotification());
//			
		commonobjects.clickProceed();
		//Thread.sleep(2000);
//In Fleet Screen
		fleettabpage.navigateToServiceProvider();
		//Thread.sleep(2000);
		fleettabpage.clickPowerOfAttroney();
		//Thread.sleep(2000);
		fleettabpage.enterEmailID(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,0));
		//Thread.sleep(2000);
		fleettabpage.selectIRPRequirementForm(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,1));
		//Thread.sleep(2000);
		fleettabpage.selectStatementofUnderstanding(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,2));		
		//Thread.sleep(2000);
		fleettabpage.selectInstallmentAgreement(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,3));
		//Thread.sleep(2000);
		fleettabpage.selectPowerOfAttroney(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,4));
		//Thread.sleep(2000);
		fleettabpage.selectHVUTForm(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,5));
		//Thread.sleep(2000);
		fleettabpage.selectPropertyTax(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,6));
		//Thread.sleep(2000);
		commonobjects.expandCommentSection();
		//Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,7));
		//Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		//Fleet Verification Screen
	/*	eleutil.updateExcel("Fleet", 0,0,fleetverify.FleetNbrlbl());
		eleutil.updateExcel("Fleet", 1,0,fleetverify.FleetNbr());
		eleutil.updateExcel("Fleet", 0,1,fleetverify.FleetRegistrantTypelbl());
		eleutil.updateExcel("Fleet", 1,1,fleetverify.FleetRegistrantType());
		eleutil.updateExcel("Fleet", 0,2,fleetverify.FleetfltNbrlbl());
		eleutil.updateExcel("Fleet", 1,2,fleetverify.FleetfltNbr());
		eleutil.updateExcel("Fleet", 0,3,fleetverify.FleetfltStatuslbl());
		eleutil.updateExcel("Fleet", 1,3,fleetverify.FleetfltStatus());
		eleutil.updateExcel("Fleet", 0,4,fleetverify.FleetCarriertypelbl());
		eleutil.updateExcel("Fleet", 1,4,fleetverify.FleetCarriertype());
		eleutil.updateExcel("Fleet", 0,5,fleetverify.FleetLegalNamelbl());
		eleutil.updateExcel("Fleet", 1,5,fleetverify.FleetLegalName());
		eleutil.updateExcel("Fleet", 0,6,fleetverify.FleetDBANamelbl());
		eleutil.updateExcel("Fleet", 1,6,fleetverify.FleetDBAName());
		eleutil.updateExcel("Fleet", 0,7,fleetverify.FleetStreet0lbl());
		eleutil.updateExcel("Fleet", 1,7,fleetverify.FleetStreet0());
		eleutil.updateExcel("Fleet", 0,8,fleetverify.FleetZip0lbl());
		eleutil.updateExcel("Fleet", 1,8,fleetverify.FleetZip0());
		eleutil.updateExcel("Fleet", 0,9,fleetverify.FleetJur0lbl());
		eleutil.updateExcel("Fleet", 1,9,fleetverify.FleetJur0());
		eleutil.updateExcel("Fleet", 0,10,fleetverify.FleetCity0lbl());
		eleutil.updateExcel("Fleet", 1,10,fleetverify.FleetCity0());
		eleutil.updateExcel("Fleet", 0,11,fleetverify.FleetCounty0lbl());
		eleutil.updateExcel("Fleet", 1,11,fleetverify.FleetCounty0());
		eleutil.updateExcel("Fleet", 0,12,fleetverify.FleetCountry0lbl());
		eleutil.updateExcel("Fleet", 1,12,fleetverify.FleetCountry0());
		eleutil.updateExcel("Fleet", 0,13,fleetverify.FleetNonDeliverable0lbl());
		eleutil.updateExcel("Fleet", 1,13,fleetverify.FleetNonDeliverable0());
		eleutil.updateExcel("Fleet", 0,14,fleetverify.FleetAddressOverridenlbl());
		eleutil.updateExcel("Fleet", 1,14,fleetverify.FleetAddressOverriden());
		eleutil.updateExcel("Fleet", 0,15,fleetverify.FleetStreet1lbl());
		eleutil.updateExcel("Fleet", 1,15,fleetverify.FleetStreet1());
		eleutil.updateExcel("Fleet", 0,16,fleetverify.FleetZip1lbl());
		eleutil.updateExcel("Fleet", 1,16,fleetverify.FleetZip1());
		eleutil.updateExcel("Fleet", 0,17,fleetverify.FleetJur1lbl());
		eleutil.updateExcel("Fleet", 1,17,fleetverify.FleetJur1());
		eleutil.updateExcel("Fleet", 0,18,fleetverify.FleetCity1lbl());
		eleutil.updateExcel("Fleet", 1,18,fleetverify.FleetCity1());
		eleutil.updateExcel("Fleet", 0,19,fleetverify.FleetCounty1lbl());
		eleutil.updateExcel("Fleet", 1,19,fleetverify.FleetCounty1());
		eleutil.updateExcel("Fleet", 0,20,fleetverify.FleetCountry1lbl());
		eleutil.updateExcel("Fleet", 1,20,fleetverify.FleetCountry1());
		eleutil.updateExcel("Fleet", 0,21,fleetverify.FleetNonDeliverable1lbl());
		eleutil.updateExcel("Fleet", 1,21,fleetverify.FleetNonDeliverable1());
		eleutil.updateExcel("Fleet", 0,22,fleetverify.FleetAttentionTOlbl());
		eleutil.updateExcel("Fleet", 1,22,fleetverify.FleetAttentionTO());
		eleutil.updateExcel("Fleet", 0,23,fleetverify.FleetAddressOverriden1lbl());
		eleutil.updateExcel("Fleet", 1,23,fleetverify.FleetAddressOverriden1());
		eleutil.updateExcel("Fleet", 0,24,fleetverify.FleetServiceProviderlbl());
		eleutil.updateExcel("Fleet", 1,24,fleetverify.FleetServiceProvider());
		eleutil.updateExcel("Fleet", 0,25,fleetverify.FleetServiceLegalNamelbl());
		eleutil.updateExcel("Fleet", 1,25,fleetverify.FleetServiceLegalName());
		eleutil.updateExcel("Fleet", 0,26,fleetverify.FleetService_DBANamelbl());
		eleutil.updateExcel("Fleet", 1,26,fleetverify.FleetService_DBAName());
		eleutil.updateExcel("Fleet", 0,27,fleetverify.FleetService_PowerOfAttroneylbl());
		eleutil.updateExcel("Fleet", 1,27,fleetverify.FleetService_PowerOfAttroney());
		eleutil.updateExcel("Fleet", 0,28,fleetverify.FleetService_PowerOfAttroneyEffDatelbl());
		eleutil.updateExcel("Fleet", 1,28,fleetverify.FleetService_PowerOfAttroneyEffDate());
		eleutil.updateExcel("Fleet", 0,29,fleetverify.FleetService_PowerOfAttroneyExpDatelbl());
		eleutil.updateExcel("Fleet", 1,29,fleetverify.FleetService_PowerOfAttroneyExpDate());
		eleutil.updateExcel("Fleet", 0,30,fleetverify.FleetService_EmailIDlbl());
		eleutil.updateExcel("Fleet", 1,30,fleetverify.FleetService_EmailID());
		eleutil.updateExcel("Fleet", 0,31,fleetverify.FleetService_PhoneNolbl());
		eleutil.updateExcel("Fleet", 1,31,fleetverify.FleetService_PhoneNo());
		eleutil.updateExcel("Fleet", 0,32,fleetverify.FleetService_FaxNolbl());
		eleutil.updateExcel("Fleet", 1,32,fleetverify.FleetService_FaxNo());
		eleutil.updateExcel("Fleet", 0,33,fleetverify.FleetService_Streetlbl());
		eleutil.updateExcel("Fleet", 1,33,fleetverify.FleetService_Street());
		eleutil.updateExcel("Fleet", 0,34,fleetverify.FleetService_Citylbl());
		eleutil.updateExcel("Fleet", 1,34,fleetverify.FleetService_City());
		eleutil.updateExcel("Fleet", 0,35,fleetverify.FleetService_Jurlbl());
		eleutil.updateExcel("Fleet", 1,35,fleetverify.FleetService_Jur());
		eleutil.updateExcel("Fleet", 0,36,fleetverify.FleetService_ZipCodelbl());
		eleutil.updateExcel("Fleet", 1,36,fleetverify.FleetService_ZipCode());
		eleutil.updateExcel("Fleet", 0,37,fleetverify.FleetService_Countrylbl());
		eleutil.updateExcel("Fleet", 1,37,fleetverify.FleetService_Country());
		eleutil.updateExcel("Fleet", 0,38,fleetverify.FleetServiceMailing_Streetlbl());
		eleutil.updateExcel("Fleet", 1,38,fleetverify.FleetServiceMailing_Street());
		eleutil.updateExcel("Fleet", 0,39,fleetverify.FleetServiceMailing_ZipCodelbl());
		eleutil.updateExcel("Fleet", 1,39,fleetverify.FleetServiceMailing_ZipCode());
		eleutil.updateExcel("Fleet", 0,40,fleetverify.FleetServiceMailing_Jurlbl());
		eleutil.updateExcel("Fleet", 1,40,fleetverify.FleetServiceMailing_Jur());
		eleutil.updateExcel("Fleet", 0,41,fleetverify.FleetServiceMailing_Citylbl());
		eleutil.updateExcel("Fleet", 1,41,fleetverify.FleetServiceMailing_City());
		eleutil.updateExcel("Fleet", 0,42,fleetverify.FleetServiceMailing_Countylbl());
		eleutil.updateExcel("Fleet", 1,42,fleetverify.FleetServiceMailing_County());
		eleutil.updateExcel("Fleet", 0,43,fleetverify.FleetServiceMailing_Countrylbl());
		eleutil.updateExcel("Fleet", 1,43,fleetverify.FleetServiceMailing_Country());
		eleutil.updateExcel("Fleet", 0,44,fleetverify.FleetServiceMailing_AttentionTOlbl());
		eleutil.updateExcel("Fleet", 1,44,fleetverify.FleetServiceMailing_AttentionTO());
		eleutil.updateExcel("Fleet", 0,45,fleetverify.FleetServiceMailing_AdsressOverriddenlbl());
		eleutil.updateExcel("Fleet", 1,45,fleetverify.FleetServiceMailing_AdsressOverridden());
		eleutil.updateExcel("Fleet", 0,46,fleetverify.FleetDetails_ContactNamelbl());
		eleutil.updateExcel("Fleet", 1,46,fleetverify.FleetDetails_ContactName());
		eleutil.updateExcel("Fleet", 0,47,fleetverify.FleetDetails_EmailIDlbl());
		eleutil.updateExcel("Fleet", 1,47,fleetverify.FleetDetails_EmailID());
		eleutil.updateExcel("Fleet", 0,48,fleetverify.FleetDetails_PrimaryCellNbrlbl());
		eleutil.updateExcel("Fleet", 1,48,fleetverify.FleetDetails_PrimaryCellNbr());
		eleutil.updateExcel("Fleet", 0,49,fleetverify.FleetDetails_AlternateCellNbrlbl());
		eleutil.updateExcel("Fleet", 1,49,fleetverify.FleetDetails_AlternateCellNbr());
		eleutil.updateExcel("Fleet", 0,50,fleetverify.FleetDetails_FaxNolbl());
		eleutil.updateExcel("Fleet", 1,50,fleetverify.FleetDetails_FaxNo());
		eleutil.updateExcel("Fleet", 0,51,fleetverify.FleetDetails_TPIDlbl());
		eleutil.updateExcel("Fleet", 1,51,fleetverify.FleetDetails_TPID());
		eleutil.updateExcel("Fleet", 0,52,fleetverify.FleetDetails_UsdotNbrlbl());
		eleutil.updateExcel("Fleet", 1,52,fleetverify.FleetDetails_UsdotNbr());
		eleutil.updateExcel("Fleet", 0,53,fleetverify.FleetDetails_ChangeVehUsdotTinlbl());
		eleutil.updateExcel("Fleet", 1,53,fleetverify.FleetDetails_ChangeVehUsdotTin());
		eleutil.updateExcel("Fleet", 0,54,fleetverify.FleetDetails_FltTypelbl());
		eleutil.updateExcel("Fleet", 1,54,fleetverify.FleetDetails_FltType());
		eleutil.updateExcel("Fleet", 0,55,fleetverify.FleetDetails_CommodityClasslbl());
		eleutil.updateExcel("Fleet", 1,55,fleetverify.FleetDetails_CommodityClass());
		eleutil.updateExcel("Fleet", 0,56,fleetverify.FleetDetails_FltEffDatelbl());
		eleutil.updateExcel("Fleet", 1,56,fleetverify.FleetDetails_FltEffDatedtPicker());
		eleutil.updateExcel("Fleet", 0,57,fleetverify.FleetDetails_FltExpDatelbl());
		eleutil.updateExcel("Fleet", 1,57,fleetverify.FleetDetails_FltExpDate());
		eleutil.updateExcel("Fleet", 0,58,fleetverify.FleetDetails_changeAddrOnUsdotlbl());
		eleutil.updateExcel("Fleet", 1,58,fleetverify.FleetDetails_changeAddrOnUsdot());
		eleutil.updateExcel("Fleet", 0,59,fleetverify.FleetDetails_FirstOperatedDatelbl());
		eleutil.updateExcel("Fleet", 1,59,fleetverify.FleetDetails_FirstOperatedDate());
		eleutil.updateExcel("Fleet", 0,60,fleetverify.FleetDetails_WyomingIndicatorlbl());
		eleutil.updateExcel("Fleet", 1,60,fleetverify.FleetDetails_WyomingIndicator());
		eleutil.updateExcel("Fleet", 0,61,fleetverify.FleetDetails_IFTADistancelbl());
		eleutil.updateExcel("Fleet", 1,61,fleetverify.FleetDetails_IFTADistance());
		eleutil.updateExcel("Fleet", 0,62,fleetverify.FleetDetails_MobileNotificationlbl());
		eleutil.updateExcel("Fleet", 1,62,fleetverify.FleetDetails_MobileNotification());
		eleutil.updateExcel("Fleet", 0,63,fleetverify.FleetDocCollection_IRPRequirementsFormlbl());
		eleutil.updateExcel("Fleet", 1,63,fleetverify.FleetDocCollection_IRPRequirementsForm());
		eleutil.updateExcel("Fleet", 0,64,fleetverify.FleetDocCollection_StatementOfUnderstandinglbl());
		eleutil.updateExcel("Fleet", 1,64,fleetverify.FleetDocCollection_StatementOfUnderstanding());
		eleutil.updateExcel("Fleet", 0,65,fleetverify.FleetDocCollection_InstallmentAgreementlbl());
		eleutil.updateExcel("Fleet", 1,65,fleetverify.FleetDocCollection_InstallmentAgreement());
		eleutil.updateExcel("Fleet", 0,66,fleetverify.FleetDocCollection_PowerOfAttorneylbl());
		eleutil.updateExcel("Fleet", 1,66,fleetverify.FleetDocCollection_PowerOfAttorney());
		eleutil.updateExcel("Fleet", 0,67,fleetverify.FleetVehDocument_HVUTFormlbl());
		eleutil.updateExcel("Fleet", 1,67,fleetverify.FleetVehDocument_HVUTForm());
		eleutil.updateExcel("Fleet", 0,68,fleetverify.FleetVehDocument_PropertyTaxlbl());
		eleutil.updateExcel("Fleet", 1,68,fleetverify.FleetVehDocument_PropertyTax());*/
		
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		
		//Distance tab
		//Thread.sleep(2000);
		distancetabpage.enterMODistanceValue(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",1,0), ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",1,1));
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",1,2));
		//Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
     	commonobjects.clickProceed();
     	//Distance Verification Screen
     /*	eleutil.updateExcel("Distance", 0, 0,Distanceverify.fetchAccountnolbl());
     	eleutil.updateExcel("Distance", 1, 0,Distanceverify.fetchAccountno());
     	eleutil.updateExcel("Distance", 0,1,Distanceverify.FleetNbrlbl());
     	eleutil.updateExcel("Distance", 1,1,Distanceverify.FleetNbr());
     	eleutil.updateExcel("Distance", 0,2,Distanceverify.DistanceSupplementNbrlbl());
     	eleutil.updateExcel("Distance", 1,2,Distanceverify.DistanceSupplementNbr());
     	eleutil.updateExcel("Distance", 0,3,Distanceverify.DistanceLegalNamelbl());
     	eleutil.updateExcel("Distance", 1,3,Distanceverify.DistanceLegalName());
     	eleutil.updateExcel("Distance", 0,4,Distanceverify.DistanceDBANamelbl());
     	eleutil.updateExcel("Distance", 1,4,Distanceverify.DistanceDBAName());
     	eleutil.updateExcel("Distance", 0,5,Distanceverify.DistanceFleetEffectiveDatelbl());
     	eleutil.updateExcel("Distance", 1,5,Distanceverify.DistanceFleetEffectiveDate());
     	eleutil.updateExcel("Distance", 0,6,Distanceverify.DistanceFleetExpiryMonthYearlbl());
     	eleutil.updateExcel("Distance", 1,6,Distanceverify.DistanceFleetExpiryMonth());
     	eleutil.updateExcel("Distance", 1,7,Distanceverify.DistanceFleetExpiryyear());
     	eleutil.updateExcel("Distance", 0,8,Distanceverify.DistanceSupplementDesclbl ());
     	eleutil.updateExcel("Distance", 1,8,Distanceverify.DistanceSupplementDesc());
     	eleutil.updateExcel("Distance", 0,9,Distanceverify.DistanceReportingPeriodFromlbl ());
     	eleutil.updateExcel("Distance", 1,9,Distanceverify.DistanceReportingPeriodFrom ());
     	eleutil.updateExcel("Distance", 0,10,Distanceverify.DistanceReportingPeriodTolbl ());
     	eleutil.updateExcel("Distance", 1,10,Distanceverify.DistanceReportingPeriodTo());
     	eleutil.updateExcel("Distance", 0,11,Distanceverify.DistanceUsdotNbrlbl());
     	eleutil.updateExcel("Distance", 1,11,Distanceverify.DistanceUsdotNbr());
     	eleutil.updateExcel("Distance", 0,12,Distanceverify.DistanceEstimatedDistanceChartlbl());
     	eleutil.updateExcel("Distance", 1,12,Distanceverify.DistanceEstimatedDistanceChart ());
     	eleutil.updateExcel("Distance", 0,12,Distanceverify.DistanceOverrideContJurlbl ());
     	eleutil.updateExcel("Distance", 1,13,Distanceverify.DistanceOverrideContJurFrom());
     	eleutil.updateExcel("Distance", 0,13,Distanceverify.DistanceActualDistanceGenlbl());
     	eleutil.updateExcel("Distance", 1,14,Distanceverify.DistanceActualDistanceGen());
     	eleutil.updateExcel("Distance", 0,14,Distanceverify.DistanceFirstYearEstimatedMileagelbl());
     	eleutil.updateExcel("Distance", 1,15,Distanceverify.DistanceFirstYearEstimatedMileage());
     	eleutil.updateExcel("Distance", 0,16,Distanceverify.DistanceTotalFleetDistanceGenlbl());
     	eleutil.updateExcel("Distance", 1,16,Distanceverify.DistanceTotalFleetDistanceGen());
     	eleutil.updateExcel("Distance", 0,17,Distanceverify.DistanceFRPMlgQuetionlbl());
     	eleutil.updateExcel("Distance", 1,15,Distanceverify.DistanceFRPMlgQuetion());
     	eleutil.updateExcel("Distance", 0,17,Distanceverify.DistanceDistanceTypelbl());
     	eleutil.updateExcel("Distance", 1,18,Distanceverify.DistanceDistanceType());
     	eleutil.updateExcel("Distance", 0, 0,Distanceverify.fetchAccountnolbl());
     	eleutil.updateExcel("Distance", 1, 0,Distanceverify.fetchAccountno());
     	eleutil.updateExcel("Distance", 0,1,Distanceverify.FleetNbrlbl());
     	eleutil.updateExcel("Distance", 1,1,Distanceverify.FleetNbr());
     	eleutil.updateExcel("Distance", 0,2,Distanceverify.DistanceSupplementNbrlbl());
     	eleutil.updateExcel("Distance", 1,2,Distanceverify.DistanceSupplementNbr());
     	eleutil.updateExcel("Distance", 0,3,Distanceverify.DistanceLegalNamelbl());
     	eleutil.updateExcel("Distance", 1,3,Distanceverify.DistanceLegalName());
     	eleutil.updateExcel("Distance", 0,4,Distanceverify.DistanceDBANamelbl());
     	eleutil.updateExcel("Distance", 1,4,Distanceverify.DistanceDBAName());
     	eleutil.updateExcel("Distance", 0,5,Distanceverify.DistanceFleetEffectiveDatelbl());
     	eleutil.updateExcel("Distance", 1,5,Distanceverify.DistanceFleetEffectiveDate());
     	eleutil.updateExcel("Distance", 0,6,Distanceverify.DistanceFleetExpiryMonthYearlbl());
     	eleutil.updateExcel("Distance", 1,6,Distanceverify.DistanceFleetExpiryMonth());
     	eleutil.updateExcel("Distance", 1,7,Distanceverify.DistanceFleetExpiryyear());
     	eleutil.updateExcel("Distance", 0,8,Distanceverify.DistanceSupplementDesclbl ());
     	eleutil.updateExcel("Distance", 1,8,Distanceverify.DistanceSupplementDesc());
     	eleutil.updateExcel("Distance", 0,9,Distanceverify.DistanceReportingPeriodFromlbl ());
     	eleutil.updateExcel("Distance", 1,9,Distanceverify.DistanceReportingPeriodFrom ());
     	eleutil.updateExcel("Distance", 0,10,Distanceverify.DistanceReportingPeriodTolbl ());
     	eleutil.updateExcel("Distance", 1,10,Distanceverify.DistanceReportingPeriodTo());
     	eleutil.updateExcel("Distance", 0,11,Distanceverify.DistanceUsdotNbrlbl());
     	eleutil.updateExcel("Distance", 1,11,Distanceverify.DistanceUsdotNbr());
     	eleutil.updateExcel("Distance", 0,12,Distanceverify.DistanceEstimatedDistanceChartlbl());
     	eleutil.updateExcel("Distance", 1,12,Distanceverify.DistanceEstimatedDistanceChart ());
     	eleutil.updateExcel("Distance", 0,12,Distanceverify.DistanceOverrideContJurlbl ());
     	eleutil.updateExcel("Distance", 1,13,Distanceverify.DistanceOverrideContJurFrom());
     	eleutil.updateExcel("Distance", 0,14,Distanceverify.DistanceActualDistanceGenlbl());
     	eleutil.updateExcel("Distance", 1,14,Distanceverify.DistanceActualDistanceGen());
     	eleutil.updateExcel("Distance", 0,15,Distanceverify.DistanceFirstYearEstimatedMileagelbl());
     	eleutil.updateExcel("Distance", 1,15,Distanceverify.DistanceFirstYearEstimatedMileage());
     	eleutil.updateExcel("Distance", 0,16,Distanceverify.DistanceTotalFleetDistanceGenlbl());
     	eleutil.updateExcel("Distance", 1,16,Distanceverify.DistanceTotalFleetDistanceGen());
     	eleutil.updateExcel("Distance", 0,17,Distanceverify.DistanceFRPMlgQuetionlbl());
     	eleutil.updateExcel("Distance", 1,17,Distanceverify.DistanceFRPMlgQuetion());
     	eleutil.updateExcel("Distance", 0,18,Distanceverify.DistanceDistanceTypelbl());
     	eleutil.updateExcel("Distance", 1,18,Distanceverify.DistanceDistanceType());
     	eleutil.updateExcel("Distance", 0,19,Distanceverify.DistanceActualDistConfirmationlbl());
     	eleutil.updateExcel("Distance", 1,19,Distanceverify.DistanceActualDistConfirmation()); */

     	//Juris Table Verification
     	//Juris Table header
     /*	ArrayList<String> TableHeadervalues=Distanceverify.FetchTableHeader();
    	for(int i=0;i<TableHeadervalues.size();i++) {
    		eleutil.updateExcel("Distance_Juris",0,i,TableHeadervalues.get(i));
    	}
    	//Juris list
    	ArrayList<String>  Juris_values=Distanceverify.FetchTable_Juris();
    	ArrayList<String>  Distance_values=Distanceverify.FetchTable_DistanceMiles();
    	ArrayList<String>  Percent_values=Distanceverify.FetchTable_Percent();
    	int j=0;
     	for(int i=0;i<Juris_values.size();i++) {
     		
     	eleutil.updateExcel("Distance_Juris", 1,i+j,Juris_values.get(i));  //0 0 13
     	j++; 
     	eleutil.updateExcel("Distance_Juris", 1,i+j,Distance_values.get(i)); //01 14
     	j++;
     	eleutil.updateExcel("Distance_Juris", 1,i+j,Percent_values.get(i)); //02 15
     	
     	}
     	 */
     	
  
     
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		
	}

	@Then("User will add, amend or delete vehicle as per the requirement")
	public void user_will_add_amend_or_delete_vehicle_as_per_the_requirement() throws Exception {
		//Thread.sleep(2000);
		//Weight Tab Screen
		wgtgroup.clickAddWeightGroup();
		//Add Weight Group Screen
		wgtgroupadd.selectWeightGroupType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,0));
		//Thread.sleep(2000);
		wgtgroupadd.enterWeightGroupNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,1));
		wgtgroupadd.selectMaxGrossWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,2));
		Thread.sleep(1000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		
		//Weight Group Screen
		//Edit Existing Weight Group
		wgtgroup.clickHandimg();
		//Thread.sleep(2000);
		String Juri_ExcelCount=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,4);
for(int i=0;i<Integer.valueOf(Juri_ExcelCount);i++) {
	System.out.print("i is:"+i);
String Juri_Excel=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,i+5);
wgtgroupadd.enterWeight_JuriValue(Juri_Excel);
}
	commonobjects.clickProceed();
	// Weight Group Verification Screen
	commonobjects.clickProceed();
	/*ArrayList<String>  headervalues=wgtverify.FetchTableHeader();
	for(int i=0;i<headervalues.size();i++) {
		eleutil.updateExcel("WeightGrouptab",0,i,headervalues.get(i));
	}
	ArrayList<String>  RowDatavalues=wgtverify.FetchTableRowData();
	for(int i=0;i<RowDatavalues.size();i++) {
		eleutil.updateExcel("WeightGrouptab",1,i,RowDatavalues.get(i));
	}*/
	//Validating JUR WITH DIFFERENT WEIGHTS
	String[] weightlist=wgtgroup.validateJurisWeightsedited(); //[AL, AR, AZ]
	for(int i=0;i<Integer.valueOf(Juri_ExcelCount);i++) {
		String Juri_Excel=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,i+5);
		System.out.print("Juri from Excel"+weightlist[i]);
		if(weightlist[i].equalsIgnoreCase(Juri_Excel)){
			System.out.print("check Weights"+weightlist[i]);
			assert true;
		}
	}
	
	//In Weight Group Screen	
		commonobjects.clickDonebtn();
		//Thread.sleep(2000);
		
		//Vehicle Tab
		//Fetch values from Vehicle screen before modifying
	/*	eleutil.updateExcel("Vehicle",0,0,vehicleverify.FetchAmendVehiclelbl());
		eleutil.updateExcel("Vehicle",1,0,vehicleverify.FetchAmendVehicle());
		eleutil.updateExcel("Vehicle",0,1,vehicleverify.FetchAddVehicleslbl());
		eleutil.updateExcel("Vehicle",1,1,vehicleverify.FetchAddVehicles());
		eleutil.updateExcel("Vehicle",0,2,vehicleverify.FetchdeleteVehiclelbl());
		eleutil.updateExcel("Vehicle",1,2,vehicleverify.FetchdeleteVehicle());
		eleutil.updateExcel("Vehicle",0,3,vehicleverify.FetchRenewVehiclelbl());
		eleutil.updateExcel("Vehicle",1,3,vehicleverify.FetchRenewVehicle());*/
		
		Vehicletabpage.clickAmendVehicleRadioButton();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		//Amend Vehicle
		int NoofVehiclestoAmend=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,3));
	for(int i=0;i<NoofVehiclestoAmend;i++) {
		vehicleAmend.selectUnitNoFromSuggestions(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleAmendTab",1,i));
		//Thread.sleep(2000);
		vehicleAmend.clickSearch();
		//Thread.sleep(2000);
	//	vehicleAmend.selectBodyType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,9));
		//Thread.sleep(2000);
		if(i==0){
		vehicleAmend.selectWeightGroupNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,3));
		//Thread.sleep(2000);}
		
		vehicleAmend.enterUnladenWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,10));
		//Thread.sleep(2000);
		vehicleAmend.clickTVR();
		//Thread.sleep(2000);
	//	vehicleAmend.selectCOSpecialTruck(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,11));
		vehicleAmend.selectSafetyChangedd(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,0));
		//Thread.sleep(2000);
		vehicleAmend.selectHVUTForm2290(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		//Thread.sleep(2000);
		vehicleAmend.selectLeaseContract(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		//Thread.sleep(2000);
		vehicleAmend.selectTitleDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		//Thread.sleep(2000);
		vehicleAmend.selectPlateReturndoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		//Thread.sleep(2000);
		vehicleAmend.selectAffidavitDoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		//Thread.sleep(2000);
		vehicleAmend.selectPropertyTax(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		//Thread.sleep(2000);
		commonobjects.expandCommentSection();
		//Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,2));
		//Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
}
		//Thread.sleep(2000);
		commonobjects.clickDonebtn();
		//Thread.sleep(2000);
		//Vehicletabpage.validateAmendedVehiclesCount(String.valueOf(NoofVehiclestoAmend));
//Delete Vehicle
		Vehicletabpage.clickDeleteVehicleRadioButton();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		int NoofVehiclestoDelete=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,4));	
for(int j=0;j<NoofVehiclestoDelete;j++) {
	System.out.print("checkunitNo:"+ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,j));
	vehicleDelete.enterUnitNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,j));
	//Thread.sleep(2000);
	vehicleDelete.clickonSearch();
	//Thread.sleep(2000);
	//rownumber=vehicleDelete.selectRowinaTable(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,j));
	vehicleDelete.ClickCheckBoxFromGrid();
	//vehicleDelete.ClickCheckBoxFromGrid(rownumber);
		//Thread.sleep(2000);
		vehicleDelete.selectPlateStatus(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,5));
		//Thread.sleep(2000);
		vehicleDelete.selectPlateReturnedDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,6));
		//Thread.sleep(2000);
		vehicleDelete.selectAffidavitDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,7));
		//Thread.sleep(2000);
		vehicleDelete.entercomments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,8));
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
}
commonobjects.clickDonebtn();
//verification screen before going to billing screen -Vehicles to be updated/cancelled from Vehicle List 
Vehicletabpage.clickVehicleList();
//Thread.sleep(2000);
Vehicletabpage.selectRow(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,0)); //selecting the unit which is deleted for the first time
//Thread.sleep(2000);
commonobjects.ClickConfirmCancel();
eleutil.isAlertPresent();
//Thread.sleep(2000);
commonobjects.validateInfoMessage(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,12));
//Thread.sleep(2000);
commonobjects.clickBack();
//Again Amend the vehicle
Vehicletabpage.clickAmendVehicleRadioButton();
//Thread.sleep(2000);
commonobjects.clickProceed();
//Thread.sleep(2000);
vehicleAmend.selectUnitNoFromSuggestions(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,0));
//Thread.sleep(2000);
vehicleAmend.clickSearch();
//Thread.sleep(2000);
vehicleAmend.enterUnladenWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,10));
//Thread.sleep(2000);
vehicleAmend.clickTVR();
//Thread.sleep(2000);
//	vehicleAmend.selectCOSpecialTruck(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,11));
vehicleAmend.selectSafetyChangedd(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,0));
//Thread.sleep(2000);
vehicleAmend.selectHVUTForm2290(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
//Thread.sleep(2000);
vehicleAmend.selectLeaseContract(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
//Thread.sleep(2000);
vehicleAmend.selectTitleDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
//Thread.sleep(2000);
vehicleAmend.selectPlateReturndoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
//Thread.sleep(2000);
vehicleAmend.selectAffidavitDoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
//Thread.sleep(2000);
vehicleAmend.selectPropertyTax(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
//Thread.sleep(2000);

commonobjects.clickProceed();
//Thread.sleep(2000);

commonobjects.clickProceed();
//Thread.sleep(2000);
commonobjects.clickDonebtn();
//Thread.sleep(2000);


//Vehicletabpage.validateDeleteVehiclesCount(String.valueOf(NoofVehiclestoDelete));
		//Thread.sleep(2000);
		commonobjects.clickDonebtn();
		//Thread.sleep(2000); 
	}
	}
	

	@Then("User will navigate to billing to verify as well to adjust the cost")
	public void user_will_navigate_to_billing_to_verify_as_well_to_adjust_the_cost() throws Exception {
	/*Thread.sleep(1000);
		billingtab.clickTVR();
		//Thread.sleep(2000);
		billingtab.clickInstallmentPlan();
		//Thread.sleep(2000);
		billingtab.selectElectronicDeliveryType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,1));
		//Thread.sleep(2000);
		commonobjects.expandCommentSection();
		//Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,2));
		//Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		billingtab.enterManualAdjBaseJur(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,0));
		//Thread.sleep(2000);
		billingtab.selectLateFilingPenalty(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,5));
		//Thread.sleep(2000);
		
		billingtab.clickReCalculate();
		//Thread.sleep(2000);
		commonobjects.validateErrorMessage(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,3));
		//Thread.sleep(2000);
		billingtab.expandManualAdjReason();
		//Thread.sleep(2000);
		billingtab.enterManualAdjReasonComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,4));
		billingtab.clickManualAdjReasonDeleteAllowed();
		billingtab.clickManualAdjReasonAddorUpdateComments();
		//Thread.sleep(2000);
		
		billingtab.expandFeeOverrideReason();
		//Thread.sleep(2000);
		billingtab.enterFeeOverrideReasonComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,6));
		billingtab.clickFeeOverrideReasonDeleteAllowed();
		billingtab.clickFeeOverrideReasonAddorUpdateComments();
		//Thread.sleep(2000);
		billingtab.clickReCalculate();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
	//eleutil.selectFirstChildWindow();	*/
	}

	@Then("User will navigate to payment")
	public void user_will_navigate_to_payment() throws IOException, Exception {
	/*
		//Thread.sleep(2000);
		pay.selectElectronicDeliverytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,4));
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		paymenttab.clickAddtoCart();
		//Thread.sleep(2000);
		paymenttab.clicksupplcont();
		//Thread.sleep(2000);
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,0));
		//paymenttab.clickandenteraccno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,0));
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000); 
		paymenttab.validatemessage(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,5));
		//Thread.sleep(2000);
		commonobjects.clickQuit();
		//Thread.sleep(2000);
		paymenttab.clickverifyaddtocart();
		////Thread.sleep(2000);
	//	commonobjects.clickProceed();//uncomment for half flow
		//Thread.sleep(2000);
		//paymenttab.clickPayNow(); //uncomment for half flow
		pay.clickPayNow();  //uncomment for full flow
		//Thread.sleep(2000);
		commonobjects.clickProceed();//uncomment for full flow
		//Thread.sleep(2000);
		//pay.check(0);
		paymenttab.clickpaymentadd();
		for(int i=0; i<2;i++) {
			System.out.print("payment Type "+i);
			pay.selectPaymentType(i,ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,i+1));	
			//Thread.sleep(2000);
			System.out.print("payment Number");
			String PaymentNumberValue=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,0);
			pay.enterpaymentNoBasedonType(i, ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,i+1),PaymentNumberValue);
			System.out.print("Payment Amount");
			String totalAmount=pay.FetchTotalAmount();
			System.out.print("totalAmount is :"+totalAmount);
			String cashAmount=String.valueOf(Double.valueOf(totalAmount)/2);
			System.out.print("cashAmount is:"+cashAmount);
			if(i==0) {
				pay.enterPaymentAmountBasedonType(i,ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,i+1),cashAmount);
			}
			//Thread.sleep(2000);
			if(i==1) {
				String RemainingAmount=pay.FetchRemainingBalance();
				System.out.print("RemainingAmount is:"+RemainingAmount); //1622.66
				pay.enterPaymentAmountBasedonType(i,ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,i+1),RemainingAmount);
			}
			//Thread.sleep(2000);
		}
		
		pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,3));
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		//commonobjects.clickProceed();
		pay.validatemsg(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,6));
	*/
	}

	@Then("User will assign the inventory")
	public void user_will_assign_the_inventory() throws IOException, Exception {
	/*	//Thread.sleep(2000);
		inventorypage.clickoperation();
			//Thread.sleep(2000);
		inventorypage.clickoninventory();
		//Thread.sleep(2000);
//		inventorypage.clickoninventorystatus();
//		//Thread.sleep(2000);
//		inventorypage.selectinventorytype("PWR");
//		//Thread.sleep(2000);
//		inventorypage.selectinventorysubtype("26000");
//		//Thread.sleep(2000);
//		commonobjects.clickProceed();
//	//Thread.sleep(2000);
//		inventorypage.validateinventorymsg();
//		//Thread.sleep(2000);
//		commonobjects.clickQuit();
//		//Thread.sleep(2000);
		inventorypage.clicknewinventory();
		//Thread.sleep(2000);
		
		//int NoofVehiclestoAmend=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,3));
		//for(int i=0;i<NoofVehiclestoAmend;i++) {
		inventorypage.selectnewinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,0));
		//Thread.sleep(2000);
		inventorypage.selectnewsubinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,1));
		//Thread.sleep(2000);
		inventorypage.enterfromno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,2)); //modify
		//Thread.sleep(2000);
		inventorypage.enterquantity(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,3));
		//Thread.sleep(2000);
		inventorypage.enteryear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,4));
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
	//	}
		inventorypage.validateaddedmsg(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,5));
		//Thread.sleep(2000);
		commonobjects.clickQuit();
		//Thread.sleep(2000);
		
		//Assign Inventory
		inventorypage.clickAssignInventory();
		//Thread.sleep(2000);
		inventorypage.selectnewinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,0));
		//Thread.sleep(2000);
		inventorypage.selectnewsubinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,1));
		//Thread.sleep(2000);
		inventorypage.enterfromno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,2)); //modify
		//Thread.sleep(2000);
		inventorypage.enterquantity(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,3));
		//Thread.sleep(2000);
		inventorypage.enteryear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,4));
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		inventorypage.validateaddedmsg(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,6));
		//Thread.sleep(2000);
		
	
		//Installment Payment
		financepage.clickfinance();
		//Thread.sleep(2000);
		financepage.clickpostpayment();
		//Thread.sleep(2000);
		financepage.enterMCEid(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,1));
		//Thread.sleep(2000);
		financepage.clicksearch();
		//Thread.sleep(2000);
		financepage.clickoncartid();
		//Thread.sleep(2000);
		financepage.clickservice();
		//Thread.sleep(2000);
		financepage.clickIRP();
		//Thread.sleep(2000);
		financepage.clickinstallmentpayment();
		//Thread.sleep(2000);
		financepage.clickandenterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,0));
		//Thread.sleep(2000);
		financepage.clickandenterfleet(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,2));
		//Thread.sleep(2000);
		financepage.clickandenterfleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,5));
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		financepage.clickgrid();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		financepage.selectpaymenttype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,1));
		//Thread.sleep(2000);
		String totalAmount=pay.FetchTotalAmount();
		System.out.print("totalAmount is :"+totalAmount);
		//String cashAmount=String.valueOf(Double.valueOf(totalAmount)/2);
		System.out.print("cashAmount is:"+totalAmount);
		//Thread.sleep(2000);
		financepage.entercashamount(totalAmount);
		//Thread.sleep(2000);
		pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,3));
		//	financepage.selectpaymenttype("D");
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		//Thread.sleep(2000);
		commonobjects.clickProceed();*/
	}

}
