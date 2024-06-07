#Author: Maheshwari.Muthu@homeserveusa.com
# https://preprod-techupsell.homeserveusa.com/alabama

Feature: alabama feature file

  Background: User navigate to Homeserve alabama application
    Given User is on "alabama" Home page

  @TC_058 @sanity @sale @alabama
  Scenario: Complete a sale in alabama with PaymetType as Credit or debit card
  	When user enters a valid zipcode and clicks on View Plans
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		And open Gmail and Validate order number in confirmation email is received
