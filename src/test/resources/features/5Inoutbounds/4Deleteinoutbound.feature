Feature: Delete inoutbound

  #Positive
  Scenario: Delete user outbounds product by valid id
    Given Delete user product outbounds by id 4
    When Send request delete outbounds
    Then Status code should be 404