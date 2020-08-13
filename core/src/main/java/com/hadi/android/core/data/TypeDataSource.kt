package com.hadi.android.core.data

import com.hadi.android.core.doman.Type

interface TypeDataSource {
    fun insert(type: Type) : Long
    fun update(type: Type) : Boolean
    fun remove(type: Type) : Boolean
    fun remove(id: Long) : Boolean
    fun get(id : Long) : Type?
    fun getAll() : List<Type>
}