package com.dteknoloji.stockservice.domain.event

import java.util.UUID

data class StockAlertEvent(
    val itemId: UUID
)