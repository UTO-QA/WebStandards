package ASU.Runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/ASU/features", format = { "pretty",
        "json:target/cucumber.json" })
public class CustomRunner {
}
