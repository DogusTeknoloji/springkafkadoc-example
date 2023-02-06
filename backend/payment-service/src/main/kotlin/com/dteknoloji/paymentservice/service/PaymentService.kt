package com.dteknoloji.paymentservice.service

import com.dteknoloji.paymentservice.domain.kafka.event.PaymentRegisteredEvent
import com.dteknoloji.paymentservice.domain.model.Payment
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val stockService: StockService
) {

    // Mock Repository for example
    private val payments: MutableList<Payment> = mutableListOf()

    fun registerPayment(event: PaymentRegisteredEvent) {
        val payment: Payment = Payment(
            event.transactionId, event.customerId, event.totalPaidAmount
        )
        stockService.registerQuantityDecrease(event.transactionId, event.itemList)

        payments.add(payment)
    }
}
