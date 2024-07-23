@Tests
Feature:Post Create New Carts

  Scenario Outline:Post create new carts with valid data
    Given create add new cart with file json "<filename>"
    When send request post add new chart
    Then Status code should be 201
    Examples:
      | filename        |
      | createcart.json |

  #Negative
  Scenario Outline:Post create new carts with invalid data symbols in "product_id"
    Given create add new cart with file json "<filename>"
    When send request post add new chart
    Then Status code should be 500
    Examples:
      | filename                          |
      | createcart_invalid_productid.json |

