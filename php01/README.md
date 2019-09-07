# docker-tutorial: php01
Tutorial docker

### Imagen personalizada, Dockerfile (FROM, COPY), docker build, mapeo de puertos (-p)

Para descargar una imagen desde algún repositorio podemos usar la instrucción docker pull. Por ejemplo, si necesitamos ejecutar aplicaciones php en un servidor web, tal vez nos interese:

`docker pull php:7.2-apache`

> Al ejecutar docker pull, la imagen se descarga del repositorio por defecto (generalmente Docker Hub)

Si deseamos ejecutar esta imagen, o cualquiera, podemos ejecutar docker run, como en el ejercicio anterior, y ponerla en uso en un container:

`docker run -d -p 8888:80 php:7.2-apache`

> Al ejecutar docker run, si la imagen aún no está en el HOST, se descarga del repositorio

La opción -d o --detach ejecuta el container en el background, liberando la consola. La opción -p o --publish permite mapear un puerto en el container con un puerto en el HOST. En la instrucción del ejemplo, -p 8888:80, estamos mapeando 8888 en el HOST con 80 en el container; cualquier petición del tipo http://localhost:8888/... (por ejemplo) hecha en el HOST se direcciona al puerto 80 del container, lo cual permite el intercambio de información entre ellos.



[Demo](https://youtu.be/RYz5ar17FR0)
