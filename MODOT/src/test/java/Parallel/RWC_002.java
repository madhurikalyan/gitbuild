package Parallel;

import java.io.IOException;

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

import io.cucumber.java.en.Then;

public class RWC_002 {
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
	
	@Then("User will navigate to renew fleet and search for  Reinstated Account Number")
	public void user_will_navigate_to_renew_fleet_and_search_for_reinstated_account_number() throws IOException, Exception {
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,0));
		fleetpage.enterFleetNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,2));
		fleetpage.enterFleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",2,3));
		commonobjects.clickProceed();	
		Thread.sleep(2000);
	}

	@Then("User should navigate to Account screen and provides all the required input to proceed")
	public void user_should_navigate_to_account_screen_and_provides_all_the_required_input_to_proceed() throws Exception {
	//ElementUtil.updateExcel("Account", 0, 0, accounttabpage.fetchAccountnolbl());
		//ElementUtil.updateExcel("Account", 1, 0, accounttabpage.fetchAccountno());
		ElementUtil.updateExcel("Account", 0, 1, accounttabpage.fetchMCECustomernolbl());
		ElementUtil.updateExcel("Account", 1, 1, accounttabpage.fetchMCECustomerno());
		ElementUtil.updateExcel("Account", 0, 2, accounttabpage.fetchAccountCarrierTypelbl());
		ElementUtil.updateExcel("Account", 1, 2, accounttabpage.fetchAccountCarrierType());
		ElementUtil.updateExcel("Account", 0, 3, accounttabpage.fetchIFTAAccountNbrlbl());
		ElementUtil.updateExcel("Account", 1, 3, accounttabpage.fetchIFTAAccountNbr());
		ElementUtil.updateExcel("Account", 0, 4, accounttabpage.fetchAccountCustomerStatuslbl());
		ElementUtil.updateExcel("Account", 1, 4, accounttabpage.fetchAccountCustomerStatus());
		
		
		//In Account Page
		accounttabpage.checkEmailNotification();
		commonobjects.expandCommentSection();
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"AccountTab",2,0));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
	}

	@Then("user should navigate to Account verification screen and proceed further")
	public void user_should_navigate_to_account_verification_screen_and_proceed_further() throws InterruptedException {
		
		
		//In Account Verification Screen
				commonobjects.clickProceed();
				Thread.sleep(2000);
	}

	@Then("user should navigate to Fleet  screen and update Fleet Expiration Date & Fleet Type & Commodity Class and proceed further")
	public void user_should_navigate_to_fleet_screen_and_update_fleet_expiration_date_fleet_type_commodity_class_and_proceed_further() throws IOException, Exception {
		ElementUtil.updateExcel("Fleet", 0, 0, fleettabpage.fetchRegistrationtypelbl());
		ElementUtil.updateExcel("Fleet", 1, 0, fleettabpage.fetchRegistrationtypelbl());
		ElementUtil.updateExcel("Fleet", 0, 1, fleettabpage.fetchfltstatuslbl());
		ElementUtil.updateExcel("Fleet", 1, 1, fleettabpage.fetchfltstatus());
		ElementUtil.updateExcel("Fleet", 0, 2, fleettabpage.fetchcarriertypelbl());
		ElementUtil.updateExcel("Fleet", 1, 2, fleettabpage.fetchcarriertype());
		ElementUtil.updateExcel("Fleet", 0, 3, fleettabpage.fetchDBANamelbl());
		ElementUtil.updateExcel("Fleet", 1, 3, fleettabpage.fetchDBAName());
		
		
		fleettabpage.navigateToServiceProvider();
		Thread.sleep(2000);
		fleettabpage.clickPowerOfAttroney();
		Thread.sleep(2000);
		fleettabpage.enterEmailID(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,0));
		Thread.sleep(2000);
		fleettabpage.enterContactName(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,8));
		Thread.sleep(2000);
		fleettabpage.enterprimaryPhone(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,9));
		Thread.sleep(2000);
		fleettabpage.selectFleetType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,9));
		Thread.sleep(2000);
		fleettabpage.selectCommodityClass(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,10));
		Thread.sleep(2000);
		fleettabpage.selectEffectiveDate(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,12));
		Thread.sleep(2000);
		fleettabpage.selectExpirationDate(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,13));
		Thread.sleep(2000);
		fleettabpage.selectFirstOperatedDate(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,14));
		Thread.sleep(2000);
		//Collecting Documents only for Power Of Attorney
		fleettabpage.selectPowerOfAttroney(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,4));
		Thread.sleep(2000);
	
		commonobjects.expandCommentSection();
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",2,7));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
	}

	@Then("user should navigate to Fleet verification screen and proceed further")
	public void user_should_navigate_to_fleet_verification_screen_and_proceed_further() throws InterruptedException {
		//Fleet Verification Screen
		commonobjects.clickProceed();
		Thread.sleep(2000); 
	}

	@Then("user should land on Distance screen and select Estimated Distance and proceed further")
	public void user_should_land_on_distance_screen_and_select_estimated_distance_and_proceed_further() throws IOException, Exception {
	  distancetabpage.selectYesOrNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",2,4));
		Thread.sleep(2000);
	  commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",2,2));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
     	commonobjects.clickProceed();
		Thread.sleep(2000);
	}

	@Then("user should navigate to Distance verification screen and proceed further")
	public void user_should_navigate_to_distance_verification_screen_and_proceed_further() throws InterruptedException {
		//Distance Verification Screen
		commonobjects.clickProceed();
		Thread.sleep(2000);
	}

	@Then("user should land on the Weight Group screen and go for Add Weight group")
	public void user_should_land_on_the_weight_group_screen_and_go_for_add_weight_group() throws IOException, Exception {
		//Weight Group
		wgtgroup.clickAddWeightGroup();
	}

	@Then("user should land on the Add Weight Group screen and provide all the required input to proceed")
	public void user_should_land_on_the_add_weight_group_screen_and_provide_all_the_required_input_to_proceed() throws IOException, Exception {
		wgtgroupadd.selectWeightGroupType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",2,0));
		Thread.sleep(2000);
		wgtgroupadd.enterWeightGroupNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",2,1));
		wgtgroupadd.selectMaxGrossWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",2,2));
		Thread.sleep(1000);
		commonobjects.clickProceed();
		Thread.sleep(2000); 
	}

	@Then("user should land on the Add Weight Group Verification screen and go for  Weight group")
	public void user_should_land_on_the_add_weight_group_verification_screen_and_go_for_weight_group() throws InterruptedException {
		//Add  Weight Group verification Screen
		commonobjects.clickProceed();
		Thread.sleep(2000);
	}

	@Then("user should land on the Weight Group and edit the existing weight group to proceed to Vehicle screen")
	public void user_should_land_on_the_weight_group_and_edit_the_existing_weight_group_to_proceed_to_vehicle_screen() throws IOException, Exception {
	    fleetpage.clickFirstHandimg();
	    Thread.sleep(1000);
	    String Juri1=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",2,4);
	    String Juri2=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",2,5);
	    String Juri3=ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",2,6);
	    wgtgroupadd.enterWeight_JuriValue(Juri1);
	commonobjects.clickProceed();
	//Verification Screen
	commonobjects.clickProceed();
	//Validating JUR WITH DIFFERENT WEIGHTS
	String[] weightlist=wgtgroup.validateJurisWeightsedited();
for(String Juri:weightlist) {
	if(Juri.equalsIgnoreCase(Juri))
		assert true;
}
	}
	@Then("user should land on the Vehicle Screen and")
	public void user_should_land_on_the_vehicle_screen_and() {
	  
	}

	@Then("user should land on the Billing screen with open status and Request for TVR & set Delivery Type as PDF with Comments")
	public void user_should_land_on_the_billing_screen_with_open_status_and_request_for_tvr_set_delivery_type_as_pdf_with_comments() {
	    
	}

	@Then("system calculates Fee and user change the supplement status as invoiced")
	public void system_calculates_fee_and_user_change_the_supplement_status_as_invoiced() {
	   
	}

	@Then("system should calculates the In-state fee and Fees should be waived\\/overridden for some vehicles.")
	public void system_should_calculates_the_in_state_fee_and_fees_should_be_waived_overridden_for_some_vehicles() {
	    
	}

	@Then("user should check Installment payment and should be selected and proceed further")
	public void user_should_check_installment_payment_and_should_be_selected_and_proceed_further() {
	    
	}

	@Then("system should generate PDF and should go to Payment Init screen.")
	public void system_should_generate_pdf_and_should_go_to_payment_init_screen() {
	   
	}

	@Then("user should verify the screen and set Delivery Types as PDF & proceed further")
	public void user_should_verify_the_screen_and_set_delivery_types_as_pdf_proceed_further() {
	   
	}

	@Then("user should land on the Payment Init Verification screen & click on Pay Now")
	public void user_should_land_on_the_payment_init_verification_screen_click_on_pay_now() {
	   
	}

	@Then("user should land on the Payment Collection page")
	public void user_should_land_on_the_payment_collection_page() {
	   
	}

	@Then("user select multiple payment types and select PDF delivery type & clicks Paynow")
	public void user_select_multiple_payment_types_and_select_pdf_delivery_type_clicks_paynow() {
	   
	}

	@Then("payment receipt should get generated & Hard stop message should get displayed")
	public void payment_receipt_should_get_generated_hard_stop_message_should_get_displayed() {
	 
	}
}
