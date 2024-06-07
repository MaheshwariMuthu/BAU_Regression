#Author: Maheshwari.Muthu@homeserveusa.com
# https://preprod-fplhometech.homeserveusa.com    

Feature: fplhometech feature file

  Background: User navigate to Homeserve fplhometech application
    Given User is on "fplhometech" Home page

  @TC_060 @sanity @sale @fplhometech
  Scenario: Complete a sale in fplhometech with PaymetType as Credit or debit card
  	When user enters a valid zipcode and clicks on View Plans
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		And open Gmail and Validate order number in confirmation email is received
