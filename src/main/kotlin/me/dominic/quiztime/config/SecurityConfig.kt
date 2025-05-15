package me.dominic.quiztime.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.invoke

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
                authorize("/public-api/**", permitAll)     // <- öffentlich
                authorize(anyRequest, authenticated)   // <- alles andere geschützt
            }
            formLogin { } // oder httpBasic { } falls du Basic Auth möchtest
        }
        return http.build()
    }
}