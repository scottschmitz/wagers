package com.michiganlabs.wagers.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.michiganlabs.wagers.logic.BetUseCase

@Suppress("MagicNumber")
val oddsOptions = listOf(-200, -110, 100, 110, 200)
private const val DEFAULT_OPTION = 100

@Composable
fun PlaceBetView(
    modifier: Modifier = Modifier,
    betUseCase: BetUseCase = BetUseCase()
) {

    val currentOdds = remember {
        mutableIntStateOf(DEFAULT_OPTION)
    }
    var wager by rememberSaveable { mutableStateOf("") }
    val wagerDouble = remember(wager) {
        wager.toDoubleOrNull()
    }
    val isValidWager = remember(wagerDouble) {
        wagerDouble != null
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 24.dp, horizontal = 16.dp),
        modifier = modifier.background(Color.White)
    ) {
        item {
            Text(text = "Select Odds")
        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                oddsOptions.forEach { odds ->
                    Button(onClick = { currentOdds.intValue = odds }) {
                        Text(text = odds.toString())
                    }
                }
            }
        }

        item {
            Text("Enter amount to wager")
        }

        item {
            TextField(
                value = wager,
                onValueChange = { wager = it },
                label = {
                    Text(text = "Amount to Wager")
                },
                modifier = Modifier.testTag("test_input")
            )
        }

        if (!isValidWager) {
            item {
                Text(
                    text = "That is not a valid wager.",
                    color = Color.Red
                )
            }
        }


        item {
            Text(text = "Odds: ${currentOdds.intValue}")
        }

        item {
            Text(text = "Wager: $wager")
        }

        item {
            val odds = currentOdds.intValue
            val payoutString = when (wagerDouble) {
                null -> "Payout: --"
                else -> "Payout: ${betUseCase.calculatePayout(odds = odds, wager = wagerDouble)}"
            }
            Text(text = payoutString)
        }
    }
}

@Preview
@Composable
fun PlaceBetViewPreview() {
    PlaceBetView(
        betUseCase = BetUseCase(),
        modifier = Modifier.fillMaxSize()
    )
}
