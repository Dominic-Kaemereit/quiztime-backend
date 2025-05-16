package me.dominic.quiztime.repository

import me.dominic.quiztime.entity.DailyQuestion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyQuestionRepository : JpaRepository<DailyQuestion, Long>  {

    fun findTopByEmailOrderByCreatedAtDesc(email: String): DailyQuestion?
}