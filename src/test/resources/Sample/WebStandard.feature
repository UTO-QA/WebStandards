Feature: First feature

Scenario Outline: run
   Given I navigate to "<url>"
   Then I verify the "ASU" logo
  # Then I verify the elements:
  # |ASU Home|
  # |My ASU  |
  # |Colleges and Schools        |
$("#asu_nav_menu #asu_universal_nav ul:first-child>li a")[0].textContent

   Examples:
   |  url   |
   | https://webapp4.asu.edu/uga_admissionsapp/       |
