# docker-tutorial: php01
Tutorial docker

### Imagen personalizada, Dockerfile (FROM, COPY), docker build, mapeo de puertos (-p)

Para descargar una imagen desde algún repositorio podemos usar la instrucción docker pull. Por ejemplo, si necesitamos ejecutar aplicaciones php en un servidor web, tal vez nos interese:

`docker pull php:7.2-apache`

> Al ejecutar docker pull, la imagen se descarga del repositorio por defecto (generalmente Docker Hub)

Si deseamos ejecutar esta imagen, o cualquiera, podemos utilizar docker run, como en el ejercicio anterior, y ponerla en uso en un container:

`docker run -d -p 8888:80 php:7.2-apache`

> Al ejecutar docker run, si la imagen aún no está en el HOST, se descarga del repositorio

La opción -d o --detach ejecuta el container en el background, liberando la consola. La opción -p o --publish permite mapear un puerto en el HOST con un puerto en el container. En la instrucción del ejemplo, -p 8888:80, estamos mapeando 8888 en el HOST con 80 en el container; cualquier petición del tipo http://localhost:8888/... (por ejemplo) hecha en el HOST se direcciona al puerto 80 del container, lo cual permite el intercambio de información entre ellos.

En este caso estamos ejecutando la imagen "tal cual" la descargamos del repositorio. Muchas veces necesitamos hacer ciertas modificaciones en una imagen para adaptarla, por ejemplo añadirle nuestra propia aplicación. En estas ocasiones puede ser necesario crear una nueva imagen personalizada a partir de la original.

Crear una nueva imagen requiere utilizar: la instrucción docker build, el archivo con las instrucciones de personalización Dockerfile y el contexto, que en general es el path donde se encuentra todo lo necesario, como por ejemplo:

`docker build -t mi-php01 .`

La opción -t o --tag permite darle un nombre y una etiqueta a la nueva imagen (nombre:etiqueta). En el ejemplo el nombre será mi-php01 y, como no hemos proporcionado una etiqueta, el sistema pondrá la etiqueta por defecto latest y nuestra imagen se llamará mi-php01:latest. Al final de la instrucción podemos ver un punto (.); esto representa el contexto, es decir la ubicación donde se encuentra toda la información (Dockerfile, archivos, etc.). El punto quiere decir "directorio actual", pero podemos poner el path a un directorio cualquiera (/home/user/midir, por ejemplo).

En el path proporcionado como contexto a la instrucción build, debe existir un archivo llamado Dockerfile (sin ninguna extensión) donde constarán las instrucciones de creación:

```
# Dockerfile para crear nuestra nueva imagen
FROM php:7.2-apache
COPY data/ /var/www/html/
```

Para este sencillo ejemplo nuestro Dockerfile es muy pequeño. Toda línea que inicie con # es un comentario. FROM indica cuál es la imagen de base a partir de la cual se creará nuestra nueva imagen, en este caso php:7.2-apache. COPY va a incluir nuestra aplicación dentro de la imagen; va a copiar todo el contenido desde el directorio data, en el HOST, hacia el directorio /var/www/html, en la nueva imagen. Necesitamos entonces un directorio data, dentro del cual pondremos nuestra aplicación para pasarla a la imagen. En el ejemplo que estamos trabajando, data contiene apenas un archivo, index.php, pero ustedes pueden poner lo que deseen.

Luego de ejecutar el build, que podría demorar un poco, tenemos la nueva imagen y podemos verificarlo si ejecutamos docker image ls. Finalmente, no queda más que probar la nueva imagen ejecutándola en un container:

`docker run -d -p 80:80 mi-php01`

Si vamos a un navegador y ponemos en la línea de dirección http://localhost (no hace falta poner el puerto, recuerden que 80 es el puerto http por defecto) veremos la respuesta de la página index.php y podremos jugar un poco con ella.

[Demo](https://youtu.be/RYz5ar17FR0)

## [Siguiente](https://github.com/daoc/docker-tutorial/tree/master/php02)
