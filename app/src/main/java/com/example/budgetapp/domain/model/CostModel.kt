package com.example.budgetapp.domain.model

/**
 * Model of cost to be noted
 *
 * @property title name of cost
 * @property sum   total sum of cost
 */
sealed class CostModel(
    open val title: String,
    open val sum: Int)

/**
 * Simple cost, one buying something
 */
data class SimpleCost(override val title: String, override val sum: Int) : CostModel(title, sum)

/**
 * Cost model for period in curtain days number, for example, buying food, or for iterable costs
 *
 * @property number number of days or iteration
 */
data class NumberCost(override val title: String, override val sum: Int, val number: Int) : CostModel(title, sum)