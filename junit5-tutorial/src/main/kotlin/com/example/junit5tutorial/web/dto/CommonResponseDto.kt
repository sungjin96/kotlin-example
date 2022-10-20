package com.example.junit5tutorial.web.dto

/**
 * Created by marathoner on 2022/10/05
 */
class CommonResponseDto<T>(
    val code: Int,
    val msg: String,
    val body: T? = null,
) {

    companion object {
        fun <T> success(msg: String, body: T): CommonResponseDto<T> {
            return CommonResponseDto(
                code = 1,
                msg = msg,
                body = body
            )
        }

        fun <T> error(msg: String, body: T): CommonResponseDto<T> {
            return CommonResponseDto(
                code = -1,
                msg = msg,
                body = body
            )
        }
    }

}
