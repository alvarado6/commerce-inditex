# Documentations, Configurations and Support Tools
   El siguiente proyecto se ha realizado para cumplir con el test enviado por la empresa inditex para poder medir los 
conocimientos del participante

El proyecto se ha realizado usando las siguientes tecnologias

- Java 8
- Spring boot 
- Maven
- Base de datos en memoria H2
- Test unitarios con Junit5 y Mockito
- Docker
- Documentacion en swagger

## Instrucciones

Para poder ejecutar el proyecto se deben realizar los siguientes pasos:

- Primeramente se debe ejecutar el comando mvn package para poder generar el .jar de la aplicacion
- Luego de haber  generado el .jar, podemos correrlo usando docker con los siguientes comandos desde la raiz del proyecto:

   docker build -t commerce:v1 .
   docker run -p 8080:8080 --name commerce commerce:v1
  
  Con esto ya tendriamos nuestro proyecto totalmente disponible
 
 Al momento de ejecutar el proyecto, este se esta inicializando con data como se pidio en las instrucciones.
 
 
- Para poder realizar pruebas del servicio y poder ver la documentacion necesaria para poder probar, se hizo la documentacion de la api en Swagger, la cual se puede ingresar desde la siguiente url: http://localhost:8080/swagger-ui.html#. Para poder probar lo puede hacer de la siguiente manera
   
   applicationDate: 2020-06-16 21:00:00
   brandId: 1
   productId: 35455
   
- Para poder visualizar la consola de la base de datos es necesario tener el proyecto corriendo 
  y ingresar a la siguiente url: http:localhost:8080/h2-console 
  Al ingresar a esta url va a pareder un cuadro de dialogo para poder realizar la conexion, 
  los parametros que debe usar para conectar son los siguientes:
  
    Saved Settings: Generic H2 (Embedded)
    Setting Name: Generic H2 (Embedded)
    Driver Class: org.h2.Driver
    JDBC URL: jdbc:h2:mem:testdb
    User Name: sa
    Password: password
