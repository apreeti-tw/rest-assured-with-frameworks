Feature: Validate request/response to Place API

  Scenario: Should be able to add a place
    Given Add Place payload
    When User calls ReqRes api with post request
    Then API call should be successful with status code 201
    And "name" in status response should be "morpheus"
