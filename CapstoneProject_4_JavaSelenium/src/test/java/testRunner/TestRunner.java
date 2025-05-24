package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = ".//Features/Featurefile.feature",
		glue = "stepDefinition",
		//dryRun = true,
		monochrome = true,
		plugin = {"pretty", "html:test-output"}
)

public class TestRunner extends  AbstractTestNGCucumberTests{
	
	

}
