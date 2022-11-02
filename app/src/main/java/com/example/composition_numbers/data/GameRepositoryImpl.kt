package com.example.composition_numbers.data

import com.example.composition_numbers.domain.entity.GameSettings
import com.example.composition_numbers.domain.entity.Level
import com.example.composition_numbers.domain.entity.Question
import com.example.composition_numbers.domain.repository.GameRepository
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1


    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = kotlin.math.max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue - 1, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.Acquaintance -> GameSettings(10, 3, 50, 5)
            Level.Easy -> GameSettings(10, 10, 70, 60)
            Level.Medium -> GameSettings(20, 20, 80, 50)
            Level.Hard -> GameSettings(30, 30, 90, 40)

        }
    }


}