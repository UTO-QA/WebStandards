Feature: Web standards for photos and videos

  Scenario Outline: Verify photo standards
    Given I navigate to "https://www.asu.edu/"
    Then I go to the "<tab>" tab verify the first photo on the page
    Examples:
      |    tab         |
      |   News/Events  |
      |   Academics    |
      |   Research     |
      |   Athletics    |
      |   Alumni       |