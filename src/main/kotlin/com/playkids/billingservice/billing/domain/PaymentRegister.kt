package com.playkids.billingservice.billing.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "payment_register")
data class PaymentRegister(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "charged_value")
    val chargedValue: BigDecimal? = null,

    @Column(name = "status")
    val paymentStatusDomain: PaymentStatus? = null
)