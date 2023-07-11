FROM openjdk:17-alpine
ADD target/GameOn-0.0.1-SNAPSHOT.jar gameon-test-1
ENTRYPOINT ["java", "-jar", "gameon-test-1"]
EXPOSE 8080