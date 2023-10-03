
## Pruebas
Para verificar la funcionalidad de las imágenes en el repositorio de Docker Hub y ejecutarlas, hacer lo siguiente:

1. En la máquina local o en cualquier otro servidor donde se desee ejecutar las imágenes, tener Docker instalado y configurado correctamente.

2. Luego, utilizar el comando `docker pull` para descargar las imágenes desde el repositorio de Docker Hub a la máquina local. Por ejemplo, para descargar la imagen `sanrocks12/arep-taller5:logservice1`, ejecutar:

   ```
   docker pull sanrocks12/arep-taller5:logservice1
   ```

   Repetir este paso para las demás imágenes que se desee utilizar.

3. Una vez que las imágenes estén descargadas en la máquina local, ejecutar contenedores basados en esas imágenes utilizando el comando `docker run`. Los contenedores deben estar conectados a la misma red para que puedan comunicarse entre sí. Es posible crear una red de Docker para esto:

   ```
   docker network create arep-network
   ```

   Luego, ejecutar los contenedores con los comandos:

   ```
   docker run --network arep-network --name mongodb -d mongo:4.2
   docker run --network arep-network --name logroundrobin -p 4567:4567 -d sanrocks12/arep-taller5:logroundrobin
   docker run --network arep-network --name logservice1 -p 4568:4568 -d sanrocks12/arep-taller5:logservice1
   docker run --network arep-network --name logservice2 -p 4569:4568 -d sanrocks12/arep-taller5:logservice2
   docker run --network arep-network --name logservice3 -p 4570:4568 -d sanrocks12/arep-taller5:logservice3
   ```

   Esto ejecutará contenedores para MongoDB, LogRoundRobin y las tres instancias de LogService. 

4. Una vez que los contenedores estén en ejecución, se debe acceder a `http://localhost:4567` y comenzar a realizar solicitudes.

Por ejemplo, probar el servicio LogRoundRobin en `http://localhost:4567` pasando diferentes valores a almacenar. También se puede probar las instancias de LogService en los puertos 4568, 4569 y 4570 respectivamente.


## Otro Método
Clonar este repositorio y ejecutar `docker-compose up` (pendiente de funcionamiento).


## Autor
- [Santiago Andres Rocha C.](https://github.com/SanRocks1220)

## Colaboradores
- [David Valencia](https://github.com/DavidVal6)
- [ChatGPT](https://chat.openai.com)