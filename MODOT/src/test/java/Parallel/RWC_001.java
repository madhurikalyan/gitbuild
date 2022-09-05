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
		
		Thread.sleep(2000);
		//In Account Page
		accounttabpage.checkEmailNotification();
		commonobjects.expandCommentSection();
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"AccountTab",1,0));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		
//In Account Verification Screen
		commonobjects.clickProceed();
		Thread.sleep(2000);
//In Fleet Screen
		fleettabpage.navigateToServiceProvider();
		Thread.sleep(2000);
		fleettabpage.clickPowerOfAttroney();
		Thread.sleep(2000);
		fleettabpage.enterEmailID(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,0));
		Thread.sleep(2000);
		fleettabpage.selectIRPRequirementForm(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,1));
		Thread.sleep(2000);
		fleettabpage.selectStatementofUnderstanding(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,2));		
		Thread.sleep(2000);
		fleettabpage.selectInstallmentAgreement(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,3));
		Thread.sleep(2000);
		fleettabpage.selectPowerOfAttroney(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,4));
		Thread.sleep(2000);
		fleettabpage.selectHVUTForm(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,5));
		Thread.sleep(2000);
		fleettabpage.selectPropertyTax(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,6));
		Thread.sleep(2000);
		commonobjects.expandCommentSection();
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"FleetTab",1,7));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		
		//Distance tab
		Thread.sleep(2000);
		//distancetabpage.enterMODistanceValue(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",1,0), ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",1,1));
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"DistanceTab",1,2));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
     	commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		
	}

	@Then("User will add, amend or delete vehicle as per the requirement")
	public void user_will_add_amend_or_delete_vehicle_as_per_the_requirement() throws Exception {
		Thread.sleep(2000);
		//Weight Tab Screen
		wgtgroup.clickAddWeightGroup();
		wgtgroupadd.selectWeightGroupType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,0));
		Thread.sleep(2000);
		wgtgroupadd.enterWeightGroupNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,1));
		wgtgroupadd.selectMaxGrossWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,2));
		Thread.sleep(1000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickDonebtn();
		Thread.sleep(2000);
		
		//Vehicle Tab
		Vehicletabpage.clickAmendVehicleRadioButton();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		//Amend Vehicle
		int NoofVehiclestoAmend=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,3));
	for(int i=0;i<NoofVehiclestoAmend;i++) {
		vehicleAmend.selectUnitNoFromSuggestions(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleAmendTab",1,i));
		Thread.sleep(2000);
		vehicleAmend.clickSearch();
		Thread.sleep(2000);
	//	vehicleAmend.selectBodyType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,9));
		Thread.sleep(2000);
		if(i==0){
		vehicleAmend.selectWeightGroupNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"WeightGrouptab",1,3));
		Thread.sleep(2000);}
		
		vehicleAmend.enterUnladenWeight(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,10));
		Thread.sleep(2000);
		vehicleAmend.clickTVR();
		Thread.sleep(2000);
	//	vehicleAmend.selectCOSpecialTruck(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,11));
		vehicleAmend.selectSafetyChangedd(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,0));
		Thread.sleep(2000);
		vehicleAmend.selectHVUTForm2290(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectLeaseContract(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectTitleDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectPlateReturndoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectAffidavitDoc(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectPropertyTax(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,1));
		Thread.sleep(2000);
		commonobjects.expandCommentSection();
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,2));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
}
		Thread.sleep(2000);
		commonobjects.clickDonebtn();
		Thread.sleep(2000);
		//Vehicletabpage.validateAmendedVehiclesCount(String.valueOf(NoofVehiclestoAmend));
//Delete Vehicle
		Vehicletabpage.clickDeleteVehicleRadioButton();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		int NoofVehiclestoDelete=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,4));	
for(int j=0;j<NoofVehiclestoDelete;j++) {
	System.out.print("checkunitNo:"+ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,j));
	vehicleDelete.enterUnitNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,j));
	Thread.sleep(2000);
	vehicleDelete.clickonSearch();
	Thread.sleep(2000);
	//rownumber=vehicleDelete.selectRowinaTable(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleDeleteTab",1,j));
	vehicleDelete.ClickCheckBoxFromGrid();
	//vehicleDelete.ClickCheckBoxFromGrid(rownumber);
		Thread.sleep(2000);
		vehicleDelete.selectPlateStatus(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,5));
		Thread.sleep(2000);
		vehicleDelete.selectPlateReturnedDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,6));
		Thread.sleep(2000);
		vehicleDelete.selectAffidavitDocument(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,7));
		Thread.sleep(2000);
		vehicleDelete.entercomments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,8));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
}
commonobjects.clickDonebtn();
//Vehicletabpage.validateDeleteVehiclesCount(String.valueOf(NoofVehiclestoDelete));
		Thread.sleep(2000);
		commonobjects.clickDonebtn();
		Thread.sleep(2000); 
	}
	

	@Then("User will navigate to billing to verify as well to adjust the cost")
	public void user_will_navigate_to_billing_to_verify_as_well_to_adjust_the_cost() throws Exception {
	Thread.sleep(1000);
		billingtab.clickTVR();
		Thread.sleep(2000);
		billingtab.clickInstallmentPlan();
		Thread.sleep(2000);
		billingtab.selectElectronicDeliveryType(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,1));
		Thread.sleep(2000);
		commonobjects.expandCommentSection();
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,2));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		billingtab.enterManualAdjBaseJur(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,0));
		Thread.sleep(2000);
		billingtab.selectLateFilingPenalty(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,5));
		Thread.sleep(2000);
		
		billingtab.clickReCalculate();
		Thread.sleep(2000);
		commonobjects.validateErrorMessage(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,3));
		Thread.sleep(2000);
		billingtab.expandManualAdjReason();
		Thread.sleep(2000);
		billingtab.enterManualAdjReasonComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,4));
		billingtab.clickManualAdjReasonDeleteAllowed();
		billingtab.clickManualAdjReasonAddorUpdateComments();
		Thread.sleep(2000);
		
		billingtab.expandFeeOverrideReason();
		Thread.sleep(2000);
		billingtab.enterFeeOverrideReasonComments(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"BillingTab",1,6));
		billingtab.clickFeeOverrideReasonDeleteAllowed();
		billingtab.clickFeeOverrideReasonAddorUpdateComments();
		Thread.sleep(2000);
		billingtab.clickReCalculate();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
	//ElementUtil.selectFirstChildWindow();	
	}

	@Then("User will navigate to payment")
	public void user_will_navigate_to_payment() throws IOException, Exception {
	
		Thread.sleep(2000);
		pay.selectElectronicDeliverytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,4));
		commonobjects.clickProceed();
		Thread.sleep(2000);
		paymenttab.clickAddtoCart();
		Thread.sleep(2000);
		paymenttab.clicksupplcont();
		Thread.sleep(2000);
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,0));
		//paymenttab.clickandenteraccno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,0));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000); 
		paymenttab.validatemessage(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,5));
		Thread.sleep(2000);
		commonobjects.clickQuit();
		Thread.sleep(2000);
		paymenttab.clickverifyaddtocart();
		//Thread.sleep(2000);
	//	commonobjects.clickProceed();//uncomment for half flow
		Thread.sleep(2000);
		//paymenttab.clickPayNow(); //uncomment for half flow
		pay.clickPayNow();  //uncomment for full flow
		Thread.sleep(2000);
		commonobjects.clickProceed();//uncomment for full flow
		Thread.sleep(2000);
		//pay.check(0);
		paymenttab.clickpaymentadd();
		for(int i=0; i<2;i++) {
			System.out.print("payment Type "+i);
			pay.selectPaymentType(i,ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,i+1));	
			Thread.sleep(2000);
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
			Thread.sleep(2000);
			if(i==1) {
				String RemainingAmount=pay.FetchRemainingBalance();
				System.out.print("RemainingAmount is:"+RemainingAmount); //1622.66
				pay.enterPaymentAmountBasedonType(i,ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,i+1),RemainingAmount);
			}
			Thread.sleep(2000);
		}
		
		pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,3));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		//commonobjects.clickProceed();
		pay.validatemsg(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,6));
	
	}

	@Then("User will assign the inventory")
	public void user_will_assign_the_inventory() throws IOException, Exception {
		Thread.sleep(2000);
		inventorypage.clickoperation();
			Thread.sleep(2000);
		inventorypage.clickoninventory();
		Thread.sleep(2000);
//		inventorypage.clickoninventorystatus();
//		Thread.sleep(2000);
//		inventorypage.selectinventorytype("PWR");
//		Thread.sleep(2000);
//		inventorypage.selectinventorysubtype("26000");
//		Thread.sleep(2000);
//		commonobjects.clickProceed();
//	Thread.sleep(2000);
//		inventorypage.validateinventorymsg();
//		Thread.sleep(2000);
//		commonobjects.clickQuit();
//		Thread.sleep(2000);
		inventorypage.clicknewinventory();
		Thread.sleep(2000);
		
		//int NoofVehiclestoAmend=Integer.valueOf(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"VehicleTab",1,3));
		//for(int i=0;i<NoofVehiclestoAmend;i++) {
		inventorypage.selectnewinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,0));
		Thread.sleep(2000);
		inventorypage.selectnewsubinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,1));
		Thread.sleep(2000);
		inventorypage.enterfromno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,2)); //modify
		Thread.sleep(2000);
		inventorypage.enterquantity(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,3));
		Thread.sleep(2000);
		inventorypage.enteryear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,4));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
	//	}
		inventorypage.validateaddedmsg(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,5));
		Thread.sleep(2000);
		commonobjects.clickQuit();
		Thread.sleep(2000);
		
		//Assign Inventory
		inventorypage.clickAssignInventory();
		Thread.sleep(2000);
		inventorypage.selectnewinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,0));
		Thread.sleep(2000);
		inventorypage.selectnewsubinventorytype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,1));
		Thread.sleep(2000);
		inventorypage.enterfromno(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,2)); //modify
		Thread.sleep(2000);
		inventorypage.enterquantity(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,3));
		Thread.sleep(2000);
		inventorypage.enteryear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,4));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		inventorypage.validateaddedmsg(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"InventoryTab",1,6));
		Thread.sleep(2000);
		
	
		//Installment Payment
		financepage.clickfinance();
		Thread.sleep(2000);
		financepage.clickpostpayment();
		Thread.sleep(2000);
		financepage.enterMCEid(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,1));
		Thread.sleep(2000);
		financepage.clicksearch();
		Thread.sleep(2000);
		financepage.clickoncartid();
		Thread.sleep(2000);
		financepage.clickservice();
		Thread.sleep(2000);
		financepage.clickIRP();
		Thread.sleep(2000);
		financepage.clickinstallmentpayment();
		Thread.sleep(2000);
		financepage.clickandenterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,0));
		Thread.sleep(2000);
		financepage.clickandenterfleet(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,2));
		Thread.sleep(2000);
		financepage.clickandenterfleetyear(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"PreSetup",1,5));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		financepage.clickgrid();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		financepage.selectpaymenttype(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,1));
		Thread.sleep(2000);
		String totalAmount=pay.FetchTotalAmount();
		System.out.print("totalAmount is :"+totalAmount);
		//String cashAmount=String.valueOf(Double.valueOf(totalAmount)/2);
		System.out.print("cashAmount is:"+totalAmount);
		Thread.sleep(2000);
		financepage.entercashamount(totalAmount);
		Thread.sleep(2000);
		pay.selectPaymentReceipt(ExcelReader.FetchDataFromSheet(ConfigReader.readRWCexcel(),"Payment",1,3));
		//	financepage.selectpaymenttype("D");
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
	}

}
