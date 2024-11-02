package com.smarthome.air.conditioner.service.excpetions

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.stereotype.Component

@Component
class ErrorMessageFactory(
    @Value("\${error-factory.code}")
    private val code: String,
    @Value("\${error-factory.message}")
    private val message: String,
) {

    private val codeSource = ResourceBundleMessageSource().apply {
        setBasename(code)
    }

    private val messageSource = ResourceBundleMessageSource().apply {
        setBasename(message)
    }

    fun getCode(exception: CoreAirConditionerServiceException) =
        codeSource.getMessage(
            exception::class.java.name,
            null,
            LocaleContextHolder.getLocale()
        )

    fun getMessage(exception: CoreAirConditionerServiceException) =
        messageSource.getMessage(
            exception::class.java.name,
            null,
            LocaleContextHolder.getLocale()
        )
}