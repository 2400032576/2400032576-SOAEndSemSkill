
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY target/*.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]
