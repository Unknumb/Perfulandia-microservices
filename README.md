# 🧾 Proyecto: Transformación Digital - Perfulandia SPA


Este repositorio contiene el desarrollo técnico del sistema basado en microservicios para la empresa Perfulandia SPA, como parte de la Evaluación Parcial 2 de la asignatura **Desarrollo Full Stack I**.

## 📦 Descripción General del Proyecto

Nuestro sistema es una arquitectura basada en microservicios, compuesta por 4 microservicios independientes que se comunican entre sí para gestionar diferentes funciones de perfulandia, Antes todo estaba en un sistema monolítico donde todas las funcionalidades estaban juntas en una sola aplicación, lo que causaba varios problemas como
 -lentitud

 -dificil mantencion
 y tenemos beneficios como:
 
 -Escalabilidad

-Modularidad

-Despliegue rapido

## 🧩 Arquitectura de Microservicios



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

En el desarrollo del sistema, cada microservicio fue diseñado para trabajar con su propia base de datos independiente, siguiendo la arquitectura de microservicios para asegurar la separación de responsabilidades y el aislamiento de datoss.

## Uso de forma local
Despues de la configuracion y creacion de la base de datos local, ejecutar el proyecto y usar este link de referancia para ingresar a pagina de swagger:  http://localhost:8080/swagger-ui.html

## 1️⃣ Motor de Base de Datos
Se utilizó MySQL como motor de base de datos para todos los microservicios.
La elección se basó en:
su compatibilidad con Spring Boot, su facilidad de uso en entornos de desarrollo locales, y su robustez y soporte para operaciones transaccionales.


## 📮 Endpoints y Pruebas

A continuación se presentan los principales endpoints disponibles por microservicio, junto con ejemplos de pruebas realizadas en Postman:

### 🛒 CarritoService (Puerto 8081)

#### **GET** `/api/usuarios/carrito/{id}` - Consultar Carrito desde Usuario
Este endpoint permite consultar el carrito asociado a un usuario específico, mostrando la comunicación entre el servicio de usuarios y el servicio de carrito.

**Ejemplo de solicitud:**
```
GET http://localhost:8081/api/usuarios/carrito/2
```

**Respuesta:**
```json
{
  "id": 2,
  "usuarioId": 1,
  "productoIds": [1, 2],
  "total": 176666.0
}
```



---

### 📦 ProductService (Puerto 8082)

#### **GET** `/api/productos/usuario/{id}` - Consultar Producto desde Usuario
Este endpoint demuestra la integración entre microservicios, permitiendo consultar información de productos desde el contexto de un usuario.

**Ejemplo de solicitud:**
```
GET http://localhost:8082/api/productos/usuario/2
```

**Respuesta:**
```json
{
  "id": 2,
  "nombre": "Ana López",
  "correo": "ana@perfulandia.com",
  "rol": "CLIENTE"
}
```



---

### 👤 UsuarioService (Puerto 8081)

#### **POST** `/api/usuarios` - Agregar Usuario
Este endpoint permite crear nuevos usuarios en el sistema, validando los datos de entrada y almacenándolos en la base de datos.

**Ejemplo de solicitud:**
```
POST http://localhost:8081/api/usuarios
Content-Type: application/json

{
  "nombre": "Ana López",
  "correo": "ana@perfulandia.com",
  "rol": "CLIENTE"
}
```

**Respuesta:**
```json
{
  "id": 2,
  "nombre": "Ana López",
  "correo": "ana@perfulandia.com",
  "rol": "CLIENTE"
}
```



---

### 🔍 Características Destacadas de los Endpoints

- **Comunicación entre Microservicios**: Los endpoints demuestran cómo los servicios se comunican entre sí usando RestTemplate
- **Separación de Responsabilidades**: Cada microservicio maneja su dominio específico (usuarios, productos, carrito)
- **APIs RESTful**: Siguiendo las mejores prácticas REST para operaciones CRUD
- **Validación de Datos**: Los endpoints incluyen validación de entrada y manejo de errores
- **Respuestas JSON**: Formato estándar para intercambio de datos entre servicios y clientes

### ✅ Estados de Respuesta
- **200 OK**: Operaciones exitosas (GET, PUT)
- **201 Created**: Recursos creados exitosamente (POST)
- **400 Bad Request**: Datos de entrada inválidos
- **404 Not Found**: Recurso no encontrado
- **500 Internal Server Error**: Errores del servidor

---

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

### Estrategia de Ramificación
- **Rama `main`**: Código estable y funcional para producción
- **Desarrollo por microservicio**: Cada integrante trabajó principalmente en su servicio asignado
- **Commits directos**: Se realizaron commits directos desde nuestras propias ramas individuales  debido al trabajo independiente de cada microservicio

### Flujo de Trabajo
1. **Asignación de servicios**: Cada integrante se enfocó en desarrollar completamente su microservicio
2. **Desarrollo paralelo**: Trabajo simultáneo en diferentes servicios sin conflictos
3. **Commits regulares**: Actualización frecuente del progreso con mensajes descriptivos
4. **Coordinación**: Comunicación constante para asegurar compatibilidad entre servicios

### Organización del Equipo
- **Distribución clara**: Cada desarrollador responsable de un microservicio específico
- **Comunicación externa**: Coordinación a través de WhatsApp y reuniones presenciales
- **Sincronización**: Verificación de cambios antes de hacer push para evitar conflictos

## 📈 Lecciones Aprendidas

### Técnicas
- **Configuración de puertos**: Aprendimos la importancia de configurar puertos diferentes para cada microservicio (8080, 8081, 8082, 8083)
- **Gestión de dependencias**: Maven facilitó mantener las dependencias organizadas en cada proyecto independiente
- **Bases de datos separadas**: Cada microservicio necesita su propia configuración de BD para mantener la independencia
- **Testing con Postman**: La documentación y prueba sistemática de endpoints es fundamental para validar la funcionalidad

### Trabajo en Equipo
- **Comunicación constante**: Los microservicios requieren coordinación entre desarrolladores para las integraciones
- **Definición de APIs**: Acordar las interfaces entre servicios desde el inicio evita problemas posteriores
- **Trabajo paralelo**: GitHub permite que cada desarrollador trabaje en su servicio sin interferir con otros
- **Resolución de conflictos**: La comunicación previa antes de commits ayuda a evitar conflictos de merge

### Arquitectura de Microservicios
- **Independencia real**: Cada servicio puede desarrollarse, probarse y desplegarse por separado
- **Escalabilidad**: La arquitectura permite modificar un servicio sin afectar los demás
- **Mantenibilidad**: Es más fácil localizar y corregir errores cuando cada servicio tiene su responsabilidad específica
- **Comunicación entre servicios**: Aprendimos a implementar llamadas REST entre microservicios usando RestTemplate

---

[Guía Oficial en Notion – Evaluación Parcial 2 (35%)](https://quilt-canary-969.notion.site/Gu-a-Oficial-Evaluaci-n-Parcial-2-35-1f75b3c4e31280aaab79c9a71f1cfb7b?pvs=4)
