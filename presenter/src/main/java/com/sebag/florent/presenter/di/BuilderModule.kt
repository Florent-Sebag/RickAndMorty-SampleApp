package com.sebag.florent.presenter.di

import com.sebag.florent.presenter.HostActivity
import com.sebag.florent.presenter.view.detail.DetailFragment
import com.sebag.florent.presenter.view.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun provideHostActivity() : HostActivity

    @ContributesAndroidInjector
    abstract fun provideHomeFragment() : HomeFragment

    @ContributesAndroidInjector
    abstract fun provideDetailFragment() : DetailFragment
}