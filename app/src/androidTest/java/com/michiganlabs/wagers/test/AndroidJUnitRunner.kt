package com.michiganlabs.wagers.test

import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"],
    plugin = ["pretty"]
)
class AndroidJUnitRunner : CucumberAndroidJUnitRunner()
