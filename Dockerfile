FROM gradle:jdk21 AS build

WORKDIR /home/gradle/src/

COPY --chown=gradle:gradle . .

RUN gradle bootJar

FROM openjdk:21-jdk-slim

EXPOSE 8080

WORKDIR /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=dev"]