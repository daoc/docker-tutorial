# docker-tutorial; php02
## Vinculando un directorio local con un directorio en el container
No hace falta en este caso (a no ser que lo deseemos) crear una nueva imagen. Podemos ejecutar simplemente a partir de una imagen existente.

En este caso, la imagen php:7.2-apache, que ya descargamos en el php01 nos puede servir, dado que venía preparada para el efecto ya que al momento de su creación, en el Dockerfile, debió haberse especificado algo como:

`VOLUME /var/www/html`

Indicando que el directorio /var/www/html se montará como un volumen y por consiguiente podrá ser atado con algún directorio en el equipo host, en tiempo de ejecución, con, por ejemplo, el comando:

`docker run -d -p 80:80 -v /home/user/mivol:/var/www/html php:7.2-apache`

Con esta instrucción arrancaremos un container a partir de la imagen php:7.2-apache; este container se ejecutará en el background (-d); se expondrá el puerto 80 en el equipo local (-p 80:80) y con la opción -v ligaremos el directorio /home/user/mivol de nuestro equipo, con el directorio /var/www/html del container.

Atención: en el ejercicio php01 se copiaba el contenido del directorio local al container. Ahora no se copia nada, se crea un link dinámico. Si cambia algo en el dir local, esto se ve reflejado en el container inmediatamente
