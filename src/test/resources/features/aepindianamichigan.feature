# https://www.reghomeserve.com/sc/mail/aepindianamichigan

Feature: aepindianamichigan feature file

  Background: User navigate to Homeserve-aepindianamichigan application
    Given User is on "aepindianamichigan" Home page

  @TC_039 @sanity @aepindianamichigan @sale
  Scenario: Complete a sale in HomeServe aepindianamichigan-Michigan
    When the user Selects the State
    Then add product to the cart and the user clicks on Proceed to Checkout
    When the user fills in the Contact details
    Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @TC_040 @sanity @aepindianamichigan @sale
  Scenario: Complete a sale in HomeServe aepindianamichigan-Indiana
    When the user Selects the State
    Then add product to the cart and the user clicks on Proceed to Checkout
    When the user fills in the Contact details
    Then the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
