package com.example.budgetapp.domain.model

import com.example.budgetapp.data.values.ID

/**
 * Domain Entity of budget
 *
 * @property id      unique identifier of budget
 * @property budget  budget data
 */
data class BudgetDomainModel(
    val id: ID,
    val budget: Budget
)

/**
 * Budget model
 *
 * @property title  name of budget
 * @property sum    costs for [period]
 * @property period time of budget
 */
data class Budget(
    val title: String,
    val costs: List<CostModel>,
    val period: BudgetPeriod
)