package me.dominic.quiztime.entity

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapKeyColumn
import jakarta.persistence.Table

@Entity
@Table(name = "daily_questions")
@Tag(name = "Daily Questions", description = "The daily questions for the quiz.")
data class DailyQuestion(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Schema(description = "The email address of the user.")
    var email: String,

    @Schema(description = "The created at timestamp of the user.")
    var createdAt: Long,

    @ElementCollection
    @CollectionTable(name = "daily_questions_answers", joinColumns = [JoinColumn(name = "daily_questions_id")])
    @MapKeyColumn(name = "question_text")
    @Column(name = "answer_text")
    @Schema(description = "The answers to the daily questions.")
    var answers: Map<String, String>
)