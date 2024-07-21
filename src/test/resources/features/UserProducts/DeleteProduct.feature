Feature: Delete Product
  Scenario: User able to delete product
    Given Set path for delete product id 1
    And Send request to delete product
    And Status code should be 204
    Then Response body should be "success delete data"