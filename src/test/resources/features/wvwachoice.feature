#URL: https://www.reghomeserve.com/sc/mail/wvwachoice

Feature: Complete an sale for wvwachoice

	Background: User navigate to wvwachoice application
		Given User is on "wvwachoice" Home page

	@TC_041 @sanity @wvwachoice @sale
	Scenario: Complete Monthly sale in wvwachoice with PaymetType as Credit or Debit Card
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_042 @wvwachoice @sale
	Scenario: Complete Quarterly sale in wvwachoice with PaymetType as Credit or Debit Card
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_043 @wvwachoice @sale
	Scenario: Complete Annually sale in wvwachoice with PaymetType as Credit or Debit Card
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

  @TC_044 @wvwachoice @sale
	Scenario: Complete Monthly sale in wvwachoice with PaymetType as Checking Account
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

  @TC_045 @wvwachoice @sale
	Scenario: Complete Monthly sale in wvwachoice with PaymetType as Checking Account
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

  @TC_046 @wvwachoice @sale
	Scenario: Complete Monthly sale in wvwachoice with PaymetType as Checking Account
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received 
