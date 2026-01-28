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


---

### 💡 Sugerencia extra
Si quieres, también puedo:
- Crearos un **logo simple** para el proyecto.
- Generar un **diagrama de base de datos**.
- Adaptar el README a un tono más formal o más breve.

Solo dime cómo lo prefieres 🙂
Tú dijiste:
otros de los objetivos es mantener el anonimato de los alumnos manteniendo datos sensibles fuera de la base de datos
ChatGPT Plus
¡Perfecto! Añadimos ese objetivo, que además es muy bueno y profesional 👌
Aquí tienes el README actualizado, incorporando el objetivo de protección de datos y anonimato del alumnado.
Puedes reemplazar tu README anterior por este.

# Sistema de Automatización de Documentos para el Departamento de Orientación

## 📌 Descripción del Proyecto

Este proyecto consiste en el desarrollo de una aplicación web destinada a **automatizar la gestión y generación de documentos** del **Departamento de Orientación de un centro educativo**.

El sistema busca facilitar tareas administrativas repetitivas, permitiendo al personal del departamento crear, almacenar y consultar documentos de forma eficiente mediante una plataforma web intuitiva.  

Un aspecto clave del proyecto es la **protección de datos personales**, garantizando el **anonimato del alumnado** y evitando el almacenamiento de información sensible en la base de datos.

Proyecto realizado como **trabajo de prácticas de 1º Desarrollo de Aplicaciones Multiplataforma (DAM)**.

---

## 👨‍💻 Autores

- **Martín Hernández Fernández**
- **Manuel Barrera Baena**

---

## 🎯 Objetivos del Proyecto

- Automatizar la creación de documentos del departamento de orientación.
- Centralizar la gestión documental en una base de datos.
- Facilitar la consulta y organización de registros.
- Desarrollar una interfaz web clara e intuitiva.
- Mantener el **anonimato del alumnado**, evitando almacenar datos sensibles.
- Aplicar principios básicos de **protección de datos y privacidad**.
- Poner en práctica conocimientos adquiridos en 1º DAM.

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

- Gestión de usuarios autorizados (orientadores / administradores).
- Generación automatizada de documentos.
- Almacenamiento estructurado de información no sensible.
- Consulta de documentos generados.
- Sistema diseñado para no almacenar datos personales del alumnado.
- Interfaz web responsive.

*(Las funcionalidades podrán ampliarse según la evolución del proyecto.)*

---

## 🔒 Protección de Datos y Privacidad

El sistema ha sido diseñado teniendo en cuenta principios básicos de protección de datos:

- No se almacenan nombres, DNI ni datos personales del alumnado.
- Los documentos se generan mediante identificadores internos anónimos.
- La base de datos solo contiene información necesaria para la gestión.
- Se evita el tratamiento de datos sensibles conforme a buenas prácticas de privacidad.

---

## 🗄️ Base de Datos

La base de datos MySQL almacena:

- Usuarios del sistema.
- Identificadores anónimos de registros.
- Metadatos de documentos generados.
- Historial de operaciones.

---
