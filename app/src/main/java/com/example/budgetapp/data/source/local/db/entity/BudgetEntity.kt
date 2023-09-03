package com.example.budgetapp.data.source.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.budgetapp.data.source.local.db.entity.BudgetEntity.Companion.TABLE_NAME

/**
 * Model of budget to save in Room DB
 *
 * @property id         id of budget
 * @property title      title of budget
 * @property sum        total amount
 * @property startDate  start date of budget
 * @property endDate    start date of budget
 */
@Entity(tableName = TABLE_NAME)
data class BudgetEntity(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID) val id: Long,
    @ColumnInfo(name = COLUMN_TITLE) val title: String,
    @ColumnInfo(name = COLUMN_START_DATE) val startDate: String,
    @ColumnInfo(name = COLUMN_END_DATE) val endDate: String,
    @ColumnInfo(name = COLUMN_COSTS) val costs: List<CostEntity>
) {

    companion object {
        /**
         * Table name
         */
        const val TABLE_NAME = "budgets"

        /**
         * Column name for budget's id
         */
        const val COLUMN_ID = "id"

        /**
         * Column name for budget's name
         */
        const val COLUMN_TITLE = "title"

        /**
         * Column name for budget's start date
         */
        const val COLUMN_START_DATE = "startDate"

        /**
         * Column name for budget's end date
         */
        const val COLUMN_END_DATE = "endDate"

        /**
         * Column name for budget's costs
         */
        const val COLUMN_COSTS = "costs"
    }
}