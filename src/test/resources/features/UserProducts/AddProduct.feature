Feature: Add Product Feature
Scenario: Add product by user
Given Set path for add product and insert product data
And Send request to add product
Then Status code should be 201
Then Validate JSON schema "Validate_AddProduct.json"

Scenario: Add product by user with existing data
Given Set path for add product and insert product data
And Send request to add product
Then Status code should be 500

Scenario: Add product by user with incomplete data
Given Set path for add product and insert incomplete product data
And Send request to add product
Then Status code should be 500