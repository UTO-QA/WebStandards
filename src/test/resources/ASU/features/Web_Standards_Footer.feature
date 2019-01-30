Feature: Verify web standards for global footer

  Scenario Outline: All ASU websites must have a global footer
  Given I navigate to "<asuwebsite>"
  When I validate the footer is displayed
  Then Verify the 2017 U.S. News & World Report logo is displayed in the footer

  Examples:
  |asuwebsite| number|
  |https://www.asu.edu| 56px|

#  Scenario: Global Footer Links
#    Then Verify the following options are listed in the footer "Copyright and Trademark, Accessibility, Privacy, Terms of Use, Jobs, Emergency, Contact ASU"
#
#  Scenario:  U.S. News & World Report Logo
#    Then Verify the 2017 U.S. News & World Report logo is displayed in the footer
#
#  Scenario:  U.S. for Innovation Statement
#    Then Verify "ASU is #1 in the U.S. for Innovation" is displayed in the footer
#
#  Scenario: Universal footer background color
#    Then the background color the universal footer should be #E5E5E5
#
#  Scenario: Universal footer gray bar height
#    Then the gray bary on the universal footer should have a height of 59px
#
#  Scenario: Universal footer font size
#    Then the universal footer's font size should be 16px
#
#  Scenario: Universal footer font weight
#    Then the universal footer's font weight should be 200
#
#  Scenario:  Universal footer gold bar height
#     Then the gold bar on the universal footer should have a height of 56 px
#
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

