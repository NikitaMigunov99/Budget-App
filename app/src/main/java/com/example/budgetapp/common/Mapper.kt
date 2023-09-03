package com.example.budgetapp.common

interface Mapper<T, R> {

    fun convert(t: T): R
}