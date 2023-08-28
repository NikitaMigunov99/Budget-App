package com.example.budgetapp.domain.usecase

import androidx.annotation.AnyThread
import androidx.annotation.WorkerThread
import com.example.budgetapp.domain.model.Budget
import com.example.budgetapp.domain.model.BudgetDomainModel

interface SaveBudgetUseCase {

    @AnyThread
    suspend fun saveNewBudget(budget: Budget)

    @AnyThread
    suspend fun updateBudget(budget: BudgetDomainModel)
}