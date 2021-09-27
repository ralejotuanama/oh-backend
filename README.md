
OH - PROYECTO - BACKEND



BACKEND OH
Consideraciones:
Para la realización de este reto he utilizado tecnología java específicamente la version 8.
También spring boot, spring security (jwt), spring data.
Como base de datos he utilizado postgres.
Hemos también utilizado maven, github.
PASO 1:
Para desplegar el aplicativo creamos la base de datos en postgress con el nombre bdoh y automáticamente con el jpa se crearán las tablas mapeadas en nuestros modelos del aplicativo.
 
Adicional a ello creamos 2 tablas que necesitaremos para el tema de los tokens de jwt.
create table oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);
create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);


PASO 2:
Para realizar la prueba de autenticamos necesitamos registra un usuario , para ello realizamos un test con junit ingresando un usuario y contraseña para ello he utilizado la clase  encrypt.
 


PASO 3:
Para pruebas en el postman he tenido que utilizar como tipo de autenticación Basic Auth y hay que poner credenciales de username y password que están el properties .
Y luego de ello en el postman ingreso el usuario y contraseña que del usuario que registre en la base de datos.
 


Para la prueba utilizamos la siguiente url en el postman.
http://localhost:8080/oauth/token
y al ser exitoso el usuario y contraseña nos retornara un token y código correcto de respuesta 200.
 

PASO 4:
Para el endpoint de notas, ya ahora que obtenermos el token de seguridad vamos a poder registrar un alumno con sus respectivas asociadas para ello utilizamos la siguiente url.
http://localhost:8080/alumnos
para la respectiva pruebas debemos utilizar en el postman la palabra bearer seguida el token de seguridad.
Ahora probemos la inserción de un alumno con sus respectivas notas es un método POST.


Vemos el código exitoso de  201 es decir creado correctamente.
Si modificamos el token de acceso o ponemos un token incorrecto nos mostrara un error que nos devolverar error de token

 

Para el listado ahora utilizamos la misma url pero en este caso es un método de tipo GET

 

Para buscar un estudiante y sus notas también utilizamos un GET pero con id a buscar
http://localhost:8080/alumnos/1

 

Si deseamos buscar un alumno que no esta registrado se nos mostrara el respectivo error debido a que hemos validado mediante la clase exception los diversos errores. Por ejemplob uscamos un alumno con id 100 y no se va encontrar

http://localhost:8080/alumnos/100
 
Adicional a ello también hemos creado un metodo para presentar datos mas específicos  Con la url del recurso consultado , para ello uilize hateoas.
 

Para borrar un cliente lo hacemos igualmente , también esta validado que no sea pueda buscar un registro a eliminar no encontrado y la respectiva eliminación. No resulta un código 204 con ello corroboramos que la eliminación fue exitosa
 













