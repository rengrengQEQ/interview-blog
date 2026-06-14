# 第一阶段：构建
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# 复制所有文件
COPY . .

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