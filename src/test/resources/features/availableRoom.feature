Feature: Check room availability

  Scenario: Room availability check
    Given I open booking page
    When I close pop-up
    When I enter city
    When I click city
    When I select first date
    When I select last date
    When I click confirm button
    When I click search button
    Then I check tour availability