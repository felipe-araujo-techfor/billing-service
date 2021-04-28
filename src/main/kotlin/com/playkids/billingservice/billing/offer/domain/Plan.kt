package com.playkids.billingservice.billing.offer.domain

import org.hibernate.annotations.Immutable
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Immutable
@Table(name = "plan")
data class Plan (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "price")
    val price: BigDecimal? = null,

    @Column(name = "trial_period")
    val trialPeriod: Int? = null,

    @Column(name = "createdAt")
    val createdAt: LocalDateTime? = null
)