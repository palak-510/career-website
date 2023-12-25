package runner;

import io.cucumber.testng.CucumberOptions;
import utility.BaseTestUtils;

@CucumberOptions(
        tags = "@RegressionTest"
)
public class RegressionTest_Runner extends BaseTestUtils {
}
