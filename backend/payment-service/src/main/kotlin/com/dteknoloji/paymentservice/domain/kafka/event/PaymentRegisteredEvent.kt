package com.dteknoloji.paymentservice.domain.kafka.event

import java.util.UUID

data class PaymentRegisteredEvent(
    val transactionId: UUID,
    val customerId: UUID,
    val totalPaidAmount: Double,
    val itemList: Map<UUID, Int>
)
