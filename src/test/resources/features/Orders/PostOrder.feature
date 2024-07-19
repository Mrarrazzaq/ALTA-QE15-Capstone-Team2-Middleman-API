Feature: Post order
  #internal server error
  Scenario Outline: Create new orders with valid data
    Given create add new order with file json "<filename>"
    When send request post add new order
    Then Status code should be 201
    Examples:
    |filename          |
    |postorder.json    |
