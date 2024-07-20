Feature: User able to get user profile
  Scenario: Get user profile with valid parameter page
    Given Set path for get user profile
    And Send request to get user profile
    And Status code should 200
    Then Validate JSON schema "Validate_UserProfile.json"

  Scenario: Get user profile without token
    Given Set path for get user profiles
    And Send request to get user profiles
    Then Status code should 400