# TechShop Ecommerce - Proyecto Final

¡Hola! Este es mi proyecto final para el curso de Java de la academia BBVA (Xideral). Es una API REST que simula una tienda de electrónica, y lo que lo hace especial es cómo integra diferentes tecnologías que aprendimos para resolver problemas reales de software.

Aquí te cuento qué herramientas usé y por qué son tan importantes para este proyecto:

## 🚀 El Corazón: Spring Boot 3 & Java 17
Elegí **Spring Boot** porque es el estándar en la industria. Me permitió levantar la aplicación de forma rápida, manejando toda la "fontanería" por debajo (inyección de dependencias, configuración de servidores) para que yo pudiera enfocarme 100% en la lógica de negocio: cómo se crea un carrito, cómo se procesa una orden y cómo se filtran los productos. Usar **Java 17** nos dio esa estabilidad y rendimiento que un ecommerce necesita.

## 💾 El Dilema de los Datos: MySQL + MongoDB
En lugar de elegir una sola base de datos, decidí usar lo mejor de ambos mundos:
*   **MySQL:** Lo usé para todo lo que requiere orden y transacciones, como los **usuarios, carritos y órdenes**. Aquí no nos podemos permitir errores; si alguien compra algo, los datos deben ser consistentes.
*   **MongoDB:** Esta fue la solución perfecta para el **catálogo de productos**. En una tienda de electrónica, una Laptop tiene RAM y Procesador, pero un Audífono tiene tipo de conexión y cancelación de ruido. MongoDB me dio la flexibilidad de guardar productos con características totalmente distintas sin romper la base de datos.

## 📊 Carga Masiva: Spring Batch
Uno de los requisitos era poder cargar más de 50 productos de golpe. Para no hacerlo uno por uno a mano, implementé **Spring Batch**. Esta tecnología es increíble para procesar grandes volúmenes de datos (en este caso un CSV) de forma eficiente y segura. Si algo falla a mitad de la carga, el sistema sabe dónde se quedó, lo que lo hace muy robusto para tareas administrativas.

## 🐳 Despliegue: Docker & Docker Compose
No quería que nadie tuviera que instalar MySQL o MongoDB localmente para probar mi código. Con **Docker**, empaqueté toda la aplicación y sus bases de datos. Con un solo comando (`docker compose up`), cualquier persona puede tener el sistema corriendo exactamente igual a como lo tengo yo en mi máquina. La portabilidad hoy en día es clave.

## 🛠️ Calidad y Documentación
*   **Swagger (OpenAPI):** Documentar una API es tedioso, pero Swagger lo hace interactivo. Puedes ver y probar todos los endpoints (rutas) directamente desde el navegador.
*   **JUnit 5 & Mockito:** Para dormir tranquilo, escribí más de 120 pruebas unitarias. Esto asegura que si cambio algo en el código en el futuro, nada de lo que ya funcionaba se rompa.

---

Este proyecto no es solo código; es el resultado de conectar piezas complejas para crear una solución que sea escalable, fácil de mantener y, sobre todo, funcional. ¡Espero que te guste!
