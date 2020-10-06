package com.hadi.android.custom.dictionary.di

import com.hadi.android.custom.dictionary.database.ObjectBox
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.objectbox.BoxStore

@Module
@InstallIn(ApplicationComponent::class)
class BoxStoreModule {

    @Provides
    fun provideBoxStore(): BoxStore {
        return ObjectBox.boxStore
    }

}