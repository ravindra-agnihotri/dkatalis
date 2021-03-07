package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.ITestListener;
import org.testng.TestRunner;

@CucumberOptions(

       glue ="stepdefinations",
        features = "src/resources/features/",
        plugin =  {"pretty", "html:target/cucumber"}






)
public class Runner extends AbstractTestNGCucumberTests {

}
