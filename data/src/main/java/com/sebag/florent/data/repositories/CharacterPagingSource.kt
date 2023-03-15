package com.sebag.florent.data.repositories

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.sebag.florent.data.api.MarvelApi
import com.sebag.florent.data.entities.Response
import com.sebag.florent.domain.models.CharacterModel
import com.squareup.moshi.Moshi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class CharacterPagingSource
@Inject constructor(
    private val service: MarvelApi,
    private val moshi: Moshi
): RxPagingSource<Int, CharacterModel>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, CharacterModel>> {
        val position = params.key ?: 1

        return service.fetchCharacterListFromApi(position)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, position) }
            .onErrorReturn {
                LoadResult.Error(Throwable(parseError(it)))
            }
    }

    private fun toLoadResult(response: Response, position: Int): LoadResult<Int, CharacterModel> {
        return LoadResult.Page(
            data = response.results,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position >= response.info.pages) null else position + 1
        )
    }

    private fun parseError(e : Throwable) : String {
        //TODO Dégueu
        val errorString = (e as HttpException).response()?.errorBody()?.string()
        var error = ""

        errorString?.let {
            error =  "Internal error"
        } ?: run {
            error = "Internal error"
        }
        return (error)
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return null
    }
}