package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import stepImplementation.SearchRolePage;
import utility.Constants;

import java.util.List;
import java.util.Map;

public class SearchRolesSteps {

    SearchRolePage searchRolePage = new SearchRolePage();

    @Given("Open the career website")
    public void openTheCareerWebsite() {
        searchRolePage.navigateToCareerWebsite();
        searchRolePage.closeCookiePopup();
    }

    @When("Click on Professionals Option")
    public void clickOnProfessionalsOption() {
        searchRolePage.clickOnProfessionalsTab();
    }

    @Then("User should be able to navigate to Professionals page")
    public void userShouldBeAbleToNavigateToProfessionalsPage() {
        String actualURL = searchRolePage.getCurrentPageURL();
        Assert.assertTrue(actualURL.contains(Constants.PROFESSIONAL_PAGE_URL));
    }

    @When("Hover over the Professionals option and click on Search Roles")
    public void hoverOverTheProfessionalsOptionAndClickOnSearchRoles() {
        searchRolePage.mouseHoverProfessionalsTab();
        searchRolePage.clickOnSearchRolesPage();
    }

    @Then("User should be navigated to Search Roles page")
    public void userShouldBeNavigatedToSearchRolesPage() {
        String actualURL = searchRolePage.getCurrentPageURL();
        Assert.assertTrue(actualURL.contains(Constants.SEARCH_ROLE_PAGE_URL));
    }

    @And("User selects Search Category as {string}")
    public void userSelectsSearchCategory(String searchCategory) {
        searchRolePage.waitInSeconds(5);
        searchRolePage.selectSearchByCategory(searchCategory);
    }

    @And("User selects below values in search filters")
    public void userSelectsBelowValuesInSearchFilters(DataTable table) {
        List<Map<String, String>> details = table.asMaps(String.class, String.class);
        String divisionCategory = details.get(0).get(Constants.DIVISION_CATEGORY);
        if (divisionCategory != null) {
            searchRolePage.selectDivisionCategory(divisionCategory);
        }
        String professionCategory = details.get(0).get(Constants.PROFESSION_CATEGORY);
        if (professionCategory != null) {
            searchRolePage.selectProfessionCategory(professionCategory);
        }
        String profession = details.get(0).get(Constants.PROFESSION);
        if (profession != null) {
            searchRolePage.selectProfession(profession);
        }
        String country = details.get(0).get(Constants.COUNTRY);
        if (country != null) {
            searchRolePage.selectCountry(country);
        }
        String city = details.get(0).get(Constants.CITY);
        if (city != null) {
            searchRolePage.selectCity(city);
        }
        String corporateTitle = details.get(0).get(Constants.CORPORATE_TITLE);
        if (corporateTitle != null) {
            searchRolePage.selectCorporateTitle(corporateTitle);
        }
        String workType = details.get(0).get(Constants.WORK_TYPE);
        if (workType != null) {
            searchRolePage.selectWorkType(workType);
        }
        String availability = details.get(0).get(Constants.AVAILABILITY);
        if (availability != null) {
            searchRolePage.selectAvailability(availability);
        }
    }

    @When("Click on Reset button")
    public void clickOnResetButton() {
        searchRolePage.clickOnResetButton();
    }

    @Then("Values in Search filters should be as below")
    public void valuesInSearchFiltersShouldBeAsBelow(DataTable table) {
        List<Map<String, String>> details = table.asMaps(String.class, String.class);
        String searchCategory = details.get(0).get(Constants.SEARCH_CATEGORY);
        searchRolePage.validateSelectedSearchCategory(searchCategory);
        String divisionCategory = details.get(0).get(Constants.DIVISION_CATEGORY);
        if (divisionCategory != null) {
            String actualText = searchRolePage.getValueOfDivisionCategory(divisionCategory);
            Assert.assertEquals(actualText, divisionCategory);
        }
        String professionCategory = details.get(0).get(Constants.PROFESSION_CATEGORY);
        if (professionCategory != null) {
            String actualText = searchRolePage.getValueOfProfessionCategory(professionCategory);
            Assert.assertEquals(actualText, professionCategory);
        }
        String profession = details.get(0).get(Constants.PROFESSION);
        if (profession != null) {
            String actualText = searchRolePage.getValueOfProfession(profession);
            Assert.assertEquals(actualText, profession);
        }
        String country = details.get(0).get(Constants.COUNTRY);
        if (country != null) {
            String actualText = searchRolePage.getValueOfCountry(country);
            Assert.assertEquals(actualText, country);
        }
        String state = details.get(0).get(Constants.STATE);
        if (state != null) {
            String actualText = searchRolePage.getValueOfState(state);
            Assert.assertEquals(actualText, state);
        }
        String city = details.get(0).get(Constants.CITY);
        if (city != null) {
            String actualText = searchRolePage.getValueOfCity(city);
            Assert.assertEquals(actualText, city);
        }
        String corporateTitle = details.get(0).get(Constants.CORPORATE_TITLE);
        if (corporateTitle != null) {
            String actualText = searchRolePage.getValueOfCorporateTitle(corporateTitle);
            Assert.assertEquals(actualText, corporateTitle);
        }
        String workType = details.get(0).get(Constants.WORK_TYPE);
        if (workType != null) {
            String actualText = searchRolePage.getValueOfWorkType(workType);
            Assert.assertEquals(actualText, workType);
        }
        String availability = details.get(0).get(Constants.AVAILABILITY);
        if (availability != null) {
            String actualText = searchRolePage.getValueOfAvailability(availability);
            Assert.assertEquals(actualText, availability);
        }
        String roleTitle = details.get(0).get(Constants.ROLE_TITLE);
        if (roleTitle != null) {
            String actualText = searchRolePage.getValueOfRoleTitle(roleTitle);
            Assert.assertEquals(actualText, roleTitle);
        }
        String jobIdKeyword = details.get(0).get(Constants.JOBID_KEYWORD);
        if (jobIdKeyword != null) {
            String actualText = searchRolePage.getValueOfJobIdKeyword(jobIdKeyword);
            Assert.assertEquals(actualText, jobIdKeyword);
        }
    }

    @And("Click on Search button under Search By section")
    public void clickOnSearchButtonUnderSearchBySection() {
        searchRolePage.clickOnSearchButtonInSearchBySection();
    }

    @And("Get the result count from search role page")
    public void getTheSearchCount() throws InterruptedException {
        Thread.sleep(3000);
        searchRolePage.getSearchCountFromSearchRolePage();
    }

    @Given("Select Role Title as {string}")
    public void selectRoleTitleAs(String roleTitle) {
        searchRolePage.selectRoleTitle(roleTitle);
    }

    @Given("Enter Job ID_Keyword as {string}")
    public void enterJobIdKeywordAs(String inputValue) {
        searchRolePage.selectJobIdKeyword(inputValue);
    }
}