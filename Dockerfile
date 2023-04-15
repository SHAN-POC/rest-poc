FROM maven:3.9-eclipse-temurin-19-alpine AS builder
LABEL author=shanmugavel.rs@gmail.com
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package

FROM eclipse-temurin:19-jre-alpine
LABEL author=shanmugavel.rs@gmail.com
VOLUME /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -Dspring.backgroundpreinitializer.ignore=true -jar /app.jar"]
#ENTRYPOINT ["java", "-jar", "app.jar"]