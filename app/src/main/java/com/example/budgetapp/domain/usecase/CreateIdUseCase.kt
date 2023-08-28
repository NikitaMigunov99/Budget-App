package com.example.budgetapp.domain.usecase

import androidx.annotation.WorkerThread
import com.example.budgetapp.data.values.ID

interface CreateIdUseCase {

    @WorkerThread
    fun create(): ID
}