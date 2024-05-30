#Author: your.email@your.domain.com
# https://preprod.slwofc.ca/mail/ottawa-french

Feature: Complete an sale for Ottawa

Background: User navigate to Ottawa page
	Given User is on "ottawa" Home page

	@TC_024 @sanity @ottawa @sale
	Scenario: Complete Monthly sale in Ottawa with PaymetType as Credit or Debit Card
		When User select product and proceed to checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_025 @ottawa @sale
	Scenario: Complete Quarterly sale in Ottawa with PaymetType as Credit or Debit Card
		When User select product and proceed to checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

	@TC_026 @ottawa @sale
	Scenario: Complete Annually sale in Ottawa with PaymetType as Credit or Debit Card
		When User select product and proceed to checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

