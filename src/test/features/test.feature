Feature: Requests Feature

  Scenario: GET Request
    Given GET Request on "/api/users?page=2" is performed

  Scenario: POST request
    Given POST Request on "/api/users" is performed with the following body:
      | name | morpheus |
      | job  | leader   |

  Scenario: PUT request
    Given PUT Request on "/api/users/2" is performed with the following body:
      | name | morpheus      |
      | job  | zion resident |

  Scenario: DELETE request
    Given DELETE Request on "/api/users/2" is performed
