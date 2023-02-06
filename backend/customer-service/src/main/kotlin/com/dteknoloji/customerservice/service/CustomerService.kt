package com.dteknoloji.customerservice.service

import com.dteknoloji.customerservice.domain.event.CustomerCreatedEvent
import com.dteknoloji.customerservice.domain.event.CustomerDeletedEvent
import com.dteknoloji.customerservice.domain.event.PaymentRegisteredEvent
import com.dteknoloji.customerservice.domain.model.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService {

    // Mock Repository
    private val customers: MutableList<Customer> = mutableListOf()

    fun createCustomer(event: CustomerCreatedEvent) {
        // ...
    }

    fun deleteCustomer(event: CustomerDeletedEvent) {
        // ...
    }

    fun paymentByCustomer(event: PaymentRegisteredEvent) {
        // ...
    }
}
