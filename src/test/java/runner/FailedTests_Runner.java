package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@build/FailedTestcase.txt"},
        glue = {"stepDefinitions", "utility", "hooks"},
        plugin = {"pretty","html:target/cucumber-html-report.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@RegressionTest"
)
public class FailedTests_Runner {
}
