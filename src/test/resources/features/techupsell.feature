#Author: Maheshwari.Muthu@homeserveusa.com
# https://preprod-techupsell.homeserveusa.com  

Feature: techupsell feature file

  Background: User navigate to Homeserve techupsell application
    Given User is on "techupsell" Home page

  @TC_059 @sanity @sale @techupsell
  Scenario: Complete a sale in techupsell with PaymetType as Credit or debit card
  	When user enters a valid zipcode and clicks on View Plans
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		And open Gmail and Validate order number in confirmation email is received
