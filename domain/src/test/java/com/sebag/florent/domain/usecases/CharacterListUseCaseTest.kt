package com.sebag.florent.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class CharacterListUseCaseTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var marvelRepository : MarvelRepository

    private lateinit var characterListUseCase: CharacterListUseCase

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        characterListUseCase = CharacterListUseCaseImpl(marvelRepository)
    }

    @Test
    fun `getCharacterDetail should call repository`() {
        characterListUseCase.getPagingCharacterList()

        verify(marvelRepository).retrieveCharacterList()
    }
}