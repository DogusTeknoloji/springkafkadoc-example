package com.dteknoloji.stockservice.kafka.producer

import com.dteknoloji.springkafkadoc.scanners.channels.AsyncApiDocProducer
import com.dteknoloji.stockservice.domain.event.StockAlertEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class StockAlertEventProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @AsyncApiDocProducer("registerQuantityDecrease")
    fun send(@Payload event: StockAlertEvent) {
        val topic = "registerQuantityDecrease"

        // logs etc...
        kafkaTemplate.send(topic, event)
    }
}