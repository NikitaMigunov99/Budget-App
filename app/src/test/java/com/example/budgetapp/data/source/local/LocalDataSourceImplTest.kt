package com.example.budgetapp.data.source.local

import com.example.budgetapp.common.Mapper
import com.example.budgetapp.data.source.local.db.dao.BudgetsDao
import com.example.budgetapp.data.source.local.db.entity.BudgetEntity
import com.example.budgetapp.domain.model.BudgetDomainModel
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence
import org.junit.Assert
import org.junit.Test

class LocalDataSourceImplTest {

    private val dao: BudgetsDao = mockk(relaxed = true)
    private val mapperToDb: Mapper<BudgetDomainModel, BudgetEntity> = mockk()
    private val mapperToDomain: Mapper<BudgetEntity, BudgetDomainModel> = mockk()
    private val budgetEntity: BudgetEntity = mockk()
    private val domainModel: BudgetDomainModel = mockk()

    private val dataSource = LocalDataSourceImpl(dao, mapperToDomain, mapperToDb)

    @Test
    fun insert() {
        every { mapperToDb.convert(domainModel) } returns budgetEntity

        dataSource.insert(domainModel)
        verifySequence {
            mapperToDb.convert(domainModel)
            dao.insert(budgetEntity)
        }
        confirmVerified(mapperToDb, mapperToDomain, dao)
    }

    @Test
    fun updateWidgetInfo() {
        every { mapperToDb.convert(domainModel) } returns budgetEntity
        every { dao.getById(ID) } returns budgetEntity

        dataSource.updateBudgetInfo(domainModel)
        verifySequence {
            mapperToDb.convert(domainModel)
            dao.updateBudgetInfo(budgetEntity)
        }
        confirmVerified(mapperToDb, mapperToDomain, dao)
    }

    @Test
    fun getAll() {
        val firstEntity: BudgetEntity = mockk()
        val secondEntity: BudgetEntity = mockk()
        val firstModel: BudgetDomainModel = mockk()
        val secondModel: BudgetDomainModel = mockk()
        every { dao.getAll() } returns listOf(firstEntity, secondEntity)
        every { mapperToDomain.convert(firstEntity) } returns firstModel
        every { mapperToDomain.convert(secondEntity) } returns secondModel

        Assert.assertEquals(dataSource.getAll(), listOf(firstModel, secondModel))
        verifySequence {
            dao.getAll()
            mapperToDomain.convert(firstEntity)
            mapperToDomain.convert(secondEntity)
        }
        confirmVerified(mapperToDb, mapperToDomain, dao)
    }

    @Test
    fun getById() {
        every { dao.getById(ID) } returns budgetEntity
        every { mapperToDomain.convert(budgetEntity) } returns domainModel

        Assert.assertEquals(dataSource.getById(ID), domainModel)
        verifySequence {
            dao.getById(ID)
            mapperToDomain.convert(budgetEntity)
        }
    }

    @Test
    fun deleteBudget() {
        dataSource.deleteBudget(ID)
        verify {
            dao.deleteBudget(ID)
        }
        confirmVerified(mapperToDb, mapperToDomain, dao)
    }

    private companion object {
        const val ID = 5
    }
}