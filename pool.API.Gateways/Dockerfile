FROM openjdk:21
VOLUME /app/log
ADD target/pool.API.Gateways-0.0.1-SNAPSHOT.jar pool.API.Gateways-0.0.1-SNAPSHOT.jar
EXPOSE 8072
ENTRYPOINT ["java", "-jar", "pool.API.Gateways-0.0.1-SNAPSHOT.jar"]
