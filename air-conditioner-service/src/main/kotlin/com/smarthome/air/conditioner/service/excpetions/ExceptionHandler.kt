package com.smarthome.air.conditioner.service.excpetions

import com.smarthome.air.conditioner.service.model.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler(
    private val errorMessageFactory: ErrorMessageFactory,
) {

    @ExceptionHandler(BadRequestException::class)
    fun handleClientException(exception: BadRequestException) =
        ResponseEntity(
            ErrorDto(
                code = errorMessageFactory.getCode(exception),
                message = errorMessageFactory.getMessage(exception),
            ),
            HttpStatus.BAD_REQUEST
        )

    @ExceptionHandler(InternalServerErrorException::class)
    fun handleServerException(exception: InternalServerErrorException) =
        ResponseEntity(
            ErrorDto(
                code = errorMessageFactory.getCode(exception),
                message = errorMessageFactory.getMessage(exception),
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
}