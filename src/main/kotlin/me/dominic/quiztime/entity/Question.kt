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
@Table(name = "questions")
@Tag(name = "Question", description = "A question for the quiz.")
data class Question (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Schema(description = "The question itself.")
    val question: String,

    @ElementCollection
    @CollectionTable(name = "question_answers", joinColumns = [JoinColumn(name = "question_id")])
    @MapKeyColumn(name = "answer_text")
    @Column(name = "is_correct")
    @Schema(description = "The answers to the question and whether they are correct.")
    var answers: Map<String, Boolean>
)