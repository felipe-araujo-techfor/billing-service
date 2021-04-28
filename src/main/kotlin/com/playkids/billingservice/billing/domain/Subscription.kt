package com.playkids.billingservice.billing.domain

import com.playkids.billingservice.billing.offer.domain.Plan
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "subscription")
data class Subscription (
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

    @Column(name = "status")
    val subscriptionStatus: SubscriptionStatus? = null,

    @JoinColumn(name = "plan_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    val plan: Plan? = null,

    @JoinColumn(name = "payment_account_id")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    val paymentAccount: PaymentAccount? = null
)