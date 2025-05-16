package me.dominic.quiztime.controller

import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import me.dominic.quiztime.entity.DailyQuestion
import me.dominic.quiztime.entity.Question
import me.dominic.quiztime.entity.User
import me.dominic.quiztime.repository.DailyQuestionRepository
import me.dominic.quiztime.repository.QuestionRepository
import me.dominic.quiztime.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.concurrent.TimeUnit

@RestController
@RequestMapping("/public-api/question/daily")
@Tag(name = "Daily Questions", description = "You can get the daily questions here.")
class DailyQuestionsController(
    private val questionRepository: QuestionRepository,
    private val userRepository: UserRepository,
    private val dailyQuestionRepository: DailyQuestionRepository
) {

    private val QUESTIONS = 5
    private val QUESTION_CACHE_EXPIRATION = TimeUnit.HOURS.toMillis(24)

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

    @GetMapping("/finish")
    fun finishDailyQuestions(request: HttpServletRequest): String {
        val authHeader = request.getHeader("Authorization")

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            val email = authHeader.substring(7) // remove "Bearer "
            // GEt all parameters
            val questions: MutableMap<String, String> = mutableMapOf()
            request.parameterMap.map { (key, value) ->
                questions[key] = value[0]
            }

            dailyQuestionRepository.save(
                DailyQuestion(
                    email = email,
                    createdAt = System.currentTimeMillis(),
                    answers = questions
                )
            )

            userQuestionCache.remove(email)

            println("Finishing daily questions for user: $email with answers: $questions")
        }

        return "No email provided, daily questions not finished."
    }

    @GetMapping("/check")
    fun checkDailyQuestions(request: HttpServletRequest): String {
        val authHeader = request.getHeader("Authorization")

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            val email = authHeader.substring(7) // remove "Bearer "

            //Get the last daily question for the user
            val lastDailyQuestion = dailyQuestionRepository.findTopByEmailOrderByCreatedAtDesc(email)

            if (lastDailyQuestion == null) {
                return "You have not answered the daily questions yet."
            }

            return if (isToday(lastDailyQuestion.createdAt)) {
                "You have already answered the daily questions."
            } else {
                "You can answer the daily questions again."
            }
        }

        return "No email provided, daily questions not finished."
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

            if (questions != null) {
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

    private fun isToday(timestampMillis: Long): Boolean {
        val today = LocalDate.now()
        val inputDate = Instant.ofEpochMilli(timestampMillis)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()

        return inputDate == today
    }
}
