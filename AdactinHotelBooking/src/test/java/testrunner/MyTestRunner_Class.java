package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/parallel/Login.feature"},glue = {"parallel", "AppHooks"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedrerun.txt",
		"timeline:test-output-thread/","pretty:target/json-report.json"
})


public class MyTestRunner_Class {

}
