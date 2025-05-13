package me.dominic.quiztime.controller

import me.dominic.quiztime.entity.Question
import me.dominic.quiztime.repository.QuestionRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/question")
class QuestionController(
    private val questionRepository: QuestionRepository
) {

    @PostMapping()
    fun createQuestion(@RequestBody question: Question): Question {
        return questionRepository.save(question)
    }
}
