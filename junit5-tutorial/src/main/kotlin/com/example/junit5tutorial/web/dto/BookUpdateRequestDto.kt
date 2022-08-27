package com.example.junit5tutorial.web.dto

import java.util.*

/**
 * Created by marathoner on 2022/08/24
 */
class BookUpdateRequestDto(
    var id: UUID,
    var title: String,
    var author: String,
)
