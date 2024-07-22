Feature: Login by Admin Feature

  Scenario: Admin able to login with valid credentials
    Given Set path for login admin
    And Admin enter email "admin.middleman@gmail.com" and password "Admin123$"
    And Admin click login button
    And status code should be 200
    Then validate JSON schema "Validate_Login.json"

  Scenario: Admin unable to login with invalid credentials
    Given Set path for login admin
    And Admin enter email "adminbaru.middleman@gmailcom" and password "Adminbaru123$"
    And Admin click login button
    And status code should be 400