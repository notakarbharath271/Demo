Feature: This feature is to create the new company
Scenario: This test is to create the new comapny
Given the user is logged in sucussfully and is on home page
When the user mouse over on the company option from the menu bar and clicks on new company from the list
And fill the from with appropreate details
And clicks on the save button
Then the user should able to see the new company created "Company Name"