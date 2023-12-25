package stepImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseTestUtils;
import utility.Context;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BaseTestUtils {

    private By locations = By.xpath(".//a[contains(@href,'#/professional/job/')]/div/div");
    private By firstSearchResult = By.xpath(".//a[contains(@href,'#/professional/job/')]");
    private By searchResultCount = By.xpath(".//div[contains(text(),'suitable results')]");
    private By searchButtoninKeywordSection = By.xpath(".//div[@class='keyword-container professional']/a[contains(@href,'#/professional/results/')]");
    private By jobTitles = By.xpath(".//a[contains(@href,'#/professional/job/')]/div/h2");
    private By city_inputField = By.xpath("//div[contains(text(),'City')]/following-sibling::div/div/div/input");
    private By city_selectedValue = By.xpath("//div[contains(text(),'City')]/following-sibling::div/div/div/span");
    private By searchButton = By.xpath(".//button[contains(text(),'Search')]");

    WebDriver driver = BaseTestUtils.driver;

    public List<String> getAllLocations() {
        List<WebElement> elements = driver.findElements(locations);
        List<String> locations = new ArrayList<>();
        if (elements.size() > 0) {
            for (WebElement element : elements) {
                String fullValue = element.getText();
                String location = fullValue.split(":")[1];
                locations.add(location);
            }
        }
        return locations;
    }

    public void clickOnFirstSearchResult() {
        driver.findElement(firstSearchResult).click();
        waitInSeconds(2);
    }

    public Integer getSearchCountFromSearchResultPage() {
        waitInSeconds(3);
        String countText = driver.findElement(searchResultCount).getText().split(" ")[0];
        return Integer.parseInt(countText);
    }

    public Integer getStoredSearchCount() {
        String expectedCountText = (String) getContext(Context.SEARCH_COUNT);
        return Integer.parseInt(expectedCountText);
    }

    public void clickOnSearchButtonInKeywordSection() {
        driver.findElement(searchButtoninKeywordSection).click();
        waitInSeconds(5);
    }

    public List<String> getAllJobTitles() {
        List<WebElement> elements = driver.findElements(jobTitles);
        List<String> jobTitles = new ArrayList<>();
        if (elements.size() > 0) {
            for (WebElement element : elements) {
                String jobTitle = element.getText();
                jobTitles.add(jobTitle);
            }
        }
        return jobTitles;
    }

    public void selectCity(String city) {
        waitInSeconds(3);
        driver.findElement(city_inputField).sendKeys(city);
        mouseHover(driver.findElement(city_inputField));
        waitInSeconds(3);
        WebElement el = driver.findElement(city_inputField);
        el.sendKeys(Keys.ENTER);
        waitUntilPresenceOf(city_selectedValue);
    }

    public void clickOnSearchButtonOnSearchResultsPage() {
        driver.findElement(searchButton).click();
    }
}
