package com.sebag.florent.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.sebag.florent.domain.models.CharacterModel
import com.sebag.florent.domain.repositories.MarvelRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class MarvelRepositoryImpl
@Inject constructor(
    private val characterPagingSource: CharacterPagingSource
) : MarvelRepository {

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
}