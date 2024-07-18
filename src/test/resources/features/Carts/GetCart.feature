Feature:Get Cart Data From Cart
  Scenario: Get cart data for user valid data
  Given Set path for get from cart
  When Send request to get carts
  Then Status code should be 200

  Scenario Outline: Post create new carts with valid data
    Given Create new cart with file json "<filename>"
    When send request post add new cart
    Then Status code should be 201
    Examples:
    |filename          |
    |createcart.json   |



