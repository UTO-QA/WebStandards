Feature: Verifying ASU Web Standard Headers

   Scenario Outline: Verify header and logo
     When I navigate to "<url>"
     Then Verify the element "<element>"
     Examples:
     |       url                |    element       |
     |https://www.asu.edu/      |    header        |
     |https://www.asu.edu/      |    logo          |
     |https://admission.asu.edu/|    header        |
     |https://admission.asu.edu/|    logo          |

  Scenario Outline: Verify different links on ASU header
    When I navigate to "<url>"
    Then User clicks on "<link>" link
    Then User should be navigated to "<page>" page
    Examples:
    |           url                 |     link              |    page             |
    |      https://www.asu.edu/     |    My ASU             |    login            |
    |      https://www.asu.edu/     |  Colleges and Schools | Colleges and Schools|
    |      https://www.asu.edu/     |  Map and Locations    | Maps                |
    |      https://www.asu.edu/     |  Directory            | Directory           |
    |    https://admission.asu.edu/ |    My ASU             |    login            |
    |    https://admission.asu.edu/ |  Colleges and Schools | Colleges and Schools|
    |    https://admission.asu.edu/ |  Map and Locations    | Maps                |
    |    https://admission.asu.edu/ |  Directory            | Directory           |


  Scenario Outline: ASU Global Search
    Given I navigate to "<url>"
    Then I enter "courses" to search
    Then The user should see a list of results for the keyword "courses"
    Examples:
    | url                     |
    |https://www.asu.edu/     |
    |https://admission.asu.edu/|

  Scenario Outline: ASU Home in Global ASU links
    Given I navigate to "<url>"
    Then User clicks on "ASU Home" link
    Then Drop-down appears for "ASU Home" with following options "News and Events, Academics, Research, Atletics, Alumni, Giving, President, About ASU"
    Examples:
      | url                     |
      |https://www.asu.edu/     |
      |https://admission.asu.edu/|


  Scenario: ASU Logo redirection
    Given I navigate to "https://www.asu.edu/"
    Then I navigate to "https://admission.asu.edu/"
    Then I click on ASU logo
    Then I should be redirected to "https://www.asu.edu/"