Feature: Put Cart

  Scenario Outline: Put update quantity product with valid data
    Given update cart with parameter id product 1 file json "<filename>"
    When send request update chart
    Then Status code should be 200
    Examples:
      | filename     |
      | putcart.json |

    #Negative
  Scenario Outline: Put update quantity product with invalid data qty
    Given update cart with parameter id product 1 file json "<filename>"
    When send request update chart
    Then Status code should be 400
    Examples:
      | filename             |
      | putcart_invalid.json |