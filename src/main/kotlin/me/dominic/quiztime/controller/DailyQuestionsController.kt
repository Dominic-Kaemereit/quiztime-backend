package me.dominic.quiztime.controller

import io.swagger.v3.oas.annotations.tags.Tag
import me.dominic.quiztime.entity.Question
import me.dominic.quiztime.repository.QuestionRepository
import org.springframework.web.bind.annotation.*
import java.util.concurrent.TimeUnit

@RestController
@RequestMapping("/public-api/question/daily")
@Tag(name = "Daily Questions", description = "You can get the daily questions here.")
class DailyQuestionsController(
    private val questionRepository: QuestionRepository
) {

    private val QUESTIONS = 5
    private val QUESTION_CACHE_EXPIRATION = TimeUnit.HOURS.toMillis(24)

    private var dailyQuestionsAge: Long = 0
    private var dailyQuestions: List<Question> = emptyList()

    @GetMapping
    fun getDailyQuestions(): List<Question> {
        return getCachedDailyQuestions()
    }

    private fun getCachedDailyQuestions(): List<Question> {
        if (dailyQuestions.isEmpty() ||
            System.currentTimeMillis() - dailyQuestionsAge > TimeUnit.HOURS.toMillis(QUESTION_CACHE_EXPIRATION)) {
            if (dailyQuestions.isNotEmpty()) {
                println("Daily questions cache expired, fetching new questions.")
            } else {
                println("Fetching daily questions for the first time.")
            }

            dailyQuestions = getDailyQuestionsFromDatabase()
            dailyQuestionsAge = System.currentTimeMillis()

            println("Daily questions cache updated.")
            println("The daily questions are:")
            dailyQuestions.forEach { question ->
                println("Question: ${question.question}")
            }
        }
        return dailyQuestions
    }

    private fun getDailyQuestionsFromDatabase(): List<Question> {
        return questionRepository.findAll()
            .shuffled()
            .take(QUESTIONS)
    }
}
