FROM openjdk:latest
EXPOSE 8765
ADD target/zuul-cloud-gateway.jar zuul-cloud-gateway.jar
ENTRYPOINT ["java","-jar", "/zuul-cloud-gateway.jar"]