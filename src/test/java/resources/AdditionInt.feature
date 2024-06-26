Feature: Addition of 2 integers
  Scenario Outline: Add 2 integers
    Given I have two integers <a> and <b>
    When I add them using AdditionInt
    Then The result should be <sum>

    Examples:
    | a  | b | sum |
    | 1  | 2 | 3   |
    | -1 | 2 | 1   |
    | 5  | 5 | 10  |
    | 0  | 0 | 0   |
