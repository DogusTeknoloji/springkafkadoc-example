package com.dteknoloji.stockservice.service

import com.dteknoloji.stockservice.domain.event.RegisterQuantityDecreaseEvent
import com.dteknoloji.stockservice.domain.event.StockAlertEvent
import com.dteknoloji.stockservice.kafka.producer.StockAlertEventProducer
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StockService(
    private val stockAlertEventProducer: StockAlertEventProducer
) {

    fun decreaseQuantityOfStock(event: RegisterQuantityDecreaseEvent) {
        // ...
    }

    fun stockAlert() {
        stockAlertEventProducer.send(StockAlertEvent(UUID.randomUUID()))
    }
}
