FROM gradle:jdk21 AS build

WORKDIR /home/gradle/src/

COPY --chown=gradle:gradle . .

RUN gradle build -x --args='--spring.profiles.active=dev'

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]