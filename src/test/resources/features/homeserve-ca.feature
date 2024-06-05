#Author: Maheshwari.Muthu@homeserveusa.com
# https://www.gethomeserve.ca

Feature: homeserve-ca feature file

  Background: User navigate to homeserve-ca application
    Given User is on "homeserve-ca" Home page

  @TC_054 @sanity @sale @homeserve-ca
  Scenario: Complete a sale in homeserve-ca
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

 
