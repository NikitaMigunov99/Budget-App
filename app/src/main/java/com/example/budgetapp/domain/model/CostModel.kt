package com.example.budgetapp.domain.model

/**
 * Model of cost to be noted
 *
 * @property title name of cost
 */
sealed class CostModel(open val title: String) {

    /** total sum of cost*/
    abstract val sum: Int
}

/**
 * Simple cost, one buying something
 * @property title name of cost
 * @property sum   total sum of cost
 */
data class SimpleCost(override val title: String, override val sum: Int) : CostModel(title)

/**
 * Cost model for period with certain days number, for example, buying food, or for iterable costs
 *
 * @property title       name of cost
 * @property singleCost  single payment sum
 * @property number      number of days or payments
 */
data class NumberCost(override val title: String, val singleCost: Int, val number: Int) : CostModel(title) {
    override val sum = singleCost * number
}