package com.dteknoloji.paymentservice.domain.model

import java.util.UUID

data class Payment (
    private val transactionId: UUID,
    private val customerId: UUID,
    private val totalPaidAmount: Double
)
