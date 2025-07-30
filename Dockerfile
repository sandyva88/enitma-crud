FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .
COPY src ./src
# Construir la aplicación
RUN ./mvnw clean package -DskipTests
# Imagen final más liviana
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app
# Copiar el JAR
COPY --from=build /app/target/*.jar app.jar
# Puerto de la aplicación
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.additional-location=file:/etc/secrets/"]