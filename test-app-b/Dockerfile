#
# Build stage
#
#FROM maven:3.8.5-openjdk-17-slim AS build
#COPY src /src
#COPY pom.xml /pom.xml
#RUN mvn -f /pom.xml clean package -DskipTests

#
# Package stage
#
FROM bellsoft/liberica-openjdk-alpine:17
#COPY --from=build /target/test-app-a-0.0.1-SNAPSHOT.jar /usr/local/lib/test-app-a.jar
COPY /target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/test-app-b.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/local/lib/test-app-b.jar"]