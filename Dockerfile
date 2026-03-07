FROM openjdk:22-jdk
ADD target/Student-app.jar Student-app.jar
ENTRYPOINT ["java","-jar","/Student-app.jar"]