package com.example.firstspringboot.datasource.mock

import com.example.firstspringboot.datasource.BankDataSource
import com.example.firstspringboot.model.Bank
import org.springframework.stereotype.Repository

/**
 * Created by marathoner on 2022/03/09
 */
@Repository
class MockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull { it.accountNumber == accountNumber }
        ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber })
            throw IllegalAccessException("Bank with account number ${bank.accountNumber} already exists.")
        banks.add(bank)
        return bank
    }
}
