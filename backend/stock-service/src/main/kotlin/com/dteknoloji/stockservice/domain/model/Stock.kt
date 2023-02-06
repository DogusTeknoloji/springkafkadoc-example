package com.dteknoloji.stockservice.domain.model

import java.util.UUID

data class Stock(
    private val itemId: UUID,
    private val amount: Int
)
