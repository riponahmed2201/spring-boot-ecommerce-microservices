# E-Commerce Application

# Introduction to Microservices Architecture

- Product Service
- Order Service
- Cart Service
- Inventory Service
- Auth Service
- Payment Service
- Notification Service
- API Gateway
- Service Registry
- Config Server
- Distributed Logging
- Event Messaging

# What Are Microservices?

- Small, independent deployable services
- Loosely Coupled Services
- Independent Deployment
- Independent Databases
- Separate Scaling
- Team-wise development
- Fault Isolation
- Example:
  - Amazon
  - Flipcart
  - meesho

- Microservices
  - Product Listing
  - Cart
  - Ordering
  - Payment
  - Delivery
  - Notifications
  - Search
  - User Account
- Monolith Codebase
  - Code heavy
  - Scaling problem
  - Bugs fix
  - Deployment risky
  - Team collaboration issue

# Microservices Communication Types

- Synchronous
  - **HTTP**
  - REST APIs
  - OpenFeign
  - Gateway routing

- Asynchronous
  - **Messaging**
    - Kafka
    - RabbitMQ

# Microservices in our Project

- Auth Service -> Registration, Login, JWT token, Role-based access
- Product Service -> Category, Search, Filter, Sorting
- Inventory Service -> Stock check, Stock update, quantity reduce
- Cart Service -> Add item, Remove item, Update quantity
- Order Service -> Place order, Inter-service communication, Order events
- Payment Service -> Payment verification, Payment events, Razorpay
- Notification Service -> Email/SMS notifications, Kafka consumer
- **Supporting Services**:
  - API Gateway
    - Centralized Routing
    - Authentication & Authorization Filters
    - Request throttling / rate limiting
    - Load balancing
    - Cross-cutting concerns
  - Service Registry
    - Eureka Server
  - Config Server
    - Spring Cloud Config Server
    - DB URL Config
    - Kafka Config
    - Email Config
    - JWT Secret
    - Login Cofig
    - Fearture Toggle
    - Rate Limit
  - Distributed Tracing
    - Spring Cloud Sleuth
    - Zipkin Server
  - Centralized Logging
    - ELK Stack (Elasticsearch + Logstash + Kibana)
    - Loki + Promtail
  - Message Broker
    - Event Driven Architecture.
    - Kafka
    - RabbitMQ

# Why Microservices for E-Commerce?

- High scalability
- Independent deployments
- Easy maintenance
- Team-wise work distribution
- Event-driven performance
- Real-world industry standards
