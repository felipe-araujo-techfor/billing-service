package com.playkids.billingservice.api.rest

import com.playkids.billingservice.api.rest.doc.BaseTestControllerOpenApi
import com.playkids.billingservice.billing.application.BillingService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/test/v1"])
class BaseTestController(val billingService: BillingService) : BaseTestControllerOpenApi {
    @get:GetMapping
    override val helloWorld: ResponseEntity<String>?
        get() = ResponseEntity.status(HttpStatus.OK).body(HTTP_RESPONSE_BODY)

    companion object {
        private const val HTTP_RESPONSE_BODY = "Hello World!"
    }
}