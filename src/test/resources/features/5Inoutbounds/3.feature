Feature: Put InOutBounds Admin can manage inbounds & user can manage outbounds

  #Positive error
  Scenario Outline:Update quantity product in carts for stock user (out) and admin (in) with valid data
    Given Put update admin inbounds product quantity with valid parameter 2 and request body "<filename>"
    When Send request put update inbounds
    Then Status code should be 200
    Examples:
      | filename                 |
      | putupdateinoutbound.json |

  #Negative erorr and bug
  Scenario Outline:Update quantity product in carts for stock user (out) and admin (in) with invalid data qty = "asdd"
    Given Put update admin inbounds product quantity with valid parameter "asds" and request body "<filename>"
    When Send request put update inbounds
    Then Status code should be 404
    Examples:
      | filename                        |
      | putupdateinoutboundinvalid.json |

