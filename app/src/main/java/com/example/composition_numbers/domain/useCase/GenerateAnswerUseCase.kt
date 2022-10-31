package com.example.composition_numbers.domain.useCase

import com.example.composition_numbers.domain.entity.Question
import com.example.composition_numbers.domain.repository.GameRepository

class GenerateAnswerUseCase(private val repository: GameRepository) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }

}