# Taller: Despliegue de una Aplicación en AWS con Docker

## Resumen

En la primera parte de este taller, se realizaron los siguientes pasos:

1. **Creación de una Aplicación Web**: Se creó una aplicación web que posteriormente se empaquetó en una imagen Docker.

2. **Creación de una Imagen Docker**: La aplicación web se empaquetó en una imagen Docker para facilitar su despliegue y ejecución en entornos de contenedores.

3. **Subida de la Imagen a Dockerhub**: La imagen Docker se subió a Dockerhub, un registro de contenedores en línea que permite compartir y acceder a las imágenes de contenedores.

4. **Configuración de una Máquina Virtual (EC2)**: Se configuró una instancia de máquina virtual EC2 en AWS.

5. **Instalación de Docker**: En la instancia de EC2, se instaló Docker para permitir la ejecución de contenedores.

6. **Configuración del Usuario en el Grupo de Docker**: Se configuró el usuario en el grupo de Docker para evitar tener que usar "sudo" al ejecutar comandos relacionados con Docker.

7. **Creación de una Instancia de Contenedor Docker**: Se creó una instancia de contenedor Docker a partir de la imagen previamente creada en Dockerhub.

8. **Apertura de Puertos de Entrada en el Security Group**: Se abrieron los puertos de entrada necesarios en el grupo de seguridad de la instancia de EC2 para permitir el acceso al servicio.

9. **Verificación de la Aplicación Web**: Se verificó que la aplicación web estuviera en funcionamiento y se accedió a ella a través de una URL específica.

## Desarrollo

Se construyó una aplicación siguiendo la arquitectura propuesta y desplegarla en AWS utilizando EC2 y Docker. La arquitectura de la aplicación incluye los siguientes componentes:

- **Servicio MongoDB**: Una instancia de MongoDB que se ejecuta en un contenedor Docker en una máquina virtual de EC2.

- **LogService**: Un servicio REST que recibe cadenas de texto, las almacena en la base de datos y responde con un objeto JSON que contiene las 10 últimas cadenas almacenadas y la fecha en que se registraron.

- **Aplicación Web LogRoundRobin**: Esta aplicación web consta de un cliente web que permite a los usuarios ingresar mensajes. Cada vez que se envía un mensaje, se envía al servicio REST, que implementa un algoritmo de balanceo de cargas Round Robin. El servicio REST distribuye el procesamiento del mensaje y la respuesta a tres instancias del servicio LogService.



## Pruebas
Para verificar la funcionalidad de las imágenes en el repositorio de Docker Hub y ejecutarlas, hacer lo siguiente:

1. Clonar el repositorio de github, y ubicarse en el directorio `AREP_Taller5`.
   ```
   git clone https://github.com/SanRocks1220/AREP_Taller5.git
   cd AREP_Taller5
   ```
2. En la máquina local o en cualquier otro servidor donde se desee ejecutar las imágenes, tener Docker instalado y configurado correctamente.

3. Luego, utilizar el comando `docker pull` para descargar las imágenes desde el repositorio de Docker Hub a la máquina local

   ```
   docker pull sanrocks12/arep-taller5-terminado:bdproject
   docker pull sanrocks12/arep-taller5-terminado:logroundrobin
   docker pull sanrocks12/arep-taller5-terminado:logservice
   ```

3. Desde la consola de comandos, "orquestar" el funcionamiento de las imágenes con el `docker-compose.yml`.
   ```
   docker-compose up
   ```

4. Una vez que los contenedores estén en ejecución, se debe acceder a `http://localhost:4567` y comenzar a realizar solicitudes.

Por ejemplo, probar el servicio LogRoundRobin en `http://localhost:4567` pasando diferentes valores a almacenar.

**Nota:** Sis e desea limpiar la base de datos, en la casilla de texto escribir `/clearDB`

## Funcionamiento en AWS
- [Funcionamiento en AWS](https://youtu.be/PJ6eGWUeSRM?si=fCTjgQ5GA71SnqeZ)

## Autor
- [Santiago Andres Rocha C.](https://github.com/SanRocks1220)

## Colaboradores
- [David Valencia](https://github.com/DavidVal6)
- [ChatGPT](https://chat.openai.com)