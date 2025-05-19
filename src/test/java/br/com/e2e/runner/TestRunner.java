package br.com.e2e.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/features",
    glue = "br.com.e2e.steps",
    plugin = {
    "pretty",
    "html:target/cucumber-report.html"
    },
    monochrome = true
)
public class TestRunner {}
