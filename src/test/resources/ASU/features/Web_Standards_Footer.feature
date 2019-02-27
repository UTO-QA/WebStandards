Feature: Verify web standards for global footer

  Scenario Outline: All ASU websites must have a global footer
    Given I navigate to "<asuWebsite>"
    When I validate the footer is displayed
    Then Verify the following options are listed in the footer "Copyright and Trademark, Accessibility, Privacy, Terms of Use, Jobs, Emergency, Contact ASU"
    Then Verify the 2017 U.S. News & World Report logo is displayed in the footer
    Then Verify "ASU is #1 in the U.S. for Innovation" is displayed in the footer
    Then Verify the footer is in the correct format




    Examples:
      | asuWebsite                 |
      | https://www.asu.edu        |
      | https://admission.asu.edu/ |


