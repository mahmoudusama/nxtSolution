package com.nxtSolutions.testRunners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "com.nxtSolutions.stepDefinitions",
                "com.nxtSolutions.common.utils"},
        plugin = { "pretty",
                "html:target/cucumber/report.html",
                "json:target/cucumber/report.json" }
)
public class TestRunner {
    private static String[] defaultOptions = {
            "--glue", "com.nxtSolutions.stepDefinitions",
            "--glue", "com.nxtSolutions.common.utils",
            "--plugin", "pretty",
            "--plugin", "json:target/cucumber/report.json",
            "--plugin", "html:target/cucumber/report.html",
            "src/test/resources/features"
    };

    public static void main(String[] args) {
        Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
        io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
    }
}
