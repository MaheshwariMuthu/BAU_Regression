#URL: https://www.reghomeserve.com/sc/mail/firstenergy-fundle

Feature: Complete an sale for firstenergy-fundle
 

Background: User navigate to Homeserve-firstenergy-fundle page
	Given User is on "firstenergy-fundle" Home page

	@TC_048 @sanity @firstenergy-fundle @sale
Scenario: Complete an sale for firstenergy-fundle
	Then add product to the cart and the user clicks on Proceed to Checkout
	Then the user fills in the Contact details
	Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message
	And open Gmail and Validate order number in confirmation email is received

	
	
	
	
	
	



  
