Feature: Register new account Booking.com

  Scenario: New account registration scenario
    Given I register new email
    When I register new user
    When I confirm email for registration
    When I login in booking account
    When I verify booking account
    Then I passed test