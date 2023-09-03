package com.example.budgetapp.data.source.local.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.budgetapp.data.source.local.db.entity.BudgetEntity

interface BudgetsDao {

    /**
     * Insert new budget into table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(budget: BudgetEntity)

    /**
     * Update existing budget
     */
    @Update
    fun updateWidgetInfo(budget: BudgetEntity)

    /**
     * Get budget with id equals [budgetId]
     */
    @Query("SELECT * FROM " + BudgetEntity.TABLE_NAME)
    fun getAll(): List<BudgetEntity>

    /**
     * Get budget with id equals [budgetId]
     */
    @Query(
        "SELECT FROM " + BudgetEntity.TABLE_NAME +
            " WHERE " + BudgetEntity.COLUMN_ID + "=:budgetId"
    )
    fun getById(budgetId: Int): BudgetEntity

    /**
     * Delete budget with id equals [budgetId]
     */
    @Query("DELETE FROM ${BudgetEntity.TABLE_NAME} WHERE ${BudgetEntity.COLUMN_ID}=:budgetId")
    fun deleteBudget(budgetId: Int)
}