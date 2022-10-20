package com.example.junit5tutorial.web.dto

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * Created by marathoner on 2022/08/24
 */
class BookUpdateRequestDto(
    @field:NotBlank
    @field:Size(min = 1, max = 50)
    var title: String = "",
    @field:NotBlank
    @field:Size(min = 1, max = 20)
    var author: String = "",
)
