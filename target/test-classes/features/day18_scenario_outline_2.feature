@scenario_outline_capital_search
Feature: capital_search_Feature
  Scenario Outline: capital_search_scenario
#shift + < puts data in <>
    Given user is on the google page
    And user search for "<capital>"
    Then verify the result has "<capital>"
    Then close the application
    Examples: Test Data
      |capital  |
      |Berlin |
      |Vienna |
      |London |
      |Madrid |
      |Paris |
