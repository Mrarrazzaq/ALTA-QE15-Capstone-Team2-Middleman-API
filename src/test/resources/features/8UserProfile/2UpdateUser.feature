Feature: Update user profile

  Scenario: User able to update profile
    Given Set path for update user profile file json "UpdateUserProfile.json"
    When send request update user profile
    And Status code should 200
    Then Response body should be "success update data"