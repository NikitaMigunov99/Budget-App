package com.example.budgetapp.domain.model

data class BudgetModel(
    val title: String,
    val costs: List<CostModel>,
    val period: DatePeriod
)