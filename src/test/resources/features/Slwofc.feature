# https://preprod.slwofc.ca/

Feature: SLWOFC feature file

  Background: User navigate to Service Line Warranties application
    Given User is on "slwofc" Home page

  @TC_016 @sanity @slwofc @sale
  Scenario: Complete Monthly sale in slwofc with PaymetType using Credit or Debit Card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

 @TC_017 @slwofc @sale
 Scenario: Complete Annually sale in slwofc with PaymetType using Credit or Debit Card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
