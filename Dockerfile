FROM maven:3.6-jdk-8 as build
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:resolve dependency:resolve-plugins
COPY src ./src
COPY docker-conf/application.yaml ./src/main/resources/
RUN mvn -B package

FROM openjdk:8-jre-alpine
WORKDIR /api
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]