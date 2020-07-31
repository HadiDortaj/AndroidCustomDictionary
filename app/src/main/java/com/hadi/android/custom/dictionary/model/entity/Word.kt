package com.hadi.android.custom.dictionary.model.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
data class Word(@Id var id: Long, var title: String) {
    lateinit var definitions: ToMany<Definition>
}