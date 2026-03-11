# Changelog

Todos los cambios notables de este proyecto serán documentados aquí.

Formato basado en [Keep a Changelog](https://keepachangelog.com/es/1.0.0/).
Los mensajes de commit siguen la convención [Conventional Commits](https://www.conventionalcommits.org/es/v1.0.0/).

---

## [Sin versión] - 2026-03-10

### Agregado
- `tecnologias.md` — archivo para documentar el stack tecnológico del proyecto.
- `arquitectura.md` — archivo para documentar la arquitectura de la aplicación.
- `AGENTS.md` — archivo de contexto e instrucciones persistentes para GitHub Copilot CLI.
- `CHANGELOG.md` — este archivo, para llevar el registro de cambios del proyecto.
- `TESTING.md` — archivo para documentar la estrategia de pruebas unitarias.

### Commit
- **`49c99b7`** — `docs: agregar estructura base y documentacion inicial de ejercicioTres`
  - Autor: aaron5630 + Copilot
  - Rama: `master` → `origin/master`
  - Archivos: `AGENTS.md`, `CHANGELOG.md`, `TESTING.md`, `arquitectura.md`, `tecnologias.md`

---

## [Sin versión] - 2026-03-10 (2)

### Cambiado
- `.gitignore` — actualizado con configuración completa para proyectos Java/Spring Boot.
  - Eliminado `*.json` para evitar ignorar archivos de configuración necesarios.
  - Agregado `target/`, `*.class`, `*.jar`, `*.war`, `*.ear` (artifacts de Maven).
  - Agregado soporte para IDEs: IntelliJ (`.idea/`, `*.iml`), Eclipse (`.settings/`, `.classpath`, `.project`), VS Code (`.vscode/`).
  - Agregado `.DS_Store`, `Thumbs.db`, `.env`, `.env.local`.

### Commit
- **`ea90228`** — `chore: actualizar .gitignore para proyectos Java/Spring Boot`
  - Autor: aaron5630 + Copilot
  - Rama: `master` → `origin/master`
  - Archivos: `.gitignore`

---
> Cada vez que se realice un `push` o `pull` en el proyecto, Copilot actualizará este registro
> con el autor, fecha y descripción del cambio correspondiente.
