Feature: Navigation to Home and Categories
As a user,
I want to navigate through the home page and categories,
So that I can explore the products.

  Scenario: Navigate to Home
  Given the user launches the Chrome browser
  When the user opens the Demoblaze home page "https://www.demoblaze.com/index.html#"
  Then the user clicks on the Home Page
  Then the user selects the Phones category
  Then the user selects the Laptops category
  Then the user selects the Monitors category
 