package com.sebag.florent.presenter.view.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.usecases.CharacterListUseCase
import com.sebag.florent.domain.usecases.CharacterListUseCaseImpl
import com.sebag.florent.presenter.mocks.homeMocks
import com.sebag.florent.presenter.view.home.adapter.CharacterAdapter
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class HomeVMTest {

    @Mock
    private lateinit var lifecycle: Lifecycle

    @Mock
    private lateinit var characterListUseCase: CharacterListUseCase

    @Mock
    private lateinit var characterAdapter: CharacterAdapter

    private lateinit var homeVM: HomeVM

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler{Schedulers.trampoline()}
        homeVM = HomeVM(characterListUseCase, characterAdapter)
    }

    @Test
    fun `launchPagingCharacterList success should submit data`() {
        val tmp = Flowable.just(PagingData.from(homeMocks.characterListMock))
        whenever(characterListUseCase.getPagingCharacterList()).thenReturn(tmp)

        homeVM.launchPagingCharacterList(lifecycle)

        verify(characterAdapter).submitData(any(), any())
        assertNull(homeVM.onError.value)
        assertEquals(false, homeVM.showLoading.value)
    }

    @Test
    fun `launchPagingCharacterList should set error message on onError`() {
        val tmp = Flowable.just(PagingData.from(homeMocks.characterListMock))
        val loadStates = mock<CombinedLoadStates>()
        val errorMessage = "Some error message"

        whenever(characterAdapter.addLoadStateListener(any())).thenAnswer {
            val listener = it.arguments[0] as (CombinedLoadStates) -> Unit
            listener(loadStates)
        }
        whenever(loadStates.append).thenReturn(LoadState.Error(Exception(errorMessage)))
        whenever(characterListUseCase.getPagingCharacterList())
            .thenReturn(tmp)

        homeVM.launchPagingCharacterList(lifecycle)

        assertEquals(errorMessage, homeVM.onError.value)
        assertEquals(false, homeVM.showLoading.value)
    }
}