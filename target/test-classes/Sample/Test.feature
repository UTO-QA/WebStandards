Feature: First feature

Scenario Outline: run
   Given I navigate to "<url>"
   Then I verify the "ASU" logo
  # Then I verify the elements:
  # |ASU Home|
  # |My ASU  |
  # |Colleges and Schools        |


   Examples:
   |  url   |
   | https://webapp4.asu.edu/uga_admissionsapp/       |
