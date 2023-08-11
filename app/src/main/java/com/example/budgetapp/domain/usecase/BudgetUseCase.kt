package com.example.budgetapp.domain.usecase

import com.example.budgetapp.domain.model.BudgetModel

interface BudgetUseCase {

    suspend fun getBudgetsList() : List<BudgetModel>
}