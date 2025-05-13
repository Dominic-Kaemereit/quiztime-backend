# QuizTime Backend

## Description
QuizTime is a backend application for a quiz system, developed with Kotlin and Spring Boot. The application manages quiz questions and provides REST endpoints for retrieving and managing questions, including a special feature for daily questions.

## Technologien
- Java SDK 21
- Kotlin 1.9
- Spring Boot
- H2 Datenbank
- PostgreSQL
- Gradle as Build-Tool

## Configuration
The application uses Spring Profiles for configuration management.
- `application.properties`: The default configuration file.
- `application-dev.properties`: The configuration file for the development environment.

## Running the Application
To run the application, you can use the following command:

### For Development
```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
```

### For Production
```bash
./gradlew bootRun
```