# Utiliza una imagen base de Java
FROM openjdk:11

WORKDIR /usrapp/bin

# Copia el archivo .class a la imagen
COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency

# Exponer el puerto en el que se ejecuta tu aplicación
EXPOSE 4568

# Comando para ejecutar la clase
CMD ["java", "-cp", "./classes:./dependency/*", "co.edu.escuelaing.arep.LogService"]
