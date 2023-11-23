FROM openjdk:latest
EXPOSE 9001
ADD target/users-service.jar users-service.jar
ENTRYPOINT ["java","-jar", "/users-service.jar"]