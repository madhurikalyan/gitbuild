package parallel;

import java.io.IOException;
import java.util.ArrayList;
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
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.ExcelUtil;
import com.qa.util.ExcelUtil2;
import com.qa.util.Screenshot_Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	private InstallmentPage installmentpage = new InstallmentPage(DriverFactory.getDriver());
	private VehicleAdd vehicleadd= new VehicleAdd(DriverFactory.getDriver());
	private Financepage financepage =new Financepage(DriverFactory.getDriver());

	int RowNo=1;

	private ElementUtil eleutil =new ElementUtil();
	private Screenshot_Utility screenshotUtil =new Screenshot_Utility();
	private ConfigReader config=new ConfigReader();
	private Logger log = Logger.getLogger(RWC_001.class); 
	private ExcelUtil excelutil=null;
	private ExcelUtil2 excelutilWrite=null;
	
	@Given("User login as a Internal user")
	public void user_login_as_a_internal_user() throws Exception {
		excelutil = new ExcelUtil(config.readRWCexcel());
		excelutilWrite=new ExcelUtil2();
		DriverFactory.getDriver().get(config.readLoginURL());
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
		excelutilWrite.setCellData("Account",accounttabpage.fetchMCECustomernolbl(),RowNo,accounttabpage.fetchMCECustomerno());
		excelutilWrite.setCellData("Account",accounttabpage.fetchRegistrationTypelbl(), RowNo,accounttabpage.fetchRegistrationType());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCarrierTypelbl(), RowNo,accounttabpage.fetchAccountCarrierType());
		excelutilWrite.setCellData("Account",accounttabpage.fetchIFTAAccountNbrlbl(),RowNo,accounttabpage.fetchIFTAAccountNbr());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountCustomerStatuslbl(),RowNo,accounttabpage.fetchAccountCustomerStatus());
		
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab1()+accounttabpage.fetchAccountStreet0lbl(),RowNo,accounttabpage.fetchAccountStreet0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab1()+accounttabpage.fetchAccountZip0lbl(),RowNo,accounttabpage.fetchAccountZip0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab1()+accounttabpage.fetchAccountJur0lbl(), RowNo,accounttabpage.fetchAccountJur0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab1()+accounttabpage.fetchAccountCity0lbl(),RowNo,accounttabpage.fetchAccountCity0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab1()+accounttabpage.fetchAccountCounty0lbl(), RowNo,accounttabpage.fetchAccountCounty0());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab1()+accounttabpage.fetchAccountCountry0lbl(),RowNo,accounttabpage.fetchAccountCountry0());
		
		accounttabpage.clickMailingAddress();
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab2()+accounttabpage.fetchAccountStreet1lbl(),RowNo,accounttabpage.fetchAccountStreet1());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab2()+accounttabpage.fetchAccountZip1lbl(), RowNo,accounttabpage.fetchAccountZip1());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab2()+accounttabpage.fetchAccountJur1lbl(), RowNo,accounttabpage.fetchAccountJur1());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab2()+accounttabpage.fetchAccountCity1lbl(),RowNo,accounttabpage.fetchAccountCity1());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab2()+accounttabpage.fetchAccountCounty1lbl(),RowNo,accounttabpage.fetchAccountCounty1());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab2()+accounttabpage.fetchAccountCountry1lbl(),RowNo,accounttabpage.fetchAccountCountry1());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountstab2()+accounttabpage.fetchAccountAttentionTolbl(),RowNo,accounttabpage.fetchAccountAttentionTo());
		
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountUSDOTNolbl(), RowNo,accounttabpage.fetchAccountUSDOTNo());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountTPIDlbl(),RowNo,accounttabpage.fetchAccountTPID());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountContactnamelbl(), RowNo,accounttabpage.fetchAccountContactname());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountEmaillbl(),RowNo,accounttabpage.fetchAccountEmail());
		
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountPrimaryPhonelbl(),RowNo,accounttabpage.fetchAccountPrimaryPhone());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountAlternatePhonelbl(), RowNo,accounttabpage.fetchAccountAlternatePhone());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountFaxNolbl(),RowNo,accounttabpage.fetchAccountFaxNo());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountEmailnotificationlbl(), RowNo,accounttabpage.fetchAccountEmailnotification());
		excelutilWrite.setCellData("Account",accounttabpage.fetchAccountFaxnotificationlbl(),RowNo,accounttabpage.fetchAccountFaxnotification());

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
		//Fetch Fleet Details screen 
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchRegistrationtypelbl(), RowNo,fleettabpage.fetchRegistrationtype());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchfltstatuslbl(),RowNo,fleettabpage.fetchfltstatus());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchcarriertypelbl(), RowNo,fleettabpage.fetchcarriertype());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchDBANamelbl(),RowNo, fleettabpage.fetchDBAName());
		
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.FleetStreet0lbl(),RowNo,fleettabpage.FleetStreet0());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.FleetZip0lbl(),RowNo,fleettabpage.FleetZip0());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.FleetJur0lbl(), RowNo,fleettabpage.FleetJur0());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.FleetCity0lbl(),RowNo, fleettabpage.FleetCity0());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.FleetCounty0lbl(), RowNo,fleettabpage.FleetCounty0());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.FleetCountry0lbl(),RowNo,fleettabpage.FleetCountry0());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabBusinessAddress()+fleettabpage.FleetNonDeliverable0lbl(), RowNo,fleettabpage.FleetNonDeliverable0());
	
		fleettabpage.clickMailingAddress();
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.FleetStreet1lbl(),RowNo,fleettabpage.FleetStreet1());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.FleetZip1lbl(),RowNo,fleettabpage.FleetZip1());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.FleetJur1lbl(), RowNo,fleettabpage.FleetJur1());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.FleetCity1lbl(),RowNo, fleettabpage.FleetCity1());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.FleetCounty1lbl(), RowNo,fleettabpage.FleetCounty1());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.FleetCountry1lbl(),RowNo,fleettabpage.FleetCountry1());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.FleetNonDeliverable1lbl(), RowNo,fleettabpage.FleetNonDeliverable1());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabMailingAddress()+fleettabpage.FleetAttentionTOlbl(), RowNo,fleettabpage.FleetAttentionTO());
		
		fleettabpage.navigateToServiceProvider();
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetServiceProviderlbl(), RowNo,fleettabpage.FleetServiceProvider());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetServiceLegalNamelbl(),RowNo,fleettabpage.FleetServiceLegalName());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_DBANamelbl(), RowNo,fleettabpage.FleetService_DBAName());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_PowerOfAttroneylbl(),RowNo, fleettabpage.FleetService_PowerOfAttroney());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_PowerOfAttroneyEffDatelbl(), RowNo,fleettabpage.FleetService_PowerOfAttroneyEffDate());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_PowerOfAttroneyExpDatelbl(),RowNo,fleettabpage.FleetService_PowerOfAttroneyExpDate());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_EmailIDlbl(), RowNo,fleettabpage.FleetService_EmailID());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_PhoneNolbl(),RowNo, fleettabpage.FleetService_PhoneNo());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_FaxNolbl(), RowNo,fleettabpage.FleetService_FaxNo());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_Streetlbl(),RowNo,fleettabpage.FleetService_Street());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_Citylbl(), RowNo,fleettabpage.FleetService_City());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_Jurlbl(),RowNo, fleettabpage.FleetService_Jur());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_ZipCodelbl(), RowNo,fleettabpage.FleetService_ZipCode());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabServiceProviderAddress()+fleettabpage.FleetService_Countrylbl(),RowNo,fleettabpage.FleetService_Country());
		
		fleettabpage.clickOnTimeMailingAddress();
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.FleetServiceMailing_Streetlbl(), RowNo,fleettabpage.FleetServiceMailing_Street());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.FleetServiceMailing_ZipCodelbl(),RowNo, fleettabpage.FleetServiceMailing_ZipCode());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.FleetServiceMailing_Jurlbl(), RowNo,fleettabpage.FleetServiceMailing_Jur());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.FleetServiceMailing_Citylbl(),RowNo,fleettabpage.FleetServiceMailing_City());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.FleetServiceMailing_Countylbl(), RowNo,fleettabpage.FleetServiceMailing_County());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.FleetServiceMailing_Countrylbl(),RowNo, fleettabpage.FleetServiceMailing_Country());
		excelutilWrite.setCellData("Fleet",fleettabpage.fetchFleetTabOneTimeMailingAddress()+fleettabpage.FleetServiceMailing_AttentionTOlbl(), RowNo,fleettabpage.FleetServiceMailing_AttentionTO());
		
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_ContactNamelbl(),RowNo,fleettabpage.FleetDetails_ContactName());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_EmailIDlbl(), RowNo,fleettabpage.FleetDetails_EmailID());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_PrimaryCellNbrlbl(),RowNo, fleettabpage.FleetDetails_PrimaryCellNbr());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_AlternateCellNbrlbl(), RowNo,fleettabpage.FleetDetails_AlternateCellNbr());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_FaxNolbl(),RowNo, fleettabpage.FleetDetails_FaxNo());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_TPIDlbl(), RowNo,fleettabpage.FleetDetails_TPID());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_UsdotNbrlbl(),RowNo,fleettabpage.FleetDetails_UsdotNbr());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_ChangeVehUsdotTinlbl(), RowNo,fleettabpage.FleetDetails_ChangeVehUsdotTin());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_FltTypelbl(),RowNo, fleettabpage.FleetDetails_FltType());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_CommodityClasslbl(), RowNo,fleettabpage.FleetDetails_CommodityClass());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_FltEffDatelbl(),RowNo,fleettabpage.FleetDetails_FltEffDatedtPicker());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_FltExpDatelbl(), RowNo,fleettabpage.FleetDetails_FltExpDate());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_changeAddrOnUsdotlbl(),RowNo, fleettabpage.FleetDetails_changeAddrOnUsdot());
	
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_FirstOperatedDatelbl(),RowNo,fleettabpage.FleetDetails_FirstOperatedDate());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_WyomingIndicatorlbl(), RowNo,fleettabpage.FleetDetails_WyomingIndicator());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_IFTADistancelbl(),RowNo, fleettabpage.FleetDetails_IFTADistance());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_MobileNotificationlbl(), RowNo,fleettabpage.FleetDetails_MobileNotification());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_IRPRequirementslbl(),RowNo, fleettabpage.FleetDetails_IRPRequirements());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_StatementOfUnderstandinglbl(), RowNo,fleettabpage.FleetDetails_StatementOfUnderstanding());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_InstallmentAgreementlbl(),RowNo,fleettabpage.FleetDetails_InstallmentAgreement());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_PowerOfAttorneylbl(), RowNo,fleettabpage.FleetDetails_PowerOfAttorney());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_HVUTFormlbl(),RowNo, fleettabpage.FleetDetails_HVUTForm());
		excelutilWrite.setCellData("Fleet",fleettabpage.FleetDetails_PropertyTaxlbl(), RowNo,fleettabpage.FleetDetails_PropertyTax());
	
		log.info(commonobjects.validateinfomsgs());
		log.info("Message in Fleet Screen "+commonobjects.FetchErrorMessage(expSucces));
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
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceReportingPeriodFromlbl(), RowNo,distancetabpage.DistanceReportingPeriodFrom());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceReportingPeriodTolbl(), RowNo,distancetabpage.DistanceReportingPeriodTo());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceUsdotNbrlbl(), RowNo,distancetabpage.DistanceUsdotNbr());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceEstimatedDistanceChartlbl(), RowNo,distancetabpage.DistanceEstimatedDistanceChart());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceOverrideContJurlbl(), RowNo,distancetabpage.DistanceOverrideContJur());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceEstimatedDistancelbl(), RowNo,distancetabpage.DistanceEstimatedDistance());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceActualDistancelbl(), RowNo,distancetabpage.DistanceActualDistance());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceTotalFleetDistancelbl(), RowNo,distancetabpage.DistanceTotalFleetDistance());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceFRPMlgQuetionlbl(), RowNo,distancetabpage.DistanceFRPMlgQuetion());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceDistanceTypelbl(), RowNo,distancetabpage.DistanceDistanceType());
		excelutilWrite.setCellData("Distance",distancetabpage.DistanceActualDistConfirmationlbl(), RowNo,distancetabpage.DistanceActualDistConfirmation());
		
		
				//Juris Table Verification
	     	//Juris Table header
	     	ArrayList<String> TableHeadervalues=distancetabpage.FetchTableHeader();
	    	ArrayList<String>  Juris_values=distancetabpage.FetchTable_Juris();
	    	ArrayList<String>  Distance_values=distancetabpage.FetchTable_DistanceMiles();
	    	ArrayList<String>  Percent_values=distancetabpage.FetchTable_Percent();
	    	
	    	for(int i=0;i<Juris_values.size();i++) {
	    	excelutilWrite.setCellData("Distance_Juris",distancetabpage.DistanceJurisTableHeader_Juri()+i, RowNo,Juris_values.get(i));
	    	excelutilWrite.setCellData("Distance_Juris",distancetabpage.DistanceJurisTableHeader_Distance()+i, RowNo,Distance_values.get(i));
	    	excelutilWrite.setCellData("Distance_Juris",distancetabpage.DistanceJurisTableHeader_Percent()+i, RowNo,Percent_values.get(i));
	    	}
	    	//Juris list
	    	/*	ArrayList<String>  Juris_values=distancetabpage.FetchTable_Juris();
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
		ArrayList<String>  headervalues=wgtgroup.FetchTableHeader();
		ArrayList<String>  RowDatavalues=wgtgroup.FetchTableRowData();
		int j=0;
		for(int i=0;i<RowDatavalues.size();i++) {
			log.info("Weight Group headervalues"+headervalues.get(i));
			log.info("Weight Group RowDatavalues"+RowDatavalues.get(i));
			excelutilWrite.setCellData("WeightGroup",headervalues.get(i)+j, RowNo,RowDatavalues.get(i));
			j+=1;
		}
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
		excelutilWrite.setCellData("VehicleTab",Vehicletabpage.FetchAmendVehiclelbl(), RowNo,Vehicletabpage.FetchAmendVehicle());
		excelutilWrite.setCellData("VehicleTab",Vehicletabpage.FetchAddVehicleslbl(), RowNo,Vehicletabpage.FetchAddVehicles());
		excelutilWrite.setCellData("VehicleTab",Vehicletabpage.FetchdeleteVehiclelbl(), RowNo,Vehicletabpage.FetchdeleteVehicle());
		excelutilWrite.setCellData("VehicleTab",Vehicletabpage.FetchRenewVehiclelbl(), RowNo,Vehicletabpage.FetchRenewVehicle());

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
				if(NoofVehiclestoAmend>Integer.valueOf(config.readAmendVehicleCondition())) {
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

			if(NoofVehiclestoDelete>Integer.valueOf(config.readDeleteVehicleCondition())) {
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
		excelutilWrite.setCellData("Billing",billingtab.fetchRegisterMonthlbl(),RowNo,billingtab.fetchRegisterMonth());
		excelutilWrite.setCellData("Billing",billingtab.fetchNoOfVehiclesinSupplbl(),RowNo,billingtab.fetchNoOfVehiclesinSupp());
		excelutilWrite.setCellData("Billing",billingtab.fetchSupplementStatuslbl(),RowNo,billingtab.fetchSupplementStatus());
		excelutilWrite.setCellData("Billing",billingtab.fetchEnterpriseSystemCreditlbl(),RowNo,billingtab.fetchEnterpriseSystemCredit());
		excelutilWrite.setCellData("Billing",billingtab.fetchIRPSystemCreditlbl(),RowNo,billingtab.fetchIRPSystemCredit());
		excelutilWrite.setCellData("Billing",billingtab.fetchRenewalFeeEffectiveDatelbl(),RowNo,billingtab.fetchRenewalFeeEffectiveDate());
		excelutilWrite.setCellData("Billing",billingtab.fetchInvoiceDatelbl(),RowNo,billingtab.fetchInvoiceDate());
		excelutilWrite.setCellData("Billing",billingtab.fetchApplicationReceiptDatelbl(),RowNo,billingtab.fetchApplicationReceiptDate());
		excelutilWrite.setCellData("Billing",billingtab.fetchPaymentDatelbl(),RowNo,billingtab.fetchPaymentDate());
		excelutilWrite.setCellData("Billing",billingtab.fetchExchangeRatelbl(),RowNo,billingtab.fetchExchangeRate());
		
		excelutilWrite.setCellData("Billing",billingtab.fetchManualAdjBaseJurlbl(),RowNo,billingtab.fetchManualAdjBaseJur());
		excelutilWrite.setCellData("Billing",billingtab.fetchBilling_BatchBillinglbl(),RowNo,billingtab.fetchBilling_BatchBilling());
		excelutilWrite.setCellData("Billing",billingtab.fetchBilling_TVRlbl(),RowNo,billingtab.fetchBilling_TVR());
		excelutilWrite.setCellData("Billing",billingtab.fetchBilling_InstallmentPlanlbl(),RowNo,billingtab.fetchBilling_InstallmentPlan());
		excelutilWrite.setCellData("Billing",billingtab.fetchBilling_IsUseOneTimeMailinglbl(),RowNo,billingtab.fetchBilling_IsUseOneTimeMailing());
		excelutilWrite.setCellData("Billing",billingtab.fetchElectronicDeliveryTypelbl(),RowNo,billingtab.fetchElectronicDeliveryType());
		excelutilWrite.setCellData("Billing","Email",RowNo,billingtab.fetchBilling_Email());
		excelutilWrite.setCellData("Billing",billingtab.FetchInvoiceReportTypelbl(),RowNo,billingtab.fetchBilling_InvoiceReportType());
		
		  ArrayList<String> TableFeeType=billingtab.FetchTable_FeeType();
		  ArrayList<String> TableFeeAmount=billingtab.FetchTable_FeeAmount();
		  
		  for(int i=0;i<TableFeeType.size();i++) {
			  excelutilWrite.setCellData("BillingGrid",billingtab.fetchBilling_GridFeeType()+i,RowNo,TableFeeType.get(i));
			  excelutilWrite.setCellData("BillingGrid",billingtab.fetchBilling_GridFeeAmount()+i,RowNo,TableFeeAmount.get(i));
			 }

		  
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
		excelutilWrite.setCellData("Billing",billingtab.fetchBilling_TVRNoOfDayslbl(),RowNo,billingtab.fetchBilling_TVRNoOfDays());
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
		//Fetch Values from Cart payment
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchEnterpriseSystemCreditlbl(),RowNo,paymenttab.FetchEnterpriseSystemCredit());
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchIRPSystemCreditlbl(),RowNo,paymenttab.FetchIRPSystemCredit());
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchInvoiceDatelbl(),RowNo,paymenttab.FetchInvoiceDate());
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchInvoiceNumberlbl(),RowNo,paymenttab.FetchInvoiceNumber());
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchPaymentReciptDatelbl(),RowNo,paymenttab.FetchPaymentReciptDate());
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchManualAdjBaseJurlbl(),RowNo,paymenttab.FetchManualAdjBaseJur());
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchBatchCredentiallbl(),RowNo,paymenttab.FetchBatchCredential());
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchWireTransferFeelbl(),RowNo,paymenttab.FetchWireTransferFee());
		excelutilWrite.setCellData("PaymentTab",paymenttab.FetchElectronicDeliveryTypelbl(),RowNo,paymenttab.FetchElectronicDeliveryType());
		ArrayList<String> Payment_TableFeeType=paymenttab.FetchTable_FeeType();
		ArrayList<String> Payment_TableFeeAmount=paymenttab.FetchTable_FeeAmount();
		  for(int i=0;i<Payment_TableFeeType.size();i++) {
			  excelutilWrite.setCellData("PaymentTab",paymenttab.FetchHeaderFeeType()+i,RowNo,Payment_TableFeeType.get(i));
			  excelutilWrite.setCellData("PaymentTab",paymenttab.FetchHeaderFeeAmount()+i,RowNo,Payment_TableFeeAmount.get(i));
	    	}
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
		commonobjects.validateinfomsgs();


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
		//Fetch Values from 
		excelutilWrite.setCellData("PaymentScreen",pay.FetchMCECustomerIdlbl(),RowNo,pay.FetchMCECustomerId());
		excelutilWrite.setCellData("PaymentScreen",pay.FetchlegalNamelbl(),RowNo,pay.FetchlegalName());
		excelutilWrite.setCellData("PaymentScreen",pay.FetchInvoiceDatelbl(),RowNo,pay.FetchInvoiceDate());
		excelutilWrite.setCellData("PaymentScreen",pay.FetchEnterpriseSystemCreditlbl(),RowNo,pay.FetchEnterpriseSystemCredit());
		excelutilWrite.setCellData("PaymentScreen",pay.FetchIRPSystemCreditlbl(),RowNo,pay.FetchIRPSystemCredit());
		excelutilWrite.setCellData("PaymentScreen",pay.FetchIftaSystemCreditlbl(),RowNo,pay.FetchIftaSystemCredit());
		excelutilWrite.setCellData("PaymentScreen",pay.FetchOpaSystemCreditlbl(),RowNo,pay.FetchOpaSystemCredit());
		excelutilWrite.setCellData("PaymentScreen",pay.FetchTotalAmountDuelbl(),RowNo,pay.FetchTotalAmountDue());
		
		ArrayList<String> TableHeadervalues=pay.FetchTable_Headers();
		ArrayList<String> Table_Invoice=pay.FetchTable_InvoiceDetails();
		  for(int i=0;i<Table_Invoice.size();i++) {
			  excelutilWrite.setCellData("PaymentScreen",TableHeadervalues.get(i),RowNo,Table_Invoice.get(i));
	    	}
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


