
#Author: Maheshwari.Muthu@homeserveusa.com
# https://www.reghomeserve.com/sc/mail/charlotte-gritty

Feature: charlotte-gritty feature file

  Background: User navigate to Homeserve charlotte-gritty application
    Given User is on "charlotte-gritty" Home page

  @TC_050 @sanity @sale @charlotte-gritty
  Scenario: Complete Monthly sale in charlotte-gritty with PaymetType as Account Number
    When User select product and proceed to checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

  @TC_051 @sale @charlotte-gritty
  Scenario: Complete Monthly sale in charlotte-gritty with PaymetType as Credit or Debit Card
    When User select product and proceed to checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received
