# progetto-email

A Spring Boot 4 project built as a Maven multi-module monorepo.

## Modules

| Module | Type | What it does |
|---|---|---|
| `xmail-migrations` | library | Flyway SQL migrations for the PostgreSQL database |
| `xmail-model` | library | Shared model classes |
| `customer-service` | service | Customer service (work in progress) |

Libraries are not started on their own: services import them as dependencies.
When `customer-service` starts, Flyway applies the migrations from `xmail-migrations`.

## Key decisions

- **Versioned database schema**: every change is a Flyway migration. Applied migrations are never edited.
- **Real database in tests**: tests use Testcontainers with PostgreSQL, not mocks or H2.
- **Safe schema changes**: new required columns are added in two steps (add and fill, then make them required), so old and new code can run together during a release.
- **Internal ID + public UUID**: an integer primary key inside the database, a UUID for the outside world.

## Build and test

Requirements: Java 17, Docker running.

```bash
./mvnw clean verify
```

## Run

```bash
./mvnw clean install -DskipTests
./mvnw -pl customer-service spring-boot:run
```

Spring Boot starts PostgreSQL with Docker Compose (`customer-service/compose.yaml`).

## CI

Every push and pull request runs build, tests and a SonarCloud analysis with GitHub Actions.
`main` is protected: changes arrive only through pull requests with a passing build.