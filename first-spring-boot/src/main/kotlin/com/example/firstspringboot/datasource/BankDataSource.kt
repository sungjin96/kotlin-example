package com.example.firstspringboot.datasource

import com.example.firstspringboot.model.Bank

/**
 * Created by marathoner on 2022/03/09
 */
interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
}
