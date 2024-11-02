package com.smarthome.air.conditioner.service.exceptions

sealed class CoreAirConditionerServiceException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : RuntimeException(message, cause)

sealed class BadRequestException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : CoreAirConditionerServiceException(message = message, cause = cause)

sealed class InternalServerErrorException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : CoreAirConditionerServiceException(message = message, cause = cause)

sealed class NotFoundException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : BadRequestException(message = message, cause = cause) {

    class AirConditionerInfoNotFoundByIdException(message: String? = null, cause: Throwable? = null) :
        NotFoundException(message = message, cause = cause)

    class AirConditionerStateNotFoundByIdException(message: String? = null, cause: Throwable? = null) :
        NotFoundException(message = message, cause = cause)

    class TimerNotFoundException(message: String? = null, cause: Throwable? = null) :
        NotFoundException(message = message, cause = cause)
}