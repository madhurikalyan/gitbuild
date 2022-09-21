package Parallel;



import java.io.IOException;
import com.pages.BillingTab;
import com.pages.CommonObjects;
import com.pages.DashBoardPage;
import com.pages.DistanceTabPage;
import com.pages.FleetPage;
import com.pages.FleetTabPage;
import com.pages.LoginPage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RIN_001 {
	LoginPage loginpage = new LoginPage(Driver_Factory.getDriver());
	DashBoardPage dashboardpage = new DashBoardPage(Driver_Factory.getDriver());
	ExcelReader excel =new ExcelReader();
	FleetTabPage fleettabpage = new FleetTabPage(Driver_Factory.getDriver());
	FleetPage fleetpage = new FleetPage(Driver_Factory.getDriver());
	CommonObjects commonobjects = new CommonObjects(Driver_Factory.getDriver());
	DistanceTabPage distancetabpage = new DistanceTabPage(Driver_Factory.getDriver());
	BillingTab billingtab = new BillingTab(Driver_Factory.getDriver());
int rownum=1;

@Given("User login as an Internal user")
public void user_login_as_an_internal_user() throws Exception {
	Driver_Factory.getDriver().get(ConfigReader.readLoginURL());
	loginpage.enterUsername(ConfigReader.readLoginInternalUser());
	loginpage.enterPassword(ConfigReader.readpswrd());
	loginpage.clickLoginbtn();
}
	@When("User will navigate to IRP & Reinstate Fleet")
	public void user_will_navigate_to_irp_reinstate_fleet() throws Exception {
		dashboardpage.clickIRPLink();
		dashboardpage.clickFleetMore();
		dashboardpage.clickFleetReinstatement();
		
	}

	@Then("User will provide all the inputs & select the record on the grid")
	public void user_will_provide_all_the_inputs_select_the_record_on_the_grid() throws Exception {
		fleetpage.enterAccountNo(ExcelReader.FetchDataFromSheet(ConfigReader.readRINexcel(),"PreSetup",rownum,0));
		fleetpage.enterlastinactivedays(ExcelReader.FetchDataFromSheet(ConfigReader.readRINexcel(),"PreSetup",rownum,1));
		commonobjects.clickProceed();	
		//select 1st record
		fleetpage.clickFirstHandimg();
		
	}

	@Then("User will navigate to Distance page & Proceed")
	public void user_will_navigate_to_distance_page_proceed() throws IOException, Exception {
		//Land on the Distance page
		//distancetabpage.validatesubhdr(ExcelReader.FetchDataFromSheet(ConfigReader.readRINexcel(),"PreSetup",rownum,2));
				commonobjects.clickProceed();
				}

	@Then("User will navigate to billing Page & provide mandatory inputs & proceed")
	public void user_will_navigate_to_billing_page_provide_mandatory_inputs_proceed() throws IOException, Exception {
		//land on the billing page
		//billingtab.validatesubhdr(ExcelReader.FetchDataFromSheet(ConfigReader.readRINexcel(),"Billing",rownum,0));
		billingtab.enterreceiptdate(ExcelReader.FetchDataFromSheet(ConfigReader.readRINexcel(),"Billing",rownum,0));
				commonobjects.clickProceed();
	}

	@Then("User will validate the Success Information Message")
	public void user_will_validate_the_success_information_message() throws IOException, Exception {
		//Validating the information message
				commonobjects.validateInfoMessage(ExcelReader.FetchDataFromSheet(ConfigReader.readRINexcel(),"Billing",rownum,1));
				dashboardpage.clickLogout();
	
	}
	
}
