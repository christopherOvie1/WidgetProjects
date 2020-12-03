package runnerTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources"},
        glue =     {"Step_Def"},           //path of step definition
        plugin = {"pretty","html:target/cucumber-html-report",  "json:target/cucumber.json"}
                )
public class TestRunner {


}