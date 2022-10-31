package com.example.composition_numbers.domain.repository

import com.example.composition_numbers.domain.entity.GameSettings
import com.example.composition_numbers.domain.entity.Level
import com.example.composition_numbers.domain.entity.Question

interface GameRepository {

    // maxSumValue - Максимальная сумма для уровня
    // countOfOptions - Колличестов ответов
    fun generateQuestion(
        maxSumValue:Int, countOfOptions:Int
    ):Question

    // level - Передаваемый уровень
    fun getGameSettings(level: Level):GameSettings
}