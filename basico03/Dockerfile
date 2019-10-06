FROM openjdk:8-alpine

MAINTAINER diego.ordonez@gmail.com

RUN mkdir -p /home/h2/data

COPY h2-1.4.199.jar /home/h2

# 8082: Puerto http interfaz web
# 9092: Puerto tcp apps clientes
EXPOSE 8082 9092

WORKDIR /home/h2/data

CMD java -cp /home/h2/h2-1.4.199.jar org.h2.tools.Server \
	-tcp -tcpAllowOthers \
	-web -webAllowOthers \
	-ifNotExists -baseDir /home/h2/data 
