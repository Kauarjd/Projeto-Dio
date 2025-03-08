# Use uma imagem base do Java
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR para o container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]
# Estágio de build
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Estágio final
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]