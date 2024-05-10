FROM openjdk:17

WORKDIR /app

COPY ./target/Chat-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD [ "java", "-jar", "/app/Chat-0.0.1-SNAPSHOT.jar" ]