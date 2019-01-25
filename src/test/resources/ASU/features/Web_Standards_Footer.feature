Feature: Verify web standards for global footer

  Scenario: Verify ranking link in the footer
    Given I navigate to "https://www.asu.edu/"
    Then I verify the ranking url is displayed in the footer

  Scenario: Verify style specifications of the footer
    Given I navigate to "https://www.asu.edu/"
    Then I verify the given style standards for the footer

