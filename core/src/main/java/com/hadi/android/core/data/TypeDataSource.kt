package com.hadi.android.core.data

import com.hadi.android.core.doman.Type

interface TypeDataSource {
    suspend fun insert(type: Type) : Long
    suspend fun update(type: Type) : Boolean
    suspend fun remove(type: Type) : Boolean
    suspend fun remove(id: Long) : Boolean
    suspend fun get(id : Long) : Type?
    suspend fun getAll() : List<Type>
}