Feature:Post Create New Carts
Scenario Outline:Post create new carts with valid data
When send request post add new chart
And set request body "<filejson>"
Then Status code should be 201
Examples:
|filejson|
|createcart.json|