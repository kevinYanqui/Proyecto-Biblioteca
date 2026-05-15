#  Sistema de Gestión de Biblioteca (Backend)

Este es un proyecto académico de fin de curso que consiste en una API robusta para la gestión de una biblioteca. Permite el control total del inventario de libros y la administración de usuarios mediante roles de seguridad.

##  Características principales
* **Gestión de Inventario:** Control de libros, autores, categorías y editoriales.
* **Sistema de Usuarios:** Registro y autenticación segura para Administradores y Lectores.
* **Préstamos y Reservas:** Flujo completo desde la reserva de un ejemplar hasta la generación del préstamo y su historial.
* **Seguridad:** Implementación de Spring Security con encriptación de contraseñas.
* **Búsqueda Avanzada:** Filtros dinámicos por título, autor o editorial.

##  Tecnologías utilizadas
* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.3.0
* **Persistencia:** Spring Data JPA / Hibernate
* **Seguridad:** Spring Security (BCrypt)
* **Base de Datos:** MySQL
* **Gestor de Dependencias:** Maven
* **Plantillas (opcional):** Thymeleaf

##  Requisitos previos
* JDK 17 o superior.
* Servidor MySQL activo.
* Crear una base de datos llamada `probiblioteca`.

##  Configuración
Los parámetros de conexión a la base de datos se encuentran en el archivo:
`src/main/resources/application.properties`

##  Nota Académica
Este proyecto fue desarrollado como parte de mi formación en Ingeniería de Sistemas e Informática, demostrando el uso de arquitecturas limpias y el manejo de seguridad en aplicaciones web empresariales.
