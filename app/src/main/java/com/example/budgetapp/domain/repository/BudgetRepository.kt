package com.example.budgetapp.domain.repository

import androidx.annotation.AnyThread
import androidx.annotation.WorkerThread
import com.example.budgetapp.data.values.ID
import com.example.budgetapp.domain.model.BudgetDomainModel

interface BudgetRepository {

    @WorkerThread
    fun putBudget(budget: BudgetDomainModel)

    @AnyThread
    suspend fun getBudgetsList() : List<BudgetDomainModel>

    @AnyThread
    suspend fun getBudget(id: ID) : BudgetDomainModel

    @AnyThread
    suspend fun updateBudget(budget: BudgetDomainModel)
}