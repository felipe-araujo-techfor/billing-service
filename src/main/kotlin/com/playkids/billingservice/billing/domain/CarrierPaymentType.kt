package com.playkids.billingservice.billing.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("CARRIER")
class CarrierPaymentType : PaymentType()