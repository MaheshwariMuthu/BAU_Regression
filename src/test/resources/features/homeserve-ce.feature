# https://www.reghomeserve.com/sc/mail/homeserve-ce

Feature: HomeServe-CE feature file

  Background: User navigate to Service Line Warranties application
    Given User is on "HomeServe-CE" Home page

  @TC_007 @sanity @sale 
  Scenario: Complete Monthly sale in HomeServe-CE with PaymetType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_008 @sale 
  Scenario: Complete Quarterly sale in HomeServe-CE with PaymetType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_009 @sale
  Scenario: Complete Annually sale in HomeServe-CE with PaymetType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
