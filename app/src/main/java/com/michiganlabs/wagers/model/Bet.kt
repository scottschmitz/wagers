package com.michiganlabs.wagers.model

data class Bet(
    val id: String,
    val eventId: String,
    val outcome: String,
    val odds: Int
)
