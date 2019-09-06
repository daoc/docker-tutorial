# Esta es la imagen del repositorio php, versión 7.2 con apache
# a partir de esta imagen de base, creamos nuestra imagen personalizada
FROM php:7.2-apache

# Copiamos el contenido del subdirectorio ./data (de nuestro equipo)
# al directorio raíz del servidor apache, dentro de la imagen
COPY data/ /var/www/html/

# Para crear la nueva imagen, ejecutar en la consola:
# docker build -t mi-php01 .
# donde mi-php01 será el nombre de nuestra imagen, y
# el . (punto) indica que el contexto es el directorio actual (Dockerfile debe estar ahí)

# Par arrancar el container, ejecutar en la consola:
# docker run -d -p 80:80 mi-php01
# donde -d indica que se ejecutará en modo dettached, liberando al consola (en el background)
# y -p 80:80 indica que el puerto 80 del equipo se mapea al puerto 80 del container
