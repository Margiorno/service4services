FROM maven:3.9.9-eclipse-temurin-24 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package

FROM openjdk:24-jdk AS runner

WORKDIR /app

COPY --from=builder ./app/target/service-catalog-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 12000

ENTRYPOINT ["java","-jar","app.jar"]