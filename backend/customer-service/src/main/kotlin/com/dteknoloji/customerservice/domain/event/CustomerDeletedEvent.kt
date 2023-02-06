package com.dteknoloji.customerservice.domain.event

import java.util.UUID

data class CustomerDeletedEvent (
    private val id: UUID
)
