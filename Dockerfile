# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/neusa-moda-1.0.1-SNAPSHOT.jar

# se nao funcionar, usar isso ARG WAR_FILE=./target/*.war

# cd /opt/app
WORKDIR /target
COPY target/neusamoda-1.0.1-SNAPSHOT.jar app.jar

# cp target/spring-boot-web.jar /opt/app/app.jar
#COPY ${JAR_FILE} app.jar

EXPOSE 8081

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
