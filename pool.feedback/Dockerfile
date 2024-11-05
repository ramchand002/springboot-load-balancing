FROM openjdk:21
VOLUME /app/log
ADD target/pool.feedback-0.0.1-SNAPSHOT.jar pool.feedback-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "pool.feedback-0.0.1-SNAPSHOT.jar"]
