Feature: Login
  Scenario: Login validation with valid credentials
    Given I am on the Home page "https://ryze-staging.formedix.com/sign-in"
    When  I enter user name in the user name field as "testteamtechtest"
    And   I enter password in the password field as "T3cht3ster"
    And   I click on sign in button
    And   I click on repository menu item
    And   I click on studies sub menu item
    And   I click on tech study link
    And   I click on data acquisition option
    And   I click on forms option
    And   I click on medical history form
    And   I click on edit button
    And   I enter description in the description field as "description updated"
    And   I click on validate and update button
    And   I click on menu user
    And   I click on sign out option
    Then  I should be able to sign out successfully