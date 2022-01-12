package com.sebag.florent.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import androidx.paging.rxjava3.flowable
import com.sebag.florent.data.api.MarvelApi
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MarvelRepositoryImpl
@Inject constructor(
    private val service: MarvelApi
) : MarvelRepository, RxPagingSource<Int, CharacterModel>() {

    override fun fetchCharacterList(): Single<List<CharacterModel>> {

        return service.fetchCharacterListFromApi(20)
            .subscribeOn(Schedulers.io())
            .map { it.data.results }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, CharacterModel>> {
        val position = params.key ?: 0

        return service.fetchCharacterListFromApi(position)
            .subscribeOn(Schedulers.io())
            .map { it.data.results }
            .map { toLoadResult(it, position) }
    }

    private fun toLoadResult(data: List<CharacterModel>, position: Int): LoadResult<Int, CharacterModel> {
        return LoadResult.Page(
            data = data,
            prevKey = if (position == 0) null else position - 20,
            nextKey = if (position == 10000) null else position + 20
            //TODO Change nextkey to the true limit
        )
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return null
    }

    override fun retrieveCharacterList() : Flowable<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40),
            pagingSourceFactory = { this }
        ).flowable
    }
}