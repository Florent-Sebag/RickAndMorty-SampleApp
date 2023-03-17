package com.sebag.florent.presenter.mocks

import com.sebag.florent.domain.models.CharacterModel

class homeMocks {

    companion object {
        val characterListMock = listOf(
            CharacterModel(
                id = 1,
                name = "Rick",
                type = "Human",
                image = ""
            )
        )
    }
}