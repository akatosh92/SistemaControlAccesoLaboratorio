# Sistema de Control de Acceso a Laboratorio

## Descripción

Este proyecto consiste en una aplicación desarrollada en Java que permite gestionar el acceso de usuarios a un laboratorio técnico.

El sistema permite registrar usuarios, controlar las entradas y salidas del laboratorio, y generar reportes de acceso, incluyendo el historial de accesos y el tiempo total que cada usuario ha permanecido dentro del laboratorio.

El proyecto fue desarrollado utilizando una arquitectura por capas para mantener una correcta separación de responsabilidades y facilitar el mantenimiento del código.

---

## Funcionalidades

### Gestión de usuarios
- Registrar usuarios
- Consultar usuarios registrados
- Eliminar usuarios

### Registro de accesos
- Registrar entrada al laboratorio
- Registrar salida del laboratorio
- Evitar doble entrada sin salida
- Evitar salida sin entrada previa

### Reportes
- Historial de accesos por usuario
- Tiempo total dentro del laboratorio

---

## Arquitectura del sistema

El sistema utiliza una arquitectura por capas:

Presentacion
↓
LogicaNegocio
↓
AccesoDatos
↓
Archivos TXT

### Capas del sistema

**Entidades**
- Representan los objetos del dominio del sistema.

Clases:
- `Usuario`
- `Acceso`

**AccesoDatos**
- Manejan la persistencia de datos en archivos `.txt`.

Clases:
- `UsuarioDAO`
- `AccesoDAO`

**LogicaNegocio**
- Contiene las reglas del sistema y validaciones.

Clases:
- `UsuarioServicio`
- `AccesoServicio`

**Presentacion**
- Interfaz de consola para interacción con el usuario.

Clases:
- `Main`
- `Menu`

---

## Persistencia de datos

El sistema utiliza archivos de texto para almacenar la información.

Archivos utilizados:

usuarios.txt
accesos.txt

Formato de almacenamiento:

### usuarios.txt:

ID;NOMBRE;ROL
U01;Carlos Perez;Estudiante
U02;Ana Lopez;Docente

### accesos.txt:

ID_USUARIO;FECHA_ENTRADA;FECHA_SALIDA
U01;2026-04-07T09:00;2026-04-07T11:30
U02;2026-04-07T10:10;null

---

## Tecnologías utilizadas

- Java
- Programación orientada a objetos
- Arquitectura por capas
- Persistencia mediante archivos `.txt`
- Control de versiones con Git
- Repositorio en GitHub

---

## Cómo ejecutar el sistema

1. Clonar el repositorio: git clone <URL_DEL_REPOSITORIO>
2. Abrir el proyecto en **VS Code**.
3. Ejecutar la clase: Main.java
4. Utilizar el menú en consola para interactuar con el sistema.

---

## Autor: Cristian Meléndez García

Proyecto desarrollado como parte del curso **Programación III**.

