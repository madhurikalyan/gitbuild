package parallel;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.pages.HomePage;
import com.pages.ProductListPage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;

public class SearchSteps {

	  private ProductListPage productListPage = new ProductListPage(Driver_Factory.getDriver());
	  private HomePage homePage = new HomePage(Driver_Factory.getDriver());
    
      @When("Input data with {string} in search bar")
    public void inputDataSearch(String data) {
    	  Driver_Factory.getDriver().get(ConfigReader.readLoginURL());
        homePage.setSearchInput(data);
    }

    @Then("Search product link with {string} data is displayed")
    public void searchProductLinkWithDataIsDisplayed(String data) {
        String dataLowerCase = data.toLowerCase();
        String actualSearchProductLink = homePage.getSearchProductLink().toLowerCase();

        Assert.assertEquals("tampilkan pencarian dari " + dataLowerCase, actualSearchProductLink);
    }

    @When("Search product with {string} keyword")
    public void searchProductWithKeyword(String productName) {
        homePage.searchProductData(productName);
        //testContext.scenarioContext.setContext(Context.EXPECTED_DATA, productName);
    }

    @Then("Product list is displayed")
    public void productListIsDisplayed() {
        Assert.assertTrue(productListPage.searchResultPageIsDisplayed());

        String actualResultTitle = productListPage.getResultTitle().toLowerCase();
       // String expectedProductName = testContext.scenarioContext.getContext(Context.EXPECTED_DATA).toString().toLowerCase();
System.out.println("actualResultTitle in SearchSteps is "+actualResultTitle);
       // Assert.assertEquals(expectedProductName, actualResultTitle);

        int totalProduct = Integer.parseInt(productListPage.getProductAmount());

        for (int i = 0; i < totalProduct; i++) {
            String actualProductTitle = productListPage.getAllProductTitle(i).toLowerCase();
            System.out.println(actualProductTitle);
          //  Assert.assertTrue(testContext.scenarioContext.isContains(Context.EXPECTED_DATA)); //Context assertion
           // Assert.assertTrue(actualProductTitle.contains(expectedProductName)); //Common assertion
        }
    }

    @When("Select product in {int} list")
    public void selectProductInList(int list) {
        Assert.assertTrue(productListPage.searchResultPageIsDisplayed());
        productListPage.selectProductInList(list);
    }
}
