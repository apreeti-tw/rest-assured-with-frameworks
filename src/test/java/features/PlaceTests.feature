Feature: Validate request/response to Place API

  Scenario Outline: Should be able to add a place
    Given Add Place payload
    When User calls ReqRes api with "POST_USER_REQUEST" with "<name>" and "<job>"
    Then API call should be successful with status code 201
    And "name" in status response should be "<name>"
    And "job" in status response should be "<job>"

    Examples:
      | name | job |
      |morpheus|leader|
      |mobius|practitioner|

