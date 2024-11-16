package com.smarthome.air.conditioner.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class AirConditionerServiceApplication

fun main(args: Array<String>) {
	runApplication<AirConditionerServiceApplication>(*args)
}
