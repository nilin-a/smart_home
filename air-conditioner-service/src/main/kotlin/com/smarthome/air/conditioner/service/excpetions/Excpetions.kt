package com.smarthome.air.conditioner.service.excpetions

sealed class CoreAirConditionerServiceException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : RuntimeException(message, cause)

sealed class BadRequestException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : CoreAirConditionerServiceException(message = message, cause = cause) {

}

sealed class InternalServerErrorException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : CoreAirConditionerServiceException(message = message, cause = cause) {

}