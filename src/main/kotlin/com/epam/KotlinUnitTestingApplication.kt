package com.epam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinUnitTestingApplication

fun main(args: Array<String>) {
	runApplication<KotlinUnitTestingApplication>(*args)
}
