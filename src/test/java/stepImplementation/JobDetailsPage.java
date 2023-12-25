package stepImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BaseTestUtils;

public class JobDetailsPage extends BaseTestUtils {

    private By applyForJob = By.xpath(".//a[contains(text(),'Apply for this job')]");
    private By backToSearchResultsButton = By.xpath(".//a[contains(text(),'Back to search results')]");
    private By jobId = By.xpath(".//*[text()='Job ID:']/..");
    private By fullparttime = By.xpath(".//*[text()='Full/Part-Time: ']/..");
    private By regulartemp = By.xpath(".//*[text()='Regular/Temporary: ']/..");
    private By listed_element = By.xpath(".//*[text()='Listed: ']/..");
    private By location_element = By.xpath(".//*[text()='Location: ']/..");

    WebDriver driver = BaseTestUtils.driver;

    public String getApplyJobURL() {
        return driver.findElement(applyForJob).getAttribute("href");
    }

    public void clickOnBackToSearchResultsButton() {
        driver.findElement(backToSearchResultsButton).click();
        waitInSeconds(2);
    }

    public String getValueOfJobIdInJobDetails() {
        return driver.findElement(jobId).getText();
    }

    public String getValueOfFullPartTimeInJobDetails() {
        return driver.findElement(fullparttime).getText();
    }

    public String getValueOfRegularTempInJobDetails() {
        return driver.findElement(regulartemp).getText();
    }

    public String getValueOfListedInJobDetails() {
        return driver.findElement(listed_element).getText();
    }

    public String getValueOfLocationInJobDetails() {
        return driver.findElement(location_element).getText().split(":")[1].trim();
    }
}
