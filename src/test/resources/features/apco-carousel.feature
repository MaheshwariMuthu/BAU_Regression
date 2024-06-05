#Author: Maheshwari.Muthu@homeserveusa.com
# https://www.reghomeserve.com/sc/mail/apco-carousel

Feature: kandela feature file

  Background: User navigate to Homeserve apco-carousel application
    Given User is on "apco-carousel" Home page

  @TC_053 @sanity @sale @apco-carousel
  Scenario: Complete a sale in HomeServe apco-carousel
    When User select product and proceed to checkout
    When the user fills in the Contact details
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

 
