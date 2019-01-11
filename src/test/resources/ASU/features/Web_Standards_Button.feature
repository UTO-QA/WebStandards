Feature: Validate various button types


  Scenario: ASU Recruitment related buttons
    When I navigate to "https://admission.asu.edu/"
    Then I validate the "Apply" button
    Then I validate the "Request info" button

  Scenario Outline: ASU explore degree buttons
    When I navigate to "<url>"
    Then I validate the "Undergraduate" button
    Examples:
      |            url                                     |
      | https://wpcarey.asu.edu/                           |


  Scenario Outline: Explore degree buttons
    When I navigate to "<url>"
    Then I validate the "Undergraduate programs" button
    Then I validate the "Graduate programs" button
    Then I verify that the buttons belong to the Explore pannel
    Examples:
      |                   url                              |
      | https://herbergerinstitute.asu.edu/degree-programs |
      | https://clas.asu.edu/                              |
