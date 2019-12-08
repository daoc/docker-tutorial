# Docker

## Conceptos introductorios

Docker es una plataforma que facilita integrar el proceso de desarrollar, probar, distribuir y ejecutar aplicaciones. Docker permite un cierto aislamiento con respeto a la arquitectura específica de la infraestructura gracias a la *virtualización ligera* proporcionada por los *contenedores* Docker.

Un contenedor Docker es similar a una máquina virtual pero mucho más *ligero*. Utiliza un servidor central, *motor docker*, que aprovecha al máximo el kernel y librerías del sistema operativo, pero al mismo tiempo mantiene cada contenedor aislado e independiente del resto. Es posible ejecutar Docker en cualquier máquina física o virtual y también ejecutar muchos más contenedores que máquinas virtuales en un mismo equipo.

Usted crea una imagen Docker con todo lo necesario (dependencias, otras aplicaciones, ...) para que su aplicación funcione correctamente. Esta imagen la puede distribuir mediante un registro (público) como Docker Hub. Quien descargue la imagen la puede ejecutar como un contenedor sin necesidad de preocuparse por dependencias adicionales; puede también recibir actualizaciones y ejecutar varias instancias del contenedor en un entorno distribuido, interactuando con otros contenedores en un esquema tipo cliente-servidor.

### Imagen

Una imagen es una plantilla empaquetada con lo necesario para su aplicación. Las imágenes pueden compartirse de manera pública o privada en registros o repositorios de imágenes. La imagen es de solo lectura pero puede servir de base para crear nuevas imágenes que añadan funcionalidad a la anterior en un esquema de capas. Las imágenes permiten crear (varias) instancias de contenedores.

### Contenedor

Es una instancia de una imagen. Los contenedores pueden ejecutarse y ponerse a la disposición de los clientes en una red de contenedores. Los contenedores se ejecutan de manera aislada pero pueden proporcionar facilidades de interconexión como abrir puertos, compartir un sistema de archivos, conectarse con servicios y brindar posibilidades personalizadas de configuración para diferentes instancias.

### Servicio

Permiten distribuir contenedores a través de varios motores Docker, posiblemente corriendo en varios equipos o nodos diferentes (clústeres, nube, ...). Los servicios pueden correr en enjambre (swarm) proporcionando réplicas, recuperación de errores, balanceo de carga, entre otras facilidades de ejecución y administración.

## Sitio web, versiones, instalador y arranque de Docker Engine

Lo primero que necesitamos hacer es descargar la versión adecuada de Docker para nuestro sistema operativo e instalarla.

Para sistemas Linux hay una variedad de alternativas y en general se instalará mediante la línea de comando (sudo apt ...). Por ejemplo, para sistemas Ubuntu, será necesario contar al menos con la versión 16.04 y seguir las [instrucciones](https://docs.docker.com/install/linux/docker-ce/ubuntu/).

[Demo (solo instalación) en Ubuntu 19<br/><img src="https://img.youtube.com/vi/-6EZfEFM8YI/maxresdefault.jpg" width="20%">](https://youtu.be/-6EZfEFM8YI)

Para sistemas Windows tenemos 2 alternativas. La mejor es [Docker Desktop](https://hub.docker.com/?overlay=onboarding), pero esta requiere un sistema que soporte [Hyper-V](https://docs.microsoft.com/es-es/virtualization/hyper-v-on-windows/quick-start/enable-hyper-v), como por ejemplo Windows 10 Pro. Para sistemas incompatibles tenemos la alternativa que trabaja con VirtualBox, [Docker Toolbox](https://github.com/docker/toolbox/releases).

Para sistemas MacOS también hay las mismas dos alternativas. [Docker Desktop](https://hub.docker.com/editions/community/docker-ce-desktop-mac) para equipos relativamente nuevos (2010+) con sistemas al menos macOS Sierra (10.12+). Para los otros sistemas deberemos usar [Docker Toolbox](https://github.com/docker/toolbox/releases).

[Demo (sin instalación) sobre Mac, con Docker Desktop<br/><img src="https://img.youtube.com/vi/OoroNAx8bxk/maxresdefault.jpg" width="20%">](https://youtu.be/OoroNAx8bxk)

## Ejecución inicial: información e instrucciones de base, descarga y ejecución de imágenes (docker run)

[Demo ejecución inicial<br/><img src="https://img.youtube.com/vi/CujFPAYeSQ0/maxresdefault.jpg" width="20%">](https://youtu.be/CujFPAYeSQ0)

## [Siguiente](https://github.com/daoc/docker-tutorial/tree/master/php01)
