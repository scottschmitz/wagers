package com.michiganlabs.wagers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.michiganlabs.wagers.logic.BetUseCase
import com.michiganlabs.wagers.ui.PlaceBetView
import com.michiganlabs.wagers.ui.theme.WagersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WagersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlaceBetView(betUseCase = BetUseCase(), modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
