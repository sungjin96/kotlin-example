package com.example.junit5tutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Junit5TutorialApplication

fun main(args: Array<String>) {
    runApplication<Junit5TutorialApplication>(*args)
}
