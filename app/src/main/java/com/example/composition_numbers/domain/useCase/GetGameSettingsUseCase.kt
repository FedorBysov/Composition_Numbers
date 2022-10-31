package com.example.composition_numbers.domain.useCase

import com.example.composition_numbers.domain.entity.GameSettings
import com.example.composition_numbers.domain.entity.Level
import com.example.composition_numbers.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level):GameSettings{
        return repository.getGameSettings(level)
    }
}