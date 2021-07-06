  Feature: Validate request/response to Users API

    Scenario Outline: Should be able to add a place
      Given Add Place payload
      When User calls ReqRes api with "POST_USER_REQUEST" with "<name>" and "<job>"
      Then API call should be successful with status code 201
      And "name" in status response should be "<name>"
      And "job" in status response should be "<job>"

      Examples:
        | name     | job          |
        | morpheus | leader       |
        | mobius   | practitioner |

    Scenario Outline: Should be able to delete a place
      Given Add Place payload
      And User calls ReqRes api with "POST_USER_REQUEST" with "<name>" and "<job>"
      When User calls ReqRes api with "DELETE_USER_REQUEST" to delete the user
      Then API call should be successful with status code 204
      Examples:
        | name     | job    |
        | morpheus | leader |

