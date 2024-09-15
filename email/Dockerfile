FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY email/build/libs/email-0.0.1-SNAPSHOT.jar email.jar

CMD ["java", "-jar", "email.jar"]