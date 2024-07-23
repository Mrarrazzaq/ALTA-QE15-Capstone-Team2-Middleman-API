Feature: Delete User
  Scenario: User able to delete profile
    Given Set path for delete user
    And Send request to delete user
    And Status code should 204
    Then Response body should be "success delete data"