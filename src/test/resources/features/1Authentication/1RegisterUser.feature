@Tests
Feature: Register new user

  Scenario: User able to register new account
    Given Set path for register new user
    And User fill the form with valid data "RegisterNewUser.json"
    And User click register button
    And Status code should be 201
    Then validate body response "Validate_Register.json"

  Scenario: User unable to register new account with existing data
    Given Set path for register new user
    And User fill the form with valid data "RegisterExistingUser.json"
    And User click register button
    And Status code should be 400