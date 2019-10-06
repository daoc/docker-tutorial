# Conectando servicios

Docker por supuesto permite que los servicios de un container estén disponibles para el HOST, pero también permite que estén disponibles entre containers.

En este ejercicio vamos a crear tres containers que van a interactuar:

- Primero tenemos un servidor de base de datos H2 que pueden descargar con: `docker pull daoc/h2:latest`. La información de creación de la imagen la tienen en su [Dockerfile](./Dockerfile).

   Vamos a ejecutar el container así: `docker run -d -p 8082:8082 -p 9092:9092 -v /Users/diego/git/Docker/docker-tutorial/basico03/vol:/home/h2/data --name h2-database daoc/h2`, de manera que exponemos el puerto de la interfaz web (8082), el puerto para clientes TCP (9092) y ligamos el directorio *.../vol* para que la base de datos *estud*, en el HOST, esté disponible en el container. Como punto nuevo pueden ver que incluimos la opción `--name h2-database`, lo que además de darle nombre al container, permite que otros containers lo ubiquen con dicho nombre mediante la resolución interna de nombres en Docker (llamémosle *DNS* por simplicidad).
  > El HOST no tiene acceso a este *DNS*. Si quiere acceder a dicho container, por ejemplo a la interfaz web, debe seguir haciéndolo con el nombre *localhost*: `http://localhost:8082`.

- Luego, tenemos un servicio rest Java (SpringBoot), que proporciona una interfaz genérica para el frontend y que se encarga de trabajar con la base de datos del servidor previo. Pueden descargar este servidor con: `docker pull daoc/rest-backend:latest`. El código del servidor y el Dockerfile están en el subdirectorio [rest-backend](./rest-backend).

   Ahora bien, en el código fuente de este servicio rest, el nombre del servidor de base de datos H2 está codificado en duro como *h2-bdd*. Dando que en el item anterior arrancamos el servidor H2 con el nombre *h2-database*, debemos utilizar otra nueva opción para poder ligarlos: *--link*.
   
   Entonces, para ejecutar este container vamos a utilizar: `docker run -d -p 8080:80 --link h2-database:h2-bdd --name rest-backend daoc/rest-backend`y justamente la opción `--link h2-database:h2-bdd` lo que hace es registrar en este nuevo container un alias para el container h2-database, el cual será *h2-bdd*. De esta manera se establecerá la conexión sin necesidad de cambiar nada.
   
- Finalmente, nuestro tercer servicio será el frontend web (también Java SpringBoot), que se puede descargar con: `docker pull daoc/web-frontend:latest`. El código del servidor y el Dockerfile están en el subdirectorio [web-frontend](./web-frontend). Este frontend se conecta con el backend rest para compartir información con la base de datos:

   > frontend <--> backend <--> database
   
   Muy parecido al servicio anterior, lo arrancamos así: `docker run -d -p 80:80 --link rest-backend:backend --name web-frontend daoc/web-frontend`. Desde el HOST nos conectaremos utilizando el browser directamente con este servidor con: `http://localhost` y no resta más que manipular el sistema.
   
   [Demo](https://youtu.be/MkGYQey9eIw)
