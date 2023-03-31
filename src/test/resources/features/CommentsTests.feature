Feature: Testing Comments Function
  * User should be able to submit GET, POST and DELETE requests on comments API

  @get
  Scenario: Comment retrieval
    When User retrieves all the comments
    Then Response code is 200

  @add
  Scenario: Creating new comment
    When User creates new comment
    Then Response code is 201
    And Response includes "id" key

  @delete
  Scenario: Delete existing comment
    Given User creates new comment
    When User deletes existing comment with id "1"
    Then Response code is 200
