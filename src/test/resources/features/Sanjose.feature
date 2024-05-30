#URL: https://www.reghomeserve.com/sc/mail/sanjose

Feature: Complete an sale for sanjose

  Background: User navigate to Sanjose page
    Given User is on "sanjose" Home page

  @TC_018 @sanity @sanjose @sale
  Scenario: Complete Monthly sale in sanjose with PaymetType as Credit or Debit Card
    When User select product and proceed to checkout
    Then User fills up the Contact details with Zipcode and City
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_019 @sanjose @sale
  Scenario: Complete Quarterly sale in sanjose with PaymetType as Credit or Debit Card
    When User select product and proceed to checkout
    Then User fills up the Contact details with Zipcode and City
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_020 @sanjose @sale
  Scenario: Complete Annually sale in sanjose with PaymetType as Credit or Debit Card
    When User select product and proceed to checkout
    Then User fills up the Contact details with Zipcode and City
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_021 @sanjose @sale
  Scenario: Complete Monthly sale in sanjose with PaymetType as Checking Account
    When User select product and proceed to checkout
    Then User fills up the Contact details with Zipcode and City
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_022 @sanjose @sale
  Scenario: Complete Quarterly sale in sanjose with PaymetType as Checking Account
    When User select product and proceed to checkout
    Then User fills up the Contact details with Zipcode and City
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_023 @sanjose @sale
  Scenario: Complete Annually sale in sanjose with PaymetType as Checking Account
    When User select product and proceed to checkout
    Then User fills up the Contact details with Zipcode and City
    Then the user selects the Billing Frequency
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received