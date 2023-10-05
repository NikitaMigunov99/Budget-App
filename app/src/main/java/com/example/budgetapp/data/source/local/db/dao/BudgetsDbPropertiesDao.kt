package com.example.budgetapp.data.source.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.budgetapp.data.source.local.db.entity.BudgetEntity

@Dao
interface BudgetsDbPropertiesDao {

    /**
     * Get max id
     */
    @Query("SELECT MAX(${BudgetEntity.COLUMN_ID}) FROM ${BudgetEntity.TABLE_NAME}")
    fun getMaxId() : Int
}