package testRunners;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/addtocart.feature",
    glue = {"stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true
    //dryRun = true
)
public class TestRunner {
	   
}
