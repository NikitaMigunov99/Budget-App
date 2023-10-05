package com.example.budgetapp.common

/**
 * Interface to convert data from one type [T] to other [R]
 */
interface Mapper<T, R> {

    fun convert(t: T): R
}