package com.smarthome.air.conditioner.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AirConditionerServiceApplication

fun main(args: Array<String>) {
	runApplication<AirConditionerServiceApplication>(*args)
}
