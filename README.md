# 智码零界——AI应用生成平台

## 一、项目介绍

这是一套以 **AI 开发实战 + 后端架构设计** 为核心的项目教程，基于 Spring Boot 3 + LangChain4j + Vue 3 开发对标大厂的 **企业级 AI 代码生成平台**。智码零界旨在通过AI技术赋能开发者，提高代码生成效率，降低开发门槛。

## 二、技术栈

### 后端技术
- **核心框架**：Spring Boot 3.5.4
- **AI引擎**：LangChain4j
- **JDK版本**：Java 21
- **数据库**：MySQL
- **API文档**：Knife4j (基于OpenAPI 3)
- **工具库**：Hutool、Lombok
- **跨域处理**：自定义CorsConfig

### 前端技术
- **框架**：Vue 3
- **UI组件**：(ant-design-pro)
- **状态管理**：(eslint+prettier)

## 三、项目架构

![项目架构图](https://picbed-chengfu-1327906653.cos.ap-guangzhou.myqcloud.com/image/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-07-25%20135511.webp)

## 四、功能特性

- AI驱动的代码生成
- 智能代码补全与优化
- 多语言支持
- 项目模板管理
- 代码质量分析
- 用户权限管理

## 五、快速开始

### 环境要求
- JDK 21+
- Maven 3.6+
- MySQL 8.0+

### 本地开发
1. 克隆项目
```bash
git clone https://github.com/chengfushi/ai-code-mother-api.git
```

2. 配置数据库
   - 创建数据库
   - 修改 `application-local.yml` 中的数据库配置

3. 启动项目
```bash
mvn spring-boot:run
```

4. 访问API文档
```
http://localhost:8123/api/doc.html
```

## 六、项目结构
```
ai-code-mother-api/
├── src/main/java/com/chengfu/aicodemotherapi/
│   ├── common/           # 通用类（响应封装、请求对象等）
│   ├── config/           # 配置类（跨域等）
│   ├── controller/       # 控制器
│   ├── exception/        # 异常处理
│   └── AiCodeMotherApiApplication.java  # 启动类
├── src/main/resources/
│   ├── application.yml   # 主配置文件
│   └── application-local.yml  # 本地开发配置
└── pom.xml               # Maven依赖
```

## 七、API文档

项目集成了Knife4j，提供了美观易用的API文档。启动项目后访问：
```
http://localhost:8123/api/doc.html
```

## 八、贡献指南

欢迎提交问题和功能需求！如果您想贡献代码，请遵循以下步骤：

1. Fork 本仓库
2. 创建您的特性分支 (`git checkout -b feature/amazing-feature`)
3. 提交您的更改 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 打开一个 Pull Request

## 九、作者

- [(Chengfu Shi)](https://github.com/chengfushi)
- [Camellia](https://github.com/camellialoveit)

## 十、许可证

本项目采用 [待定] 许可证

## 十一、联系方式

如有任何问题或建议，请通过以下方式联系我们：
- GitHub Issues
- Email: [待补充]
