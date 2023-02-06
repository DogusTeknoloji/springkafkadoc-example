package com.dteknoloji.paymentservice.consumer

import com.dteknoloji.paymentservice.domain.kafka.event.PaymentRegisteredEvent
import com.dteknoloji.paymentservice.service.PaymentService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class PaymentRegisteredEventConsumer (
    private val paymentService: PaymentService
) {

    // We are passing the kafka topics by env variables at work, so we developed it like this.
    // The topic pattern is necessary
    @KafkaListener(topicPattern = "\${kafka.topics.paymentRegistered}", groupId = "payment")
    fun receive(@Payload event: PaymentRegisteredEvent) {
        // ...

        paymentService.registerPayment(event)

        // ...
    }
}
