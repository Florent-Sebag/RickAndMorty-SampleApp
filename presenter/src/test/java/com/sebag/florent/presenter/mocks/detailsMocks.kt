package com.sebag.florent.presenter.mocks

import com.sebag.florent.domain.models.CharacterModel

class detailsMocks {

    companion object {
        val characterMock =
            CharacterModel(
                id = 1,
                name = "Rick",
                type = "Human",
                image = ""
            )
    }
}