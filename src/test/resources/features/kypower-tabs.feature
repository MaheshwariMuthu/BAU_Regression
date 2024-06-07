# https://www.reghomeserve.com/sc/mail/kypower-tabs

Feature: kypower-tabs feature file

  Background: User navigate to Homeserve-kypower-tabs application
    Given User is on "kypower-tabs" Home page

  @TC_047 @sanity @sale @kypower-tabs @parallel
  Scenario: Complete a sale in HomeServe kypower-tabs
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		And open Gmail and Validate order number in confirmation email is received
