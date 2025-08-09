# 💱 Coinverter

**Coinverter** es una aplicación Java de consola que permite convertir montos entre distintas monedas, utilizando datos actualizados obtenidos de la API [ExchangeRate API](https://www.exchangerate-api.com/).

---

## 🚀 Funcionalidades

- Conversión de montos entre:
  - Peso argentino (ARS) y dólar estadounidense (USD)
  - Peso argentino (ARS) y euro (EUR)
  - Peso argentino (ARS) y real brasileño (BRL)
  - (Y viceversa)
- Validación de entrada: asegura que los montos ingresados sean válidos.
- Manejo de errores por formato numérico incorrecto o problemas con la API.

---

## 🛠️ Tecnologías utilizadas

- **Java 21+**
- **Gson** (para parseo de JSON)
- **HttpClient** (para realizar las peticiones HTTP)
- IDE sugerido: **IntelliJ IDEA**

---

## 🧪 Cómo ejecutar el proyecto

1. Cloná o descargá el repositorio.
2. Abrí el proyecto en tu IDE (IntelliJ recomendado).
3. Asegurate de tener instalada la dependencia de **Gson**. Si no estás usando Maven/Gradle:
   - Podés descargar el `.jar` desde [Gson GitHub](https://github.com/google/gson) y agregarlo al classpath.
4. Ejecutá el archivo `Main.java`.

---

## 🔐 Clave de API

El proyecto utiliza [ExchangeRate API](https://www.exchangerate-api.com/) para obtener las tasas de conversión.

1. Creá una cuenta gratuita en la web de la API.
2. Obtené tu API key.
3. Pegala en el código en la parte donde se construye la URL de la API:

```java
String direccion = "https://v6.exchangerate-api.com/v6/TU_API_KEY/latest/"+ monedaBase;
```
---
## 📋 Ejemplo de uso

```text
**********************************
             COINVERTER
**********************************

------------ MENÚ DE MONEDAS ------------

1 - Peso Argentino  →  Dólar Americano
2 - Dólar Americano →  Peso Argentino
3 - Peso Argentino  →  Euro
4 - Euro            →  Peso Argentino
5 - Peso Argentino  →  Real Brasileño
6 - Real Brasileño  →  Peso Argentino
7 - Salir
------------------------------------------
Ingrese el número de opción deseado: 
1
Ingrese el monto a convertir: 
1500
1500 ARS equivalen a 1.13 USD
```
---
## 📄 Licencia
Este proyecto es solo con fines educativos.

