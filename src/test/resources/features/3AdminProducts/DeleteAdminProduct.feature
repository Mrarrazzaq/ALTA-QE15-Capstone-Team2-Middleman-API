#Belum ada sintak di steps nya

Feature: Delete product by admin
  Scenario: Admin able to delete product
    Given Set path for delete product by product id 1
    When Send request to delete admin product
    Then Status code should be 204