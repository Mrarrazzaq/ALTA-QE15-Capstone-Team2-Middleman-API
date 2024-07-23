@Tests
Feature: Get Admin Product

  Scenario: Get all admin products
    Given set path for get admin products
    When send request to get admin products
    Then Status code should be 200

  Scenario: Search admin product by product name
    Given set path for get admin products name "Vacum"
    When send request to get admin products by search
    Then Status code should be 200

  Scenario: Search admin product by non-existent product name
    Given set path for get admin products name "Tidak Ada"
    When send request to get admin products by search
    Then Status code should be 200