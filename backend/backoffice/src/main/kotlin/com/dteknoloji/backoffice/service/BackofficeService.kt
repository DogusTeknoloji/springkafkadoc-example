package com.dteknoloji.backoffice.service

import com.dteknoloji.backoffice.domain.event.CustomerCreatedEvent
import com.dteknoloji.backoffice.domain.event.CustomerDeletedEvent
import com.dteknoloji.backoffice.domain.event.PaymentRegisteredEvent
import com.dteknoloji.backoffice.producer.CustomerCreatedEventProducer
import com.dteknoloji.backoffice.producer.CustomerDeletedEventProducer
import com.dteknoloji.backoffice.producer.PaymentRegisteredEventProducer
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BackofficeService(
    private val customerCreatedEventProducer: CustomerCreatedEventProducer,
    private val customerDeletedEventProducer: CustomerDeletedEventProducer,
    private val paymentRegisteredEventProducer: PaymentRegisteredEventProducer
) {

    fun createCustomer() {
        // ...
        customerCreatedEventProducer.send(
            CustomerCreatedEvent(
                UUID.randomUUID(),
                "Name",
                15,
                15.02
            )
        )
    }

    fun deleteCustomer() {
        customerDeletedEventProducer.send(
            CustomerDeletedEvent(UUID.randomUUID())
        )
    }

    fun registerPayment() {
        paymentRegisteredEventProducer.send(
            PaymentRegisteredEvent(
                UUID.randomUUID(),
                UUID.randomUUID(),
                12.3,
                mapOf()
            )
        )
    }
}
