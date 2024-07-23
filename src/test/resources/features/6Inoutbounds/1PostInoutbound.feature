@Tests
Feature: Post InOutBounds Admin can manage inbounds & user can manage outbounds

  #Positive
  Scenario: Post Create new cart for stock user (out) and admin (in) with valid data
    Given Get admin products inbounds form-data
    When Send request get admin inbounds
    Then Status code inoutbound should be 201
#    Examples:
#      | filename                 |
#      | postinoutboundvalid.json |

  #Negative
  Scenario Outline: Post Create new cart for stock user (out) and admin (in) with invalid data body product_id =  "asdaf"
    Given Get admin products inbounds "<filename>"
    When Send request get admin inbounds
    Then Status code inoutbound should be 400
    Examples:
      | filename                   |
      | postinoutboundinvalid.json |

