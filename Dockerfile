# 第一阶段：构建
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# 复制 Maven Wrapper 和项目文件
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

# 给 mvnw 执行权限
RUN chmod +x ./mvnw

# 执行打包
RUN ./mvnw clean package -DskipTests

# 第二阶段：运行
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]