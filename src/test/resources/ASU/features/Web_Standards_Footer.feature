Feature: Verify web standards for global footer

  Scenario Outline: All ASU websites must have a global footer
  Given I navigate to "<asuWebsite>"
  When I validate the footer is displayed


  Examples:
  |asuWebsite|
  |https://www.asu.edu|

  Scenario: Global Footer Links
    Then Verify the following options are listed in the footer "Copyright and Trademark, Accessibility, Privacy, Terms of Use, Jobs, Emergency, Contact ASU"

  Scenario:  U.S. News & World Report Logo
    Then Verify the 2017 U.S. News & World Report logo is displayed in the footer

  Scenario:  U.S. for Innovation Statement
    Then Verify "ASU is #1 in the U.S. for Innovation" is displayed in the footer

  Scenario: Universal footer menu background color
    Then Verify the background color for the footer menu is gray

  Scenario: Universal footer menu gray bar height
    Then the gray bar on the universal footer should have a height of "56px"

  Scenario: Universal footer menu font size
    Then the universal footer's font size should be "16px"

  Scenario: Universal footer menu font weight
    Then the universal footer's font weight should be "200"

  Scenario:  Innovation gold bar height
     Then the innovation gold bar in the footer should have a height of "56 px"

  Scenario:  Innovation bar background color
    Then the innovation bar background color should be gold

  Scenario: Innovation bar text font and color
    Then the innovation ranking status font family should be the correct font family and in black

#  Scenario:  Universal footer link color
#    Then the link color in the universal footer should be #333333
#
#  Scenario: Verify ranking link in the footer
#    Given I navigate to "https://www.asu.edu/"
#    Then I verify the ranking url is displayed in the footer
#
#  Scenario: Verify style specifications of the footer
#    Given I navigate to "https://www.asu.edu/"
#    Then I verify the given style standards for the footer

