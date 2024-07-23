@Tests
Feature: Get Order user & admin
  #Positive
  Scenario: Get All History Order (USER) with valid data
    Given Set path for get all history order user
    When Send request to get all history order
    Then Status code should be 200
  #Positive
  Scenario: Get all History Order (Admin) with valid data
    Given Set path for get all history order admin
    When Send request to get all history order admin
    Then Status code should be 200


      #Positive Bug
  Scenario: Get Detail Orders(Admin & User) with valid data
    Given Set path for detail order with 1721296315
    When Send request to get detail order
    Then Status code should be 200

      #Negative Bug
  Scenario Outline: Get Detail Orders(Admin & User) with invalid data
    Given Set path for detail order with "<Invalidid>"
    When Send request to get detail order
    Then Status code should be 404
    Examples:
      | Invalidid |
      | qwe       |
      #Positive Bug
  Scenario:Get Incoming order from user (ADMIN) with valid data
    Given set path for incoming order from admin
    When Send request to get incoming order admin
    Then Status code should be 200
