package com.example.budgetapp.domain.model

import java.time.LocalDate
import java.time.Period

/**
 * It describes budget period
 *
 * @property startDate start date of budget
 * @property endDate start date of budget
 */
data class BudgetPeriod internal constructor(
    private val startDate: LocalDate,
    private val endDate: LocalDate
) {

    fun periodDaysNumber() = Period.between(startDate, endDate).days

    companion object {
        fun create(firstDate: LocalDate, secondDate: LocalDate): BudgetPeriod =
            if (firstDate <= secondDate) {
                BudgetPeriod(firstDate, secondDate)
            } else {
                BudgetPeriod(secondDate, firstDate)
            }
    }
}

