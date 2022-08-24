package com.example.junit5tutorial.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

/**
 * Created by marathoner on 2022/08/23
 */
interface BookRepository : JpaRepository<Book, UUID> {
}
