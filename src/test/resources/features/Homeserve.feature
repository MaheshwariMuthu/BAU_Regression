#Author: aatish.slathia@homeserveusa.com
# https://www.homeserve.com/en-us/

Feature: Homeserve feature file

  Background: User navigate to Homeserve application
    Given User is on "Homeserve" Home page

  @TC_001 @sanity @homeserve @sale
  Scenario: Complete Monthly sale in Homeserve with PaymetType as Checking Account
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

   @TC_002 @homeserve @sale
  Scenario: Complete Quarterly sale in Homeserve with PaymetType as Checking Account
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_003 @homeserve @sale
  Scenario: Complete Annually sale in Homeserve with PaymetType as Checking Account
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_004 @sanity @homeserve @sale
  Scenario: Complete a Monthly sale in HomeServe with payment type as Credit or Debit Card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_005 @homeserve @sale
  Scenario: Complete a Quarterly sale in HomeServe with payment type as Credit or Debit Card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_006 @homeserve @sale
  Scenario: Complete a Annually sale in HomeServe with payment type as Credit or Debit Card
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
 
