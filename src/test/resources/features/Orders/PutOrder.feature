Feature: Put Confirm order
  Scenario Outline: PUT Confirm order by id (ADMIN)
    Given update confirm order by admin with valid id <Validid>
    When send request put update confirm order
    Then Status code should be 200
    Examples:
    |Validid    |
    |1721136734 |

    Scenario Outline: PUT Finish Order By Id (ADMIN) with valid data
      Given update finish order by admin with valid id <Validid>
      When send request put update finish order
      Then Status code should be 200
      Examples:
      |Validid   |
      |1721136734|
