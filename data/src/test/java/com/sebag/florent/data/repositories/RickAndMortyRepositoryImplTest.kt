package com.sebag.florent.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sebag.florent.data.api.RickAndMortyApi
import com.sebag.florent.data.repositories.mocks.RickAndMortyRepositoryMocks
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
class RickAndMortyRepositoryImplTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var service: RickAndMortyApi

    @Mock
    private lateinit var characterPagingSource: CharacterPagingSource

    private lateinit var rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler{ Schedulers.trampoline()}
        rickAndMortyRepositoryImpl = RickAndMortyRepositoryImpl(service, characterPagingSource)
    }

    @Test
    fun `retrieveCharacterDetails should return a CharacterModel`() {
        val expected = RickAndMortyRepositoryMocks.characterModelMock

        whenever(service.fetchCharacterDetail(0)).thenReturn(
            Single.just(RickAndMortyRepositoryMocks.characterEntityMock)
        )

        val result = rickAndMortyRepositoryImpl.retrieveCharacterDetails(0, 0).blockingGet()

        verify(service).fetchCharacterDetail(0)
        assertEquals(expected, result)
    }
}