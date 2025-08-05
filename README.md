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
