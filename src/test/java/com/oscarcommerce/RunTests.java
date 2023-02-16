package com.oscarcommerce;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "~@wip",
        glue = {"src/test/java/com/oscarcommerce/glue"},
        plugin = {"pretty", "html:target/cucumber.html"}
)

public class RunTests {
}

