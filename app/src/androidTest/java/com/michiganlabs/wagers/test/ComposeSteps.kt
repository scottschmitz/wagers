package com.michiganlabs.wagers.test

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.cucumber.junit.WithJunitRule
import org.junit.Rule
import com.michiganlabs.wagers.ui.PlaceBetView

@WithJunitRule
class ComposeSteps {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Given("^I initialize app")
    fun initialize_app() {
        composeTestRule.setContent {
            PlaceBetView()
        }
    }

    @When("^a user taps the button that says '(.*)'")
    fun click_on_button(text: String) {
        composeTestRule.onNodeWithText(text).performClick()
    }

    @When("^a user enters '(.*)' in the '(.*)' field")
    fun enter_text_in_text_field(text: String, tag: String) {
        composeTestRule.onNodeWithTag(tag).performTextInput(text)
    }

    @Then("^the screen should show '(.*)'")
    fun validate_text_exists(text: String) {
        composeTestRule.onNodeWithText(text).assertIsDisplayed()
    }
}
