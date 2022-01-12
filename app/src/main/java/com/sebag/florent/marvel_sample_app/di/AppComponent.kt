package com.sebag.florent.marvel_sample_app.di

import com.sebag.florent.marvel_sample_app.MarvelApp
import com.sebag.florent.presenter.di.BuilderModule
import com.sebag.florent.presenter.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        BuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: MarvelApp): Builder
        fun build(): AppComponent
    }

    fun inject(app: MarvelApp)
}