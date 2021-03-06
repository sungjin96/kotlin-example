package com.example.firstspringboot.service

import com.example.firstspringboot.datasource.BankDataSource
import com.example.firstspringboot.model.Bank
import org.springframework.stereotype.Service

/**
 * Created by marathoner on 2022/03/09
 */
@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    fun deleteBank(accountNumber: String) = dataSource.deleteBank(accountNumber)
}
