FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} seminardemoapplication.jar
ENTRYPOINT ["java","-jar","/seminardemoapplication.jar"]