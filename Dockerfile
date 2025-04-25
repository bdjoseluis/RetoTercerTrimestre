# Etapa 1: Build con Maven y Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY . .

RUN mvn clean package -DskipTests

# Etapa 2: Imagen ligera para ejecutar la app
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/RetoDaw-0.0.1-SNAPSHOT.war RetoDaw.war

EXPOSE 5001

ENTRYPOINT ["java", "-jar", "RetoDaw.war"]
