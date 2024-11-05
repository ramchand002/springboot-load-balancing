FROM openjdk:21
VOLUME /app/log
COPY target/pool.customer-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "pool.customer-0.0.1-SNAPSHOT.jar"]
