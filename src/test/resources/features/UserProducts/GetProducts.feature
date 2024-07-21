Feature: Get User Products Feature
  Scenario: User able to get user products
    Given Set path for get user products
    And Send request to get user products
    And Status code should be 200
    Then validate JSON schema "Validate_GetUserProducts.json"

  Scenario: User able to get product by search
      Given Set path for get product by search product name "Batu Aquarium"
      And Send request to get product by search
      And Status code should be 200
      Then validate JSON schema "Validate_GetProductBySearch.json"

    Scenario: User unable to get product by search with nonexistent product
      Given Set path for get product by search product name "Bom"
      And Send request to get product by search
      Then Status code should be 404