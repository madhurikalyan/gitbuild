package parallel;

import org.junit.Assert;

import com.pages.ProductDetailPageB;
import com.pages.ProductListingPageB;
import com.qa.factory.Driver_Factory;
import io.cucumber.java.en.And;


public class productListingPageB {
	
	public ProductListingPageB plp;
	public ProductDetailPageB pdp;
	
	@And("^Select product from PLP$")
	public void Select_product_from_PLP() {
		plp=new ProductListingPageB(Driver_Factory.getDriver());
	//	plp=new ProductListingPage();
		plp.selectProduct("5");
		pdp=new ProductDetailPageB(Driver_Factory.getDriver());
		//pdp=new ProductDetailPage();
		Assert.assertTrue(pdp.verifyPDPPage());
		
	}

}
