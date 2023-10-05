package com.example.budgetapp.domain.usecase

import com.example.budgetapp.data.source.local.db.dao.BudgetsDbPropertiesDao
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class CreateIdUseCaseTest {

    private val useCase: CreateIdUseCase = mockk()
    private val dao: BudgetsDbPropertiesDao = mockk()

    @Test
    fun createId() {
        every { dao.getMaxId() } returns ID
        Assert.assertEquals(useCase.create(), NEW_ID)
    }

    private companion object {
        const val ID = 5
        const val NEW_ID = 6
    }
}