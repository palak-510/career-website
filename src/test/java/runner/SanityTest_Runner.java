package runner;

import io.cucumber.testng.CucumberOptions;
import utility.BaseTestUtils;

@CucumberOptions(
        tags = "@SanityTest"
)
public class SanityTest_Runner extends BaseTestUtils {
}
