package com.example.junit5tutorial.web.dto

/**
 * Created by marathoner on 2022/10/05
 */
class CommonResponseDto<T>(
    val code: Int,
    val msg: String,
    val body: T,
) {
}
