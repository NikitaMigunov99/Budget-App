package com.example.budgetapp.domain.usecase

import androidx.annotation.AnyThread
import com.example.budgetapp.data.values.ID
import com.example.budgetapp.domain.model.BudgetDomainModel

interface BudgetUseCase {

    @AnyThread
    suspend fun getBudgetsList() : List<BudgetDomainModel>

    @AnyThread
    suspend fun getBudget(id: ID) : BudgetDomainModel
}