# Ejecutar servicios en cluster con Docker Swarm

En el ejemplo anterior, [intermedio01](../intermedio01), vimos cómo crear un servicio compuesto de varios
contenedores. Este servicio se ejecutaba en un solo nodo o computador. Si contamos con un cluster, o varios
computadores (nodos) en red, todos ellos corriendo Docker, podemos distribuir el trabajo en todos ellos.

En este ejemplo vamos a trabajar con Docker Swarm, pero hay varios orquestadores u organizadores para
trabajar en cluster: [Docker Swarm](https://docs.docker.com/engine/swarm/), [Kubernetes](https://kubernetes.io/), [Mesos](http://mesos.apache.org/), entre otros.

Vamos a trabajar con la definición del servicio en el ejemplo anterior. Este definición podría utilizarse tal y como está, con lo cual el sistema distribuiría un contenedor por nodo. Sin embargo, en ocasiones puede ser interesante tener réplicas de un contenedor corriendo en varios nodos, para mejorar la distribución de carga, entre otras razones. Es eso lo que vamos a aumentar en nuestro ejemplo, en la subsección *deploy*:

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
    deploy:
        replicas: 1
    networks:
      - tutorialnet
  backend:
    image: daoc/rest-backend
    deploy:
        replicas: 2
    networks:
      - tutorialnet
  frontend:
    image: daoc/web-frontend
    ports:
      - 80:80
    deploy:
        replicas: 3
    networks:
      - tutorialnet
```
El servicio *h2-bdd* va a tener una sola réplica, dado que debe haber una sola base de datos centralizada que atienda a todos los demás servicios. *backend* en este caso tiene 2 réplicas, pero no es muy relevante cuántas para el ejemplo. *frontend* tiene 3 réplicas, pero esto dependería mucho del número de nodos.

Una vez que se active el swarm, esta definición se ejecutaría desde el nodo manager con:

`docker stack deploy -c docker-compose.yml my_web`

Donde my_web es simplemente el nombre que le estamos dando a todo el stack o grupo de servicios.

## Crear el swarm

Primero, claro, es necesario tener varios computadores o nodos interconectados, sea físicos o virtuales, con Docker instalado.

Primero, escogemos uno de estos nodos, que va a ser el manager, y ejecutamos:

`docker swarm init --advertise-addr <IP>`

donde `<IP>` debe ser la dirección accesible por todos los otros nodos en la red. Al ejecutar esta instrucción obtendremos una confirmación que contendrá el siguiente comando (el token variará, claro):

`docker swarm join --token SWMTKN-1-49nj..rr2e7c <IP>:2377`

Ahora copie este comando y ejecútelo en todos los otros nodos para unirlos al cluster. A partir de esto su swarm está creado y listo para trabajar.

## Arrancar el servicio

Vaya al manager y active el servicio del ejemplo:

`docker stack deploy -c docker-compose.yml my_web`

esto puede demorar hasta que todas las imágenes se descarguen en todos los nodos. Al terminar la carga vaya a un browser e invoque la dirección de cualquiera de los nodos. Verá aparecer la página del frontend.

## Algunos elementos sobre el swarm

El swarm tiene un punto de acceso (Ingress) único, de manera que usted puede intentar acceder a cualquiera de los servicios por cualquiera de los nodos y siempre obtendrá respuesta, sin importar en cuales nodos se hayan creado las réplicas.

Para manipular los servicios en el swarm, acceda siempre al nodo manager.

Si desea visualizar información, el siguiente comando le da información general:

`docker service ls`

Fíjese que los servicios aparecen prejiados con *my_web* que es el nombre del stack.

Para ver información más específica de cada servicio use el nombre completo con el comando:

`docker service ps my_web_h2-bdd` por ejemplo.

Para eliminar los servicios use su nombre completo y bórrelos uno por uno:
```
docker service rm my_web_frontend
docker service rm my_web_backend
docker service rm my_web_h2-bdd
```
