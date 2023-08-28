package com.example.budgetapp.domain.usecase

import com.example.budgetapp.domain.repository.BudgetRepository
import com.example.budgetapp.utils.BudgetGenerator
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BudgetUseCaseTest {

    private val generator = BudgetGenerator()

    private val repository: BudgetRepository = mockk(relaxed = true)
    private val useCase: BudgetUseCase = mockk()

    @Test
    fun getAll() = runTest {
        val list = generator.createList()
        coEvery { repository.getBudgetsList() } returns list
        Assert.assertEquals(list, useCase.getBudgetsList())
        coVerify { repository.getBudgetsList() }
    }

    @Test
    fun getOne() = runTest {
        val id = generator.randomID()
        val model = generator.createBudgetEntity()
        coEvery { repository.getBudget(id) } returns model
        Assert.assertEquals(model, useCase.getBudget(id))
        coVerify { repository.getBudgetsList() }
    }
}