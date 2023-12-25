Feature: Job Details

  Background: Navigate to Search Roles Page
    Given Open the career website
    When Hover over the Professionals option and click on Search Roles
    Then User should be navigated to Search Roles page

  @RegressionTest
  Scenario: Validate Apply for this Job navigation url and Back to search results navigation
    Given Click on Search button under Search By section
    And User should be able to view search results with 'Different' location(s)
    When User clicks on any of the search result
    Then User validates Apply for this job url reference
    When User clicks on Back to search results button
    Then User should be navigated to search results page