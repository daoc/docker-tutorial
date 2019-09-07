# docker-tutorial; php02
## Vinculando un directorio en el HOST con un directorio en el container
A veces necesitamos que HOST y container compartan información dinámicamente mediante el sistema de archivos. Para esto podemos, al ejecutar el container, vincular directorios HOST_dir -> container_dir, mediante el comando:

`docker run [...] -v HOST_dir:/volumen-dentro-del-container [...] imagen`

No hace falta crear una nueva imagen. Podemos ejecutar simplemente a partir de una imagen existente.

En este caso, la imagen php:7.2-apache, que ya descargamos en el php01 nos puede servir. Queremos que el directorio raíz de apache en el container, /var/www/html, obtenga todo su contenido de algún directorio en el HOST, en tiempo de ejecución:

`docker run -d -p 8888:80 -v /home/user/mivol:/var/www/html php:7.2-apache`

Con esta instrucción arrancaremos un container a partir de la imagen php:7.2-apache; este container se ejecutará en el background (-d); se mapeará el puerto 8888 en el HOST con el 80 en el container (-p 8888:80) y con la opción -v vincularemos el directorio /home/user/mivol del HOST, con el directorio /var/www/html del container.

Atención: en el ejercicio php01 se copiaba el contenido del directorio local al container; ahora no se copia nada, se crea un link dinámico. Tanto el HOST como el container usarán el mismo directorio que ha sido vinculado: los cambios hechos por el uno los ve inmediatamente el otro.
