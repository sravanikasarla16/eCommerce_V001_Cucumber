Feature: Add to Cart
  As a customer
  I want to add products to my cart
  So that I can purchase them

@sanity
  Scenario: Add product to cart
    Given User launch chrome browser
    When User opens URL "https://www.demoblaze.com/index.html#"
    When I add a product to cart
    Then I should see the product in my cart
    And I place the order
    And I fill the order form with:
      | name   | country | city    | card    | month | year |
      | John   | USA     | New York| 123456  | 12    | 2023 |
    When I click on purchase
    Then I should see the order confirmation