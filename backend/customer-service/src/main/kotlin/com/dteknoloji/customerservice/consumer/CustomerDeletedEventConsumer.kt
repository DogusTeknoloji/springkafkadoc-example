package com.dteknoloji.customerservice.consumer

import com.dteknoloji.customerservice.domain.event.CustomerDeletedEvent
import com.dteknoloji.customerservice.service.CustomerService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class CustomerDeletedEventConsumer(
    private val customerService: CustomerService
) {

    // We are passing the kafka topics by env variables at work, so we developed it like this.
    // The topic pattern is necessary
    @KafkaListener(topicPattern = "\${kafka.topics.customerDeleted}", groupId = "customer")
    fun receive(@Payload event: CustomerDeletedEvent) {
        // ...

        customerService.deleteCustomer(event)

        // ...
    }
}