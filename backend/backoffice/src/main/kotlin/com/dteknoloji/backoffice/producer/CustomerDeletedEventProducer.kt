package com.dteknoloji.backoffice.producer

import com.dteknoloji.backoffice.domain.event.CustomerDeletedEvent
import com.dteknoloji.springkafkadoc.scanners.channels.AsyncApiDocProducer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class CustomerDeletedEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @AsyncApiDocProducer("customerDeletedEvent")
    fun send(@Payload event: CustomerDeletedEvent) {
        val topic = "customerDeletedEvent"

        // logs etc...
        kafkaTemplate.send(topic, event)
    }
}