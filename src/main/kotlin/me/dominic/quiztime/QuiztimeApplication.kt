package me.dominic.quiztime

import me.dominic.quiztime.default.DefaultDBData
import me.dominic.quiztime.entity.Question
import me.dominic.quiztime.repository.QuestionRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.UUID

@SpringBootApplication
class QuiztimeApplication {

	@Bean
	fun initData(questionRepository: QuestionRepository) = CommandLineRunner {
		if (questionRepository.findAll().isEmpty()) {
			println("Loading default questions into the database...")
			val questions = DefaultDBData(questionRepository).loadDefaultQuestions()
			println("Loaded $questions default questions into the database.")
		} else {
			println("Database already contains questions, skipping default data load.")
		}
	}
}

fun main(args: Array<String>) {
	runApplication<QuiztimeApplication>(*args)
}
