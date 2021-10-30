Feature: booking search

  Scenario: search result should be correct
    Given User is on the search hotel page
    When User is searching for the "Hilton Минск"
    Then User goes to the result page
    Then "Hilton Минск" exists on the page at the top
    And rating of first result is "9,1"
