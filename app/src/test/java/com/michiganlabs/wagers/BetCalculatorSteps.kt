package com.michiganlabs.wagers

import com.michiganlabs.wagers.logic.BetUseCase
import com.michiganlabs.wagers.model.Bet
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import kotlin.test.Test
import kotlin.test.assertEquals

class BetCalculatorSteps {

    private lateinit var bet: Bet
    private var wager: Double = 0.0

    @Given("^a bet with odds of '(.*)'")
    fun givenOdds(odds: String) {
        bet = Bet(
            id = "id",
            eventId = "eventId",
            outcome = "outcome",
            odds = odds.toInt()
        )
    }

    @When("^the user bets '(.*)'")
    fun whenBetsAmount(wager: Double) {
        this.wager = wager
    }

    @Then("^the payout should be '(.*)'")
    fun the_payout_should_be(payout: Double) {
        val calculatedPayout = BetUseCase().calculatePayout(this.bet, this.wager)
        assertEquals(payout, calculatedPayout)
    }
}
