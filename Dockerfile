# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY build/libs/record-0.0.1-SNAPSHOT.jar app.jar

# 컨테이너가 노출할 포트 설정
EXPOSE 8080

# 애플리케이션 실행 명령어
CMD ["java", "-jar", "app.jar"]