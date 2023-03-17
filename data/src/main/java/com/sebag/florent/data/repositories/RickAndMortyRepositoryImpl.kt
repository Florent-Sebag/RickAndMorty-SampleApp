package com.sebag.florent.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.sebag.florent.data.api.RickAndMortyApi
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.RickAndMortyRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RickAndMortyRepositoryImpl
@Inject constructor(
    private val service: RickAndMortyApi,
    private val characterPagingSource: CharacterPagingSource
) : RickAndMortyRepository {

    override fun retrieveCharacterList() : Flowable<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40),
            pagingSourceFactory = { characterPagingSource }
        ).flowable
    }

    override fun retrieveCharacterDetails(id: Int, position: Int) : Single<CharacterModel> {
        return service.fetchCharacterDetail(id)
            .subscribeOn(Schedulers.io())
            .map { CharacterModel(
                id = it.id,
                name = it.name,
                type = it.species,
                image = it.image
            )}
    }
}