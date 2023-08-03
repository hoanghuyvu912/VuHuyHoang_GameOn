FROM openjdk:11

WORKDIR /app

COPY . /app

ADD target/GameOn-0.0.1-SNAPSHOT.jar game-on-image

ENTRYPOINT ["java","-jar","game-on-image"]

EXPOSE 8080