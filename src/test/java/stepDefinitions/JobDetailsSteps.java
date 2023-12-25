package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import stepImplementation.JobDetailsPage;
import utility.Constants;

import java.util.List;
import java.util.Map;

public class JobDetailsSteps {

    JobDetailsPage jobDetailsPage = new JobDetailsPage();

    @Then("User validates Apply for this job url reference")
    public void userValidatesApplyForThisJobUrlReference() {
        String applyForJobURL = jobDetailsPage.getApplyJobURL();
        Assert.assertTrue(applyForJobURL.contains(Constants.WORKDAYURL));
    }

    @When("User clicks on Back to search results button")
    public void userClicksOnBackToSearchResultsButton() {
        jobDetailsPage.clickOnBackToSearchResultsButton();
    }

    @Then("User should be able to view below fields")
    public void userShouldBeAbleToViewBelowFields(DataTable table) {
        List<Map<String, String>> details = table.asMaps(String.class, String.class);

        String expectedJobId = details.get(0).get(Constants.JOBID);
        String actualJobId = jobDetailsPage.getValueOfJobIdInJobDetails();
        verifyValuesOnJobDetails(expectedJobId, actualJobId);

        String expectedfulltime_parttime = details.get(0).get(Constants.FULLTIMEPARTTIME);
        String actualfulltime_parttime = jobDetailsPage.getValueOfFullPartTimeInJobDetails();
        verifyValuesOnJobDetails(expectedfulltime_parttime, actualfulltime_parttime);

        String expectedregulartemporary = details.get(0).get(Constants.REGULARTEMP);
        String actualregulartemporary = jobDetailsPage.getValueOfRegularTempInJobDetails();
        verifyValuesOnJobDetails(expectedregulartemporary, actualregulartemporary);

        String expectedlisted = details.get(0).get(Constants.LISTED);
        String actualListed = jobDetailsPage.getValueOfListedInJobDetails();
        verifyValuesOnJobDetails(expectedlisted, actualListed);

        String expectedlocation = details.get(0).get(Constants.LOCATION);
        String actualLocation = jobDetailsPage.getValueOfLocationInJobDetails();
        verifyValuesOnJobDetails(expectedlocation, actualLocation);
    }

    private void verifyValuesOnJobDetails(String expectedValue, String actualValue) {
        if (expectedValue.equals(Constants.ANYVALUE)) {
            Assert.assertNotNull(actualValue);
            Assert.assertNotEquals(actualValue, "");
        } else {
            Assert.assertEquals(actualValue, expectedValue);
        }
    }
}
