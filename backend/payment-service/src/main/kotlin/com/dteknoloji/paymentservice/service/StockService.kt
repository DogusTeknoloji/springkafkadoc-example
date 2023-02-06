package com.dteknoloji.paymentservice.service

import com.dteknoloji.paymentservice.domain.kafka.event.RegisterQuantityDecreaseEvent
import com.dteknoloji.paymentservice.producer.RegisterQuantityDecreaseEventProducer
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StockService(
    private val registerQuantityDecreaseEventProducer: RegisterQuantityDecreaseEventProducer
) {

    fun registerQuantityDecrease(transactionId: UUID, items: Map<UUID, Int>) {
        items.forEach { (id, amount) ->
            val event = RegisterQuantityDecreaseEvent(id, transactionId, amount)
            registerQuantityDecreaseEventProducer.send(event)
        }
    }
}
