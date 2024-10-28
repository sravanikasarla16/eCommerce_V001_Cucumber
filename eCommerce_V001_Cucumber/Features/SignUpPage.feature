Feature: Signup Feature

  As a user
  I want to signup on Demoblaze
  So that I can access its features
    
    Background:
    Given User launch chrome browser
    When User opens URL "https://www.demoblaze.com/index.html#"
    When Click on Sign up
     
    
    @Sanity
    Scenario: Successful signup with valid credentials
    And User enters username and password 
    And Click on Sign up to register
    Then User should see a successful signup message
    And Click on login after successful signup
    And User should be able to login with new credentials username as "Userlogin" and password as "login"
    Then Click on login button with new credentials
    And Click on logout
       
    @Regression
    Scenario: Duplicate Signup
    And User enters existing username as "Userlogin" and password as "login"
    And Click on Sign up with duplicate credentials
    Then User should see a duplicate account error message
   
    @Regression
    Scenario Outline: Blank Credentials
    When User leaves blank in username and password fields
    And Click on Sign up with blank credentials
    Then User should see a error message
    
  

   