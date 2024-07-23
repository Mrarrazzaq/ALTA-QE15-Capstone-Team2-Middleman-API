@Tests
Feature: Post inventories

  #Positive User (Shop) 400
  Scenario Outline: Create a form to list product (OUT) with valid data
    Given Post create product with valid request body "<filename>"
    When Send request post inventory
    Then Status code should be 201
    Examples:
      | filename             |
      | createInventory.json |

    #Positive User (Shop) 400
  Scenario Outline: Create a form to list product (IN) with valid data
    Given Post create product admin with valid request body "<filename>"
    When Send request post inventory admin
    Then Status code should be 201
    Examples:
      | filename                  |
      | createInventoryadmin.json |

