#Author: Maheshwari.Muthu@homeserveusa.com
# https://www.reghomeserve.com/en-us/clp/display/pk-yellow-no-redirect/

Feature: pk-yellow-no-redirect feature file

  Background: User navigate to pk-yellow-no-redirect application
    Given User is on "pk-yellow-no-redirect" Home page

  @TC_061 @sanity @pk-yellow-no-redirect @sale @parallel
  Scenario: Complete a sale in pk-yellow-no-redirect with PaymetType as Credit or debit card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
    
  @TC_062 @sanity @pk-yellow-no-redirect @sale
  Scenario: Complete a sale in pk-yellow-no-redirect with PaymetType as Checking Account
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
