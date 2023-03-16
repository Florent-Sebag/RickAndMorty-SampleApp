package com.sebag.florent.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sebag.florent.data.api.MarvelApi
import com.sebag.florent.data.entities.CharacterEntity
import com.sebag.florent.data.repositories.mocks.MarvelRepositoryMocks
import com.sebag.florent.domain.models.CharacterModel
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class MarvelRepositoryImplTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var service: MarvelApi

    @Mock
    private lateinit var characterPagingSource: CharacterPagingSource

    private lateinit var marvelRepository: MarvelRepositoryImpl

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler{ Schedulers.trampoline()}
        marvelRepository = MarvelRepositoryImpl(service, characterPagingSource)
    }

    @Test
    fun `retrieveCharacterDetails should return a CharacterModel`() {
        val expected = MarvelRepositoryMocks.characterModelMock

        whenever(service.fetchCharacterDetail(0)).thenReturn(
            Single.just(MarvelRepositoryMocks.characterEntityMock)
        )

        val result = marvelRepository.retrieveCharacterDetails(0, 0).blockingGet()

        verify(service).fetchCharacterDetail(0)
        assertEquals(expected, result)
    }
}