Feature: Add Jacket to Cart

  Scenario: User logs in and adds a jacket to the cart
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the homepage
    And I navigate to the "Men" category
    And I navigate to the subcategory and click on "Jackets"
    And I search for the desired jacket by name "Proteus Fitness Jackshirt"
    And I select size "M" and color "Black"
    And I click on the "Add to Cart" button
    Then Verify the success message product added to cart
    And I click on the cart icon
    And I click on the "View/Edit Cart" button
    Then I should see the desired jacket in the cart
    And click on proceed to checkout page
    And select desired Shipping methods
    Then order summary get the order amount 
    Then click Next and verify order total shiping amount is added to order amount
    Then click on place order and verify the order purchase message and order number
    
    
    
