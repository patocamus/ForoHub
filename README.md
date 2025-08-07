# 🧠 ForoHub API

API REST construida con **Spring Boot**, diseñada para gestionar tópicos en un foro educativo, con funcionalidades completas de autenticación JWT, seguridad con Spring Security, y persistencia en base de datos MySQL utilizando migraciones con Flyway.

---

## 🚀 Tecnologías utilizadas

- ✅ Java 17
- ✅ Spring Boot 3
- ✅ Spring Web
- ✅ Spring Data JPA
- ✅ Spring Security
- ✅ JWT (JSON Web Token)
- ✅ MySQL
- ✅ Flyway (Migraciones)
- ✅ Maven
- ✅ Lombok

---

## 📚 Funcionalidades principales

- 🔐 Autenticación de usuarios con JWT
- ✅ Registro de nuevos tópicos
- 📄 Listado y detalle de tópicos
- ✏️ Actualización de tópicos
- 🗑️ Eliminación de tópicos
- 🔍 Filtros por curso y orden cronológico (opcional)
- ⚙️ Gestión de usuarios, cursos y respuestas (estructurado)

---

## 🛠️ Configuración inicial

### 🔧 Requisitos

- Java 17+
- Maven
- MySQL

### 🧱 Crear base de datos

En tu cliente de MySQL, creá la base vacía:

```sql
CREATE DATABASE forohub_api;
```

---
##  Configuración de entorno
📁 `src/main/resources/application.properties:`
```
# Base de datos
spring.datasource.url=jdbc:mysql://localhost/forohub_api
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

# JPA
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Flyway
spring.flyway.enabled=true

# Seguridad JWT
api.security.secret=${JWT_SECRET:123456}

# Errores
server.error.include-stacktrace=never

```

---
## 🧪 Cómo ejecutar el proyecto
1.Cloná el repositorio:
```
git clone https://github.com/tu-usuario/forohub-api.git
cd forohub-api
```

2. Asegurate de tener la base de datos creada.
3. Ejecutá el proyecto:
```
./mvnw spring-boot:run
```
4. Flyway aplicará las migraciones automáticamente ✅
---
## 🔐 Autenticación
Para acceder a los endpoints protegidos, primero obtené un token JWT:

### 📥 Endpoint de login
POST `/login`

#### Body (JSON)
```
{
  "login": "correo@ejemplo.com",
  "clave": "123456"
}
```
#### Respuesta
```
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

Usá este token en los headers con: `Authorization: Bearer TU_TOKEN`

---
## 🧾 Endpoints principales
| Método | URI             | Descripción              |
| ------ | --------------- | ------------------------ |
| POST   | `/topicos`      | Crear nuevo tópico       |
| GET    | `/topicos`      | Listar todos los tópicos |
| GET    | `/topicos/{id}` | Ver detalle de un tópico |
| PUT    | `/topicos/{id}` | Actualizar un tópico     |
| DELETE | `/topicos/{id}` | Eliminar un tópico       |


Todos los endpoints requieren autenticación con JWT.

---
## 📂 Estructura del proyecto
```
src
└── main
    ├── java
    │   └── com.aluracursos.foro.api
    │       ├── controller
    │       ├── domain
    │       │   ├── topico
    │       │   ├── curso
    │       │   ├── usuario
    │       │   ├── respuesta
    │       │   └── perfil
    │       ├── infra.security
    │       └── ...
    └── resources
        ├── application.properties
        └── db/migration/
```

---
## 📦 Instalación en producción
1. Configurar application-prod.properties
2. Establecer spring.profiles.active=prod
3. Configurar base de datos y JWT_SECRET como variables de entorno
4. Compilar con Maven:
```
./mvnw clean package
```
5. Ejecutar el .jar generado:
```
java -jar target/api-0.0.1-SNAPSHOT.jar
```
