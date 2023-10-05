package com.example.budgetapp.data.source.local

import com.example.budgetapp.domain.model.BudgetDomainModel

interface LocalDataSource {


    fun insert(budget: BudgetDomainModel)

    /**
     * Update existing budget
     */
    fun updateBudgetInfo(budget: BudgetDomainModel)

    /**
     * Get budget with id equals [budgetId]
     */
    fun getAll(): List<BudgetDomainModel>

    /**
     * Get budget with id equals [budgetId]
     */
    fun getById(budgetId: Int): BudgetDomainModel

    /**
     * Delete budget with id equals [budgetId]
     */
    fun deleteBudget(budgetId: Int)
}