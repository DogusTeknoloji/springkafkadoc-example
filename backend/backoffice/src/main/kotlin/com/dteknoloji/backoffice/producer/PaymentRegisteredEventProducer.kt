package com.dteknoloji.backoffice.producer

import com.dteknoloji.backoffice.domain.event.PaymentRegisteredEvent
import com.dteknoloji.springkafkadoc.scanners.channels.AsyncApiDocProducer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class PaymentRegisteredEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @AsyncApiDocProducer("paymentRegisteredEvent")
    fun send(@Payload event: PaymentRegisteredEvent) {
        val topic = "paymentRegisteredEvent"

        // logs etc...
        kafkaTemplate.send(topic, event)
    }
}