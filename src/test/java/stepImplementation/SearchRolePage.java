package stepImplementation;

import org.openqa.selenium.*;
import org.testng.Assert;
import utility.BaseTestUtils;
import utility.Constants;
import utility.Context;
import utility.Property;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchRolePage extends BaseTestUtils {

    private By professionalsTab = By.xpath(".//a[@title='Professionals']");
    private By searchRolesTab = By.xpath(".//a[@title='Search Roles']");
    private By shadowRoot = By.id("usercentrics-root");
    private By cookie_denyAndContinue = By.cssSelector("[data-testid='uc-deny-all-button']");
    private By searchByDivision = By.cssSelector("[id='divisionProf']");
    private By searchByDivision_selected = By.xpath(".//button[@id='divisionProf']/div");
    private By searchByProfession = By.cssSelector("[id='profession']");
    private By searchByProfession_selected = By.xpath(".//button[@id='profession']/div");
    private By divisionCategory_inputField = By.xpath("//div[contains(text(),'Division Category')]/following-sibling::div/div/div/input");
    private By divisionCategory_selectedValue = By.xpath("//div[contains(text(),'Division Category')]/following-sibling::div/div/div/span");
    private By roleTitle = By.cssSelector("[id='roleKeyword']");
    private By jobId_Keyword = By.cssSelector("[id='jobIdSearch']");
    private By resetButton = By.xpath(".//a[contains(text(),'Reset')]");
    private By profession_inputField = By.xpath("//div[(text()='Profession')]/following-sibling::div/div/div/input");
    private By profession_selectedValue = By.xpath("//div[(text()='Profession')]/following-sibling::div/div/div/span");
    private By professionCategory_inputField = By.xpath("//div[contains(text(),'Profession Category')]/following-sibling::div/div/div/input");
    private By professionCategory_selectedValue = By.xpath("//div[contains(text(),'Profession Category')]/following-sibling::div/div/div/span");
    private By country_inputField = By.xpath("//div[contains(text(),'Country')]/following-sibling::div/div/div/input");
    private By country_selectedValue = By.xpath("//div[contains(text(),'Country')]/following-sibling::div/div/div/span");
    private By state_inputField = By.xpath("//div[contains(text(),'State')]/following-sibling::div/div/div/input");
    private By state_selectedValue = By.xpath("//div[contains(text(),'State')]/following-sibling::div/div/div/span");
    private By city_inputField = By.xpath("//div[contains(text(),'City')]/following-sibling::div/div/div/input");
    private By city_selectedValue = By.xpath("//div[contains(text(),'City')]/following-sibling::div/div/div/span");
    private By title_inputField = By.xpath("//div[contains(text(),'Corporate title')]/following-sibling::div/div/div/input");
    private By title_selectedValue = By.xpath("//div[contains(text(),'Corporate title')]/following-sibling::div/div/div/span");
    private By workType_inputField = By.xpath("//div[contains(text(),'I want to work')]/following-sibling::div/div/div/input");
    private By workType_selectedValue = By.xpath("//div[contains(text(),'I want to work')]/following-sibling::div/div/div/span");
    private By availability_inputField = By.xpath("//div[contains(text(),'What is your availability?')]/following-sibling::div/div/div/input");
    private By availability_selectedValue = By.xpath("//div[contains(text(),'What is your availability?')]/following-sibling::div/div/div/span");
    private By roleTitle_inputField = By.id("roleKeyword");
    private By roleTitle_selectedValue = By.id("roleKeyword");
    private By jobIdKeyword_inputField = By.id("jobIdSearch");
    private By searchButtoninSearchBySection = By.xpath(".//div[@class='button-wrapper']/a[contains(@href,'#/professional/results/')]");
    private By searchCountOnSearchRolePage = By.xpath(".//a[contains(@href,'#/professional/results/')]/../following-sibling::div");

    WebDriver driver = BaseTestUtils.driver;
    Property property = new Property();

    public void navigateToCareerWebsite() {
        String websiteURL = property.getApplicationUrl();
        driver.get(websiteURL);
    }

    public void closeCookiePopup() {
        waitUntilPresenceOf(shadowRoot);
        WebElement shadowRootElement = driver.findElement(shadowRoot);
        SearchContext shadowRoot = shadowRootElement.getShadowRoot();
        if (shadowRoot.findElements(cookie_denyAndContinue).size() != 0) {
            shadowRoot.findElement(cookie_denyAndContinue).click();
        }
    }

    public void clickOnProfessionalsTab() {
        driver.findElement(professionalsTab).click();
    }

    public void mouseHoverProfessionalsTab() {
        mouseHover(driver.findElement(professionalsTab));
        waitInSeconds(2);
    }

    public void clickOnSearchRolesPage() {
        driver.findElement(searchRolesTab).click();
        waitInSeconds(2);
    }

    public void selectSearchByCategory(String searchCategory) {
        if (searchCategory.equals(Constants.SEARCH_BY_DIVISION)) {
            driver.findElement(searchByDivision).click();
        } else if (searchCategory.equals(Constants.SEARCH_BY_PROFESSION)) {
            driver.findElement(searchByProfession).click();
        }
    }

    public void selectDivisionCategory(String division) {
        waitInSeconds(3);
        driver.findElement(divisionCategory_inputField).sendKeys(division);
        mouseHover(driver.findElement(divisionCategory_inputField));
        waitInSeconds(3);
        WebElement el = driver.findElement(divisionCategory_inputField);
        el.sendKeys(Keys.ENTER);
        waitUntilPresenceOf(divisionCategory_selectedValue);
    }

    public void selectProfessionCategory(String professionCategory) {
        waitInSeconds(3);
        driver.findElement(professionCategory_inputField).sendKeys(professionCategory);
        mouseHover(driver.findElement(professionCategory_inputField));
        waitInSeconds(3);
        WebElement el = driver.findElement(professionCategory_inputField);
        el.sendKeys(Keys.ENTER);
        waitUntilPresenceOf(professionCategory_selectedValue);
    }

    public void selectProfession(String profession) {
        waitInSeconds(3);
        driver.findElement(profession_inputField).sendKeys(profession);
        mouseHover(driver.findElement(profession_inputField));
        waitInSeconds(3);
        WebElement el = driver.findElement(profession_inputField);
        el.sendKeys(Keys.ENTER);
        waitUntilPresenceOf(profession_selectedValue);
    }

    public void selectCountry(String country) {
        waitInSeconds(3);
        driver.findElement(country_inputField).sendKeys(country);
        mouseHover(driver.findElement(country_inputField));
        waitInSeconds(3);
        WebElement el = driver.findElement(country_inputField);
        el.sendKeys(Keys.ENTER);
        waitUntilPresenceOf(country_selectedValue);
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

    public void selectCorporateTitle(String corporateTitle) {
        waitInSeconds(3);
        driver.findElement(title_inputField).sendKeys(corporateTitle);
        mouseHover(driver.findElement(title_inputField));
        waitInSeconds(3);
        WebElement el = driver.findElement(title_inputField);
        el.sendKeys(Keys.ENTER);
        waitUntilPresenceOf(title_selectedValue);
    }

    public void selectWorkType(String workType) {
        waitInSeconds(3);
        driver.findElement(workType_inputField).sendKeys(workType);
        mouseHover(driver.findElement(workType_inputField));
        waitInSeconds(3);
        WebElement el = driver.findElement(workType_inputField);
        el.sendKeys(Keys.ENTER);
        waitUntilPresenceOf(workType_selectedValue);
    }

    public void selectAvailability(String availability) {
        waitInSeconds(3);
        driver.findElement(availability_inputField).sendKeys(availability);
        mouseHover(driver.findElement(availability_inputField));
        waitInSeconds(3);
        WebElement el = driver.findElement(availability_inputField);
        el.sendKeys(Keys.ENTER);
        waitUntilPresenceOf(availability_selectedValue);
    }

    public void clickOnResetButton() {
        driver.findElement(resetButton).click();
        waitInSeconds(2);
    }

    public String getValueOfDivisionCategory(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(divisionCategory_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(divisionCategory_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfProfessionCategory(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(professionCategory_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(professionCategory_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfProfession(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(profession_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(profession_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfCountry(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(country_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(country_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfState(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(state_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(state_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfCity(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(city_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(city_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfCorporateTitle(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(title_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(title_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfWorkType(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(workType_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(workType_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfAvailability(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.PLEASE_SELECT)) {
            actualText = driver.findElement(availability_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(availability_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfRoleTitle(String expectedText) {
        String actualText;
        if (expectedText.equals(Constants.ROLE_TITLE)) {
            actualText = driver.findElement(roleTitle_inputField).getAttribute("placeholder");
        } else {
            actualText = driver.findElement(roleTitle_selectedValue).getText().trim();
        }
        return actualText;
    }

    public String getValueOfJobIdKeyword(String expectedText) {
        return driver.findElement(jobIdKeyword_inputField).getAttribute("placeholder");
    }

    public void selectRoleTitle(String role) {
        WebElement element = driver.findElement(roleTitle);
        element.sendKeys(role);
    }

    public void selectJobIdKeyword(String jobIdKeyword) {
        WebElement element = driver.findElement(jobId_Keyword);
        element.sendKeys(jobIdKeyword);
    }

    public void validateSelectedSearchCategory(String searchCategory) {
        boolean isDivisionSelected = false;
        boolean isProfessionSelected = false;
        if (searchCategory.equals(Constants.SEARCH_BY_DIVISION)) {
            try {
                isDivisionSelected = driver.findElement(searchByDivision_selected).isDisplayed();
            } catch (Exception e) {
                System.out.println("Search By Division is not selected");
                throw (e);
            }
        } else if (searchCategory.equals(Constants.SEARCH_BY_PROFESSION)) {
            try {
                isProfessionSelected = driver.findElement(searchByProfession_selected).isDisplayed();
            } catch (Exception e) {
                System.out.println("Search By Division is not selected");
                throw (e);
            }
        }
        if (searchCategory.equals(Constants.SEARCH_BY_DIVISION)) {
            assertThat(isDivisionSelected).isNotEqualTo(isProfessionSelected).isEqualTo(true);
        } else if (searchCategory.equals(Constants.SEARCH_BY_PROFESSION)) {
            assertThat(isProfessionSelected).isNotEqualTo(isDivisionSelected).isEqualTo(true);
        }
    }

    public void clickOnSearchButtonInSearchBySection() {
        waitUntilPresenceOf(searchButtoninSearchBySection);
        driver.findElement(searchButtoninSearchBySection).click();
        waitInSeconds(5);
    }

    public void getSearchCountFromSearchRolePage() {
        waitInSeconds(3);
        String text = driver.findElement(searchCountOnSearchRolePage).getText();
        String count = text.split(":")[1].trim();
        setContext(Context.SEARCH_COUNT, count);
    }
}
