#Author: Maheshwari.Muthu@homeserveusa.com
# https://www.reghomeserve.com/en-us/lp/servline-water/

Feature: servline-water feature file

  Background: User navigate to servline-water application
    Given User is on "servline-water" Home page

  @TC_056 @sanity @servline-water @sale
  Scenario: Complete Monthly sale in servline-water with PaymetType as Checking Account
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
