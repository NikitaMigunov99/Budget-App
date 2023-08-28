package com.example.budgetapp.domain.repository

import androidx.annotation.WorkerThread
import com.example.budgetapp.data.values.ID
import com.example.budgetapp.domain.model.BudgetDomainModel

interface BudgetRepository {

    @WorkerThread
    fun getBudgetsList() : List<BudgetDomainModel>

    @WorkerThread
    fun getBudget(id: ID) : BudgetDomainModel

    @WorkerThread
    fun putBudget(budget: BudgetDomainModel)

    @WorkerThread
    fun updateBudget(budget: BudgetDomainModel)
}