FROM eclipse-temurin:17-jdk-alpine
MAINTAINER shanmugavel.rs@gmail.com
VOLUME /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]