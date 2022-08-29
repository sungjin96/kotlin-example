package com.example.junit5tutorial.util

import org.springframework.stereotype.Component

/**
 * Created by marathoner on 2022/08/29
 */
// @Component
class MailSenderAdapter(private val mail: Mail) : MailSender {

    override fun send(): Boolean {
        return mail.sendMail()
    }

    constructor() : this(Mail())

}
