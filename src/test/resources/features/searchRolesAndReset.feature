Feature: Search Roles And Reset Functionality

  @SmokeTest
  Scenario: Validate user is able to navigate to Professionals and Search Roles page
    Given Open the career website
    When Click on Professionals Option
    Then User should be able to navigate to Professionals page
    When Hover over the Professionals option and click on Search Roles
    Then User should be navigated to Search Roles page

  @SanityTest @RegressionTest
  Scenario: Validate reset functionality when initial selected search category is Division
    Given Open the career website
    And Hover over the Professionals option and click on Search Roles
    And User selects Search Category as 'Division'
    And User selects below values in search filters
      | Division Category | Country | State | City      | Corporate Title          | I want to work | What is your availability |
      | Chairman          | Germany | Hesse | Frankfurt | Assistant Vice President | Permanent      | Full time                 |
    When Click on Reset button
    Then Values in Search filters should be as below
      | Search Category | Division Category | Country       | State         | City          | Corporate Title | I want to work | What is your availability |
      | Division        | Please select     | Please select | Please select | Please select | Please select   | Please select  | Please select             |
    When Click on Search button under Search By section
    And Click on Reset button
    Then User should be navigated to Search Roles page
    And Values in Search filters should be as below
      | Search Category | Division Category | Country       | State         | City          | Corporate Title | I want to work | What is your availability |
      | Division        | Please select     | Please select | Please select | Please select | Please select   | Please select  | Please select             |

  @SanityTest @RegressionTest
  Scenario: Validate reset functionality when initial selected search category is Profession
    Given Open the career website
    And Hover over the Professionals option and click on Search Roles
    And User should be navigated to Search Roles page
    And User selects Search Category as 'Profession'
    And User selects below values in search filters
      | Profession Category | Profession                       | Country     | City   | Corporate Title | I want to work | What is your availability |
      | Finance             | Financial & Regulatory Reporting | Philippines | Manila | Associate       | Permanent      | Full time                 |
    When Click on Reset button
    Then Values in Search filters should be as below
      | Search Category | Profession Category | Profession    | Country       | State         | City          | Corporate Title | I want to work | What is your availability |
      | Profession      | Please select       | Please select | Please select | Please select | Please select | Please select   | Please select  | Please select             |
    When User selects Search Category as 'Profession'
    And Click on Search button under Search By section
    And Click on Reset button
    Then User should be navigated to Search Roles page
    And Values in Search filters should be as below
      | Search Category | Profession Category | Profession    | Country       | State         | City          | Corporate Title | I want to work | What is your availability | Role Title | Job Id/Keyword |
      | Profession      | Please select       | Please select | Please select | Please select | Please select | Please select   | Please select  | Please select             |            |                |