


Feature: Login Functionality
  As a registered user
  User want to login to Demoblaze
  So that user can access the store and perform various actions
  
   Background:
    Given User launch chrome browser
    When User opens URL "https://www.demoblaze.com/index.html#"
    When  Click on the Login
    
    
  @Sanity
  Scenario: Successful Login
     When User enter valid username and password
      | username | password |
      | Userlogin | login |
     When User click on the Log in button
    Then User verify the page title is "STORE"
    Then User click on the Logout button
   
    
   @Regression
   Scenario: Invalid Credentials
      When User enter invalid username and password
      | username | password |
      | wronguser | wrongpass |
    And User click on the Log in button
    Then User verify an error message is displayed


  @Regression
   Scenario: Blank Credentials
     When User enter blank username and password
    And User click on the Log in button
    Then User verify an error message is displayed
    And Click on close button and quit the browser