package runner;

import io.cucumber.testng.CucumberOptions;
import utility.BaseTestUtils;

@CucumberOptions(
        tags = "@SmokeTest"
)
public class SmokeTest_Runner extends BaseTestUtils {
}
