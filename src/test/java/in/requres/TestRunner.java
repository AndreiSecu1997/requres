package in.requres;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/features"},
        plugin = {"json:target/cucumber-report/cucumber.json", "html:target/cucumber-html-report",})
public class TestRunner {

    @BeforeClass
    public static void setup() {
    }

    @AfterClass
    public static void teardown() {
    }
}

