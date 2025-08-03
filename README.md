# 💱 Conversor de Monedas – Challenge ONE – Java Back-End

Aplicación de consola desarrollada en Java que permite realizar conversiones de divisas en tiempo real utilizando una API externa. Este proyecto fue realizado como parte del **Challenge Back-End** del programa **Oracle Next Education (ONE)**, en alianza con **Alura Latam**.

---

## 📌 Funcionalidades del sistema

- ✅ Menú interactivo en consola para guiar al usuario paso a paso  
- ✅ Conversión en tiempo real entre monedas seleccionadas  
- ✅ Lista predefinida de monedas internacionales  
- ✅ Uso de una API externa confiable ([ExchangeRate-API](https://www.exchangerate-api.com))  
- ✅ Carga segura de clave API desde archivo externo (`config.properties`)  
- ✅ Empaquetado como `.jar` ejecutable con dependencias incluidas  
- ✅ Manejo de errores y validaciones básicas de entrada  

---

## 🌍 Monedas disponibles

Estas son las monedas soportadas por defecto en el sistema:

| Código | Moneda              |
|--------|---------------------|
| USD    | Dólar estadounidense |
| EUR    | Euro                |
| BRL    | Real brasileño      |
| ARS    | Peso argentino      |
| CLP    | Peso chileno        |
| MXN    | Peso mexicano       |
| COP    | Peso colombiano     |
| GBP    | Libra esterlina     |
| JPY    | Yen japonés         |
| CNY    | Yuan chino          |

---

## 🧰 Tecnologías utilizadas

- Java 17+ ☕  
- Maven (gestión de dependencias)  
- OkHttp (cliente HTTP)  
- GSON (parser JSON)  
- ExchangeRate-API ([https://www.exchangerate-api.com](https://www.exchangerate-api.com))  
- IntelliJ IDEA como entorno de desarrollo  

---

## 🗂️ Estructura del proyecto

```
ConversorDeMonedas/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/conversor/
│   │   │       ├── Main.java
│   │   │       ├── CurrencyConverter.java
│   │   │       ├── ApiExchangeResponse.java
│   │   │       └── CurrencyOption.java
│   │   └── resources/
│   │       └── config.properties
├── target/
│   └── ConversorDeMonedas-1.0-SNAPSHOT-jar-with-dependencies.jar
├── pom.xml
```

---

## 🚀 ¿Cómo ejecutar el sistema?

### ✅ 1. Clonar el repositorio

```bash
git clone https://github.com/dev-gringo/ConversorDeMonedas.git
cd conversor-de-monedas
```

### ✅ 2. Crear el archivo de configuración

Crear un archivo llamado `config.properties` en la misma carpeta del `.jar`, o dentro de `src/main/resources/` si estás trabajando desde IntelliJ:

```properties
api.key=tu_clave_api_aqui
```

Puedes obtener una API Key gratuita desde: [https://www.exchangerate-api.com](https://www.exchangerate-api.com)

---

### ✅ 3. Compilar el proyecto con Maven

```bash
mvn clean package
```

Esto generará un `.jar` ejecutable con todas las dependencias incluidas:

```
target/ConversorDeMonedas-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

### ✅ 4. Ejecutar la aplicación

```bash
java -jar target/ConversorDeMonedas-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

## 🎥 Ejemplo de uso (consola)

```
=== Conversor de Moneda ===

1. Convertir moneda
2. Salir
Seleccione una opción: 1

Monedas disponibles:
1. USD - Dólar estadounidense
2. EUR - Euro
...
Seleccione moneda base (número): 1
Seleccione moneda destino (número): 7
Monto a convertir: 100
💰 100,00 USD = 417221,00 COP
```

---

## 📦 Empaquetado

El proyecto utiliza el plugin `maven-assembly-plugin` para empaquetar todas las dependencias en un único `.jar` ejecutable:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-assembly-plugin</artifactId>
  <version>3.3.0</version>
  <configuration>
    <archive>
      <manifest>
        <mainClass>com.conversor.Main</mainClass>
      </manifest>
    </archive>
    <descriptorRefs>
      <descriptorRef>jar-with-dependencies</descriptorRef>
    </descriptorRefs>
  </configuration>
  <executions>
    <execution>
      <id>make-assembly</id>
      <phase>package</phase>
      <goals>
        <goal>single</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

---

## ✍️ Autor

**Johan Stiven Orrego Arias**  

Desarrollado como parte del programa [ONE - Oracle Next Education](https://www.oracle.com/lad/education/oracle-next-education/) – Back-End con Java

---

## 📄 Licencia

Este proyecto es de uso educativo. Puedes usarlo, modificarlo y compartirlo libremente con atribución.
