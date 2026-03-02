外卖平台系统 (takeaway-platform)
一款基于前后端分离架构开发的外卖平台系统，覆盖用户点餐、商家运营、骑手配送、平台管理全核心流程，适配本地生活服务场景的一站式解决方案。
项目简介
本系统采用主流开源技术栈构建，前端聚焦用户交互体验，后端保障业务逻辑稳定与可扩展，支持多角色（用户 / 商家 / 骑手 / 平台管理员）协同操作，满足外卖平台从日常运营到后台管控的全场景需求。
技术栈
前端 (elmclient)
核心框架：Vue.js (Vue 2/Vue 3)
路由管理：Vue Router
状态管理：Vuex/Pinia
网络请求：Axios
UI 组件库：Element UI/Element Plus
构建工具：npm/yarn + Webpack/Vite
后端 (elma_admin)
核心框架：Spring Boot
Web 框架：Spring MVC
权限控制：Spring Security
数据持久化：MyBatis/MyBatis-Plus
数据库：MySQL
构建工具：Maven
可选扩展：Redis（缓存）、RabbitMQ（消息队列）、OSS（文件存储）
数据库
脚本文件：elm.sql（包含完整表结构 + 初始测试数据）
项目结构
plaintext
takeaway-platform/
├── elmclient/          # 前端客户端模块（用户/商家/骑手端界面）
├── elma_admin/         # 后端服务模块（接口提供+后台管理）
├── elm.sql             # 数据库初始化脚本
└── README.md           # 项目说明文档
商家端
店铺信息管理（基本信息、营业时间、配送范围）
菜品管理（分类、上下架、价格 / 库存调整）
订单管理（接单、拒单、订单状态更新）
营收数据统计
快速部署
前置条件
前端：Node.js (v14+)、npm/yarn
后端：JDK 8+/11+、Maven 3.6+
数据库：MySQL 5.7+/8.0+
步骤
数据库初始化
sql
-- 登录MySQL后执行
source /path/to/elm.sql;
后端启动
bash
运行
cd elma_admin
mvn clean package
java -jar target/elma_admin-1.0.0.jar
# 或直接通过IDE启动Spring Boot主类
前端启动
bash
运行
cd elmclient
npm install  # 安装依赖
npm run serve  # 开发环境启动
# 生产环境打包：npm run build
访问地址
前端：http://localhost:8080（默认，可在 vue.config.js 调整）
后端接口：http://localhost:8081（默认，可在 application.yml 调整）
后台管理：http://localhost:8081/admin
开发规范
前端：遵循 Vue 官方编码规范，组件化开发，统一 API 请求封装
后端：遵循 RESTful 接口设计，分层架构（Controller/Service/Mapper），统一异常处理
数据库：命名规范统一，核心表添加索引，重要操作记录日志
