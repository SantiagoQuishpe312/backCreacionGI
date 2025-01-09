@MGDGIYM-8
Feature: Obtener grupo de investigación por usuario

  Scenario: El usuario tiene un grupo asociado
    Given the user with ID 201 exists and has an associated research group
    When the user sends a GET request to "http://localhost:8080/api/v1.0/private/inv-group/user/201"
    Then the response status should be 200
    And the response should contain group data

  Scenario: El usuario no tiene un grupo asociado
    Given the user with ID 2 exists but has no associated groups
    When the user sends a GET request to "http://localhost:8080/api/v1.0/private/inv-group/user/2"
    Then the response status should be 200
    And the response should contain an empty body
