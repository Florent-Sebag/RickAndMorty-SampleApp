package com.sebag.florent.data.repositories

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.sebag.florent.data.api.MarvelApi
import com.sebag.florent.data.entities.ResponseEntity
import com.sebag.florent.domain.models.CharacterModel
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class CharacterPagingSource
@Inject constructor(
    private val service: MarvelApi
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

    private fun toLoadResult(responseEntity: ResponseEntity, position: Int): LoadResult<Int, CharacterModel> {
        return LoadResult.Page(
            data = responseEntity.results,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position >= responseEntity.info.pages) null else position + 1
        )
    }

    private fun parseError(e : Throwable) : String {
        //TODO Dégueu + test page 43 pour voir gestion d'erreur
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