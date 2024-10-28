Feature: Interact with carousel to view and navigate
Scenario: Verify carousel navigation
Given  User launch chrome browser
When User opens URL "https://www.demoblaze.com/index.html#"
Then Click on next button
Then Click on previous button
And Quit the browser
