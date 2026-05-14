<<<<<<< HEAD
# 🛒 E-Commerce Backend API

A **production-style E-Commerce backend application** built with **Spring Boot**, providing secure REST APIs for authentication and product management.
The project demonstrates modern backend practices including **JWT authentication, Docker containerization, cloud deployment, and PostgreSQL integration**.

---

# 🌐 Live API

Swagger Documentation:
https://vcom-production.up.railway.app/swagger-ui/index.html

> ⚠️ The API may take **15–30 seconds to start** on the first request due to cold start on the free hosting tier.



# 🚀 Features

* User **Registration & Login**
* **JWT-based Authentication**
* Secure **REST API architecture**
* **Role-based authorization**
* **Product management APIs**
* Image storage using **PostgreSQL**
* API documentation with **Swagger UI**
* **Dockerized backend**
* **Cloud deployment on Railway**

# 🧰 Tech Stack

| Technology        | Usage                          |
| ----------------- | ------------------------------ |
| Java 21           | Backend programming            |
| Spring Boot       | REST API framework             |
| Spring Security   | Authentication & authorization |
| JWT               | Stateless authentication       |
| PostgreSQL        | Database                       |
| Spring Data JPA   | ORM layer                      |
| Docker            | Containerization               |
| Railway           | Cloud deployment               |
| Swagger / OpenAPI | API documentation              |


# 📦 API Endpoints

### Authentication

| Method | Endpoint                | Description       |
| ------ | ----------------------- | ----------------- |
| POST   | `/api/v1/auth/register` | Register new user |
| POST   | `/api/v1/auth/login`    | Authenticate user |

### Example Request

json
{
  "firstname": "John",
  "lastname": "Doe",
  "email": "john@example.com",
  "password": "password123"
}


# 📘 Swagger API Walkthrough

This project includes **interactive API documentation using Swagger UI**, allowing users to explore and test endpoints directly from the browser.

### Step 1 — Open Swagger

Visit:


https://vcom-production.up.railway.app/swagger-ui/index.html


### Step 2 — Register a User

1. Open **Auth Controller**
2. Click **POST `/api/v1/auth/register`**
3. Click **Try it out**
4. Enter:

json
{
  "firstname": "John",
  "lastname": "Doe",
  "email": "john@example.com",
  "password": "password123"
}


5. Click **Execute**

This creates a user account.



### Step 3 — Login

Open:


POST /api/v1/auth/login


Example request:

json
{
  "email": "john@example.com",
  "password": "password123"
}


Swagger will return a **JWT token**.


### Step 4 — Authorize Using JWT

1. Copy the JWT token
2. Click **Authorize** in Swagger
3. Enter:


Bearer YOUR_JWT_TOKEN


4. Click **Authorize**

You can now access **secured APIs**.

### Example Authorization Header


Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...

# 🏗️ Project Architecture

Controller
      ↓
Service Layer
      ↓
Repository Layer
      ↓
PostgreSQL Database


The project follows a **layered architecture**, separating business logic, persistence, and API layers for maintainability and scalability.



# 🐳 Docker Deployment

The application is containerized using Docker.

dockerfile
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]




 ☁️ Cloud Deployment

The backend is deployed on **Railway** using:

* Docker container
* Managed PostgreSQL database
* Environment variables for configuration

Deployment flow:


GitHub → Railway → Docker Build → Spring Boot Container → PostgreSQL



# 🔐 Security

* **JWT-based stateless authentication**
* **Spring Security filter chain**
* Protected endpoints requiring authentication
* Public endpoints for authentication & Swagger documentation



# 📂 Project Structure


src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── configuration
 └── security

# 💡 Future Improvements


* Role-based access control (Admin / User)

# 👨‍💻 Author

**Ram prasad**
Backend Developer | Java | Spring Boot 
⭐ If you found this project useful, consider giving it a star!



⭐ If you found this project useful, consider giving it a star!
=======
# E-Com
>>>>>>> e506f489ba74466f28aadfd29e1a065fa2fd623a
