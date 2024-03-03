FROM openjdk:17-jdk

LABEL creator="kiel0103@naver.com"
LABEL version="1.0.0"

WORKDIR /app
COPY skeleton-api/build/libs/skeleton-api-1.0.0.jar skeleton-api-1.0.0.jar

EXPOSE 8080/tcp

CMD ["java", "-jar", "/app/skeleton-api-1.0.0.jar"]