package com.dteknoloji.stockservice.kafka.consumer

import com.dteknoloji.stockservice.domain.event.RegisterQuantityDecreaseEvent
import com.dteknoloji.stockservice.service.StockService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class RegisterQuantityDecreaseEventConsumer (
    private val stockService: StockService
) {

    // We are passing the kafka topics by env variables at work, so we developed it like this.
    // The topic pattern is necessary
    @KafkaListener(topicPattern = "\${kafka.topics.registerQuantityDecrease}", groupId = "stock")
    fun receive(@Payload event: RegisterQuantityDecreaseEvent) {
        stockService.decreaseQuantityOfStock(event)
    }
}