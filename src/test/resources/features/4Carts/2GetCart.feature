@Tests
Feature:Get Cart Data From Cart
  Scenario: Get cart data for user valid data
  Given Set path for get from cart
  When Send request to get carts
  Then Status code should be 200


