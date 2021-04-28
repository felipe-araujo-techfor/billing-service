package com.playkids.billingservice.api.dto

import org.springframework.http.HttpStatus

class ApiResponse(val status: HttpStatus, val message: String?)