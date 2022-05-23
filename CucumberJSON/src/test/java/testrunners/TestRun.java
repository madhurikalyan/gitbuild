package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Loginpage.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=false,
		plugin= {"pretty",
				"html:test-output"
		}
		)

public class TestRun {

}
