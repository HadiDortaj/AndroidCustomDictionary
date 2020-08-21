package com.hadi.android.custom.dictionary.di

import com.hadi.android.core.data.CategoryDataSource
import com.hadi.android.custom.dictionary.frameowork.datasource.CategoryDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindCategoryDataSource(categoryDataSourceImp: CategoryDataSourceImp): CategoryDataSource

}