package com.smart.home.coffee.machine.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class CoffeeMachineServiceApplication

fun main(args: Array<String>) {
	runApplication<CoffeeMachineServiceApplication>(*args)
}
