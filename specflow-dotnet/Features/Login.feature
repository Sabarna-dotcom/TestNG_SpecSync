Feature: Login

  Scenario: Login with valid credentials
    Given the user opens the login page
    When the user submits valid credentials
    Then the dashboard is displayed
