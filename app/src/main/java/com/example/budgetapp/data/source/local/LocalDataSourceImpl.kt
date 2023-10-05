package com.example.budgetapp.data.source.local

import com.example.budgetapp.common.Mapper
import com.example.budgetapp.data.source.local.db.dao.BudgetsDao
import com.example.budgetapp.data.source.local.db.entity.BudgetEntity
import com.example.budgetapp.domain.model.BudgetDomainModel

class LocalDataSourceImpl(
    private val dao: BudgetsDao,
    private val mapperToDomain: Mapper<BudgetEntity,BudgetDomainModel >,
    private val mapperToDbEntity: Mapper<BudgetDomainModel, BudgetEntity>,
) : LocalDataSource {
    override fun insert(budget: BudgetDomainModel) {
        TODO("Not yet implemented")
    }

    override fun updateBudgetInfo(budget: BudgetDomainModel) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<BudgetDomainModel> {
        TODO("Not yet implemented")
    }

    override fun getById(budgetId: Int): BudgetDomainModel {
        TODO("Not yet implemented")
    }

    override fun deleteBudget(budgetId: Int) {
        TODO("Not yet implemented")
    }
}