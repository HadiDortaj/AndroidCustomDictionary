package com.hadi.android.custom.dictionary.di

import com.hadi.android.core.data.CategoryDataSource
import com.hadi.android.core.data.CategoryRepository
import com.hadi.android.core.data.WordDataSource
import com.hadi.android.core.data.WordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class RepositoriesModule {

    @Provides
    fun provideCategoryRepository(categoryDataSource: CategoryDataSource): CategoryRepository {
        return CategoryRepository(categoryDataSource)
    }

    @Provides
    fun provideWordRepository(wordDataSource: WordDataSource): WordRepository {
        return WordRepository(wordDataSource)
    }

}