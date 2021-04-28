package com.playkids.billingservice.infra.config

import com.playkids.billingservice.api.dto.ApiResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
internal class ControllerExceptionHandlerConfig : ResponseEntityExceptionHandler() {
    @ExceptionHandler(Exception::class)
    fun clienteException(e: Exception, req: HttpServletRequest?): ResponseEntity<ApiResponse> {
        val apiResponse = ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.message)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest
    ): ResponseEntity<Any> {
        val errorMsg = ex.bindingResult.fieldErrors.stream()
            .map { obj: FieldError -> obj.defaultMessage }
            .findFirst().orElse(ex.message)
        val err = ApiResponse(status, errorMsg)
        return ResponseEntity(err, status)
    }
}