@Tests
Feature: Update Product data by Admin
  Scenario: Admin able to update product data
    Given Set path for admin update product with parameter id 2
    And Send request update product
    And Status code should be 200
    Then Response body should be "success update data"