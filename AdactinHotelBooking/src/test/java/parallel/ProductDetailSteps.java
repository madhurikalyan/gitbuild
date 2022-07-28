package parallel;


import io.cucumber.java.en.Then;
import org.testng.Assert;
import com.pages.ProductDetailPage;
import com.qa.factory.Driver_Factory;

public class ProductDetailSteps {

   private ProductDetailPage productDetailPage = new ProductDetailPage(Driver_Factory.getDriver());

   
    @Then("Product detail with {string} type is displayed")
    public void productDetailWithType(String type) {
        Assert.assertTrue(productDetailPage.defaultProductDetailPageIsDisplayed());

        switch (type) {
            case "non fisik":
                Assert.assertTrue(productDetailPage.nonFisikProductDetailDataIsDisplayed());
                break;
            case "fisik":
                Assert.assertTrue(productDetailPage.fisikProductDetailDataIsDisplayed());
                break;
        }

        String actualBreadcrumbName = productDetailPage.getAllBreadcrumbName(3).toLowerCase();
        System.out.println(actualBreadcrumbName);
   
       // Assert.assertTrue(actualBreadcrumbName.contains(expectedBreadcrumbName));

        Assert.assertTrue(productDetailPage.moreBreadcrumbIsDisplayed());
    }
}
