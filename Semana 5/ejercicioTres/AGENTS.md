# Contexto del Proyecto - ejercicioTres

Este archivo es leído automáticamente por GitHub Copilot CLI al iniciar una sesión en esta carpeta.
Contiene el contexto, reglas y estado actual del proyecto para mantener continuidad entre sesiones.

---

## 📌 Descripción del Proyecto

> _Por definir — Ver `README.md` para la descripción pública y `BUSINESS.md` para las reglas de negocio._

Aplicación demostrativa del uso de IA en la generación de código, construida con Spring Boot.

## 📖 Archivos de Contexto — Leer al iniciar sesión

Al iniciar una sesión en este proyecto, GitHub Copilot CLI debe leer los siguientes archivos en orden:

| Prioridad | Archivo | Contenido |
|---|---|---|
| 1 | `AGENTS.md` | Contexto general, reglas y convenciones *(este archivo)* |
| 2 | `BUSINESS.md` | Reglas de negocio, funcionalidades y entidades del dominio |
| 3 | `arquitectura.md` | Arquitectura, capas, estructura de paquetes y SOLID |
| 4 | `tecnologias.md` | Stack tecnológico |
| 5 | `CHANGELOG.md` | Historial de cambios recientes |

---

## 🛠️ Tecnologías y Stack

> _Por definir — Ver también `tecnologias.md` para el detalle completo._

---

## 🏛️ Arquitectura

> _Por definir — Ver también `arquitectura.md` para el detalle completo._

---

## 📁 Estructura del Proyecto

> _Se actualizará una vez que se genere el proyecto Spring Boot._

---

## ✅ Reglas y Convenciones

- Responder siempre en **español**.
- Antes de hacer cambios importantes, listar las actividades a realizar y pedir confirmación.
- Mantener este archivo (`AGENTS.md`) actualizado con cada cambio relevante del proyecto.
- Mantener `tecnologias.md` y `arquitectura.md` sincronizados con el estado actual del proyecto.
- Hacer cambios precisos y quirúrgicos; no modificar código no relacionado.
- Documentar decisiones de diseño importantes aquí.

## 📋 Responsabilidad sobre CHANGELOG.md

**GitHub Copilot CLI es responsable de mantener `CHANGELOG.md` actualizado.**

Cada vez que se realice un `push` o `pull` en el proyecto, Copilot debe:

1. Ejecutar `git log` para obtener los commits recientes.
2. Identificar commits nuevos no registrados en `CHANGELOG.md`.
3. Agregar una nueva entrada con el siguiente formato:

```
## [vX.X.X o Sin versión] - YYYY-MM-DD

### Tipo (Agregado / Cambiado / Corregido / Eliminado)
- `autor` — descripción del cambio (referencia al commit si aplica)
```

4. Incluir el **autor del commit**, la **fecha** y una **descripción breve** del cambio.
5. Usar la convención **Conventional Commits** para los mensajes:
   - `feat:` nueva funcionalidad
   - `fix:` corrección de error
   - `docs:` cambios en documentación
   - `refactor:` refactorización de código
   - `chore:` tareas de mantenimiento

---

## 📝 Historial de Decisiones

| Fecha       | Decisión                                      |
|-------------|-----------------------------------------------|
| 2026-03-10  | Se crea estructura inicial del proyecto       |
| 2026-03-10  | Se crean `tecnologias.md` y `arquitectura.md` |
| 2026-03-10  | Se crea `AGENTS.md` para contexto persistente |

---

## 🚧 Estado Actual

- [ ] Definir stack tecnológico
- [ ] Definir arquitectura de la aplicación
- [ ] Generar proyecto Spring Boot base
