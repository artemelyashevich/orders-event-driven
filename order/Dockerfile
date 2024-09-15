FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY order/build/libs/order-0.0.1-SNAPSHOT.jar order.jar

CMD ["java", "-jar", "order.jar"]