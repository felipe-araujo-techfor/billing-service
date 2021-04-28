package com.playkids.billingservice.billing.domain

import javax.persistence.*

@Entity(name = "payment_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null
}