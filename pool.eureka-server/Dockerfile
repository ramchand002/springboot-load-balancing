FROM openjdk:21
VOLUME /app/log
ADD target/pool.eureka-server-0.0.1-SNAPSHOT.jar pool.eureka-server-0.0.1-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "pool.eureka-server-0.0.1-SNAPSHOT.jar"]
