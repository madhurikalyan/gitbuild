package parallel;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import com.pages.LoginPageA;
import com.pages.Loginpage;
import com.qa.factory.Driver_Factory;

import java.util.List;
import java.util.Map;

public class LoginSteps {

	private LoginPageA loginPageA = new LoginPageA(Driver_Factory.getDriver());
    //LoginPage loginPage;

    @Then("Login page is displayed")
    public void loginPageIsDisplayed() {
        Assert.assertTrue(loginPageA.emailLoginPageIsDisplayed());

        String actualLoginHeaderTitle = loginPageA.getLoginHeaderTitle();
        Assert.assertEquals("Silakan masuk ke akun Anda", actualLoginHeaderTitle);

        String actualRegisterQuestionText = loginPageA.getQuestionRegisterText();
        Assert.assertEquals("Belum punya akun Bhinneka? Daftar", actualRegisterQuestionText);
    }

    @When("Input {string} as email, {string} as password, {string} as account type")
    public void inputAsEmailAsPasswordAsAccountType(String email, String password, String account) {
        System.out.println("---" + email);
        System.out.println("---" + password);
        System.out.println("---" + account);
    }

    @When("Input credentials to login without headers")
    public void inputCredentialsToLoginWithoutHeaders(DataTable dataTable) {
        List<String> dataRow = dataTable.row(0);
        String email = dataRow.get(0);

        System.out.println("row index 0 --- " + email);
        loginPageA.fillEmailData(email);
        System.out.println("row index 1 --- " + dataRow.get(1));
        System.out.println("row index 2 --- " + dataRow.get(2));
    }

    @When("Input credentials to login with headers table")
    public void inputCredentialsToLoginWithHeadersTable(DataTable dataTable) {
        List<Map<String,String>> dataRow = dataTable.asMaps(String.class,String.class);

        //Use for...loop if you have multiple data table
        for (Map<String, String> dataMap : dataRow) {
            String email = dataMap.get("Email");
            loginPageA.fillEmailData(email);
            System.out.println("row header email " + email);
            System.out.println("row index 1 --- " + dataMap.get("Password"));
            System.out.println("row index 2 --- " + dataMap.get("Account Type"));
        }
    }

    @When("Click selanjutnya button")
    public void clickSelanjutnyaButton() {
    	loginPageA.clickSelanjutnyaButton();
    }
}
