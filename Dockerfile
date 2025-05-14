# Verwende ein schlankes Basis-Image mit einer JRE für Java 21
FROM eclipse-temurin:21-jre-alpine

# Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere das erstellte JAR-File in den Container
COPY target/*.jar app.jar

# Gib den Port an, auf dem die Anwendung läuft (passe ihn ggf. an)
EXPOSE 8080

# Definiere den Befehl zum Starten der Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]