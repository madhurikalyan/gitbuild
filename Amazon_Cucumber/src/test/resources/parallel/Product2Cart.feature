Feature: Search product and select and add to cart with other functionalities
Background: Customer login to the app and change the country  
When login to the Amazon app 
Scenario: Adding product to the cart  
Then user search the product "Amazon Essentials Women's Digital Chronograph Resin Strap Watch"  
Then product add to the cart 
And user validates the product with quantity "1" in the cart 
Then user search the product "Mouse" 
And increase the quantity of the product by 2 in cart 
Then product add to the cart 
And user validates the product with quantity "2" in the cart 
Then user search the product "fitness watch" 
Then product add to the cart 
And user validates the product with quantity "1" in the cart 
Then user deletes the product "fitness watch" 
Then user search the product "fitness watch" 
And product add to the cart to proceed to checkout 
Then navigate and validate the screen Select a shipping address 
Then navigate to cart and validate the save later functionality 