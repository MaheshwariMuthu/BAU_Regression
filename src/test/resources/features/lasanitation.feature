# https://preprod.slwofa.com/mail/lasanitation

Feature: HomeServe-lasanitation feature file

  Background: User navigate to lasanitation application
    Given User is on "lasanitation" Home page

   @TC_027 @sanity @lasanitation @sale
  Scenario: Complete a Monthly sale in HomeServe-lasanitation with PaymentType as Credit or Debit Card
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills in the Contact details
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_028 @lasanitation @sale
  Scenario: Complete a Quarterly sale in HomeServe-lasanitation with PaymentType as Credit or Debit Card
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills in the Contact details
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_029 @lasanitation @sale
  Scenario: Complete a Annually sale in HomeServe-lasanitation with PaymentType as Credit or Debit Card
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills in the Contact details
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_030 @lasanitation @sale
  Scenario: Complete a Monthly sale in HomeServe-lasanitation with PaymentType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills in the Contact details
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_031 @lasanitation @sale
  Scenario: Complete a Quarterly sale in HomeServe-lasanitation with PaymentType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills in the Contact details
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_032 @lasanitation @sale
  Scenario: Complete a Quarterly sale in HomeServe-lasanitation with PaymentType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills in the Contact details
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

