package com.example.junit5tutorial.util

import org.springframework.stereotype.Component

/**
 * Created by marathoner on 2022/08/29
 */
@Component
class MailSenderStub: MailSender {
    override fun send(): Boolean {
        return true
    }

}
