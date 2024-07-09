# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# 작업 디렉토리 설정
WORKDIR /app

# Copy the .env file into the container
COPY .env .env

# Export environment variables from .env file
RUN export $(cat .env | grep -v ^# | xargs)

# 빌드된 JAR 파일 복사
COPY build/libs/record-0.0.1-SNAPSHOT.jar app.jar

# 컨테이너가 노출할 포트 설정
EXPOSE ${PORT:-8080}


# 애플리케이션 실행 명령어
CMD ["sh", "-c", "java -jar app.jar"]