# 智码零界 (AI Code Mother)

<div align="center">
  <img src="https://picbed-chengfu-1327906653.cos.ap-guangzhou.myqcloud.com/image/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-07-25%20135511.webp" alt="智码零界架构图" width="600">

  <p>基于AI驱动的代码生成与应用开发平台</p>

  <p>
    <img src="https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen" alt="Spring Boot">
    <img src="https://img.shields.io/badge/Java-21-orange" alt="Java">
    <img src="https://img.shields.io/badge/Vue-3-blue" alt="Vue">
    <img src="https://img.shields.io/badge/LangChain4j-latest-purple" alt="LangChain4j">
    <img src="https://img.shields.io/badge/License-MIT-yellow" alt="License">
  </p>
</div>

## 📖 项目概述

智码零界是一个革命性的AI代码生成平台，旨在通过大语言模型技术赋能开发者，显著提升开发效率，降低技术门槛。平台集成了多种AI模型，能够根据自然语言描述智能生成多种编程语言的代码，并提供代码优化、项目模板管理等功能。

本项目不仅是一个实用的开发工具，也是一套完整的**AI开发实战 + 后端架构设计**教程，展示了如何将前沿AI技术与现代软件开发架构相结合。

## 🚀 核心特性

- **AI驱动的代码生成**：根据自然语言描述自动生成高质量代码
- **多模型路由系统**：根据不同任务类型智能选择最适合的AI模型
- **多语言支持**：支持Java、JavaScript、Python、Vue等多种编程语言
- **项目模板管理**：提供多种项目模板，快速搭建应用框架
- **代码质量分析**：AI辅助代码审查与优化建议
- **实时协作**：支持多用户协作开发
- **应用管理系统**：完整的应用生命周期管理
- **用户权限控制**：细粒度的权限管理系统

## 🛠️ 技术架构

### 后端技术栈

- **核心框架**：Spring Boot 3.5.4
- **AI引擎**：LangChain4j (AI模型编排框架)
- **JDK版本**：Java 21
- **数据存储**：MySQL 8.0+, Redis
- **ORM框架**：MyBatis
- **API文档**：Knife4j (基于OpenAPI 3)
- **对象存储**：腾讯云COS
- **工具库**：Hutool, Lombok
- **安全框架**：自定义认证与鉴权

### 前端技术栈

- **核心框架**：Vue 3 + TypeScript
- **构建工具**：Vite
- **状态管理**：Pinia
- **UI组件**：Element Plus / Ant Design Vue
- **HTTP客户端**：Axios
- **代码规范**：ESLint + Prettier
- **Markdown渲染**：自定义Markdown组件

## 🏗️ 系统架构

智码零界采用前后端分离架构，后端基于微服务设计理念构建：

1. **用户层**：提供用户认证、权限管理等基础服务
2. **应用层**：负责应用管理、部署和监控
3. **AI服务层**：
    - 模型路由系统：根据任务类型选择最适合的AI模型
    - 代码生成引擎：处理自然语言到代码的转换
    - 安全守卫系统：输入过滤和输出验证
4. **存储层**：数据持久化和缓存
5. **集成层**：与第三方服务和API的集成

## 🔧 快速开始

### 环境要求

- JDK 21+
- Maven 3.6+
- MySQL 8.0+
- Redis 6.0+
- Node.js 16+

### 后端服务启动

1. **克隆仓库**

```bash
git clone https://github.com/chengfushi/ai-code-mother-api.git
cd ai-code-mother-api
```

2. **配置数据库**

```sql
# 执行SQL脚本创建数据库和表
mysql -u username -p < sql/create_table.sql
```

3. **修改配置文件**

编辑 `src/main/resources/application.yml`，配置数据库连接、Redis和AI模型API密钥等

4. **编译并运行**

```bash
mvn clean package
java -jar target/ai-code-mother-api-1.0.0.jar
```

或使用Maven插件直接运行：

```bash
mvn spring-boot:run
```

### 前端服务启动

1. **进入前端目录**

```bash
cd ai-code-mother-web
```

2. **安装依赖**

```bash
npm install
# 或
yarn
```

3. **启动开发服务器**

```bash
npm run dev
# 或
yarn dev
```

4. **构建生产版本**

```bash
npm run build
# 或
yarn build
```

### 访问服务

- **后端API文档**：`http://localhost:8123/api/doc.html`
- **前端应用**：`http://localhost:5173/`

## 📁 项目结构

### 后端结构

```
src/main/java/com/chengfu/aicodemotherapi/
├── ai/                    # AI相关核心组件
│   ├── model/             # AI模型封装
│   ├── tools/             # AI工具集
│   └── guardrail/         # 安全守卫系统
├── common/                # 通用组件
│   ├── BaseResponse.java  # 统一响应封装
│   └── ResultUtils.java   # 结果工具类
├── config/                # 配置类
│   ├── CorsConfig.java    # 跨域配置
│   ├── RedisConfig.java   # Redis配置
│   └── AiModelConfig.java # AI模型配置
├── controller/            # 控制器层
├── service/               # 服务层
│   └── impl/              # 服务实现
├── mapper/                # 数据访问层
├── model/                 # 数据模型
│   ├── entity/            # 实体类
│   ├── dto/               # 数据传输对象
│   ├── vo/                # 视图对象
│   └── enums/             # 枚举类
├── exception/             # 异常处理
├── utils/                 # 工具类
└── AiCodeMotherApiApplication.java  # 应用入口
```

### 前端结构

```
ai-code-mother-web/
├── public/                # 静态资源
├── src/
│   ├── api/               # API接口定义
│   ├── assets/            # 静态资源
│   ├── components/        # 公共组件
│   ├── config/            # 配置文件
│   ├── layouts/           # 布局组件
│   ├── pages/             # 页面组件
│   │   ├── admin/         # 管理员页面
│   │   ├── app/           # 应用相关页面
│   │   └── user/          # 用户相关页面
│   ├── router/            # 路由配置
│   ├── stores/            # 状态管理
│   ├── utils/             # 工具函数
│   ├── App.vue            # 根组件
│   └── main.ts            # 入口文件
├── .env.development       # 开发环境变量
├── package.json           # 项目依赖
└── vite.config.ts         # Vite配置
```

## 🔐 核心功能模块

### 1. AI代码生成系统

- **多模型路由**：根据任务类型自动选择最适合的AI模型
- **代码解析器**：将AI生成的代码解析为结构化数据
- **代码保存器**：将生成的代码保存到文件系统或项目结构中
- **安全守卫**：输入过滤和输出验证，确保生成代码的安全性

### 2. 应用管理系统

- **应用创建与配置**：创建新应用并进行基础配置
- **应用部署与发布**：一键部署应用到测试或生产环境
- **应用监控与管理**：监控应用状态和性能指标

### 3. 用户管理系统

- **用户认证**：登录、注册、密码重置
- **权限控制**：基于角色的访问控制
- **用户画像**：记录用户偏好和使用习惯

### 4. 聊天历史管理

- **会话记录**：保存用户与AI的交互历史
- **上下文管理**：维护对话上下文，提高AI响应质量

## 📊 性能与扩展性

- **模型缓存**：缓存常用AI模型响应，减少API调用
- **分布式设计**：支持水平扩展以处理高并发请求
- **异步处理**：长时间任务采用异步处理机制
- **限流保护**：API级别的限流措施，防止滥用

## 🔍 API文档

项目集成了Knife4j，提供了美观易用的API文档。启动项目后访问：

```
http://localhost:8123/api/doc.html
```

主要API端点包括：

- `/api/user/**` - 用户相关API
- `/api/app/**` - 应用相关API
- `/api/chat/**` - 聊天历史相关API

## 🤝 贡献指南

我们欢迎各种形式的贡献，无论是新功能、bug修复还是文档改进！

1. Fork 本仓库
2. 创建您的特性分支 (`git checkout -b feature/amazing-feature`)
3. 提交您的更改 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 打开一个 Pull Request

请确保您的代码符合项目的编码规范，并附有适当的测试。

## 👥 核心团队

- **ChengFu** ([@chengfushi](https://github.com/chengfushi)) - 项目负责人

## 📄 许可证

本项目采用 MIT 许可证 - 详情请参阅 [LICENSE](LICENSE) 文件

## 📞 联系我们

如有任何问题或建议，请通过以下方式联系我们：

- **GitHub Issues**: [提交问题](https://github.com/chengfushi/ai-code-mother-api/issues)
- **电子邮件**: [303623518@qq.com]

## 🙏 致谢

感谢所有为本项目做出贡献的开发者，以及以下开源项目：

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Vue.js](https://vuejs.org/)
- [LangChain4j](https://github.com/langchain4j/langchain4j)
- [MyBatis](https://mybatis.org/mybatis-3/)

---

<div align="center">
  <p>用AI重新定义代码开发体验</p>
  <p>© 2025 智码零界团队. 保留所有权利.</p>
</div>