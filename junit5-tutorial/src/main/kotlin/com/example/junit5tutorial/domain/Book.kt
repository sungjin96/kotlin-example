package com.example.junit5tutorial.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by marathoner on 2022/08/23
 */
@Entity
class Book(
    title: String,
    author: String
): PrimaryKeyEntity() {
    @Column(nullable = false, length = 50)
    var title: String  = title
        protected set

    @Column(nullable = false, length = 20)
    var author: String = author
        protected set

}
