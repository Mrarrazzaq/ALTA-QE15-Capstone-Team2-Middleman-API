#Steps belum dibuat
 Feature: Add Admin Products
   Scenario: Admin able to add new product
     Given Set path for add admin product and insert product data
     When send request add new product
     And Status code should be 201
     Then Response body should be "success adding a product"

     Scenario: Admin not able to add new product with existing data
       Given Set path for add admin product and insert product data
       When send request add new product
       Then Status code should be 500

       Scenario: Admin not able to add new product with invalid data
         Given Set path for add product and insert invalid product data
         When send request add new product
         Then Status code should be 500