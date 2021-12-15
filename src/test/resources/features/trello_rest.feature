Feature: Trello Api

  Scenario: Create Board
    When I send create a new board request
    Then I see 200 status code in get board info request
    When I send delete the board request
    Then I see 404 status code in get board info request