FROM openjdk:8-alpine

MAINTAINER diego.ordonez@gmail.com

RUN mkdir -p /home/service

COPY web-frontend-0.0.1-SNAPSHOT.jar /home/service

# 80: Puerto http interfaz rest
EXPOSE 80

WORKDIR /home/service

CMD java -jar /home/service/web-frontend-0.0.1-SNAPSHOT.jar

# Este servicio se conecta con un backend rest: corriendo
# en http://backend:80
# ---
#server.port=80
#usrval.restbackend.server=backend
#usrval.restbackend.port=80
#usrval.restbackend.path=/estud
# ---