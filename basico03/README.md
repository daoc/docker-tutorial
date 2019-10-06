# Conectando servicios

Docker por supuesto permite que los servicios de un container estén disponibles para el HOST, pero también permite que estén disponibles entre containers.

En este ejercicio vamos a crear tres containers que van a interactuar:

Primero tendremos un servidor de base de datos H2 que pueden descargar con: `docker pull daoc/h2:latest`. La información de creación de la imagen la tienen en su [Dockerfile](./Dockerfile)
