Feature: First feature

Scenario Outline: run
   Given I navigate to "<url>"
   Then I verify the "ASU" logo

   Examples:
   |  url   |
   | https://webapp4.asu.edu/uga_admissionsapp/       |
