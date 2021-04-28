package com.playkids.billingservice.billing.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "payment_account")
data class PaymentAccount (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null,

    @Column(name = "cancelled_at")
    val cancelledAt: LocalDateTime? = null,

    @JoinColumn(name = "payment_type")
    @OneToOne(optional = false)
    val paymentType: PaymentType? = null,

//    @JoinColumn(name = "payment_register_id")
    @OneToMany(cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
    val paymentRegister: List<PaymentRegister>? = null
)