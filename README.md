# Docker
Conceptos introductorios y ejecución de base

### Sitio web, versiones, instalador y arranque de Docker Engine

Lo primero que necesitamos hacer es descargar la versión adecuada de Docker para nuestro sistema operativo e instalarla.

Para sistemas Linux hay una variedad de alternativas y en general se instalará mediante la línea de comando (sudo apt ...). Por ejemplo, para sistemas Ubuntu, será necesario contar al menos con la versión 16.04 y seguir las [instrucciones](https://docs.docker.com/install/linux/docker-ce/ubuntu/).

[Demo (solo instalación) en Ubuntu 19](https://youtu.be/-6EZfEFM8YI)

Para sistemas Windows tenemos 2 alternativas. La mejor es [Docker Desktop](https://hub.docker.com/?overlay=onboarding), pero esta requiere un sistema que soporte [Hyper-V](https://docs.microsoft.com/es-es/virtualization/hyper-v-on-windows/quick-start/enable-hyper-v), como por ejemplo Windows 10 Pro. Para sistemas incompatibles tenemos la alternativa que trabaja con VirtualBox, [Docker Toolbox](https://github.com/docker/toolbox/releases).

Para sistemas MacOS también hay las mismas dos alternativas. [Docker Desktop](https://hub.docker.com/editions/community/docker-ce-desktop-mac) para equipos relativamente nuevos (2010+) con sistemas al menos macOS Sierra (10.12+). Para los otros sistemas deberemos usar [Docker Toolbox](https://github.com/docker/toolbox/releases).

[Demo (sin instalación) sobre Mac, con Docker Desktop](https://youtu.be/OoroNAx8bxk)

### Ejecución inicial: información e instrucciones de base, descarga y ejecución de imágenes (docker run)

[Demo](https://youtu.be/CujFPAYeSQ0)

