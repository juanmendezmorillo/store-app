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

API Endpoint (Obtiene 'ids' de productos con stock):

```
open http://localhost:8080/productstock
```

# Development Steps

* Se ha utilizado una 'arquitectura hexagonal' con 'puertos' (Interfaces), 'adaptadores' (Implementaciones), capa de 
'aplicación' y capa de 'dominio'. Se pretende que la capa de 'dominio' no dependa del framework, ni del modelo de 
datos de la base de datos y sólo se centre en el 'negocio' y para ello contiene sus propias clases y métodos.
Con esta arquitectura conseguimos que la capa de 'dominio' no se vea afectada por cambios en las 'capas externas' 
como pueden ser los 'adaptadores' en los que se encuentran la implementación de los puertos de 
entrada (llamadas de un cliente) y salida (operaciones en base de datos). Estas capas externas son más propicias a los 
cambios. En la capa de 'aplicación' se encuentran los 'casos de uso' que serán igualmente cambiantes.


* La versión utilizada de 'spring-boot' es la '2.7.6'. Como base de datos se ha utilizado 'h2'(se ejecuta en memoria), 
'flyway' para cargar el esquema en 'h2', 'jpa' para las operaciones con la base de datos, 'lombok', 'modelmapper', 
'validation', 'Junit 5' y todo ello utilizando 'programación funcional' con Java 8.


* La carga de productos se realiza al iniciar la aplicación [Start](#start). 
Los productos se encuentran en ficheros '.csv' en la ruta 'resources/csv'.

# I'm closing

Gracias :)

