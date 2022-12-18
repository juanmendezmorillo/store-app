# Store-App

Aplicación que filtra productos que se han quedado sin stock y con ello facilita al usuario el encontrar 
productos que pueda comprar.

# Build guide

## Maven

### Testing

Verifique que pueda compilar y pasar las pruebas:
```
mvn clean test
```

Para informe de prueba y cobertura de código:

```
mvn surefire-report:report
open target/site/surefire-report.html

mvn jacoco:report
open target/site/jacoco/index.html
```

### <a id="start" />Start

Ejecutar la API de back-end localmente:

```
mvn spring-boot:run
```

Otra forma es construirlo como un '.jar' y ejecutarlo:

```
mvn clean install 
java -jar .\target\store-app-0.0.1-SNAPSHOT.jar
```

# Server check

Para acceder a la base de datos (H2) en modo dev:

```
open http://localhost:8080/h2-console 
```

API Documentación (Swagger):

```
open http://localhost:8080/v3/api-docs
open http://localhost:8080/swagger-ui.html
```

# Development Steps

* Se ha utilizado una 'arquitectura hexagonal' con 'puertos' (Interfaces), 'adaptadores' (Implementaciones), capa de 
'aplicación' y capa de 'dominio'. Se pretende que la capa de 'dominio' no dependa del framework, ni del modelo de 
datos de la base de datos y sólo se centre en el 'negocio' y para ello contiene sus propias clases y métodos.
Con esta arquitectura conseguimos que la capa de 'dominio' no se vea afectada por cambios en las 'capas externas' 
como pueden ser los 'adaptadores' en los que se encuentran la implementación de los puertos de 
entrada (por ejemplo llamadas Http desde un cliente) y salida (operaciones en base de datos). 
Estas capas externas son más propicias a los cambios. En la capa de 'aplicación' se encuentran los 'casos de uso' 
que serán igualmente cambiantes.


* La carga de productos se realiza al iniciar la aplicación [Start](#start). Dentro del paquete 'loaddata' esta la 
clase que carga los ficheros '.csv'.


* La versión utilizada de 'spring-boot' es la '2.7.6', como base de datos se ha utilizado 'h2'(se ejecuta en memoria), 
'flyway' para cargar el esquema en 'h2', 'jpa' para las operaciones con la base de datos, 'lombok', 'modelmapper', 
'validation', 'Junit 5', 'openapi', 'jacoco' y 'programación funcional' con Java 8.


#### Gracias por su atención.




