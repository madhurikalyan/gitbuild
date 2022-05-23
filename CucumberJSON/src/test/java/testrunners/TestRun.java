package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Loginpage.feature",
		glue="stepDefinitions",
		dryRun=true,
		plugin= {"pretty",
				"json:target/cucumberReport.json"
		}
		)

public class TestRun {

}
