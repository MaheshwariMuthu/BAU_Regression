# https://www.reghomeserve.com/sts/kandela

Feature: kandela feature file

  Background: User navigate to Homeserve-kandela application
    Given User is on "kandela" Home page

  @TC_049 @sale @kandela
  Scenario: Complete a sale in HomeServe kandela
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

 
