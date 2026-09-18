# Lab 03 - Gestión de usuarios

Aplicacion web para el Laboratorio N.° 03 de Diseño de Software. El proyecto
usara Spring Boot, PostgreSQL y Docker para cubrir autenticacion y CRUD de
usuarios.

## Requisitos

- Java 11 o superior
- Docker Desktop

## Inicio rápido

```powershell
docker compose up --build
```

Abrir `http://localhost:8080/login` y usar las credenciales iniciales:

- Usuario: `admin`
- Contrasena: `admin123`

La aplicación crea automaticamente la tabla `usuarios` y el usuario inicial.
Las contrasenas se guardan usando BCrypt.

## Ejecucion local

Con PostgreSQL ejecutandose en Docker, se puede iniciar la aplicacion desde
la clase `SoftwareDesignApplication` en VS Code o IntelliJ. Maven debe estar
disponible en el entorno local para ejecutar el ciclo de vida del proyecto.

## Estructura

```text
src/main/java/com/lab03/softwaredesign
auth/       Controlador de login
security/   Configuracion y usuario inicial
user/       Entidad, repositorio, servicio y CRUD
src/main/resources
templates/  Vistas Thymeleaf
static/     Estilos CSS
Dockerfile
docker-compose.yml
```
