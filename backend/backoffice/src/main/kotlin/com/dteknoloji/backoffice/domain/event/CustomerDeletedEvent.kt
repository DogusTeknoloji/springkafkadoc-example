package com.dteknoloji.backoffice.domain.event

import java.util.UUID

data class CustomerDeletedEvent (
    private val id: UUID
)
