Feature: Login functionality

Scenario: Successful login
Given I am on the login page
When I enter valid credentials
Then I should be redirected to the homepage

