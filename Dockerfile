FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/Karumien/http-echo

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/http-echo /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/echo-service-1.0.0-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java -jar echo-service-1.0.0-SNAPSHOT.jar"]
