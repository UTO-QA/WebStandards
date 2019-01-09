Feature: Verifying ASU Web Standard Headers

  Background: All ASU websites must have a header
    Given I navigate to "https://www.asu.edu/"

  Scenario: White Background
    Then Verify the header has white backgrounnd

  Scenario: ASU Home in Global ASU links
    Then User clicks on "ASU Home" link
    Then Drop-down appears for "ASU Home" with following options "News and Events, Academics, Research, Atletics, Alumni, Giving, President, About ASU"

  Scenario: My ASU in global links
    Then User clicks on "My ASU" link
    Then User should be navigated to MyASU login page

  Scenario: Colleges and Schools in global links
    Then User clicks on "Colleges and Schools" link
    Then User should be navigate to Colleges and Schools home page

  Scenario: Maps and Locations in global links
    Then User clicks on "Maps and Location" link
    Then User should be navigated to the Maps page

  Scenario: Directory in global links
    Then User clicks on "Directory" link
    Then User should be navigated to the Directory page

  Scenario: ASU Global Search
    Then I enter "courses" to search
    Then The user should see a list of results for the keyword "courses"

  Scenario: ASU Logo
    Then I verify the asu logo is placed at Top

  Scenario: ASU Logo redirection
    Then I navigate to "https://admission.asu.edu/"
    Then I click on ASU logo
    Then I should be redirected to "https://www.asu.edu/"