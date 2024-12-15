Feature: Add Jacket to Cart

  Scenario: User logs in and adds a jacket to the cart
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the homepage
    And I hover over the "Men" category
    And I hover over "Tops" and click on "Jackets"
    And I search for the desired jacket
    And I hover over the jacket and select size "M" and color "Black"
    And I click on the "Add to Cart" button
    And I click on the cart icon
    And I click on the "View/Edit Cart" button
    Then I should see the desired jacket in the cart
