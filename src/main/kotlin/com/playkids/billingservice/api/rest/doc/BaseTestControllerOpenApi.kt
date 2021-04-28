package com.playkids.billingservice.api.rest.doc

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

@Tag(name = BaseTestControllerOpenApi.TAG, description = "API Test")
interface BaseTestControllerOpenApi {
    @get:ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Success",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = String::class)
            )]
        )]
    )
    @get:Operation(summary = "Say hello world", tags = [TAG])
    val helloWorld: ResponseEntity<String>?

    companion object {
        const val TAG = "PK-Billing"
    }
}