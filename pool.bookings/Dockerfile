FROM openjdk:21
VOLUME /app/log
ADD target/pool.bookings-0.0.1-SNAPSHOT.jar pool.bookings-0.0.1-SNAPSHOT.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "pool.bookings-0.0.1-SNAPSHOT.jar"]
