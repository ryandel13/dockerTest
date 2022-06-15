#
# Build stage
#
FROM maven:3.8.5-openjdk-17-slim AS build
COPY src /src
COPY pom.xml /pom.xml
RUN mvn -f /pom.xml clean package -DskipTests

#
# Package stage
#
#FROM openjdk:17.0.1-jdk-slim
FROM bellsoft/liberica-openjdk-alpine:17
COPY --from=build /target/config-0.0.1-SNAPSHOT.jar /usr/local/lib/config-server.jar
COPY /target/extra-resources /usr/local/configs/
EXPOSE 8081
ENTRYPOINT ["java","-Dspring.profiles.active=docker,native","-jar","/usr/local/lib/config-server.jar"]