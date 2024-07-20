Feature: Inoutbound  item
  Scenario: Get cart for stock user (out) and admin (in) with valid data
    Given Set path for stock user and admin in and out
    When Send request inoutbound
    Then Status code should be 200
