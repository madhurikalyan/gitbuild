package Parallel;

import java.io.IOException; 
import com.pages.AccountTabPage;
import com.pages.BillingTab;
import com.pages.CommonObjects;
import com.pages.DashBoardPage;
import com.pages.DistanceTabPage;
import com.pages.FleetPage;
import com.pages.FleetTabPage;
import com.pages.LoginPage;
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

public class RenewFleet_StepDefinition {

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
	ExcelReader excel =new ExcelReader();
	int rownumber=0;
	
	
	
	@Given("User login as Internal user")
	public void user_login_as_internal_user() throws Exception {
		Driver_Factory.getDriver().get("https://test.celtic.bz/AutoEnterprise/");
		loginpage.enterUsername(ConfigReader.readLoginInternalUser());
		loginpage.enterPassword(ConfigReader.readpswrd());
		loginpage.clickLoginbtn();

	}

	@When("User will navigate to IRP")
	public void user_will_navigate_to_irp() throws InterruptedException, IOException {

		dashboardpage.clickIRPLink();
		dashboardpage.clickRenewFleetLink();
		System.out.println("1"+ExcelReader.FetchDataFromSheet("PreSetup",1,0));
		System.out.println("2"+ExcelReader.FetchDataFromSheet("PreSetup",1,1));
		System.out.println("3"+ExcelReader.FetchDataFromSheet("PreSetup",1,2));
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet("PreSetup",1,0));
		fleetpage.enterFleetNo(ExcelReader.FetchDataFromSheet("PreSetup",1,2));
		fleetpage.enterFleetyear(ExcelReader.FetchDataFromSheet("PreSetup",1,3));
		commonobjects.clickProceed();	}

	@Then("User will navigate to renew fleet and input all the details")
	public void user_will_navigate_to_renew_fleet_and_input_all_the_details() throws Exception {
		Thread.sleep(2000);
		//In Account Page
		accounttabpage.checkEmailNotification();
		commonobjects.expandCommentSection();
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet("AccountTab",1,0));
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
		fleettabpage.navigateToPowerOfAttroney();
		//fleettabpage.navigatetoserviceprovider();
		Thread.sleep(2000);
		fleettabpage.clickPowerOfAttroney();
		Thread.sleep(2000);
		fleettabpage.enterEmailID(ExcelReader.FetchDataFromSheet("FleetTab",1,0));
		Thread.sleep(2000);
		fleettabpage.selectIRPRequirementForm(ExcelReader.FetchDataFromSheet("FleetTab",1,1));
		Thread.sleep(2000);
		fleettabpage.selectStatementofUnderstanding(ExcelReader.FetchDataFromSheet("FleetTab",1,2));		
		Thread.sleep(2000);
		fleettabpage.selectInstallmentAgreement(ExcelReader.FetchDataFromSheet("FleetTab",1,3));
		Thread.sleep(2000);
		fleettabpage.selectPowerOfAttroney(ExcelReader.FetchDataFromSheet("FleetTab",1,4));
		Thread.sleep(2000);
		fleettabpage.selectHVUTForm(ExcelReader.FetchDataFromSheet("FleetTab",1,5));
		Thread.sleep(2000);
		fleettabpage.selectPropertyTax(ExcelReader.FetchDataFromSheet("FleetTab",1,6));
		Thread.sleep(2000);
		commonobjects.expandCommentSection();
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet("FleetTab",1,7));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		//commonobjects.clickcomment();
		//Thread.sleep(2000);
		commonobjects.clickProceed();
		
		//Distance tab
		distancetabpage.enterMODistanceValue(ExcelReader.FetchDataFromSheet("DistanceTab",1,0), ExcelReader.FetchDataFromSheet("DistanceTab",1,1));
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet("DistanceTab",1,2));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
     	commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		
	}

	@Then("User will add, amend or delete vehicle as per the requirement")
	public void user_will_add_amend_or_delete_vehicle_as_per_the_requirement() throws InterruptedException, NumberFormatException, IOException {
		Thread.sleep(2000);
		//Weight Tab Screen
		wgtgroup.clickAddWeightGroup();
		//wgtgroupadd.clickonaddweightgroup();
		wgtgroupadd.selectWeightGroupType(ExcelReader.FetchDataFromSheet("WeightGrouptab",1,0));
		Thread.sleep(2000);
		wgtgroupadd.enterWeightGroupNo(ExcelReader.FetchDataFromSheet("WeightGrouptab",1,1));
		wgtgroupadd.selectMaxGrossWeight(ExcelReader.FetchDataFromSheet("WeightGrouptab",1,2));
		Thread.sleep(1000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickDonebtn();
		//commonobjects.clickDone();
		Thread.sleep(2000);
		
		//Vehicle Tab
		Vehicletabpage.clickAmendVehicleRadioButton();
		//Vehicletabpage.clickAmendVehicle();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		//Amend Vehicle
		int NoofVehiclestoAmend=Integer.valueOf(ExcelReader.FetchDataFromSheet("VehicleTab",1,3));
	for(int i=0;i<=NoofVehiclestoAmend;i++) {
		vehicleAmend.selectUnitNoFromSuggestions(ExcelReader.FetchDataFromSheet("VehicleAmendTab",1,i));
		Thread.sleep(2000);
		vehicleAmend.clickSearch();
		Thread.sleep(2000);
		vehicleAmend.clickTVR();
		Thread.sleep(2000);
		vehicleAmend.selectSafetyChangedd(ExcelReader.FetchDataFromSheet("VehicleTab",1,0));
		Thread.sleep(2000);
		vehicleAmend.selectHVUTForm2290(ExcelReader.FetchDataFromSheet("VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectLeaseContract(ExcelReader.FetchDataFromSheet("VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectTitleDocument(ExcelReader.FetchDataFromSheet("VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectPlateReturndoc(ExcelReader.FetchDataFromSheet("VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectAffidavitDoc(ExcelReader.FetchDataFromSheet("VehicleTab",1,1));
		Thread.sleep(2000);
		vehicleAmend.selectPropertyTax(ExcelReader.FetchDataFromSheet("VehicleTab",1,1));
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet("DistanceTab",1,2));
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
//Delete Vehicle
		Vehicletabpage.clickDeleteVehicleRadioButton();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		Vehicletabpage.validateAmendedVehiclesCount(String.valueOf(NoofVehiclestoAmend));
		int NoofVehiclestoDelete=Integer.valueOf(ExcelReader.FetchDataFromSheet("VehicleTab",1,4));
for(int j=0;j<NoofVehiclestoDelete;j++) {
		 rownumber=vehicleDelete.selectRowinaTable(ExcelReader.FetchDataFromSheet("VehicleDeleteTab",1,j));
		vehicleDelete.ClickCheckBoxFromGrid(rownumber);
		Thread.sleep(2000);
		vehicleDelete.selectPlateStatus(rownumber, ExcelReader.FetchDataFromSheet("VehicleTab",1,5));
		Thread.sleep(2000);
		vehicleDelete.selectPlateReturnedDocument(rownumber, ExcelReader.FetchDataFromSheet("VehicleTab",1,6));
		Thread.sleep(2000);
		vehicleDelete.selectAffidavitDocument(rownumber, ExcelReader.FetchDataFromSheet("VehicleTab",1,7));
		Thread.sleep(2000);
		vehicleDelete.entercomments(rownumber,ExcelReader.FetchDataFromSheet("VehicleTab",1,8));
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
}
commonobjects.clickDonebtn();
Vehicletabpage.validateDeleteVehiclesCount(String.valueOf(NoofVehiclestoDelete));
		Thread.sleep(2000);
		commonobjects.clickDonebtn();
		Thread.sleep(2000);
		
	}
	

	@Then("User will navigate to billing to verify as well to adjust the cost")
	public void user_will_navigate_to_billing_to_verify_as_well_to_adjust_the_cost() throws InterruptedException, IOException {
Thread.sleep(2000);
		billingtab.clickTVR();
		Thread.sleep(2000);
		billingtab.clickInstallmentPlan();
		Thread.sleep(2000);
		billingtab.enterManualAdjBaseJur(ExcelReader.FetchDataFromSheet("BillingTab",1,0));
		Thread.sleep(2000);
		billingtab.selectElectronicDeliveryType(ExcelReader.FetchDataFromSheet("BillingTab",1,1));
		Thread.sleep(2000);
		commonobjects.enterComments(ExcelReader.FetchDataFromSheet("BillingTab",1,2));
		Thread.sleep(2000);
		commonobjects.checkDeleteAllowed();
		commonobjects.clickAddorUpdateComment();
		Thread.sleep(3000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		commonobjects.validateErrorMessage(ExcelReader.FetchDataFromSheet("BillingTab",1,3));
				
		billingtab.expandManualAdjReason();
		Thread.sleep(2000);
		billingtab.enterManualAdjReasonComments(ExcelReader.FetchDataFromSheet("BillingTab",1,4));
		billingtab.clickManualAdjReasonDeleteAllowed();
		billingtab.clickManualAdjReasonAddorUpdateComments();
		Thread.sleep(2000);
		commonobjects.clickProceed();
		Thread.sleep(2000);
		billingtab.selectLateFilingPenalty(ExcelReader.FetchDataFromSheet("BillingTab",1,5));
		Thread.sleep(2000);
		billingtab.expandFeeOverrideReason();
		Thread.sleep(2000);
		billingtab.enterFeeOverrideReasonComments(ExcelReader.FetchDataFromSheet("BillingTab",1,6));
		billingtab.clickFeeOverrideReasonDeleteAllowed();
		billingtab.clickFeeOverrideReasonAddorUpdateComments();
		Thread.sleep(2000);
		billingtab.clickReCalculate();
		Thread.sleep(2000);
		commonobjects.clickProceed();
	}

	@Then("User will navigate to payment")
	public void user_will_navigate_to_payment() {

	}

	@Then("User will assign the inventory")
	public void user_will_assign_the_inventory() {

	}

}
