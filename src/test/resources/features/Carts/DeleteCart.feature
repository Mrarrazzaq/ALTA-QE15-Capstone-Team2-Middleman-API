Feature: Delete cart
  Scenario: Validate delete a cart with valid data
    Given Delete cart with id 2
    When send request delete cart
    Then Status code should be 200