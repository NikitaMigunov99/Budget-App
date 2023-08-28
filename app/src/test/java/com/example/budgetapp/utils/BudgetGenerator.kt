package com.example.budgetapp.utils

import com.example.budgetapp.data.values.ID
import com.example.budgetapp.domain.model.Budget
import com.example.budgetapp.domain.model.BudgetDomainModel
import com.example.budgetapp.domain.model.BudgetPeriod
import com.example.budgetapp.domain.model.NumberCost
import com.example.budgetapp.domain.model.SimpleCost
import java.time.LocalDate

class BudgetGenerator {

    fun createList() = listOf(createBudgetEntity(), createBudgetEntity())

    fun createBudgetEntity() = BudgetDomainModel(
        id = randomID(),
        budget = createBudget()
    )

    fun randomID() = ID(value = (0..100).random())

    fun createBudget() = Budget(
        TITLE,
        listOf(createCost(), createNumberCost()),
        BudgetPeriod(
            LocalDate.of(FIRST_YEAR, MONTH, FIRST_DAY),
            LocalDate.of(SECOND_YEAR, MONTH, SECOND_DAY)
        )
    )

    private fun createCost() = SimpleCost(BOOK, SUM)

    private fun createNumberCost() = NumberCost(FOOD, SUM, NUMBER)



    companion object {
        private const val FIRST_YEAR = 2023
        private const val SECOND_YEAR = 2024
        private const val MONTH = 12
        private const val FIRST_DAY = 5
        private const val SECOND_DAY = 10
        private const val NUMBER = 5
        private const val SUM = 500
        private const val TITLE = "Budget Title"
        private const val FOOD = "food"
        private const val BOOK = "book"
    }
}