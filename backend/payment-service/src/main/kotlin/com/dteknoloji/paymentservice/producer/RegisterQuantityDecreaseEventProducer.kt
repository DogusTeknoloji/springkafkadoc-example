package com.dteknoloji.paymentservice.producer

import com.dteknoloji.paymentservice.domain.kafka.event.RegisterQuantityDecreaseEvent
import com.dteknoloji.springkafkadoc.scanners.channels.AsyncApiDocProducer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class RegisterQuantityDecreaseEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @AsyncApiDocProducer("registerQuantityDecrease")
    fun send(@Payload event: RegisterQuantityDecreaseEvent) {
        val topic = "registerQuantityDecrease"

        // logs etc...
        kafkaTemplate.send(topic, event)
    }
}
