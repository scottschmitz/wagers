package com.michiganlabs.wagers.test

import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"],
)
class AndroidJUnitRunner : CucumberAndroidJUnitRunner()
