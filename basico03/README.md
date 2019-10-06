# Conectando servicios

Docker por supuesto permite que los servicios de un container estén disponibles para el HOST, pero también permite que estén disponibles entre containers.

En este ejercicio vamos a crear tres containers que van a interactuar:

Primero tendremos un servidor de base de datos H2 que pueden descargar con: `docker pull daoc/h2:latest`. La información de creación de la imagen la tienen en su [Dockerfile](./Dockerfile).

Vamos a ejecutar el container así: `docker run -d -p 8082:8082 -p 9092:9092 -v /Users/diego/git/Docker/docker-tutorial/basico03/vol:/home/h2/data --name h2-database daoc/h2`, de manera que exponemos el puerto de la interfaz web (8082), el puerto para clientes TCP (9092) y ligamos el directorio *.../vol* para que la base de datos *estud*, en el HOST, esté disponible en el container. Como punto nuevo pueden ver que incluimos la opción `--name h2-database`, lo que además de darle nombre al container, permite que otros containers lo ubiquen con dicho nombre mediante el DNS interno de Docker.
> El HOST no tiene acceso a este DNS. Si quiere acceder a dicho container, por ejemplo a la interfaz web, debe seguir haciéndolo como localhost: `http://localhost:8082`.

