package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumberReports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-raport/cucumber.xml",
        },
        features = "src/test/resources",
        glue = {"StepDefitions","Hooks"},
        tags = "@UA1",
        dryRun = false

)

public class Runner {

}
