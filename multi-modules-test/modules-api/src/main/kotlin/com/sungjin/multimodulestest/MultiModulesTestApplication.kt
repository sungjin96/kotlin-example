package com.sungjin.multimodulestest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ModulesApiApplication

fun main(args: Array<String>) {
    runApplication<ModulesApiApplication>(*args)
}
