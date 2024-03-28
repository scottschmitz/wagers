package com.michiganlabs.wagers.logic

import com.michiganlabs.wagers.model.Bet
import kotlin.math.abs
import kotlin.math.floor

class BetUseCase {
    fun calculatePayout(bet: Bet, wager: Double): Double {
        return calculatePayout(bet.odds, wager)
    }

    fun calculatePayout(odds: Int, wager: Double): Double {
        val profit = if (odds > 0) {
            // underdog
            wager * (odds / 100.0)
        } else {
            // favorite
            abs(wager / (odds / 100.0))
        }

        return floor((wager + profit) * 100) / 100
    }
}
