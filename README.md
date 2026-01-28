# Sistema de Automatización de Documentos para el Departamento de Orientación

## 📌 Descripción del Proyecto

Este proyecto consiste en el desarrollo de una aplicación web destinada a **automatizar la gestión y generación de documentos** del **Departamento de Orientación de un centro educativo**.  

El objetivo principal es facilitar y agilizar tareas administrativas repetitivas, permitiendo al personal del departamento crear, almacenar y consultar documentos de manera eficiente mediante una plataforma web intuitiva.

Este trabajo se realiza como **proyecto de prácticas de 1º Desarrollo de Aplicaciones Multiplataforma (DAM)**.

---

## 👨‍💻 Autores

- **Martín Hernández Fernández**
- **Manuel Barrera Baena**

---

## 🎯 Objetivos del Proyecto

- Automatizar la creación de documentos utilizados en el departamento de orientación.
- Centralizar el almacenamiento de información en una base de datos.
- Facilitar la consulta y gestión de registros.
- Desarrollar una interfaz web sencilla e intuitiva.
- Aplicar los conocimientos adquiridos en el primer curso de DAM.

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
- **Thymeleaf**
- **MySQL**
- **HTML / CSS / Bootstrap**
- **Maven**

---

## ⚙️ Funcionalidades Principales

- Gestión de usuarios (orientadores / administradores).
- Creación automática de documentos orientativos.
- Almacenamiento de datos en base de datos MySQL.
- Visualización y descarga de documentos generados.
- Interfaz web responsive.

*(Las funcionalidades pueden ampliarse según el progreso del proyecto.)*

---

## 🗄️ Base de Datos

El sistema utiliza **MySQL** para almacenar:

- Usuarios del sistema.
- Registros de estudiantes.
- Documentos generados.
- Historial de operaciones.

---

## 🚀 Instalación y Ejecución

### Requisitos previos

- Java JDK 17 o superior  
- MySQL Server  
- Maven  
- IDE recomendado: IntelliJ IDEA o Eclipse

### Pasos

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/nombre-del-repositorio.git
Crear la base de datos en MySQL:

CREATE DATABASE orientacion_db;
Configurar el archivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/orientacion_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
Ejecutar el proyecto:

mvn spring-boot:run
Acceder desde el navegador:

http://localhost:8080
📅 Estado del Proyecto
🔧 En desarrollo — Proyecto en fase de construcción como práctica académica.

📚 Documentación
La documentación técnica y funcional se incluirá progresivamente en la carpeta /docs.

🏫 Contexto Académico
Proyecto realizado para la asignatura de Programación / Entornos de Desarrollo
Ciclo Formativo de Grado Superior: Desarrollo de Aplicaciones Multiplataforma (DAM)
Curso: 1º DAM

📄 Licencia
Este proyecto se desarrolla con fines educativos.
Uso libre para aprendizaje y demostración académica.

⭐ Agradecimientos
A los docentes del ciclo DAM por la guía y apoyo durante el desarrollo del proyecto.

