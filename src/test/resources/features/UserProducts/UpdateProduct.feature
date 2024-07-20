Feature: Update Product Feature
  Scenario: User able to update product with valid data
    Given Set path for update product with parameter id 1
    And Send request to update product
    And Status code should be 200
    Then Response body should be "success update data"