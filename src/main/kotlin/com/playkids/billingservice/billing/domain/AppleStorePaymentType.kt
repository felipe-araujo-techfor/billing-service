package com.playkids.billingservice.billing.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("APPLE_STORE")
class AppleStorePaymentType : PaymentType()