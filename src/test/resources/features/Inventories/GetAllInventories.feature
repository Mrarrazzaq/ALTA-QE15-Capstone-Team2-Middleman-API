Feature: Get all inventories
  #Positive User (Shop) 400
  Scenario: Get all form products inventory (outbound) valid data
    Given Set path for get all product invetory shop
    When Send request to get all product inventory shop
    Then Status code should be 200

  #Positive User (Shop) 404
  Scenario: Get detail form product inventory (outbound) valid id parameter
    Given  Get detailed product from inventory by user and set parameter to 1721128158
    When   Send request get detailed product from inventory id
    Then   Status code should be 200

  #Positive User (Admin) eror
  Scenario: Get all form products inventory (IN) valid data
    Given Set path for get all product invetory admin
    When Send request to get all product inventory admin
    Then Status code should be 200

  #Positive User (Admin) 404
  Scenario: Get detail form product inventory (outbound) valid id parameter
    Given  Get detailed product from inventory by admin and set parameter to 1721128158
    When   Send request get detailed product from inventory id for admin
    Then   Status code should be 200


