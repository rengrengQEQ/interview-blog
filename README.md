# 个人博客系统 | Interview Project

一个使用 **Spring Boot + Thymeleaf + MySQL + JWT** 开发的个人博客系统，适合作为 Java 后端开发面试项目。

## 项目亮点

- 用户注册与登录（JWT Token 认证）
- Markdown 编辑器 + 实时渲染
- 文章发布、列表、详情查看
- 响应式前端界面（Bootstrap 5）
- 登录状态动态按钮显示

## 技术栈

- **后端**：Spring Boot 3 + Spring Security + JWT + JPA (Hibernate)
- **数据库**：MySQL 8
- **前端**：Thymeleaf + Bootstrap 5 + SimpleMDE (Markdown 编辑器)
- **构建工具**：Maven

## 快速启动

1. 创建数据库 `blog_db`
2. 修改 `application.yml` 中的 MySQL 密码
3. 运行 `BlogApplication.java`
4. 浏览器访问：http://localhost:8080

## 测试账号

- 用户名：`testuser`
- 密码：`123456`

## 主要功能

- [x] 用户注册 + 密码加密（BCrypt）
- [x] JWT 登录认证
- [x] Markdown 文章编辑与渲染
- [x] 文章 CRUD 操作
- [x] 登录状态动态导航

## 项目结构
