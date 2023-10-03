# Utiliza una imagen base que incluya Java y Maven
FROM openjdk:11

# Copia el archivo .class a la imagen
COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency

# Exponer el puerto en el que se ejecuta tu aplicación 
EXPOSE 4567

# Comando para ejecutar tu aplicación
CMD ["java", "-jar", "target/classes/:target/dependency/*", "co.edu.escuelaing.arep.LogRoundRobin"]


#java -cp "target/classes/;target/dependencies/*" co.edu.escuelaing.arep.LogRoundRobin