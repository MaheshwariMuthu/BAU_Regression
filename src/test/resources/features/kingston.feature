
#Author: Maheshwari.Muthu@homeserveusa.com
# https://preprod.slwofc.ca/mail/kingston

Feature: kingston feature file

  Background: User navigate to Homeserve-kingston application
    Given User is on "kingston" Home page

  @TC_052 @sanity @sale @kingston
  Scenario: Complete Monthly sale in kingston with PaymetType as Account Number
    When User select product and proceed to checkout
		Then the user selects the Billing Frequency
		Then the user fills in the Contact details
		Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

