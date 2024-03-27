package com.michiganlabs.wagers.test

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.WithJunitRule
import org.junit.Rule
import com.michiganlabs.wagers.App

@WithJunitRule
class ComposeSteps {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Given("^I initialize app")
    fun initialize_app() {
        composeTestRule.setContent {
            App()
        }
    }

    @When("^a user taps the button that says '(.*)'")
    fun click_on_button(text: String) {
        composeTestRule.onNodeWithText(text).performClick()
    }

    @Then("^the screen should show '(.*)'")
    fun validate_text_exists(text: String) {
        composeTestRule.onNodeWithText(text).assertIsDisplayed()
    }
}