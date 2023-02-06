package com.dteknoloji.paymentservice.domain.kafka.event

import java.util.UUID

data class RegisterQuantityDecreaseEvent(
    val itemId: UUID,
    val transactionId: UUID,
    val amount: Int
)
