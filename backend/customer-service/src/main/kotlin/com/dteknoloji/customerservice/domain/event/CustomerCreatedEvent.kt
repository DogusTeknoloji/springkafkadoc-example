package com.dteknoloji.customerservice.domain.event

import java.util.UUID

data class CustomerCreatedEvent (
    private val id: UUID,
    private val name: String,
    private val age: Int,
    private var budget: Double
)
