# Conectando servicios con docker-compose

La ejecución manual de servicios con *docker run* puede ser tediosa y proclive a cometer errores al tipear los comandos. Puede ser mucho más práctico, cuando nuestra aplicación consta de varios servicios, configurar su ejecución concertada en un archivo docker-compose.yml.

Vamos a replicar la ejecución del ejercicio anterior, [básico03](../basico03), pero ahora utilizando docker-compose. La configuración se hace en un archivo [.yml](https://en.wikipedia.org/wiki/YAML), en el cual vamos a crear una red específica para toda la aplicación o sistema y vamos a tener una sección por cada uno de los servicios:

```
version: "3.1"
networks:
  tutorialnet:
services:
  h2-bdd:
    image: daoc/h2
    ports:
      - 8082:8082
    volumes:
      - ~/git/Docker/docker-tutorial/intermedio01/vol:/home/h2/data
    networks:
      - tutorialnet
  backend:
    image: daoc/rest-backend
    networks:
      - tutorialnet
  frontend:
    image: daoc/web-frontend
    ports:
      - 80:80
    networks:
      - tutorialnet
```
La sección *networks* crea la red *tutorialnet*. La secciòn *services* crea los 3 servicios: *h2-bdd*, *backend* y *frontend*. En cada servicio, la sección *image* indica la imagen de base para crear el container, *ports* expone los puertos necesarios al HOST, *volumes* liga los directorios del HOST y container y, en todos los casos, *networks* une el container a la red creada en la primera sección.

