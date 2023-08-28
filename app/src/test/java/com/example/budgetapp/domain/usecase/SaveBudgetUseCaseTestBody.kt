package com.example.budgetapp.domain.usecase

import com.example.budgetapp.data.values.ID
import com.example.budgetapp.domain.model.BudgetDomainModel
import com.example.budgetapp.domain.repository.BudgetRepository
import com.example.budgetapp.utils.BudgetGenerator
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SaveBudgetUseCaseTestBody {

    private val generator = BudgetGenerator()

    private val repository: BudgetRepository = mockk(relaxed = true)
    private val idUseCase: CreateIdUseCase = mockk(relaxed = true)
    private val id: ID = mockk(relaxed = true)
    private val useCase: SaveBudgetUseCase = mockk()

    @Test
    fun saveNewBudget() = runTest {
        every { idUseCase.create() } returns id
        val budget = generator.createBudget()

        useCase.saveNewBudget(budget)
        verify {
            idUseCase.create()
            repository.putBudget(BudgetDomainModel(id, budget))
        }
    }

    @Test
    fun getOne() = runTest {
        val budget = generator.createBudgetEntity()
        useCase.updateBudget(budget)
        verify {
            idUseCase.create()
            repository.updateBudget(budget)
        }
    }
}