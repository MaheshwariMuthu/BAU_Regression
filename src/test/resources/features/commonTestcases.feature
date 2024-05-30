#Author: maheshwari.muthu@homeserveusa.com

Feature: Homeserve feature file

  @TC_SANITY_001 @sanity @homeserve @sale
  Scenario: Complete Monthly sale in Homeserve with PaymetType as Credit or Debit Card
  	Given User is on "Homeserve" Home page
    When user enters a valid zipcode and clicks on View Plans
    Then add product to the cart and the user clicks on Proceed to Checkout