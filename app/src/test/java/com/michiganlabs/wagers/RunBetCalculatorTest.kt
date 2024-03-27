package com.michiganlabs.wagers

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/assets/features"],
    plugin = ["pretty", "html:target/cucumber-reports.html"]
)
class RunBetCalculatorTest {
}