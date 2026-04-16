# Reservas de Hotel Seguro

## 🚀 API REST - Gestión de Hoteles, Clientes y Reservas

Aplicación Spring Boot para gestionar reservas de hoteles con PostgreSQL.

[![Java](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-green.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-Central-orange.svg)](https://maven.apache.org/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16%2B-lightblue.svg)](https://www.postgresql.org/)

## 📋 Características
- **CRUD** completo para Clientes, Hoteles y Reservas
- **Relaciones**: Many-to-One (Reservas → Hotel/Cliente)
- **Validaciones** JSR-303 (@NotNull, @NotBlank, etc.)
- **API REST** con JSON Snake Case
- **PostgreSQL** database

## 🛠️ Prerrequisitos
- **Java 17+** (SDK)
- **Maven 3.8+**
- **PostgreSQL 13+** (con `createdb` y `psql` en PATH)
- **IDE** (VS Code con Extension Pack for Java / IntelliJ)

## 🗄️ Configuración de Base de Datos

1. **Crear base de datos**:
   ```bash
   createdb -U postgres hotel_reservas
   ```

2. **Ejecutar schema** (incluye datos de prueba):
   ```bash
   psql -U postgres -d hotel_reservas -f hotel_reservas.sql
   ```

3. **Verificar**:
   ```sql
   \\dt  -- Lista tablas
   SELECT * FROM clientes;
   SELECT * FROM hoteles;
   SELECT * FROM reservas;
   ```

**Config DB** (`src/main/resources/application.properties`):
```
spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_reservas
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update  # update/create en dev
```

## 📦 Instalación de Dependencias

```bash
mvn clean install
```

**Dependencias principales** (`pom.xml`):
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- postgresql (runtime)
- spring-boot-starter-validation

## ▶️ Ejecutar el Proyecto

```bash
mvn spring-boot:run
```

**Puerto**: `http://localhost:8080`

## 🌐 Endpoints de la API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/clientes` | Listar clientes |
| `POST` | `/api/clientes` | Crear cliente |
| `GET` | `/api/clientes/{id}` | Obtener cliente |
| `PUT` | `/api/clientes/{id}` | Actualizar |
| `DELETE` | `/api/clientes/{id}` | Eliminar |
| `GET` | `/api/hoteles` | Listar hoteles |
| `POST` | `/api/hoteles` | Crear hotel |
| ... | (similares para `/hoteles`, `/reservas`) | ... |

**Ejemplo POST Cliente**:
```bash
curl -X POST http://localhost:8080/api/clientes \\
  -H "Content-Type: application/json" \\
  -d '{\"nombre\":\"Ana Garcia\",\"email\":\"ana@example.com\",\"telefono\":\"555-0303\"}'
```

## 🧪 Pruebas

```bash
mvn test
```

## 📁 Estructura del Proyecto
```
.
├── pom.xml
├── hotel_reservas.sql      ← Schema SQL
├── README.md              ← Este archivo
├── src/
│   ├── main/java/seguro/seguro/
│   │   ├── SeguroApplication.java
│   │   ├── controller/     ← ClienteController, HotelController, ReservasController
│   │   ├── model/         ← Cliente, Hotel, Reservas (@Entity)
│   │   ├── repository/    ← JpaRepository interfaces
│   │   └── service/       ← Business logic
│   └── main/resources/
│       ├── application.properties  ← Config DB/Port
│       └── static/templates/
└── target/
```

## 🔧 Configuraciones Adicionales

- **Puerto**: Cambiar `server.port=8080` en `application.properties`
- **DB Prod**: Actualizar URL/credentials
- **ddl-auto**: `validate` en producción
- **Logging**: `spring.jpa.show-sql=true`
