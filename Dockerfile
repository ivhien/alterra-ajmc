FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=target/*.jar
WORKDIR /opt
ENV PORT 9090
EXPOSE 9090
COPY ${JAR_FILE} Tugas02-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Tugas02-0.0.1-SNAPSHOT.jar"]
