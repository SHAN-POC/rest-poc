FROM eclipse-temurin:17-jre-alpine
MAINTAINER shanmugavel.rs@gmail.com
VOLUME /app
COPY target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -Dspring.backgroundpreinitializer.ignore=true -jar /app.jar"]
#ENTRYPOINT ["java", "-jar", "app.jar"]