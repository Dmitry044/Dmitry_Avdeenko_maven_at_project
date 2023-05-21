Feature: at_project

  @w3schools
  Scenario: copy tutorial
    Given I open the "w3schools.com"
    When I copy "Tutorial" word
    And I open the "google.com"
    And I paste "Tutorial" to the search field and click the Enter
    Then I check that all result links contain the word "Tutorial"

  @demoQA
  Scenario: select all
    Given I open "demoQA.com"
    When I click on the Select Value Dropdown
    And I select Group1 Option1
    And I click on the Select One Dropdown
    And I select Dr
    And I select Blue Of Old Style Select Menu
    And I click on the Multi Select Dropdown
    And I select Green
    And I select Audi in the Standard Multi Select
    Then I check that all fields are selected

  @booking
  Scenario: checking price per night
    Given I open the "booking.com"
    When I skip "Sign In" offer
    And I select the "Париж" city
    And I set dates from 3 to 10
    And I click on the Occupancy dropdown
    And I click on the Adults +
    And I click on the Adults +
    And I click on the Apartments +
    And I click on the Submit
    And I click on the max price per night in the filters
    And I wait when spinner disappears
    And I click on the Sorting dropdown
    And I select the Price Sorting
    Then I check the price per night

  @booking
  Scenario: checking the changing colors
    Given I open the "booking.com"
    When I skip "Sign In" offer
    And I select the "Париж" city
    And I set dates from 3 to 10
    And I click on the Submit
    And I scroll to the 10th hotel
    And I change the 10th hotel's background
    And I change the 10th hotel's title color
    Then I check that colors of the 10th hotel are changed

  @booking
  Scenario: checking hotel availability
    Given I open the "booking.com"
    When I skip "Sign In" offer
    And I select the "Париж" city
    And I set dates from 3 to 10
    And I click on the Submit
    Then I check appearance at least one hotel

  @booking
  Scenario: checking the hotel rating
    Given I open the "booking.com"
    When I skip "Sign In" offer
    And I select the "Париж" city
    And I set dates from 3 to 10
    And I click on the Submit
    And I click on the max rating in the filters
    And I wait when spinner disappears
    And I open the first hotel
    Then I check the hotel rating

  @booking
  Scenario: checking the currency tooltip value
    Given I open the "booking.com"
    When I skip "Sign In" offer
    And I hover on the currency
    Then I check the currency tooltip value

  @booking
  Scenario: checking the language tooltip value
    Given I open the "booking.com"
    When I skip "Sign In" offer
    And I hover on the language
    Then I check the language tooltip value