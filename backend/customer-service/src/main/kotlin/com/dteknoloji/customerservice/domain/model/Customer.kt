package com.dteknoloji.customerservice.domain.model

import java.util.UUID

data class Customer (
    private val id: UUID,
    private val name: String,
    private val age: Int
)
