Feature: Requests Feature

  Scenario: GET Request
    When GET Request on "/api/users?page=2" is performed
    Then the response code is 200
    And the "data" list contains 6 entities
    And each "data" entity contains the following attributes:
      | id         |
      | email      |
      | first_name |
      | last_name  |
      | avatar     |
    And the list "data" contains the following attributes with values:
      | email      | george.edwards@reqres.in |
      | first_name | George                   |

  Scenario Outline: POST request
    When POST Request on "/api/users" is performed with the following body:
      | name | <name> |
      | job  | <job>  |
    Then the response code is 201
    And the response contains the following attributes with values:
      | name | <name> |
      | job  | <job>  |
    Examples:
      | name  | job        |
      | John  | leader     |
      | Gicu  | Doctor     |
      | Vasea | Accountant |

  Scenario Outline: PUT request
    When PUT Request on "/api/users/2" is performed with the following body:
      | name | <name> |
      | job  | <job>  |
    Then the response code is 200
    And the response contains the following attributes with values:
      | name | <name> |
      | job  | <job>  |
    Examples:
      | name  | job        |
      | John  | leader     |
      | Gicu  | Doctor     |
      | Vasea | Accountant |


  Scenario: DELETE request
    When DELETE Request on "/api/users/2" is performed
    Then the response code is 204