package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(		
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedrerun.txt"
		},
		monochrome =true,
		glue = {"stepdefinitions", "AppHooks"},
		features = {"@target/failedrerun.txt"}
		)

public class FailedRun {

}
