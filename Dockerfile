FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ws-racemanagement-trektrak.jar
ENTRYPOINT ["java","-jar","/ws-racemanagement-trektrak.jar"]