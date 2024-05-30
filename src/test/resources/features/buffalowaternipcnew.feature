#URL: https://www.reghomeserve.com/sc/mail/buffalowaternipcnew

Feature: Complete an sale for buffalowaternipcnew

	Background: User navigate to buffalowaternipcnew application
		Given User is on "buffalowaternipcnew" Home page

	@TC_033 @sanity @buffalowaternipcnew @sale
	Scenario: Complete Monthly sale in buffalowaternipcnew with PaymetType as Credit or Debit Card
		Then User select product and proceed to checkout
		Then the user selects the Billing Frequency
		When the user fills in the Contact details
		Then  the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_034 @buffalowaternipcnew @sale
	Scenario: Complete Quarterly sale in buffalowaternipcnew with PaymetType as Credit or Debit Card
		Then User select product and proceed to checkout
		Then the user selects the Billing Frequency
		When the user fills in the Contact details
		Then  the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_035 @buffalowaternipcnew @sale
	Scenario: Complete Annually sale in buffalowaternipcnew with PaymetType as Credit or Debit Card
		Then User select product and proceed to checkout
		Then the user selects the Billing Frequency
		When the user fills in the Contact details
		Then  the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_036 @buffalowaternipcnew @sale
	Scenario: Complete Monthly sale in buffalowaternipcnew with PaymetType as Checking Account
		Then User select product and proceed to checkout
		Then the user selects the Billing Frequency
		When the user fills in the Contact details
		Then  the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_037 @buffalowaternipcnew @sale
	Scenario: Complete Quarterly sale in buffalowaternipcnew with PaymetType as Checking Account
		Then User select product and proceed to checkout
		Then the user selects the Billing Frequency
		When the user fills in the Contact details
		Then  the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_038 @buffalowaternipcnew @sale
	Scenario: Complete Annually sale in buffalowaternipcnew with PaymetType as Checking Account
		Then User select product and proceed to checkout
		Then the user selects the Billing Frequency
		When the user fills in the Contact details
		Then  the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received 
