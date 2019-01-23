Feature: Verify web standards for global navigation bar

  Scenario Outline: Verify tabs in global navigation bar
    Given I navigate to "https://www.asu.edu/"
    Then I verify the navigation bar standards
    Then I go to the "<tab>" tab and verify the tab standards
  Examples:
  |    tab         |
  |   News/Events  |
  |   Academics    |
  |   Research     |
  |   Athletics    |
  |   Alumni       |