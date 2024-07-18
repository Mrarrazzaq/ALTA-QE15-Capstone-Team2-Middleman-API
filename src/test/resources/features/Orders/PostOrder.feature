Feature: Post order
  Scenario Outline: Create new orders with valid data
    Given create add new order with file json "<filename>"
    When send request post add new order
    Then status code should be response 201
    Examples:
    |filename          |
    |postorder.json    |
