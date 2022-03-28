package com.example.demo

import com.example.demo.dto.MemberDto
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    val member = MemberDto()
    println(member)
    runApplication<DemoApplication>(*args)
}
