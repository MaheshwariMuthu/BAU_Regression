#Author: Maheshwari.Muthu@homeserveusa.com
# https://www.reghomeserve.com/sc/mail/kypower-tabs

Feature: cnpee feature file

  Background: User navigate to Homeserve cnpee application
    Given User is on "cnpee" Home page

  @TC_055 @sanity @sale @cnpee
  Scenario: Complete a sale in cnpee with PaymetType as onBill
		Then add product to the cart and the user clicks on Proceed to Checkout
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		And open Gmail and Validate order number in confirmation email is received
