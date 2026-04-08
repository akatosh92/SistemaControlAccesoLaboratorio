# Registro de Uso de Inteligencia Artificial

Este documento describe el uso de herramientas de inteligencia artificial durante el desarrollo del proyecto.

La IA fue utilizada como herramienta de apoyo para comprender conceptos, estructurar el sistema y mejorar el código, sin copiar soluciones completas.

---

## Prompt 1

Analizar el enunciado del sistema de control de acceso a laboratorio y determinar las entidades necesarias.

### Resultado

Se identificaron las entidades principales del sistema:

- Usuario
- Acceso

### Ajustes manuales

Se revisaron los atributos de cada entidad para cumplir con los requerimientos del enunciado.

### Justificación

La IA permitió estructurar rápidamente el modelo inicial del sistema.

---

## Prompt 2

Cómo implementar una capa de acceso a datos en Java utilizando archivos TXT para persistir información.

### Resultado

Se generaron las clases:

- UsuarioDAO
- AccesoDAO

Las cuales permiten:

- Guardar datos en archivos
- Leer información desde archivos
- Mantener persistencia sin usar base de datos

### Ajustes manuales

Se revisó el formato de almacenamiento en archivos para asegurar consistencia y evitar redundancia.

### Justificación

La IA ayudó a estructurar la lectura y escritura de archivos en Java.

---

## Prompt 3

Cómo implementar una arquitectura por capas en Java para separar la lógica del sistema.

### Resultado

Se diseñó la estructura del proyecto con las capas:

- Entidades
- AccesoDatos
- LogicaNegocio
- Presentacion

### Ajustes manuales

Se adaptó la estructura al formato requerido por el enunciado del proyecto.

### Justificación

El uso de IA permitió diseñar una arquitectura clara y organizada.

---

## Prompt 4

Cómo mejorar el manejo de errores en un sistema Java de consola.

### Resultado

Se agregaron validaciones para:

- IDs duplicados
- Campos vacíos
- Rol inválido
- Accesos incorrectos
- Entrada inválida en el menú

### Ajustes manuales

Se revisaron las validaciones para garantizar que cumplieran con los requerimientos del sistema.

### Justificación

La IA permitió identificar posibles errores y mejorar la robustez del sistema.