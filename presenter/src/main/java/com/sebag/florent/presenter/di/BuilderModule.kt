package com.sebag.florent.presenter.di

import com.sebag.florent.presenter.view.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment() : HomeFragment
}