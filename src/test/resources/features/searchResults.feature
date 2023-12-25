Feature: Search Results

  Background: Navigate to Search Roles Page
    Given Open the career website
    When Hover over the Professionals option and click on Search Roles
    Then User should be navigated to Search Roles page

  @SmokeTest @RegressionTest
  Scenario: Validate search results when searched by Division and default values in sub-fields
    Given User selects Search Category as 'Division'
    And Get the result count from search role page
    When Click on Search button under Search By section
    Then User should be able to view search results with 'Different' location(s)
    And Count of search result should be same as shown in search role page
    And Values in Search filters should be as below
      | Search Category | Division Category | Country       | State         | City          | Corporate Title | I want to work | What is your availability | Role Title | Job Id/Keyword |
      | Division        | Please select     | Please select | Please select | Please select | Please select   | Please select  | Please select             | Role Title | Search         |

  @SmokeTest @RegressionTest
  Scenario: Validate search results when searched by Profession and default values in sub-fields
    Given User selects Search Category as 'Profession'
    And Get the result count from search role page
    When Click on Search button under Search By section
    Then User should be able to view search results with 'Different' location(s)
    And Count of search result should be same as shown in search role page
    And Values in Search filters should be as below
      | Search Category | Profession Category | Profession    | Country       | State         | City          | Corporate Title | I want to work | What is your availability | Role Title | Job Id/Keyword |
      | Profession      | Please select       | Please select | Please select | Please select | Please select | Please select   | Please select  | Please select             | Role Title | Search         |

  @SanityTest @RegressionTest
  Scenario: Validate search results when searched by Division and other sub-fields
    Given User selects Search Category as 'Division'
    And User selects below values in search filters
      | Division Category | Country | City   |
      | Investment Bank   | India   | Mumbai |
    And Get the result count from search role page
    When Click on Search button under Search By section
    Then User should be able to view search results with 'Mumbai' location(s)
    And Count of search result should be same as shown in search role page
    And Values in Search filters should be as below
      | Search Category | Division Category | Country | City   |
      | Division        | Investment Bank   | India   | Mumbai |
    When User clicks on any of the search result
    Then User should be able to view below fields
      | Job ID    | Full/Part-Time | Regular/Temporary | Listed    | Location |
      | ANY_VALUE | ANY_VALUE      | ANY_VALUE         | ANY_VALUE | Mumbai   |

  @SanityTest @RegressionTest
  Scenario: Validate search results when searched by Profession and other sub-fields
    Given User selects Search Category as 'Profession'
    And User selects below values in search filters
      | Profession Category | Profession                       | Country     | City   |
      | Finance             | Financial & Regulatory Reporting | Philippines | Manila |
    And Get the result count from search role page
    When Click on Search button under Search By section
    Then User should be able to view search results with 'Manila' location(s)
    And Count of search result should be same as shown in search role page
    And Values in Search filters should be as below
      | Search Category | Profession Category | Profession                       | Country     | City   |
      | Profession      | Finance             | Financial & Regulatory Reporting | Philippines | Manila |
    When User clicks on any of the search result
    Then User should be able to view below fields
      | Job ID    | Full/Part-Time | Regular/Temporary | Listed    | Location |
      | ANY_VALUE | ANY_VALUE      | ANY_VALUE         | ANY_VALUE | Manila   |

  @SanityTest @RegressionTest
  Scenario: Validate search results when searched by fields in Keyword Search section
    Given Select Role Title as 'Test Automation Engineer'
    When Click on Search button under Keyword search section
    Then User should be able to view search results with 'Different' location(s)
    And User should be able to get search results related to 'Test Automation Engineer'

  @RegressionTest
  Scenario: Validate search results when filter is applied from Search Results page
    Given Click on Search button under Search By section
    And User should be able to view search results with 'Different' location(s)
    When User select City as 'Pune'
    And Click on Search button on Search Results Page
    Then User should be able to view search results with 'Pune' location(s)

  @RegressionTest
  Scenario: Validate search results with Incorrect Search Term
    Given Select Role Title as 'Tste'
    And Enter Job ID_Keyword as 'Tste'
    When Click on Search button under Keyword search section
    Then User should not be able to view any search results