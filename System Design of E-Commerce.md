# System Design in E-Commerce?

A Complete **bluprint** of the entire E-Commerce application

- Define required microservices
- Decides where and how data will be stored
- Explains how services communicate
- Ensures performance, throughput, reliability
- Handles concurrency & consistency
- Plans system scaling
- Prepares failure recovery strategy

# E-Commerce Microservices Overview

**Core Business Microservices:**

- User Service
- Product Catalog Service
- Inventory Service
- Cart Service
- Order Service
- Payment Service
- Shipping Service

**Auxiliary Microservices**

- Notification Service
- Review & Rating Service
- Search Service
- Recommendation Service
- Coupon / Discount Service
- Analytics Service
- Admin Service

# Communication Between Microservices

- Synchronous Communication
- Asynchronous Communication

**Synchronous Communication:**

- Service waits for immediate response
- Request -> Response flow
- **Use Cases:** Login, Add to Cart, Payment initiation, Stock check
- **Protocols:** HTTP/REST, gRPC
- **Cons:** High dependency, not good for heavy traffic

**Asynchronous Communication:**

- Service does not wait for response
- Event publish -> Event consume
- Best for background processing
- **Use Cases:** Notifications, Inventory update, Search indexing
- **Technologies:** Kafka, RabbitMQ, ActiveMQ, SNS/SQS
- **Cons:** Complex debugging, event loss/duplication risks

# How E-Commerce Services Communicate

**API Gateway**

- Single entry point for all client requests
- Client never call microservices directly

**Service Registry**

- Kepps track of all running services with their IP/Port
- Supports auto-registration of services at startup
- Enables dynamic load balancing across multiple instances

**Eventual Consistency**

- Services don't stay instantly consistent
- **Huge traffic:** orders, views, updates
- Instant consistency slow the system
- Avoids checkout delays and failures
