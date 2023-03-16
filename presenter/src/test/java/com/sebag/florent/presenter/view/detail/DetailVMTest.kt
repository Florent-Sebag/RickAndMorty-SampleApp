package com.sebag.florent.presenter.view.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.usecases.CharacterDetailsUseCase
import com.sebag.florent.presenter.mocks.detailsMocks
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class DetailVMTest {

    @Mock
    private lateinit var characterDetailUseCase: CharacterDetailsUseCase

    private lateinit var detailVM: DetailVM

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler{Schedulers.trampoline()}
        detailVM = DetailVM(characterDetailUseCase)
    }

    @Test
    fun `getCharacterDetail success should fill characterDetails data`() {
        whenever(characterDetailUseCase.getCharacterDetail(detailsMocks.characterMock.id, 0))
            .thenReturn(Single.just(detailsMocks.characterMock))

        detailVM.getCharacterDetails(detailsMocks.characterMock.id, 0)

        assertEquals(detailsMocks.characterMock, detailVM.characterDetails.value)
    }

    @Test
    fun `getCharacterDetail error should set error message on onError`() {
        whenever(characterDetailUseCase.getCharacterDetail(detailsMocks.characterMock.id, 0))
            .thenReturn(Single.error(Throwable("")))

        detailVM.getCharacterDetails(detailsMocks.characterMock.id, 0)

        assertEquals(DetailVM.DETAILS_ERROR_MESSAGE, detailVM.onError.value)
    }
}