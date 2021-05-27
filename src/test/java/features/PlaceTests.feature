Feature: Validate request/response to Place API

  Scenario: Should be able to add a place
    Given Add Place payload
    When User calls AddPlace api with post request
    Then API call should be successful with status code 200
    And status message should contain OK
