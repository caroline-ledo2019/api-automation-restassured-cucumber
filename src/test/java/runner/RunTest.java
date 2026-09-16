package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    // 👇 Adicionamos os geradores de arquivos html e json dentro da pasta target/reports
    plugin = {
        "pretty", 
        "html:target/reports/cucumber-report.html",
        "json:target/reports/cucumber-report.json"
    },
    monochrome = true
)
public class RunTest {
}
