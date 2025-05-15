# Verwende ein anderes Basis-Image mit JDK 21
FROM openjdk:21-jdk-slim

# Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere die Gradle-Wrapper-Dateien
COPY gradlew .
COPY gradle ./gradle

# Kopiere die Gradle-Konfigurationsdateien
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Kopiere den Quellcode
COPY src ./src

# Führe Gradle aus, um die Anwendung zu bauen
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

# Kopiere die erstellte JAR-Datei
COPY build/libs/*.jar /app/app.jar

# Gib den Port an, auf dem die Anwendung läuft
EXPOSE 8080

# Definiere den Befehl zum Ausführen der Anwendung
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--spring.profiles.active=dev"]