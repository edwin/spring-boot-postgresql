# Spring Boot PostgreSQL Demo

A simple Spring Boot application demonstrating integration with PostgreSQL database for managing customer data.

## Technologies Used

- Java 21
- Spring Boot 3.5.9
- Spring Data JPA
- PostgreSQL 42.7.7
- Lombok
- OpenTelemetry for observability
- Maven

## Prerequisites

- JDK 21
- Maven 3.6+
- PostgreSQL database server
- Docker (optional, for containerized deployment)

## Project Structure

```
src/main/java/com/edw/
├── Main.java                  # Application entry point
├── controller/
│   └── CustomerController.java # REST API endpoints
├── model/
│   └── Customer.java          # JPA entity
├── repository/
│   └── CustomerRepository.java # Data access layer
└── service/
    └── CustomerService.java   # Business logic layer
```

## Database Schema

The application uses a simple database schema with a single table:

- `t_customer`: Stores customer information
  - `customer_id`: Primary key, auto-generated
  - `customer_name`: Customer's name

## Setup and Installation

### Database Setup

1. Create a PostgreSQL database named `test_db`:

```sql
CREATE DATABASE test_db;
```

2. The application will automatically create the required tables on startup.

### Application Configuration

The application can be configured using environment variables or by modifying the `application.properties` file:

```properties
# Server configuration
server.port=${HTTP_PORT:8080}
spring.application.name=spring-boot-postgresql

# Database configuration
spring.datasource.url=${JDBC_URL:jdbc:postgresql://localhost:5432/test_db}
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=${JDBC_USERNAME:postgres}
spring.datasource.password=${JDBC_PASSWORD:postgres}

# Logging configuration
logging.level.root=INFO
logging.level.com.edw=${LOG_LEVEL:DEBUG}

# OpenTelemetry configuration
otel.exporter.otlp.endpoint=${OTEL_URL:http://192.168.8.140:4317}
otel.exporter.otlp.protocol=grpc
```

### Building the Application

```bash
mvn clean package
```

### Running the Application

```bash
java -jar target/spring-boot-postgresql-1.0-SNAPSHOT.jar
```

Or using Maven:

```bash
mvn spring-boot:run
```

### Docker Deployment (Distroless)

The application can be deployed using a distroless Docker image for improved security and smaller image size.

1. Build the application:
```bash
mvn clean package
```

2. Build the Docker image:
```bash
docker build -f Dockerfile.distroless -t spring-boot-postgresql:distroless .
```

3. Run the container:
```bash
docker run -p 8080:8080 \
  -e JDBC_URL=jdbc:postgresql://host.docker.internal:5432/test_db \
  -e JDBC_USERNAME=postgres \
  -e JDBC_PASSWORD=postgres \
  spring-boot-postgresql:distroless
```

Note: When running in Docker, use `host.docker.internal` instead of `localhost` to connect to services on the host machine.

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /        | Retrieve all customers sorted by ID |

## Environment Variables

The application supports the following environment variables for configuration:

| Variable       | Description                      | Default Value                      |
|----------------|----------------------------------|-----------------------------------|
| HTTP_PORT      | Server port                      | 8080                              |
| JDBC_URL       | PostgreSQL connection URL        | jdbc:postgresql://localhost:5432/test_db |
| JDBC_USERNAME  | Database username                | postgres                          |
| JDBC_PASSWORD  | Database password                | postgres                          |
| LOG_LEVEL      | Logging level for the application| DEBUG                             |
| OTEL_URL       | OpenTelemetry collector endpoint | http://192.168.8.140:4317         |

## Author

Muhammad Edwin < edwin at redhat dot com >
