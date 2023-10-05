package com.example.budgetapp.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.budgetapp.data.source.local.db.dao.BudgetsDao
import com.example.budgetapp.data.source.local.db.dao.BudgetsDbPropertiesDao
import com.example.budgetapp.data.source.local.db.entity.BudgetEntity

@Database(entities = [BudgetEntity::class], version = 1, exportSchema = false)
abstract class BudgetDataBaseDb : RoomDatabase() {

    abstract fun budgetsDao(): BudgetsDao

    abstract fun budgetsDbPropertiesDao(): BudgetsDbPropertiesDao
}