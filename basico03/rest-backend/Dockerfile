FROM openjdk:8-alpine

MAINTAINER diego.ordonez@gmail.com

RUN mkdir -p /home/service

COPY rest-backend-0.0.1-SNAPSHOT.jar /home/service

# 80: Puerto http interfaz rest
EXPOSE 80

WORKDIR /home/service

CMD java -jar /home/service/rest-backend-0.0.1-SNAPSHOT.jar

# Este servicio se conecta con una base de datos h2: corriendo
# en tcp://h2-bdd:9092
# ---
#server.port=80
#spring.datasource.name=estud
#spring.datasource.driverClassName=org.h2.Driver
#spring.datasource.username=sa
#spring.datasource.password=sa
#spring.datasource.initialization-mode=embedded
#spring.datasource.url=jdbc:h2:tcp://h2-bdd:9092/estud;DB_CLOSE_ON_EXIT=FALSE;
#spring.jpa.hibernate.ddl-auto=update
# ---