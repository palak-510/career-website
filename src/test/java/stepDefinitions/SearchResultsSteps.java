package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import stepImplementation.SearchResultsPage;
import utility.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchResultsSteps {

    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @And("User should be able to view search results with {string} location\\(s)")
    public void userShouldBeAbleToViewSearchResultsWithDifferentLocationS(String location) {
        List<String> allLocations = searchResultsPage.getAllLocations();
        if (allLocations.size() > 0) {
            Set<String> differentLocations = new HashSet<>(allLocations);
            if (location.toLowerCase().contains(Constants.DIFFERENT) && allLocations.size() > 1) {
                Assert.assertTrue(differentLocations.size() > 1);
            } else {
                Assert.assertEquals(1, differentLocations.size());
            }
        } else {
            System.out.println("No search results found");
            Assert.fail();
        }
    }

    @Then("User should be navigated to search results page")
    public void userShouldBeNavigatedToSearchResultsPage() {
        String actualURL = searchResultsPage.getCurrentPageURL();
        Assert.assertTrue(actualURL.contains(Constants.SEARCH_RESULTS_PAGE_URL));
    }

    @When("User clicks on any of the search result")
    public void userClicksOnAnyOfTheSearchResult() {
        searchResultsPage.clickOnFirstSearchResult();
    }

    @And("Count of search result should be same as shown in search role page")
    public void countOfSearchResultShouldBeSameAsShownInSearchRolePage() {
        Integer actualCount = searchResultsPage.getSearchCountFromSearchResultPage();
        Integer expectedCount = searchResultsPage.getStoredSearchCount();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @When("Click on Search button under Keyword search section")
    public void clickOnSearchButtonUnderKeywordSearchSection() {
        searchResultsPage.clickOnSearchButtonInKeywordSection();
    }

    @And("User should be able to get search results related to {string}")
    public void userShouldBeAbleToGetSearchResultsRelatedToTestAutomationEngineer(String searchKeyword) {
        String[] inputWord = searchKeyword.split(" ");
        List<String> actualJobTitlesList = searchResultsPage.getAllJobTitles();
        if (actualJobTitlesList.size() > 0) {
            for (String jobTitle : actualJobTitlesList) {
                Assert.assertTrue(jobTitle.toLowerCase().contains(inputWord[0].toLowerCase()) || jobTitle.toLowerCase().contains(inputWord[1].toLowerCase()) || jobTitle.toLowerCase().contains(inputWord[2].toLowerCase()));
            }
        } else {
            System.out.println("No search results found, please search for other job role");
        }
    }

    @When("User select City as {string}")
    public void userSelectCityAsPune(String city) {
        searchResultsPage.selectCity(city);
    }

    @And("Click on Search button on Search Results Page")
    public void clickOnSearchButtonOnSearchResultsPage() throws InterruptedException {
        searchResultsPage.clickOnSearchButtonOnSearchResultsPage();
        Thread.sleep(3000);
    }

    @Then("User should not be able to view any search results")
    public void userShouldNotBeAbleToViewAnySearchResults() {
        List<String> allLocations = searchResultsPage.getAllLocations();
        Assert.assertEquals(0, allLocations.size());
    }
}
