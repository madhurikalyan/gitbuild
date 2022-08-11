package parallel;


import com.pages.ProductPage;
import com.qa.factory.Driver_Factory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDefinition {
	private ProductPage productobj = new ProductPage(Driver_Factory.getDriver());
		@When("login to the Amazon app")
		public void login_to_the_amazon_app() throws Exception {
			productobj.Login();
		}

		@Then("user search the product {string}")
		public void user_search_the_product(String string) throws Exception {
			productobj.searchproduct(string);
		}

		@Then("product add to the cart")
		public void product_add_to_the_cart() throws Exception {
			productobj.NavigatetoCart();		
}

		@Then("user validates the product with quantity {string} in the cart")
		public void user_validates_the_product_with_quantity_in_the_cart(String string) throws Exception {
			productobj.ValidateCart(string);
			Thread.sleep(3000);
			}
		

		@Then("increase the quantity of the product by {int} in cart")
		public void increase_the_quantity_of_the_product_by_in_cart(Integer int1) throws Exception {
			productobj.inputQuantity(productobj.ddquantity , "2");}

		@Then("user deletes the product {string}")
		public void user_deletes_the_product(String string) throws Exception {
			productobj.delete(); 
		}

		@Then("product add to the cart to proceed to checkout")
		public void product_add_to_the_cart_to_proceed_to_checkout() throws Exception {
		productobj.NavigatetoCheckout();   
		}

		@Then("navigate and validate the screen Select a shipping address")
		public void navigate_and_validate_the_screen_select_a_shipping_address() throws Exception {
		   productobj.validateshippingscreen();
		   productobj.navigateback();
		}

		@Then("navigate to cart and validate the save later functionality")
		public void navigate_to_cart_and_validate_the_save_later_functionality() throws InterruptedException {
		   productobj.saveforlaterandgotocart();
		}

}
