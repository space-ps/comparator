FROM openjdk:14-alpine
COPY build/libs/comparator-*-all.jar comparator.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "comparator.jar"]