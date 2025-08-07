# AI Code Mother Web

AI Code Mother Web (智码零界) is an AI-powered code generation platform built with Vue 3 and TypeScript. This platform aims to help developers generate code using AI technologies.

## Project Overview

This is a frontend application for an AI code generation platform based on Spring Boot 3 + LangChain4j + Vue 3. The platform is designed to provide enterprise-level AI code generation capabilities.

![Architecture Overview](https://picbed-chengfu-1327906653.cos.ap-guangzhou.myqcloud.com/image/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202025-07-25%20135511.webp)

## Features

- Modern UI built with Vue 3 and Ant Design Vue
- TypeScript for type safety
- API integration with backend services
- User authentication system
- Responsive layout

## Tech Stack

- **Vue 3**: Progressive JavaScript framework
- **TypeScript**: Typed JavaScript
- **Vite**: Next generation frontend tooling
- **Pinia**: State management
- **Vue Router**: Official router for Vue.js
- **Ant Design Vue**: UI component library
- **Axios**: Promise based HTTP client

## Project Structure

```
ai-code-mother-web/
├── public/                 # Static assets
├── src/
│   ├── api/                # API integration
│   ├── assets/             # Images, fonts, etc.
│   ├── components/         # Reusable Vue components
│   ├── layouts/            # Layout components
│   ├── pages/              # Page components
│   ├── router/             # Vue Router configuration
│   ├── stores/             # Pinia stores
│   ├── App.vue             # Root component
│   ├── main.ts             # Application entry point
│   └── request.ts          # Axios configuration
├── index.html              # HTML entry point
├── vite.config.ts          # Vite configuration
├── tsconfig.json           # TypeScript configuration
└── package.json            # Project dependencies and scripts
```

## Getting Started

### Prerequisites

- Node.js (v16 or higher)
- npm or yarn

### Installation

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd ai-code-mother-web
   ```

2. Install dependencies:

   ```bash
   npm install
   # or
   yarn install
   ```

3. Start the development server:

   ```bash
   npm run dev
   # or
   yarn dev
   ```

4. Open your browser and navigate to `http://localhost:5173`

### API Integration

The project is configured to connect to a backend API running at `http://localhost:8123/api`. You can generate API client code using the OpenAPI generator:

```bash
node openapi.config.js
```

This will generate TypeScript API clients based on the OpenAPI specification provided by the backend.

## Available Scripts

- `npm run dev` - Start the development server
- `npm run build` - Build the application for production
- `npm run preview` - Preview the production build locally
- `npm run type-check` - Run TypeScript type checking
- `npm run lint` - Lint the codebase
- `npm run format` - Format the codebase with Prettier

## Deployment

To build the application for production:

```bash
npm run build
```

The built files will be in the `dist` directory, which can be deployed to any static hosting service.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- [Chengfu](https://github.com/chengfushi)
- [Yike](https://github.com/camellialoveit)
