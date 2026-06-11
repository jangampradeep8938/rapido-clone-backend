FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /build/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]