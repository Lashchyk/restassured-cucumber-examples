# Basic API Test Examples using RestAssured and Cucumber
----------------
## Introduction
[REST Assured](https://rest-assured.io/) is a Java library that provides a domain-specific language for writing powerful, maintainable tests for RESTful APIs

## Tests
Example is based on free fake API https://jsonplaceholder.typicode.com/ and covers basic positive scenarios to validate core API requests:

```
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
```

## How to run tests
run all tests by `gradle cucumber`

run specific test by using tags, e.g. `gradle cucumber --tags @get`
