package me.dominic.quiztime.entity

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
@Tag(name = "User", description = "A user of the quiz application.")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Schema(description = "The email address of the user.")
    var email: String,

    @Schema(description = "The created at timestamp of the user.")
    val createdAt: Long,

    @Schema(description = "The updated at timestamp of the user.")
    var updatedAt: Long
)