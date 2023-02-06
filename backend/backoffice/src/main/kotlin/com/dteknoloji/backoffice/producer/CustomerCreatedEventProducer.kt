package com.dteknoloji.backoffice.producer

import com.dteknoloji.backoffice.domain.event.CustomerCreatedEvent
import com.dteknoloji.springkafkadoc.scanners.channels.AsyncApiDocProducer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class CustomerCreatedEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @AsyncApiDocProducer("customerCreatedEvent")
    fun send(@Payload event: CustomerCreatedEvent) {
        val topic = "customerCreatedEvent"

        // logs etc...
        kafkaTemplate.send(topic, event)
    }
}