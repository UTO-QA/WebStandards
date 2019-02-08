package ASU.Runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/ASU/features", glue = "ASU.Steps",format = { "pretty","html:target/cucumber.html", "json:target/cucumber.json" })
public class CustomRunner {
}
