FROM openjdk:latest
EXPOSE 9002
ADD target/transactions-service.jar transactions-service.jar
ENTRYPOINT ["java","-jar", "/transactions-service.jar"]