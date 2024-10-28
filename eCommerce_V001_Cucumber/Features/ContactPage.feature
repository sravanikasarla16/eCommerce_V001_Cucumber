Feature: Contact
Scenario: Contact Customer Care
Given User launch chrome browser
When User opens URL "https://www.demoblaze.com/index.html#"
Then Click on contact
And Enter Contact Email, Name, Message from "D:\eCommerce_v001\ExcelFiles\contactdetails.xlsx"
And Click on Send message
