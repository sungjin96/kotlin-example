package com.example.demo.dto

import com.example.demo.NoArg


/**
 * Created by marathoner on 2022/03/26
 */
@NoArg
data class MemberDto(
    val name: String,
    val age: Int,
){
    companion object {
        val get: MemberDto = MemberDto::class.java.getDeclaredConstructor().newInstance()
    }
}
