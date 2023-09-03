package com.example.budgetapp.data.source.local.db.entity

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import kotlinx.parcelize.Parcelize

/**
 * Model of cost to save in Room DB
 *
 * @property title      name of cost
 * @property sum        total amount
 * @property singleCost cost of one payment (only for iterable costs)
 * @property singleCost number of payments (only for iterable costs)
 */
@Parcelize
@JsonDeserialize(`as` = CostEntity::class)
data class CostEntity(
    @field:JsonProperty val title: String,
    @field:JsonProperty val sum: Int,
    @field:JsonProperty val singleCost: Int = 0,
    @field:JsonProperty val number: Int = 1,
) : Parcelable