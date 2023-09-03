package com.example.budgetapp.data.source.local

import androidx.room.Database
import com.example.budgetapp.data.source.local.db.dao.BudgetsDao
import com.example.budgetapp.data.source.local.db.entity.BudgetEntity

@Database(entities = [BudgetEntity::class], version = 1)
abstract class BudgetDataBaseDb {

    abstract fun budgetsDao(): BudgetsDao
}