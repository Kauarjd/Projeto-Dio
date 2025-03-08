# Use uma imagem base do Java
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR para o container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]