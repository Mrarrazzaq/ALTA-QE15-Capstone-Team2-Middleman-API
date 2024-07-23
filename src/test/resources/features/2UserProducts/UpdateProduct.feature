@Tests
Feature: Update Product Feature
#Ini Bug
  Scenario: User able to update product with valid data
    Given Set path for update product with parameter id 33
    And Send request to update product
    And Status code should be 200
    Then Response body should be "success update data"