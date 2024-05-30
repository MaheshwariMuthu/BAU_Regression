# https://www.slwofa.com/

Feature: SLWOFA feature file

  Background: User navigate to Service Line Warranties application
    Given User is on "slwofa" Home page

  @TC_010 @slwofa @sale2
  Scenario: Complete Monthly sale in slwofa with PaymetType as Credit or Debit Card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_011 @slwofa @sale2 
  Scenario: Complete Quarterly sale in slwofa with PaymetType as Credit or Debit Card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_012 @slwofa @sale2
  Scenario: Complete Annually sale in slwofa with PaymetType as Credit or Debit Card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_013 @slwofa @sale2
  Scenario: Complete Monthly sale in slwofa with PaymetType as Checking Account
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_014 @slwofa @sale2
  Scenario: Complete Quarterly sale in slwofa with PaymetType as Checking Account
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_015 @slwofa @sale2
  Scenario: Complete Annually sale in slwofa with PaymetType as Checking Account
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
