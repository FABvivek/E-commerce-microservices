# 🛒 E-Commerce Microservices Platform

A scalable, event-driven **E-commerce backend system** built using **Spring Boot Microservices**, featuring secure authentication, asynchronous communication, and distributed architecture.

---

## 🚀 Tech Stack

* **Backend:** Java, Spring Boot, Spring Cloud
* **Security:** Spring Security, JWT
* **Messaging:** Apache Kafka
* **Databases:** MySQL, MongoDB
* **Caching:** Redis
* **Service Discovery:** Eureka
* **API Gateway:** Spring Cloud Gateway
* **Containerization:** Docker, Docker Compose
* **Payment Integration:** Stripe

---

## 🏗️ Architecture Overview

This project follows a **microservices architecture**, where each service is independently deployed and communicates via REST APIs and Kafka events.

### Services:

* 🔐 **User Service** – Authentication & JWT generation
* 📦 **Product Service** – Product catalog (MongoDB)
* 🛒 **Cart Service** – Cart management (Redis)
* 📑 **Order Service** – Order processing (MySQL)
* 💳 **Payment Service** – Stripe integration & event publishing
* 📊 **Inventory Service** – Stock management (Kafka consumer)
* 🌐 **API Gateway** – Routing & security
* 🧭 **Eureka Server** – Service discovery

---

## 🔄 Workflow (End-to-End Flow)

1. User logs in → receives JWT token
2. User adds items to cart (Redis)
3. User places order → stored in Order Service
4. Payment is initiated via Stripe
5. On payment success → event published to Kafka
6. Inventory Service consumes event → reduces stock
7. Order status updated → response returned

---

## 🔐 Authentication & Authorization

* JWT-based authentication
* Role-based access control (USER / ADMIN)
* Secured endpoints using Spring Security

---

## ⚡ Kafka Event Flow

* **Producer:** Payment Service
* **Topic:** `payment-events`
* **Consumer:** Inventory Service

Ensures:

* Loose coupling
* Asynchronous processing
* Scalability

---

## 🧠 Key Concepts Used

* Microservices Architecture
* Event-Driven Design
* Idempotent Consumers
* Distributed Systems
* REST APIs
* Caching with Redis

---

## 🐳 Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git
cd ecommerce-microservices
```

### 2. Start all services using Docker

```bash
docker-compose up -d
```

### 3. Start services manually (if not using Docker)

Run each Spring Boot service individually.

---

## 🧪 Testing APIs

Use Postman:

* Login → get JWT
* Add product
* Add to cart
* Place order
* Trigger payment
* Verify inventory update

---

## 📌 Future Improvements

* Add notification service (email/SMS)
* Implement retry & dead-letter queues
* Add API rate limiting
* Deploy on AWS / Kubernetes

---



Give it a ⭐ on GitHub!
