package me.dominic.quiztime.repository

import me.dominic.quiztime.entity.Question
import me.dominic.quiztime.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String): User?
}