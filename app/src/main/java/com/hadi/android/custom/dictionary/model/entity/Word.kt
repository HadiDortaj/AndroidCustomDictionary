package com.hadi.android.custom.dictionary.model.entity

import com.hadi.android.custom.dictionary.model.entity.Definition
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
data class Word(@Id var id: Long, var title: String, var definitions: ToMany<Definition>)