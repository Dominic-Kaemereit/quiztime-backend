# Or another base image with JDK 21
FROM openjdk:21-jdk-slim

# Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere die Gradle-Wrapper-Dateien (optional, aber gut für konsistente Builds)
COPY gradlew .
COPY gradle ./gradle

# Kopiere die Gradle-Konfigurationsdateien
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Kopiere die Kotlin-Quellcode-Dateien
COPY src ./src

# Führe Gradle aus, um die Anwendung zu bauen (das Ergebnis ist eine ausführbare JAR-Datei)
RUN chmod +x ./gradlew && ./gradlew bootJar

# Kopiere die erstellte JAR-Datei in das Image (angepasster Pfad)
COPY build/libs/*.jar app.jar

# Gib den Port an, auf dem die Anwendung läuft (passe dies bei Bedarf an)
EXPOSE 8080

# Definiere den Befehl zum Ausführen der Anwendung mit dem dev-Profil (vereinfachter Pfad)
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=dev"]