FROM openjdk:22-jdk
ADD target/Student-app.jar Student-app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","Student-app.jar"]
