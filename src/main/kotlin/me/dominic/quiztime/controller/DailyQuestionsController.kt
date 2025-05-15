package me.dominic.quiztime.controller

import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import me.dominic.quiztime.entity.Question
import me.dominic.quiztime.entity.User
import me.dominic.quiztime.repository.QuestionRepository
import me.dominic.quiztime.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RestController
@RequestMapping("/public-api/question/daily")
@Tag(name = "Daily Questions", description = "You can get the daily questions here.")
class DailyQuestionsController(
    private val questionRepository: QuestionRepository,
    private val userRepository: UserRepository
) {

    private val QUESTIONS = 5
    private val QUESTION_CACHE_EXPIRATION = TimeUnit.HOURS.toMillis(24)

    private var dailyQuestionsAge: Long = 0

    private val userQuestionCache: MutableMap<String, List<Question>> = mutableMapOf()

    @GetMapping
    fun getDailyQuestions(request: HttpServletRequest): List<Question> {
        val authHeader = request.getHeader("Authorization")

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            val email = authHeader.substring(7) // remove "Bearer "
            return getCachedDailyQuestions(email)
        }

        return getCachedDailyQuestions(null)
    }

    private fun getCachedDailyQuestions(email: String?): List<Question> {
        if (email != null) {
            var user = userRepository.findByEmail(email)

            if (user == null) {
                user = User(
                    email = email,
                    createdAt = System.currentTimeMillis(),
                    updatedAt = System.currentTimeMillis()
                )
            }

            val questions = userQuestionCache[user.email]

            if (questions != null && System.currentTimeMillis() - dailyQuestionsAge < TimeUnit.HOURS.toMillis(QUESTION_CACHE_EXPIRATION)) {
                println("Returning cached questions for user: ${user.email}")
                return questions
            } else {
                println("No cached questions found for user: ${user.email}, fetching new questions.")
                userQuestionCache[user.email] = getDailyQuestionsFromDatabase()
                return userQuestionCache[user.email]!!
            }
        } else {
            println("No email provided, using default daily questions.")
        }

        return getDailyQuestionsFromDatabase()
    }

    private fun getDailyQuestionsFromDatabase(): List<Question> {
        return questionRepository.findAll()
            .shuffled()
            .take(QUESTIONS)
    }
}
