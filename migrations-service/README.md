# migrations-service

A small Spring Boot microservice that manages the **PostgreSQL database schema** using **Flyway**.

On startup, it connects to the database and automatically applies any new SQL migrations,
keeping the schema up to date and versioned. Once the migrations are done, the application stops.

## Tech stack

- Java 17
- Flyway
- PostgreSQL
- Docker Compose (local database)
- Testcontainers (integration tests)

## How it works

- SQL migrations live in `src/main/resources/db/migration`
- Each file follows the Flyway naming convention: `V<version>__<description>.sql`
- Flyway tracks applied migrations in the `flyway_schema_history` table
- Applied migrations must **never be modified**: create a new migration file instead

## Running locally

Requirements: Docker running.

```bash
./mvnw spring-boot:run
```

Spring Boot starts the PostgreSQL container defined in `compose.yaml` and applies the migrations.
