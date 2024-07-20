Feature: Login by User Feature
  Scenario: User able to login with valid credentials
    Given Set path for login user
    And User enter email "shop1.middleman@mail.com" and password "shop123"
    And User click login button
    And status code should be 200
    Then validate JSON schema "Validate_Login.json"

  Scenario: User unable to login with invalid credentials
    Given Set path for login user
    And User enter email "lupa.middleman@gmailcom" and password "cobacoba123"
    And User click login button
    And status code should be 400