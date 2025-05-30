# 🧾 Proyecto: Transformación Digital - Perfulandia SPA


Este repositorio contiene el desarrollo técnico del sistema basado en microservicios para la empresa Perfulandia SPA, como parte de la Evaluación Parcial 2 de la asignatura **Desarrollo Full Stack I**.

## 📦 Descripción General del Proyecto

> Nuestro sistema es una arquitectura basada en microservicios, compuesta por 4 microservicios independientes que se comunican entre sí para gestionar diferentes funciones de perfulandia, Antes todo estaba en un sistema monolítico donde todas las funcionalidades estaban juntas en una sola aplicación, lo que causaba varios problemas como
> 
> -lentitud
> -dificil mantencion
> entre otros.
> y tenemos beneficios como:
> 
> -Escalabilidad
> -Modularidad
> -Despliegue rapido

## 🧩 Arquitectura de Microservicios

> 📝 Describir cómo está estructurado el sistema en microservicios. Pueden incluir un diagrama y explicar brevemente la función de cada servicio.

### Microservicios Desarrollados

- `usuarioservice`: > 📝 Registra los usuarios del sistema.
- `productservice`: > 📝 Almacena el stock de perfumes de perfulandia.
- `carritoservice`: > 📝 Registra los productos por comprar.
- `notificacionservice`: > 📝 Notifica las creacion de un carrito.

## 🛠️ Tecnologías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo de los microservicios
- **Maven**: Herramienta de gestión de dependencias y construcción de proyectos
- **MySQL**: Sistema de gestión de bases de datos relacionales
- **Postman**: Herramienta para pruebas y documentación de APIs
- **GitHub**: Plataforma de control de versiones y colaboración en el código

## 🗄️ Configuración de Bases de Datos

> 📝 Indicar qué motor de base de datos usaron, cómo configuraron la conexión (`application.properties`), y qué tablas y campos definieron para cada microservicio.

## 📮 Endpoints y Pruebas

> 📝 Especificar los principales endpoints disponibles por microservicio (CRUD y llamadas entre servicios).  
> Incluir capturas o descripciones de pruebas realizadas con Postman (mínimo 3 por micro-servicio).

## 🧑‍💻 Integrantes del Equipo

> 📝 Indicar nombre completo y rol de cada integrante del equipo.

| Nombre                  | Rol en el proyecto         | Servicio principal trabajado |
|-------------------------|----------------------------|------------------------------|
| Alvaro Uribe | (Repositorio - Carrito)   | carritoservice           |
| Juan Toledo | (Carrito - Notificaciones)   | usuarioservice              |
| Nicolas Hölck | (Notificaciones) | notificacionservice     |

## 📂 Estructura del Repositorio

El repositorio está organizado con cada microservicio en su propia carpeta independiente, cada uno con su configuración y dependencias específicas:

```
📦 Perfulandia-microservices/
├── 🛒 carritoservice/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   └── README.md
├── 🔔 notificacionservice/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   └── README.md
├── 📦 productservice/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   └── README.md
├── 👤 usuarioservice/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   ├── pom.xml
│   └── README.md
├── LICENSE
└── README.md
```

Cada microservicio es un proyecto Spring Boot independiente con:
- **Estructura Maven estándar**: Organización de código fuente, recursos y pruebas
- **Configuración independiente**: Cada servicio tiene su propio `application.properties`
- **Base de datos específica**: Cada microservicio gestiona su propio esquema de datos
- **APIs REST**: Endpoints específicos para las funcionalidades de cada dominio

## 👥 Colaboración en GitHub

> 📝 Explicar cómo se organizó el trabajo en ramas (`master`, `pruebas`), frecuencia de commits y cómo se coordinaron como equipo.

## 📈 Lecciones Aprendidas

> 📝 Reflexionar brevemente sobre qué aprendieron durante el desarrollo del proyecto (técnico y en trabajo en equipo).

---

[Guía Oficial en Notion – Evaluación Parcial 2 (35%)](https://quilt-canary-969.notion.site/Gu-a-Oficial-Evaluaci-n-Parcial-2-35-1f75b3c4e31280aaab79c9a71f1cfb7b?pvs=4)
