package com.sebag.florent.data.repositories.mocks

import com.sebag.florent.data.entities.CharacterEntity
import com.sebag.florent.domain.models.CharacterModel

class MarvelRepositoryMocks {
    companion object {
        val characterModelMock = CharacterModel(
            0,
            "name",
            "type",
            "url"
        )

        val characterEntityMock = CharacterEntity(
            0,
            "name",
            "type",
            "url"
        )
    }
}