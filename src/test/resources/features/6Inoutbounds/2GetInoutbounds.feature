@Tests
Feature: Inoutbound  item
#Postman Get cart for stock user outbound (Shop)
  Scenario: Get cart for stock user (out) and admin (in) with valid data
    Given Set path for stock user and admin in and out
    When Send request inoutbound
    Then Status code inoutbound should be 200
